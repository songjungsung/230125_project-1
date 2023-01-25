package hotel.service;

import java.util.List;

import hotel.dto.ReservationDto;
import hotel.dto.ReviewDto;

public interface ReservationService {
	//<호텔 예약 서비스>
		public List<ReservationDto> selectReservationList() throws Exception;

		public String insertReservation(ReservationDto reservationDto) throws Exception;
	//<예약 조회 서비스>
		public List<ReservationDto> checkReservationInfo(ReservationDto reservationDto) throws Exception;

		public List<ReservationDto> CheckReservation(int checkIdx) throws Exception;

		public ReservationDto reservationInfoWrite() throws Exception;
		public List<ReservationDto> selectReservationList(ReservationDto reservationDto) throws Exception;
		public int selectReservationListCount(ReservationDto reservationDto) throws Exception;
	}