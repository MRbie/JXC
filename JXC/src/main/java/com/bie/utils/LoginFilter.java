package com.bie.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;   
/**
 * 异常登陆过滤
 * @author 别先生
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;  
        HttpServletResponse httpServletResponse=(HttpServletResponse) response;  
        HttpSession session = httpServletRequest.getSession();  
        //获取session里面登陆的账号密码信息
        Object adminLogin = session.getAttribute("adminLogin");
        //获取的请求路径  
        String uri=httpServletRequest.getRequestURI();
        //System.out.println("测试请求的路径:" + uri);  
        //如果获取到的登陆信息不为空且不为空字符串  
        if(adminLogin != null && !"".equals(adminLogin)){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else if(uri.contains("/resource/")){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else if(uri.contains("/admin/login")){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else if(uri.contains("/admin/verificationCode.action")){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else if(uri.contains("login.jsp")){
			filterChain.doFilter(httpServletRequest, httpServletResponse);
		}else{
			//request.getRequestDispatcher("/view/system/main/login.jsp").forward(servletRequest, servletResponse);
			request.getRequestDispatcher("/view/main/login.jsp").forward(httpServletRequest, httpServletResponse);
		}
        
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
