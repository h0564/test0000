package com.hk.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hk.member.vo.MemberVO;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// reutrn true 가던길 감
		// reutrn false 그만 가
		// /board/list 요청햇는데 true 일경우 화면 노출 
		// false 일경우 화면 미노출,기능중지
		System.out.println("인터셉터실행");
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendRedirect("login");
			return false; 
		}
		
		
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		if(memberVO==null) {
			response.sendRedirect("login");
			return false; 
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
