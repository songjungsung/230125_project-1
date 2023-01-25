package hotel.dto;

import lombok.Data;

@Data
public class CreateDto {
	private String userId;
	private String userPassword;
	private String userPasswordCheck;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userContact;
}
