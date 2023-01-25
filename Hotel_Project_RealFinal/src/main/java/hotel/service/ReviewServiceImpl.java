package hotel.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hotel.dto.ReviewDto;
import hotel.mapper.ReviewMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	// 설정 파일에서 업로드 파일이 저장되는 경로를 가져와서 가지고 있는 변수
	@Value("${application.upload-path}")
	private String uploadPath;

	@Override
	public List<ReviewDto> selectReviewList(int offset) throws Exception {
		return reviewMapper.selectReviewList(offset);
	}

	@Override
	public void insertReview(ReviewDto reviewDto, MultipartFile file) throws Exception {
		if (!file.isEmpty()) {
			String savedFilePath = saveFile(file);
			reviewDto.setReviewImage(savedFilePath);
		}
		reviewMapper.insertReview(reviewDto);
	}

	//리뷰 상세
	@Override
	public ReviewDto selectReviewDetail(int reviewIdx) throws Exception {
		reviewMapper.updateHitCount(reviewIdx);
		return reviewMapper.selectReviewDetail(reviewIdx);
	}

	//리뷰 업데이트
	@Override
	public void updateReview(ReviewDto reviewDto) throws Exception {
		 reviewMapper.updateReview(reviewDto);
	}
	
	//리뷰 삭제
	@Override
	public void deleteReview(int reviewIdx) throws Exception {
		 reviewMapper.deleteReview(reviewIdx);
	}

	@Override
	public int selectReviewListCount() throws Exception {
		return reviewMapper.selectReviewListCount();
	}


	@Override
	public void reviewImageInsert(ReviewDto reviewDto, MultipartFile file) throws Exception {
		String savedFilePath = saveFile(file);
		reviewDto.setReviewImage(savedFilePath);
		reviewMapper.reviewImageInsert(reviewDto);		
	}

		

	 //파일을 저장하고 저장 경로를 반환하는 메서드
		@Override
		public String saveFile(MultipartFile file) throws Exception {
			String savedFilePath = uploadPath + file.getOriginalFilename();
			log.debug(savedFilePath);
			
			File uploadFile = new File(savedFilePath);
			file.transferTo(uploadFile);
			
			return savedFilePath;
		}

		

		

}
