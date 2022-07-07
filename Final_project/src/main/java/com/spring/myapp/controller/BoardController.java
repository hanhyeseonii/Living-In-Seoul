package com.spring.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.advice.ErrorCode;
import com.spring.myapp.advice.ErrorCode1;
import com.spring.myapp.dto.Board;
import com.spring.myapp.dto.Page;
import com.spring.myapp.service.BoardFileService;
import com.spring.myapp.service.BoardService;

@Controller
@RequestMapping("culture/board")
//@SessionAttributes("page") //1)세션에 담을 변수명
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardFileService boardFileService;
	
	@GetMapping("/")
	public String listhome(Page page, Model model) { //2)page객체 생성
		//세션에 객체를 할당하기 위한 목적(@SessionAttributes이 존재시 session생성)
		model.addAttribute("page", page); //3)세션에 할당
		// WEB-INF/views/board/list.jsp로 이동
		return "culture/board/list";
	}
	
	//@ModelAttribute("page") : @SessionAttributes가 있을때는 세션에도 저장
	//@SessionAttributes의 page에 객체할당후 실행
	//@ModelAttribute("page") : 생략가능
	@GetMapping("list")
	public void list(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("blist", boardService.selectList(page));
		//@ModelAttribute :뷰까지 전달
		//model.addAttribute("page", page); //서비스에서 page 계산
		// WEB-INF/views/board/list.jsp로 이동
		
	}
	
	//상세페이지 이동
	@GetMapping("detail")
	public void detail(@RequestParam int bnum, Model model) {
		//1)조회수+1
		boardService.updateReadCnt(bnum);
		//2)게시물 조회
		model.addAttribute("board", boardService.selectOne(bnum));
		//3)게시물파일들 조회
		model.addAttribute("bflist", boardFileService.selectList(bnum));
		
		// WEB-INF/views/board/detail.jsp로 이동
	}
	
	
	//추가페이지이동
	@GetMapping("add")
	public void add() {
	}
	
	//추가
	@PostMapping("add")
	public String add( Board board, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		//클라이언트 ip
		board.setIp(request.getRemoteAddr());
		ErrorCode1 errorCode =  boardService.insert(board);
		
		//리스트 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:list";
		
	}
	
	//수정폼으로 이동
	@GetMapping("modify")
	public void modify(@RequestParam int bnum, Model model) {
		//1)게시물 조회
		model.addAttribute("board", boardService.selectOne(bnum));
		//2)게시물파일들 조회
		model.addAttribute("bflist", boardFileService.selectList(bnum));
		
		//board/modify.jsp로 이동
	}
	
	//수정버튼을 클릭했을때 
	//required = false :데이터가 없을때도 있다
	@PostMapping("modify")
	public String modify(Board board, 
			@RequestParam(required = false) List<Integer> removeFiles,
			HttpServletRequest request,
			RedirectAttributes rattr) throws Exception {
		//사용자의 ip
		board.setIp(request.getRemoteAddr());
		
		ErrorCode1 errorCode = boardService.update(board, removeFiles);
		
		//redirect방식, detail로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg()); //한번만 실행 파라메터
		rattr.addAttribute("bnum", board.getBnum()); //url에 포함
		
		return "redirect:detail";
	}
	
	//삭제버튼클릭시
	@GetMapping("remove")
	public String remove(@RequestParam int bnum, RedirectAttributes rattr) {
		ErrorCode1 errorCode = boardService.updateRemoveyn(bnum);
		
		//redirect, list로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		return "redirect:list";
		
	}
	
	@GetMapping("sessionClear")
	public String sessionClear(SessionStatus sessionStatus) {
		sessionStatus.setComplete(); //세션에서 지우기
		return "culture/board/list";
	}
	
	//좋아요+1
	@ResponseBody
	@PutMapping("like/{bnum}")
	public String likecnt(@PathVariable int bnum) {
		boardService.updateLikeCnt(bnum);
		Board board = boardService.selectOne(bnum);
		//좋아요를 문자로 변경후 리턴
		return String.valueOf(board.getLikecnt());
	}
	
	//싫어요+1
	@ResponseBody
	@PutMapping("dislike/{bnum}")
	public String dislikecnt(@PathVariable int bnum) {
		boardService.updateDisLikeCnt(bnum);
		Board board = boardService.selectOne(bnum);
		return String.valueOf(board.getDislikecnt());
	}
	
	
	
	@ResponseBody
	@GetMapping("hotBoard")
	public List<Board> hotBoard(){
		return boardService.selectHot();
	}
	

	@ResponseBody
	@GetMapping("newBoard")
	public List<Board> newBoard(){
		return boardService.selectNew();
	}
	
	
	
	
	
	
}
