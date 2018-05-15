package com.bie.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcMenu;
import com.bie.service.MenuService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:菜单的控制层
 */
@Controller
@RequestMapping(value="/menu")
public class MenuAction {

	@Resource()
	private MenuService menuService;
	
	//查询菜单的方法
	@RequestMapping("/menuSelect")
	public ModelAndView selectMenu(JxcMenu jxcMenu,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断菜单姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("menuName") && context != null && !"".equals(context)){
			jxcMenu.setMenuName(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcMenu> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcMenu> resultMenu = menuService.selectAll(jxcMenu);
			//将菜单的信息放入到PageInfo中
			page = new PageInfo<JxcMenu>(resultMenu, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemMenuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入菜单的方法
	@RequestMapping("/insertMenu")
	public ModelAndView insertMenu(JxcMenu jxcMenu,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置菜单正常值为9000
		jxcMenu.setMenuStatus(Constants.menuStatusTrue);
		try {
			boolean flag = menuService.insert(jxcMenu);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemMenuSelect);
			}else{
				//如果插入失败,在菜单插入界面提示插入失败
				mv.setViewName(Views.systemMenuAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//菜单修改的方法menuUpdate
	@RequestMapping("/menuUpdate")
	public ModelAndView updateMenu(JxcMenu jxcMenu,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String menuIsleaf = jxcMenu.getMenuIsleaf();
		//修改的时候判断一下其值是否是yes,如果不是yes就赋值为no
		if(menuIsleaf == null || menuIsleaf.equals("")){
			menuIsleaf="no";
			jxcMenu.setMenuIsleaf(menuIsleaf);
		}
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = menuService.update(jxcMenu);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到菜单管理页面
				mv.setViewName(Views.systemMenuSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//菜单删除的方法menuDelete
	@RequestMapping("/menuDelete")
	public ModelAndView deleteMenu(JxcMenu jxcMenu,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置菜单异常值为9001
		jxcMenu.setMenuStatus(Constants.menuStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = menuService.delete(jxcMenu);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到菜单管理页面
				mv.setViewName(Views.systemMenuSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//菜单查询个人的方法
	@RequestMapping("/queryMenuBySingle")
	public ModelAndView queryMenuBySingle(JxcMenu jxcMenu,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcMenu resultSingleMenu = menuService.select(jxcMenu);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleMenu != null && !"".equals(resultSingleMenu)){
				//设置到域中
				request.setAttribute("resultSingleMenu", resultSingleMenu);
			}
			//设置返回页面
			mv.setViewName(Views.systemMenuUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除菜单信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="menuIds")List<Integer> menuIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除菜单的方法
		try {
			boolean batchDelete = menuService.deleteList(menuIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemMenuSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	
	
}
