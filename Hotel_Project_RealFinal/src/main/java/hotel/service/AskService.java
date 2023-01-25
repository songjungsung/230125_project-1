package hotel.service;

import java.util.List;

import hotel.dto.AskDto;

public interface AskService {

	public List<AskDto> selectAskList() throws Exception;

	
	public void insertAsk(AskDto askDto) throws Exception;
//	public AskDto selectAskDetail(int askIdx) throws Exception;
	void updateAsk(AskDto askdDto) throws Exception;
	void deleteAsk(int askIdx) throws Exception;


	public List<AskDto> selectAskList(int offset) throws Exception;


	int selectAskListCount() throws Exception;
}
