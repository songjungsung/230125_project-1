package hotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import hotel.dto.CreateDto;
import hotel.dto.LoginDto;

@Mapper
public interface LoginMapper {
	public CreateDto login(LoginDto loginDto) throws Exception;
}