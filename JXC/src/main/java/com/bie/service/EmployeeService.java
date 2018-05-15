package com.bie.service;

import java.util.List;
import java.util.Set;

import com.bie.po.JxcEmployee;
import com.bie.po.Navigation;

/**
 * 员工的业务层的接口
 * @author 别先生
 *
 */
public interface EmployeeService extends BaseService<JxcEmployee>{

	public List<JxcEmployee> selectByEmployeeRole(String roleName);
	
	//管理员登录的方法
	public JxcEmployee adminLogin(JxcEmployee jxcEmployee) throws Exception;
	
	//根据管理员编号进行密码修改
	public boolean modifyPassword(JxcEmployee jxcEmployee) throws Exception;
	
	//结合shiro实现的功能
	//根据用户名获取用户所有角色
	public Set<String> findRolesByEmployeeName(String employeeName) throws Exception;
	
	//根据用户名获取用户所有权限
	public Set<String> findPermissionsByEmployeeName(String employeeName) throws Exception;
	
	//获取导航栏内容
	public List<Navigation> getNavigationBar(String employeeName) throws Exception;
	
	//根据用户名获取用户
	public JxcEmployee getEmployeeByEmployeeName(String employeeName) throws Exception;
	
	//员工报表统计信息
	public List<JxcEmployee> selectByEmployeeRoleType() throws Exception;
	
	//员工薪资统计
	public List<JxcEmployee> selectByEmployeeSalary() throws Exception;
}
