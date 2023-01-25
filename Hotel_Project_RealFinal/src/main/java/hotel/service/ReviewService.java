package hotel.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hotel.dto.ReviewDto;

public interface ReviewService {
	public List<ReviewDto> selectReviewList(int offset) throws Exception;
	public void insertReview(ReviewDto reviewDto, MultipartFile file) throws Exception;
	public ReviewDto selectReviewDetail(int reviewIdx) throws Exception;
	void updateReview(ReviewDto reviewDto) throws Exception;
	void deleteReview(int reviewIdx) throws Exception;
	public int selectReviewListCount() throws Exception;
	String saveFile(MultipartFile file) throws Exception;
	public void reviewImageInsert(ReviewDto reviewDto, MultipartFile file) throws Exception;
	

}
