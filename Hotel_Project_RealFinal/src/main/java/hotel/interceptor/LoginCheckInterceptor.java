package hotel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 요청 주소에 "/Hotel/openReviewWrite.do"가 포함된 경우, 세션에 user 정보가 존재하는지 체크
		// 포함되지 않은 경우 메시지와 함께 login 페이지로 이동
		if ((request.getRequestURI().indexOf("/Hotel/openReviewWrite.do") >= 0 
				|| request.getRequestURI().indexOf("/Hotel/openReservationWrite/Seoul.do") >= 0 
				|| request.getRequestURI().indexOf("/Hotel/openReservationWrite/Jeju.do") >= 0)
				&& request.getSession().getAttribute("user") == null) {
			request.getSession().setAttribute("message", "로그인 후 사용하실 수 있습니다.");
			response.sendRedirect("/Hotel/login.do");
			return false;
		} else {
			return true;
		}
	}
}
