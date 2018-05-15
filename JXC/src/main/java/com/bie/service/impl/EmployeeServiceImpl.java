package com.bie.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bie.po.JxcAdmin;
import com.bie.po.JxcEmployee;
import com.bie.po.Navigation;
import com.bie.service.EmployeeService;

/***
 * 
 * @author 别先生
 * 1:员工的业务层实现类,继承工具类,实现员工接口
 */
@Service("employeeService")
public class EmployeeServiceImpl extends BaseServiceImpl<JxcEmployee> implements EmployeeService{

	@Override
	public List<JxcEmployee> selectByEmployeeRole(String roleName) {
		return jxcEmployeeMapper.selectByEmployeeRole(roleName);
	}

	//管理员登陆的方法
	@Override
	public JxcEmployee adminLogin(JxcEmployee jxcEmployee) throws Exception {
		// TODO Auto-generated method stub
		JxcEmployee result = isEmpty(jxcEmployee);
		return result;
	}
	
	//判断是否为空
	public JxcEmployee isEmpty(JxcEmployee jxcEmployee){
		//如果账号和密码不为空
		if(jxcEmployee != null && !"".equals(jxcEmployee)){
			return jxcEmployeeMapper.adminLogin(jxcEmployee);
		}
		return null;
	}

	
	@Override
	public boolean modifyPassword(JxcEmployee jxcEmployee) throws Exception {
		return jxcEmployeeMapper.modifyPassword(jxcEmployee);
	}

	@Override
	public Set<String> findRolesByEmployeeName(String employeeName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissionsByEmployeeName(String employeeName) throws Exception {
		// TODO Auto-generated method stub
		
		return new HashSet<String>(jxcEmployeeMapper.findPermissionsByEmployeeName(employeeName));
	}

	@Override
	public List<Navigation> getNavigationBar(String employeeName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JxcEmployee getEmployeeByEmployeeName(String employeeName) {
		// TODO Auto-generated method stub
		jxcEmployeeMapper.findEmployeeByEmployeeName(employeeName);
		return null;
	}

	@Override
	public List<JxcEmployee> selectByEmployeeRoleType() throws Exception {
		// TODO Auto-generated method stub
		return jxcEmployeeMapper.selectByEmployeeRoleType();
	}

	@Override
	public List<JxcEmployee> selectByEmployeeSalary() throws Exception {
		// TODO Auto-generated method stub
		return jxcEmployeeMapper.selectByEmployeeSalary();
	}
	
}
