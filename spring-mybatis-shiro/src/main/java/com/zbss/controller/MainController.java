package com.zbss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhaobing on 2017/7/4.
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
}
