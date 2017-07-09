package com.zbss.resolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zbss
 * @date 2016年5月19日 下午3:56:49
 * @desc
 */
public class DefaultExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		
		System.out.println("==============异常开始=============");
		ex.printStackTrace();
		System.out.println("==============异常结束=============");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
		mv.setViewName("error/exception");

		return mv;
	}

}
