package hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hotel.dto.ReservationDto;
import hotel.dto.ReviewDto;
import hotel.service.ReservationService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

//<호텔 예약 시스템>
//예약자 명단 (t_reservation에 저장된 정보) 나오는 page
	@RequestMapping("/Hotel/openReservationList.do")

	public ModelAndView openReservationList() throws Exception {
		ModelAndView mv = new ModelAndView("/Hotel/ReservationList");

		List<ReservationDto> list = reservationService.selectReservationList();
		mv.addObject("list", list);

		return mv;
	}

	//서울 호텔 예약 정보 입력하는 page
	   @RequestMapping("/Hotel/openReservationWrite/Seoul.do")
	   public String openReservationWriteSeoul() throws Exception {
	      return "SeoulReservation.html";
	   }
	   
	   //제주 호텔 예약 정보 입력하는 page
	      @RequestMapping("/Hotel/openReservationWrite/Jeju.do")
	      public String openReservationWriteJeju() throws Exception {
	         return "JejuReservation.html";
	      }
	

//예약 정보를 insert하는 메서드
	@RequestMapping("/Hotel/insertReservation.do")
	public String insertReservation(ReservationDto reservationDto, HttpSession session) throws Exception {
		String msg = reservationService.insertReservation(reservationDto);
		if (msg == "Success") {
			
			return "redirect:/Hotel/reservationInfoWrite.do";
		} else {
			session.setAttribute("msg", msg);
			System.out.println(reservationDto.getRoomType().charAt(0));
			if (reservationDto.getRoomType().charAt(0) == 'J') {
				return "JejuReservation.html";
			} else {
				return "SeoulReservation.html";
			}
		}
	}

//<예약 조회 시스템>
//예약 확인을 위한 정보 (이름, 연락처) 입력하는 페이지
	@RequestMapping("/Hotel/reservationInfoWrite.do")
	public String reservationInfoWrite() throws Exception {
		return "/checkReservation";
	}

//입력 받은 정보를 reservationInfo(DTO)에서 조회, 리스트 반환
	@RequestMapping(value="/Hotel/checkReservationInfo.do")
	public ModelAndView checkReservationInfo(ReservationDto reservationDto) throws Exception {
		ModelAndView mv = new ModelAndView("/CheckReservationDetail");

		List<ReservationDto> list = reservationService.checkReservationInfo(reservationDto);
		mv.addObject("list", list);

		return mv;
	}
	
	// 예약확인 리스트 페이지 요청 처리
	@RequestMapping("/Hotel/checkReservationList.do")
	public ModelAndView openReservationList(ReservationDto reservationDto, 

			// 현재 페이지 번호를 요청 파라미터로 부터 추출
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage)
			throws Exception {
		ModelAndView mv = new ModelAndView("CheckReservationDetail.html");

		List<ReservationDto> list = reservationService.selectReservationList(reservationDto);
		mv.addObject("list", list);

		// 페이징 정보 출력에 사용되는 변수
		mv.addObject("pageCount", Math.ceil(reservationService.selectReservationListCount(reservationDto) / 10.0));
		mv.addObject("currentPage", currentPage);

		return mv;
	}
	
	
//checkIdx를 파라미터로 받아서 예약 정보를 조회, 리스트 반환
	@RequestMapping("/Hotel/openReservationInfo.do")
	public ModelAndView CheckReservation(@RequestParam int checkIdx) throws Exception {

		ModelAndView mv = new ModelAndView("/CheckReservation");

		List<ReservationDto> list = reservationService.CheckReservation(checkIdx);
		mv.addObject("list", list);

		return mv;
	}

}
