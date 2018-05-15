package com.bie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bie.dao.JxcAdminMapper;
import com.bie.po.JxcAdmin;
import com.bie.service.AdminService;

/***
 * 
 * @author 别先生
 * 1: extends BaseServiceImpl<JxcAdmin> 
 */
//添加到Ioc容器中
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	//添加到Ioc容器中
	@Autowired
	protected JxcAdminMapper jxcAdminMapper;
	
	//管理员登陆的方法
	@Override
	public JxcAdmin adminLogin(JxcAdmin jxcAdmin) {
		JxcAdmin result = isEmpty(jxcAdmin);
		return result;
	}

	//判断是否为空
	public JxcAdmin isEmpty(JxcAdmin jxcAdmin){
		//如果账号和密码不为空
		if(jxcAdmin != null && !"".equals(jxcAdmin)){
			return jxcAdminMapper.adminLogin(jxcAdmin);
		}
		return null;
	}

	@Override
	public int insertAdmin(JxcAdmin jxcAdmin) throws Exception {
		int insertAdmin = jxcAdminMapper.insertAdmin(jxcAdmin);
		return insertAdmin;
	}

	@Override
	public List<JxcAdmin> selectAllAdmin(JxcAdmin jxcAdmin) throws Exception {
		List<JxcAdmin> resultAll = jxcAdminMapper.selectAllAdmin(jxcAdmin);
		if(resultAll != null && !"".equals(resultAll)){
			return resultAll;
		}
		return null;
	}

	@Override
	public JxcAdmin queryBySingle(JxcAdmin jxcAdmin) throws Exception {
		if(jxcAdmin != null && !"".equals(jxcAdmin)
				&& jxcAdmin.getAdminId() != null && !"".equals(jxcAdmin.getAdminId())){
			//注意,必须将查询的结果返回回去,避免出现此类错误
			return jxcAdminMapper.queryBySingle(jxcAdmin.getAdminId());
		}
		return null;
	}

	@Override
	public boolean updateAdmin(JxcAdmin jxcAdmin) throws Exception {
		if(jxcAdmin != null && !"".equals(jxcAdmin)){
			boolean updateAdmin = jxcAdminMapper.updateAdmin(jxcAdmin);
			//判断如果为true，可以返回为true，可以省略为一步
			if(updateAdmin){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteAdmin(JxcAdmin jxcAdmin) throws Exception {
		if(jxcAdmin != null && !"".equals(jxcAdmin)){
			//如果删除成功就返回true
			return jxcAdminMapper.deleteAdmin(jxcAdmin);
		}
		return false;
	}

	@Override
	public List<JxcAdmin> queryByCondition(JxcAdmin jxcAdmin) {
		if(jxcAdmin != null && !"".equals(jxcAdmin)){
			List<JxcAdmin> queryByCondition = jxcAdminMapper.queryByCondition(jxcAdmin);
			return queryByCondition;
		}
		return null;
	}

	@Override
	public boolean batchDeleteAdmin(List<Integer> adminIds) throws Exception {
		//判断List集合里面是否存在数据
		if(!adminIds.isEmpty() &&  adminIds.size() > 0){
			//如果批量删除成功就返回true
			return jxcAdminMapper.batchDeleteAdmin(adminIds);
		}
		return false;
	}

	
	
	 
}
