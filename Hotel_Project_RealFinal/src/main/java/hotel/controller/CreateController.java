package hotel.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.dto.CreateDto;
import hotel.service.CreateService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CreateController {
	
	@Autowired
	private CreateService createService;
	
	//회원가입 페이지에 대한 요청을 처리
	@GetMapping("/Hotel/createMember")
	public String createMember() throws Exception{
		return "Register.html";
	}

	//회원 정보 저장 처리에 대한 요청을 처리
	@RequestMapping("/Hotel/insertCreateMember")
	public String insertCreateMember(CreateDto createDto, HttpSession session) throws Exception{
		createService.insertCreateMember(createDto, session);
		return"redirect:/Hotel/login.do";
	}
	
	
}
