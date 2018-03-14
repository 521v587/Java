package cn.dean.spring.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object obj,
			Exception ex) {
		//obj代表的是 异常发生地点的路径 包 类 方法（属性）
		ModelAndView mav = new ModelAndView();
		if(ex instanceof MessageException){
			mav.addObject("error", ((MessageException) ex).getMsg());
		}else{
			mav.addObject("error", "未知异常");
		}
		mav.setViewName("error");
		return mav;
	}

}
