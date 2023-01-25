package hotel.service;

import hotel.dto.CreateDto;
import hotel.dto.LoginDto;

public interface LoginService {
	public CreateDto login(LoginDto loginDto) throws Exception;
}