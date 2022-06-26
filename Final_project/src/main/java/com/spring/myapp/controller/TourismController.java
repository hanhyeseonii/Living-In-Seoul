package com.spring.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.spring.myapp.dto.Page;
import com.spring.myapp.service.TourismService;

@Controller
@RequestMapping("tourism")
//@SessionAttributes("page") //1)세션에 담을 변수명
public class TourismController {
	@Autowired
	private TourismService tourismService;
	
	@GetMapping("/")
	public String list() { //2)page객체 생성
		//세션에 객체를 할당하기 위한 목적(@SessionAttributes이 존재시 session생성)
		// WEB-INF/views/board/list.jsp로 이동
		return "/tourism/list";
	}
	
	//@ModelAttribute("page") : @SessionAttributes가 있을때는 세션에도 저장
	//@SessionAttributes의 page에 객체할당후 실행
	//@ModelAttribute("page") : 생략가능
	@GetMapping("list")
	public void list(@ModelAttribute("page") Page page, Model model) {
		model.addAttribute("tlist", tourismService.selectList(page));
		//@ModelAttribute :뷰까지 전달
		//model.addAttribute("page", page); //서비스에서 page 계산
		// WEB-INF/views/board/list.jsp로 이동
		
	}
	//상세페이지 이동
		@GetMapping("detail")
		public void detail(@RequestParam int tnum, Model model) {
			//1)조회수+1
			tourismService.updateReadCnt(tnum);
			//2)게시물 조회
			model.addAttribute("tourism", tourismService.selectOne(tnum));
			
			// WEB-INF/views/board/detail.jsp로 이동
		}	
	

}