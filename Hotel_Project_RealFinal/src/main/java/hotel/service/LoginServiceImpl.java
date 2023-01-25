package hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.dto.CreateDto;
import hotel.dto.LoginDto;
import hotel.mapper.LoginMapper;

@Service 
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
	public CreateDto login(LoginDto loginDto) throws Exception {
		return loginMapper.login(loginDto);
	}
}