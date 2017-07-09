package com.zbss.controller;

import com.alibaba.fastjson.JSONObject;
import com.zbss.entity.PageData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zbss
 * @date 2016年5月19日 下午3:23:34
 * @desc
 */
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	@ModelAttribute
	public void setBaseUrl(HttpServletRequest request){
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
		request.getSession().setAttribute("baseUrl", basePath);
	}
	
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	public JSONObject putRetJson(JSONObject retVal, String code, String msg){
		retVal.put("code", code);
		retVal.put("msg", msg);
		return retVal;
	}

	public JSONObject getRetJson(String code, String msg){
		JSONObject ret = new JSONObject();
		ret.put("code", code);
		ret.put("msg", msg);
		return ret;
	}

	public String getPostParam() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(getRequest().getInputStream()));
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null){
			sb.append(line);
		}
		return sb.toString();
	}
}
