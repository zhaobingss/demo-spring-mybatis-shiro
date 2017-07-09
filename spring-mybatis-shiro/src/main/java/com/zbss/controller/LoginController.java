package com.zbss.controller;

import com.alibaba.fastjson.JSONObject;
import com.zbss.entity.PageData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zhaobing on 2017/7/3.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/doLogin", produces = "application/json;charset=utf-8;", method = RequestMethod.POST)
	public @ResponseBody String doLogin(){
		JSONObject ret = getRetJson("0", "success");

		PageData pd = getPageData();

		String username = pd.getString("username");
		String password = pd.getString("password");
		String rememberMe = pd.getString("rememberMe");
		boolean rm = "1".equals(rememberMe) ? true : false;

		UsernamePasswordToken token = new UsernamePasswordToken();
		token.setRememberMe(rm);
		token.setUsername(username);
		token.setPassword(password.toCharArray());

		Subject subject = SecurityUtils.getSubject();
		String msg = "";
		try {
			subject.login(token);
		} catch (UnknownAccountException une) {
			msg = "账户不正确！";
		} catch(IncorrectCredentialsException ice){
			msg = "密码不正确！";
		}catch(LockedAccountException lae){
			msg = "账户已锁定！";
		}catch(ExcessiveAttemptsException eae){
			msg = "用户名或密码错误次数过多！";
		}catch(AuthenticationException ae){
			msg = "用户名或密码不正确！";
		}

		if (!subject.isAuthenticated()){
			token.clear();
			return putRetJson(ret, "-1", msg).toJSONString();
		}

		return ret.toJSONString();
	}

	@RequestMapping("/doLogout")
	public @ResponseBody String doLogout(){
		JSONObject ret = getRetJson("0", "success");

		Subject subject = SecurityUtils.getSubject();
		if (subject != null){
			subject.logout();
		}

		return ret.toJSONString();
	}

}
