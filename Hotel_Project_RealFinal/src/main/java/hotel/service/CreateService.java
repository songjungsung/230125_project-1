package hotel.service;

import javax.servlet.http.HttpSession;

import hotel.dto.CreateDto;

public interface CreateService {

	void insertCreateMember(CreateDto createDto, HttpSession session) throws Exception;
}
