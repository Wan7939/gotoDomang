package com.gotoDomang.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
	
//	private Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		logger.info("[### preHandle ]" + request.getRequestURI());
		
		return true;
		
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		
		logger.warn("[### postHandle ]" + request.getRequestURI());
	}
		
	@Override
	public void afterCompletion	(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		
		logger.error("[### afterCompletion ]" + request.getRequestURI());
	}
}






