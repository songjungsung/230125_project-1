package hotel.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hotel.dto.ReviewDto;
import hotel.service.ReviewService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// 리뷰 리스트 페이지 요청 처리
	@GetMapping("/Hotel/openReviewList.do")
	public ModelAndView openReviewList(

			// 현재 페이지 번호를 요청 파라미터로 부터 추출
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage)
			throws Exception {
		ModelAndView mv = new ModelAndView("ReviewList.html");

		List<ReviewDto> list = reviewService.selectReviewList((currentPage - 1) * 10);
		mv.addObject("list", list);

		// 페이징 정보 출력에 사용되는 변수
		mv.addObject("pageCount", Math.ceil(reviewService.selectReviewListCount() / 10.0));
		mv.addObject("currentPage", currentPage);

		return mv;
	}

	// 리뷰 작성 페이지 요청처리
	@GetMapping("/Hotel/openReviewWrite.do")
	public ModelAndView openReview() throws Exception {
		ModelAndView mv = new ModelAndView("ReviewWrite.html");

		return mv;
	}

	// 리뷰 저장 요청 처리 -> 전달받은 데이터를 데이터베이스에 저장
	@PostMapping("/Hotel/insertReview.do")
	public String insertReview(@RequestParam("imageFile") MultipartFile file, ReviewDto reviewDto) throws Exception {

		reviewService.insertReview(reviewDto, file);
		return "redirect:/Hotel/openReviewList.do";
	}

	@GetMapping("/Hotel/reviewDetail.do")
	public ModelAndView openReviewDetail(@RequestParam int reviewIdx) throws Exception {
		//여기에 기능확인용 askDetail.html, 디자인보는 ReviewDetail.html 경로 바꿔가며 보기
		ModelAndView mv = new ModelAndView("ReviewDetail.html");

		ReviewDto reviewDto = reviewService.selectReviewDetail(reviewIdx);
		mv.addObject("review", reviewDto);

		return mv;
	}

	// 리뷰 업데이트
	@RequestMapping("/Hotel/updateReview.do")
	public String updateReview(ReviewDto reviewDto) throws Exception {
		reviewService.updateReview(reviewDto);
		return "redirect:/Hotel/openReviewList.do";
	}

	// 리뷰 삭제
	@RequestMapping("/Hotel/deleteReview.do")
	public String deleteReview(int reviewIdx) throws Exception {
		reviewService.deleteReview(reviewIdx);
		return "redirect:/Hotel/openReviewList.do";
	}

	@GetMapping("/download.do")
	public void downloadFile(@RequestParam int reviewIdx, HttpServletResponse response) throws Exception {
		// reviewIdx에 해당하는 기사 정보 조회
		ReviewDto reviewDto = reviewService.selectReviewDetail(reviewIdx);
				
		// 기사 정보에서 topicImage 정보를 추출
		String reviewImage = reviewDto.getReviewImage();
		
		// reviewImage 정보에 해당하는 파일을 읽어서 response 객체를 통해서 클라이언트로 전달
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			response.setHeader("Content-Disposition", "inline;");
			
			byte[] buf = new byte[1024];
			fis = new FileInputStream(reviewImage);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			int read;
			while((read = bis.read(buf, 0, 1024)) != -1) {
				bos.write(buf, 0, read);
			}
		} finally {
			bos.close();
			bis.close();
			fis.close();
		}
	}	
//	@PostMapping(value = "insertDo")
//	public void insertDo(File files, Test test, HttpServletResponse reponse, MultipartFile[] uploadFile)
//			throws Exception {
//		System.out.println("TestController insertDo() start");
//
//		String uploadFolder = "C:\\upload";
//		for (MultipartFile multipartFile : uploadFile) {
//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//			try {
//				multipartFile.transferTo(saveFile);
//				files.setOriginalFileName(multipartFile.getOriginalFilename());
//				files.setEmpno(test.getEmpno());
//
//				int fileResult = service.insertFiles(files);
//			} catch (Exception e) {
//				System.out.println("파일 업로드 에러 메세지 >>>" + e.getMessage());
//			}
//		}
//		response.sendRedirect("empList");
//	}

}
