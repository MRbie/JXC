package com.bie.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bie.po.JxcEmployee;
import com.bie.service.EmployeeService;

public class UserRealm extends AuthorizingRealm{

	//@Autowired
	//private UserService userService;
	//员工Ioc注入
	@Autowired
	private EmployeeService employeeService;
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String employeeName=(String)principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		try {
			authorizationInfo.setRoles(employeeService.findPermissionsByEmployeeName(employeeName));
			authorizationInfo.setStringPermissions(employeeService.findPermissionsByEmployeeName(employeeName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String employeeName=(String)token.getPrincipal();
		JxcEmployee jxcEmployee;
		try {
			jxcEmployee = employeeService.getEmployeeByEmployeeName(employeeName);
			if(jxcEmployee==null){
				throw new UnknownAccountException();
			}
			SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
					jxcEmployee.getEmployeeAccount(),
					jxcEmployee.getEmployeePassword(),
					ByteSource.Util.bytes(jxcEmployee.getEmployeeAccount()+jxcEmployee.getEmployeePassword()),
					getName());
			return authenticationInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
