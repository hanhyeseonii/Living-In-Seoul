package com.spring.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.advice.ErrorCode;
import com.spring.myapp.dto.Member;
import com.spring.myapp.service.MemberService;
import com.spring.myapp.service.NaverService;

@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private NaverService naverService;


	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//가입 폼으로 이동
	@GetMapping("sign_up")
	public void sign_up() {
	}
	
	//sign up 버튼을 눌렀을 때
	@PostMapping("sign_up")
	public String sign_up(@ModelAttribute Member member, Model model, RedirectAttributes rattr, HttpSession session ) {
		logger.info(member.toString());
		ErrorCode errorCode = memberService.insert(member, session);
		rattr.addFlashAttribute("msg",errorCode.getMsg());
		
		return "redirect:/member/login"; //로그인폼으로 이동
		
	}
	
	
	//로그인 폼으로 이동(네이버간편)
	@GetMapping("naverlogin")
	public void naverlogin(HttpSession session,HttpServletRequest request, Model model) throws Exception {
	 	//네이버 간편가입 위해서 apiURL 얻기
		Map<String, String> rmap = naverService.getApiUrl(request.getContextPath());
		logger.info(rmap.toString());
		//세션에 state넣기(callback메소드에서 인증하기 위해서)
		session.setAttribute("state", rmap.get("state"));
		//jsp에 보내기
		model.addAttribute("apiURL", rmap.get("apiURL"));
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public void login() {
	}
	
	//로그인 버튼을 눌렀을 때
	@PostMapping("login")
	public String login(@RequestParam String email, @RequestParam String passwd, RedirectAttributes rattr, HttpSession session) {
		ErrorCode errorCode = memberService.loginCheck(email, passwd);
		
		//성공이면 홈 아니면 login으로 이동
		int code = errorCode.getCode();
		
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		if(code == 0) {//성공
			session.setAttribute("email", email);
			
			return "redirect:/member/";
		}else
			return "redirect:/member/login";
	}
	
	//이메일 찾기로 이동
	@GetMapping("find_email")
	public void find_email() {
	}
	
	//find 버튼을 눌렀을 때
	@PostMapping("find_email") 
	public String find_email(Model model, Member member) {
		String findemail = memberService.id_selectOne(member);
		model.addAttribute("findemail", findemail);
		
		return "member/find_email";
	}
	
	//비밀번호 찾기로 이동
	@GetMapping("find_passwd")
	public void find_passwd() {
	}
	
	//find 버튼을 눌렀을 때
	@PostMapping("find_passwd")
	public String find_passwd(Model model, Member member, RedirectAttributes rattr) {

		ErrorCode errorCode = memberService.pw_selectOne(member);

		//성공이면 비밀번호 변경으로 이동
		int code = errorCode.getCode();
		
		model.addAttribute("msg", errorCode.getMsg());
		
		if(code == 0) {//성공
			return "member/passwd_modify";
		}else
		return "member/find_passwd";
		
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//세션지우기
		session.invalidate();
		
		return "redirect:/member/";
	}
	
	//1)네이버 로그인 요청(GET:로그인창으로 이동)
	//2)callback주소로 code, state 받기
	//3)code, state를 이용해서 access_token 얻기(회원정보 얻기)
	//4)access_token를 이용해서 개인회원정보 요청
	
	//네이버 콜백 주소
	@GetMapping("naverCallback")
	public String naverCallback(@RequestParam String code, @RequestParam String state, HttpSession session, RedirectAttributes rattr) {
		logger.info(code); //네이버에서 만들어준 코드(동의했다)
		logger.info(state);
		//세션의 state와 파라메터의 state가 일치한다면 정상 사용자
		String state_s = (String) session.getAttribute("state");
		logger.info("session state :" + state_s);
		
		if (state_s != null && state_s.equals(state)) {
			ErrorCode errorCode= naverService.naverLogin(code, state, session);
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			//code가 0이면 session에 email넣고 home으로 이동
			if (errorCode.getCode()==0) {
				return "redirect:/"; 
			}
			//아니면 login.jsp로 이동
			return "redirect:login";
				
		}else {
			//state_s이 null이거나 state_s가 일치하지 않는다면
		rattr.addFlashAttribute("msg", ErrorCode.ERROR_NAVERAUTH.getMsg());
			return "redirect:login";
		}
		 
	}
		
	//이메일을 눌렀을 때
	@GetMapping("info")
	public String info(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		//한건 조회
		Member member = memberService.selectOne(email);
		
		//forward방식 : member + info.jsp => response
		model.addAttribute("member", member);
		
		return "member/info";
	}
	
	//MODIFY 버튼을 눌렀을 때(MY INFORMATION MODIFY로 이동)
	@GetMapping("info_modify")
	public void info_modify(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		//한건 조회
		Member member = memberService.selectOne(email);
		
		//forward방식 : member + info.jsp => response
		model.addAttribute("member", member);
	}
	
	//MY INFORMATION MODIFY에서 SAVE 버튼을 눌렀을 때(MY INFORMATION으로 이동)
	@PostMapping("info_modify")
	public String info_modify(Member member, Model model, RedirectAttributes rattr) {
		ErrorCode errorCode = memberService.update(member);
		if(errorCode.getCode() !=0) {
			model.addAttribute("msg",errorCode.getMsg());
			return "member/info_modify";
		}else { //성공시
			rattr.addFlashAttribute("msg",errorCode.getMsg());
			return "redirect:/member/info";
		}
		
	}
	
	//이메일 중복확인 버튼을 눌렀을 때
	@ResponseBody
	@RequestMapping("duplCheck/{email}")
	public Map<String, Object> duplCheck(@PathVariable String email) {
		ErrorCode errorCode = memberService.duplCheck(email);
		//에러를 맵에 담아서 반환
		Map<String, Object> map = new HashMap<>();
		map.put("code", errorCode.getCode());
		map.put("msg", errorCode.getMsg());
		return map;
		
	}
	
	//비밀번호 변경 버튼을 눌렀을 때(MY PASSWORD MODIFY로 이동)
	@GetMapping("passwd_modify")
	public void passwd_modify(){
	}
	
	//비밀번호 변경에서 SAVE버튼을 눌렀을 때(MY INFORMATION으로 이동)
	@PostMapping("passwd_modify")
	public String passwd_modify(@ModelAttribute Member member,
			Model model,RedirectAttributes rattr, HttpSession session) {
		logger.info(member.toString());
		member.setEmail((String)session.getAttribute("email"));
		ErrorCode errorCode = memberService.passwd_update(member);
		rattr.addFlashAttribute("msg",errorCode.getMsg());
		
		return "redirect:/member/info";
	}
	
	//회원탈퇴 버튼을 눌렀을 때(MEMBERSHIP WITTHDRAWAL로 이동)
	@GetMapping("drawal")
	public void drawal(HttpSession session, Model model){
		String email = (String) session.getAttribute("email");
		
		//forward방식 : member + info.jsp => response
		model.addAttribute("email", email);
	}
	
	
	//탈퇴 버튼을 눌렀을 때(home으로 이동)
	@PostMapping("drawal")
	public String drawal(@ModelAttribute Member member, Model model,RedirectAttributes rattr, HttpSession session){
		logger.info(member.toString());
		ErrorCode errorCode = memberService.insert(member, session);
		rattr.addFlashAttribute("msg",errorCode.getMsg());
		
		return "member/";
	}
	

}
