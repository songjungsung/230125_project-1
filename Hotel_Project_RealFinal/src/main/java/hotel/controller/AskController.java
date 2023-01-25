package hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hotel.dto.AskDto;
import hotel.service.AskService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AskController {

	@Autowired
	private AskService askService;

	@GetMapping("/Hotel/openAskList.do")
	public ModelAndView openAskList(

		// 현재 페이지 번호를 요청 파라미터로 부터 추출
		@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage) throws Exception {

		

		ModelAndView mv = new ModelAndView("/askList");

		List<AskDto> list = askService.selectAskList((currentPage - 1) * 10);
		mv.addObject("list", list);

		// 페이징 정보 출력에 사용되는 변수
		mv.addObject("pageCount", Math.ceil(askService.selectAskListCount() / 10.0));
		mv.addObject("currentPage", currentPage);

		return mv;
	}

	@GetMapping("/Hotel/openAskWrite.do")
	public String openAsk() throws Exception {
		return "askWrite.html";
	}

	@RequestMapping("/Hotel/insertAsk.do")
	public String insertAsk(AskDto askDto) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>");
		askService.insertAsk(askDto);
		System.out.println(">>>>>>>>>>>>>>>>");
		return "redirect:/Hotel/openAskList.do";
	}

//	@GetMapping("/Hotel/askDetail.do")
//	public ModelAndView openAskDetail(@RequestParam int askIdx) throws Exception {
//		ModelAndView mv = new ModelAndView("/askDetail");
//
//		AskDto askDto = askService.selectAskDetail(askIdx);
//		mv.addObject("ask", askDto);
//
//		return mv;
//	}
//
//	@PostMapping("/Hotel/updateAsk.do")
//	public String updateAsk(AskDto askDto) throws Exception {
//		askService.updateAsk(askDto);
//		return "redirect:/Hotel/askList.do";
//	}
//
//	@PostMapping("/Hotel/deleteAsk.do")
//	public String deleteAsk(AskDto askDto) throws Exception {
//		askService.deleteAsk(askDto.getAskIdx());
//		return "redirect:/Hotel/askList.do";
//	}
}
