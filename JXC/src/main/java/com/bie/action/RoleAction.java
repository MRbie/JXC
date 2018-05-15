package com.bie.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcMenu;
import com.bie.po.JxcRole;
import com.bie.service.MenuService;
import com.bie.service.RoleService;
import com.bie.utils.Constants;
import com.bie.utils.JsonUtils;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1角色的控制层
 */
@Controller
@RequestMapping(value="/role")
public class RoleAction {

	//注意:实现类不支持jdk的动态代码,只支持接口方式注入。实现类可以使用cglib代码模式。
	@Resource()
	private RoleService roleService;
	@Resource()
	private MenuService menuService;
	
	//查询角色的方法
	@RequestMapping("/roleSelect")
	public ModelAndView selectRole(JxcRole jxcRole,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断角色姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("roleName") && context != null && !"".equals(context)){
			jxcRole.setRoleName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcRole> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcRole> resultRole = roleService.selectAll(jxcRole);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcRole>(resultRole, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemRoleList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入角色的方法
	@RequestMapping("/insertRole")
	public ModelAndView insertRole(JxcRole JxcRole,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置角色正常值为3000
		JxcRole.setRoleStatus(Constants.roleStatusTrue);
		try {
			boolean flag = roleService.insert(JxcRole);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemRoleSelect);
			}else{
				//如果插入失败,在角色插入界面提示插入失败
				mv.setViewName(Views.systemRoleAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//角色修改的方法roleUpdate
	@RequestMapping("/roleUpdate")
	public ModelAndView updateRole(JxcRole JxcRole,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = roleService.update(JxcRole);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到角色管理页面
				mv.setViewName(Views.systemRoleSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//角色删除的方法roleDelete
	@RequestMapping("/roleDelete")
	public ModelAndView deleteRole(JxcRole JxcRole,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置角色异常值为3001
		JxcRole.setRoleStatus(Constants.roleStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = roleService.delete(JxcRole);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到角色管理页面
				mv.setViewName(Views.systemRoleSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//角色查询个单个的方法
	@RequestMapping("/queryRoleBySingle")
	public ModelAndView queryRoleBySingle(JxcRole JxcRole,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcRole resultSingleRole = roleService.select(JxcRole);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleRole != null && !"".equals(resultSingleRole)){
				//设置到域中
				request.setAttribute("resultSingleRole", resultSingleRole);
				//设置返回页面
				mv.setViewName(Views.systemRoleUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除角色信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="roleIds")List<Integer> roleIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除角色的方法
		try {
			boolean batchDelete = roleService.deleteList(roleIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemRoleSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	//角色查询详细信息的方法
	@RequestMapping("/queryRoleDetail")
	public ModelAndView queryRoleDetail(JxcRole JxcRole,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcRole queryRoleDetail = roleService.select(JxcRole);
			//如果查询的值不为空,就显示在修改页面
			if(queryRoleDetail != null && !"".equals(queryRoleDetail)){
				//设置到域中
				request.setAttribute("queryRoleDetail", queryRoleDetail);
				//设置返回页面
				mv.setViewName(Views.systemRoleShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	
	//先将员工类型查询出来
	@RequestMapping(value="preInsertEmployeeMessage",method=RequestMethod.GET)
	public ModelAndView preInsertEmployeeMessage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			//查询出角色类型
			List<JxcRole> roleType = roleService.selectAll(null);
			if(!roleType.isEmpty() && roleType.size() > 0){
				request.setAttribute("roleType", roleType);
				mv.setViewName(Views.systemEmployeeAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
		
	
	//给角色授权
	@RequestMapping(value="roleToMenu",method=RequestMethod.POST)
	//@ResponseBody
	public ModelAndView roleToMenu(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		ModelAndView mv = new ModelAndView();
		//查询出菜单信息,展示出来
		try {
			List<JxcMenu> resultMenu = menuService.selectAll(null);
			if(resultMenu.size()>0 && !resultMenu.isEmpty()){
				//page = new PageInfo<JxcGoods>(resultGoods, 3);
				//request.setAttribute("pageInfo", page);
				request.setAttribute("resultMenu", resultMenu);
				response.getWriter().write(JsonUtils.object2String(resultMenu));
				response.getWriter().flush();
				response.getWriter().close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
}
