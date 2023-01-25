package hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.dto.ReservationDto;
import hotel.dto.ReviewDto;
import hotel.mapper.HotelMapper;
import hotel.mapper.ReservationMapper;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationMapper reservationMapper;

//<호텔 예약 서비스>
	@Override
	public List<ReservationDto> selectReservationList() throws Exception {
		return reservationMapper.selectReservationList();
	}

	@Override
	public String insertReservation(ReservationDto reservationDto) throws Exception {
		ReservationDto duple = reservationMapper.checkDuplicate(reservationDto);
		if (duple == null) {
			System.out.println("예약이 완료되었습니다.");
			reservationMapper.insertReservation(reservationDto);
			return "Success";
		} else {
			System.out.println("중복입니다.");
//			throw new Exception("예외를 강제로 발생시켰습니다.");
			return "이미 예약된 객실입니다 다른 날짜를 선택해주세요";
		}
	}

//<예약 조회 시스템>
	@Override
	public List<ReservationDto> checkReservationInfo(ReservationDto reservationDto) throws Exception {
		return reservationMapper.checkReservationInfo(reservationDto);
	}

	@Override
	public List<ReservationDto> CheckReservation(int checkIdx) throws Exception {
		return reservationMapper.CheckReservation(checkIdx);
	}

	@Override
	public ReservationDto reservationInfoWrite() throws Exception {
		return reservationMapper.reservationInfoWrite();
	}

	@Override
	public List<ReservationDto> selectReservationList(ReservationDto reservationDto) throws Exception {
		return reservationMapper.selectReservationList(reservationDto);
	}

	@Override
	public int selectReservationListCount(ReservationDto reservationDto) throws Exception {
		return reservationMapper.selectReservationListCount(reservationDto);
	}

	
}
