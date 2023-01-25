package hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hotel.dto.AskDto;

@Mapper
public interface AskMapper {

	List<AskDto> selectAskList() throws Exception;

	

	void insertAsk(AskDto askDto) throws Exception;
//	void updateHitCount(int askIdx) throws Exception;
//	AskDto selectAskDetail(int askIdx) throws Exception;
	void updateAsk(AskDto askDto) throws Exception;
	void deleteAsk(int askIdx) throws Exception;



	List<AskDto> selectAskList(int offset) throws Exception;



	int selectAskListCount() throws Exception;

}
