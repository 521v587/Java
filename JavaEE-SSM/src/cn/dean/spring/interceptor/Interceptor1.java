package cn.dean.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class Interceptor1 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		//判断用户是否登录，如果登录则放行到List列表，没有登录则重定向到登录页面
		//URI:/login.action
		//URL：Http://localhost:8080/springmvc-mybatis/login.action
		String requestURI = request.getRequestURI();
		if(!requestURI.contains("login")){
			String username = (String) request.getSession().getAttribute("USER_SESSION");
			if(username == null){
				response.sendRedirect(request.getContextPath() + "/login.action");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}



}
