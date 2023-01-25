package hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.dto.AskDto;
import hotel.mapper.AskMapper;

@Service
public class AskServiceImpl implements AskService {

	@Autowired
	private AskMapper askMapper;

	@Override
	public List<AskDto> selectAskList() throws Exception {
		return askMapper.selectAskList();
	}

	@Override
	public void insertAsk(AskDto askDto) throws Exception {
		askMapper.insertAsk(askDto);
	}

//	@Override
//	public AskDto selectAskDetail(int askIdx) throws Exception {
//		askMapper.updateHitCount(askIdx);
//		return askMapper.selectAskDetail(askIdx);
//	}

	@Override
	public void updateAsk(AskDto askdDto) throws Exception {
		askMapper.updateAsk(askdDto);
	}

	@Override
	public void deleteAsk(int askIdx) throws Exception {
		askMapper.deleteAsk(askIdx);
	}

	@Override
	public List<AskDto> selectAskList(int offset) throws Exception {
		return askMapper.selectAskList(offset);
	}

	@Override
	public int selectAskListCount() throws Exception {
		return askMapper.selectAskListCount();
	}

}
