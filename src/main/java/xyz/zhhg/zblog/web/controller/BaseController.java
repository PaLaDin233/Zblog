/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package xyz.zhhg.zblog.web.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import xyz.zhhg.zblog.utils.paging.Paging;
import xyz.zhhg.zblog.web.conf.Views;
import xyz.zhhg.zblog.web.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller 基类
 * 
 * @author langhsu
 * 
 */
public class BaseController {
	
	protected AuthenticationToken createToken(String username, String password) {
		return new UsernamePasswordToken(username, password);
	}

	/**
	 * 包装分页对象
	 * 
	 * @param pn 页码
	 * @return
	 */
	protected Paging wrapPage(Integer pn) {
		if (pn == null || pn == 0) {
			pn = 1;
		}
		return wrapPage(pn, 7);
	}

	/**
	 * 包装分页对象
	 *
	 * @param pn 页码
	 * @param maxResults 页码
	 * @return
	 */
	protected Paging wrapPage(Integer pn, Integer maxResults) {
		if (pn == null || pn == 0) {
			pn = 1;
		}
		if (maxResults == null || maxResults == 0) {
			maxResults = 10;
		}
		return new Paging(pn, maxResults);
	}

	protected String getSuffix(String name) {
		int pos = name.lastIndexOf(".");
		return name.substring(pos);
	}

	public static String toJson(Object obj) {
		return new Gson().toJson(obj);
	}
	
	public static Map<String,Object> jsonToMap(String json){
		System.out.println(json);
		return JSONObject.parseObject(json);
	}

	protected String getView(String view) {
		return "/jsp" + view+".jsp";
	}
	protected String getView(String view,HttpServletSession session){
		if(session.getAttribute("user")!=null){
			return getView("/user"+view);
		}else{
			return getView("/visit"+view);
		}
	}
	
	protected String routeView(String route, String group) {
		String format = "/jsp" + route;
		return String.format(format, group);
	}
	
	protected String redirectView(String view){
		return "redirect:"+view;
	}

	public static String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("X-Real-IP");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			return ip;
		}
		ip = request.getHeader("X-Forwarded-For");
		if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = ip.indexOf(',');
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		} else {
			return request.getRemoteAddr();
		}
	}
	
	protected void writeToResponse(HttpServletResponse response,Object data){
		String json=toJson(data);
		PrintWriter printWriter = null;
	    try {
	      printWriter = response.getWriter();
	      printWriter.print(json);
	    } catch (IOException ex) {
	      Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      if (null != printWriter) {
	        printWriter.flush();
	        printWriter.close();
	      }
	    }
		
	}
	
	protected User getUser(HttpServletRequest request){
		return (User)request.getSession().getAttribute("user");
	}
	
}
