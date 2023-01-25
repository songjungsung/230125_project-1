package hotel.dto;

import lombok.Data;
import hotel.dto.ReservationDto;

@Data
public class ReservationDto {
		private int reservationIdx;
		private String userName;
		private String reservationContact;
		private String roomType;
		private String poolReservation;
		private String checkIn;
		private String checkOut;
}

