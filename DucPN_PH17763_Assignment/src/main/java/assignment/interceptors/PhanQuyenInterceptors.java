package assignment.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import assignment.entities.Accounts;

@Component
public class PhanQuyenInterceptors implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (((Accounts) request.getSession().getAttribute("acc")).getAdmin() == 0) {
			response.sendRedirect("/assignment/trangchu");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("DemoLogInterceptor@afterCompletion");

		if (ex instanceof NullPointerException) {
			//
		} else if (ex instanceof IndexOutOfBoundsException) {
			//
		}
	}
}
