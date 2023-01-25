package hotel.mapper;

import org.apache.ibatis.annotations.Mapper;

import hotel.dto.CreateDto;

@Mapper
public interface CreateMapper {
	public void insertCreateMember(CreateDto createDto) throws Exception;
}
