package com.bie.shiro.filter;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.bie.po.Navigation;
import com.bie.service.EmployeeService;

public class WithNavibarFormAuthenticationFilter extends FormAuthenticationFilter {

	//@Autowired
	//private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest httpReq=(HttpServletRequest)request;
		
		String employeeName=(String)SecurityUtils.getSubject().getPrincipal();
		List<Navigation> navigationBar=employeeService.getNavigationBar(employeeName);
		httpReq.getSession().setAttribute("navibar", navigationBar);
		return super.onLoginSuccess(token, subject, request, response);
	}
	

}
