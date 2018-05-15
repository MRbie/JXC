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

import com.bie.po.JxcDatadictionary;
import com.bie.service.DatadictionaryService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:数据字典的控制层
 */
@Controller
@RequestMapping(value="/datadictionary")
public class DatadictionaryAction {

	//注意:实现类不支持jdk的动态代码,只支持接口方式注入。实现类可以使用cglib代码模式。
	@Resource()
	private DatadictionaryService datadictionaryService;
	
	//查询数据字典的方法
	@RequestMapping("/datadictionarySelect")
	public ModelAndView selectDatadictionaryName(JxcDatadictionary jxcDatadictionary,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断数据字典名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("datadictionaryName") && context != null && !"".equals(context)){
			jxcDatadictionary.setDatadictionaryName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcDatadictionary> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcDatadictionary> resultDatadictionaryName = datadictionaryService.selectAll(jxcDatadictionary);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcDatadictionary>(resultDatadictionaryName, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemDatadictionaryList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入数据字典的方法
	@RequestMapping("/insertDatadictionary")
	public ModelAndView insertDatadictionary(JxcDatadictionary jxcDatadictionary,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			boolean flag = datadictionaryService.insert(jxcDatadictionary);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemDatadictionarySelect);
			}else{
				//如果插入失败,在数据字典插入界面提示插入失败
				mv.setViewName(Views.systemDatadictionaryAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//数据字典修改的方法datadictionaryUpdate
	@RequestMapping("/datadictionaryUpdate")
	public ModelAndView updateDatadictionary(JxcDatadictionary jxcDatadictionary,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = datadictionaryService.update(jxcDatadictionary);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到数据字典管理页面
				mv.setViewName(Views.systemDatadictionarySelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//数据字典删除的方法datadictionaryDelete
	@RequestMapping("/datadictionaryDelete")
	public ModelAndView deleteDatadictionary(JxcDatadictionary jxcDatadictionary,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = datadictionaryService.delete(jxcDatadictionary);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到数据字典管理页面
				mv.setViewName(Views.systemDatadictionarySelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//数据字典查询详细的方法
	@RequestMapping("/queryDatadictionaryBySingle")
	public ModelAndView queryDatadictionaryBySingle(JxcDatadictionary jxcDatadictionary,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcDatadictionary resultSingleDatadictionary = datadictionaryService.select(jxcDatadictionary);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleDatadictionary != null && !"".equals(resultSingleDatadictionary)){
				//设置到域中
				request.setAttribute("resultSingleDatadictionary", resultSingleDatadictionary);
				//设置返回页面
				mv.setViewName(Views.systemDatadictionaryUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除数据字典信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="datadictionaryIds")List<Integer> datadictionaryIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除数据字典的方法
		try {
			boolean batchDelete = datadictionaryService.deleteList(datadictionaryIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemDatadictionarySelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//数据字典查询个人详细信息的方法
	@RequestMapping("/queryDatadictionaryDetail")
	public ModelAndView queryDatadictionaryDetail(JxcDatadictionary jxcDatadictionary,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcDatadictionary queryDatadictionaryDetail = datadictionaryService.select(jxcDatadictionary);
			//如果查询的值不为空,就显示在修改页面
			if(queryDatadictionaryDetail != null && !"".equals(queryDatadictionaryDetail)){
				//设置到域中
				request.setAttribute("queryDatadictionaryDetail", queryDatadictionaryDetail);
				//设置返回页面
				mv.setViewName(Views.systemDatadictionaryShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
}
