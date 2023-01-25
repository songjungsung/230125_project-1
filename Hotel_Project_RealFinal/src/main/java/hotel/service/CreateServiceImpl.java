package hotel.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.dto.CreateDto;
import hotel.mapper.CreateMapper;

@Service
public class CreateServiceImpl implements CreateService {
	
	@Autowired
	private CreateMapper createMapper;

	 @Override
	   public void insertCreateMember(CreateDto createDto, HttpSession session) throws Exception {
	      String password = createDto.getUserPassword();
	      String checkPsw = createDto.getUserPasswordCheck();
	      
	      if (password.equals(checkPsw)) {
	         createMapper.insertCreateMember(createDto);
	      } else {
	    	  //메세지 내용 수정
	    	  session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
	      }
	 }
}
