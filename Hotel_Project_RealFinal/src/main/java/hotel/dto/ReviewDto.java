package hotel.dto;

import lombok.Data;

@Data
public class ReviewDto {
	private int reviewIdx; 
	private String userNickname;  
	private String title; 
	private String contents; 
	private int hitCnt;  
	private String registDt;
	private String updatedDt;
	private String reviewImage;
	private int reviewStar;

}
