package hotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hotel.dto.ReviewDto;

@Mapper
public interface ReviewMapper {
	List<ReviewDto> selectReviewList(int offset) throws Exception;
	void insertReview(ReviewDto reviewDto) throws Exception;
	void updateHitCount(int reviewIdx) throws Exception;
	ReviewDto selectReviewDetail(int reviewIdx) throws Exception;
	void updateReview(ReviewDto reviewDto) throws Exception;
	void deleteReview(int reviewIdx) throws Exception;
	int selectReviewListCount() throws Exception;
	void reviewImageInsert(ReviewDto reviewDto);
	
	

}
