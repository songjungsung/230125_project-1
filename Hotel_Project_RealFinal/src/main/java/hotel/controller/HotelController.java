package hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotelController {

	// 첫 메인 화면
	@GetMapping("/Hotel/firstMain")
	public String firstMain() throws Exception {
		return "firstMain.html";
	}
	// 서울호텔
	@GetMapping("/Hotel/Seoul")
	public String seoul() throws Exception {
		return "Seoul.html";
	}

	// 제주호텔
	@GetMapping("/Hotel/Jeju")
	public String jeju() throws Exception {
		return "Jeju.html";
	}


}
