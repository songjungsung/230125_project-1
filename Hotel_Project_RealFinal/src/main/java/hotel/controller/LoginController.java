package hotel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hotel.dto.CreateDto;
import hotel.dto.LoginDto;
import hotel.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	// 로그인 페이지를 반환합니다.    
	@GetMapping("/Hotel/login.do")
	public String login(HttpSession session) throws Exception {
		if (session.getAttribute("user") == null) {
			return "LoginPage.html";
		} else {
			return "redirect:/Hotel/firstMain";
		}
	}
	
	// 일치하는 사용자가 존재하지 않는 경우 메시지와 함께 로그인 페이지로
	@PostMapping("/Hotel/login.do")
	public String login(LoginDto loginDto, HttpSession session) throws Exception {
		CreateDto createDto = loginService.login(loginDto);
		if (createDto == null) {
			session.setAttribute("message", "일치하는 정보가 존재하지 않습니다.");
			return "redirect:/Hotel/login.do";
		} else {
			session.setAttribute("user", createDto);
			return "redirect:/Hotel/firstMain";
		}
	}
	
	// 세션에 user를 삭제하고, 세션을 무효화한 후 로그인 페이지로 이동합니다.
		@GetMapping("/Hotel/logout.do")
		public String logout(HttpSession session) throws Exception {
			session.removeAttribute("user");
			session.invalidate();
			return "redirect:/Hotel/firstMain";
		}
}
