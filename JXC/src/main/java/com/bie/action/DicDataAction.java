package com.bie.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcDatadictionary;
import com.bie.po.JxcDicdata;
import com.bie.po.JxcEmployee;
import com.bie.service.DicDataService;
import com.bie.service.EmployeeService;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:数据字典存值的控制层
 */
@Controller
@RequestMapping(value="/dicdata")
public class DicDataAction {

	//注意:实现类不支持jdk的动态代码,只支持接口方式注入。实现类可以使用cglib代码模式。
	@Resource()
	public DicDataService dicDataService;
	@Resource()
	private EmployeeService dicEmployeeService;
	
	//维护数据字典的操作,即对字典项进行增删改查操作
	@RequestMapping(value="maintainDatadictionary")
	public ModelAndView maintainDatadictionary(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		Object lastDicdataCode = session.getAttribute("dicdataCodeRequest");
		//System.out.println("销毁的上次的dicdataCodeRequest: "+ lastDicdataCode);
		/*if(lastDicdataCode != null && !"".equals(lastDicdataCode)){
			//清空上次保存到session中的字典项类型,为了再次获取字典项类型
			session.removeAttribute("dicdataCodeRequest");
		}*/
		//接受超链接后面跟的参数,数据字典的字段的值
		//String dicdataCode = request.getParameter("dicdataCode");
		String dicdataCode = request.getParameter("dicdataCode");
		//获取到的值保存到session中,方便获取
		//session.setAttribute("dicdataCode", dicdataCode);
		//创建一个jxcDicdata对象
		JxcDicdata jxcDicdata = new JxcDicdata();
		System.out.println("数据字典参数:" + dicdataCode);
		if(dicdataCode != null && !"".equals(dicdataCode)){
			request.setAttribute("dicdataCodeRequest", dicdataCode);
			//将传过来唯一值datadictionaryField保存到存数据字典数据的字段里面
			jxcDicdata.setDicdataCode(dicdataCode);
		}else if(lastDicdataCode != null && !"".equals(lastDicdataCode)){
			//如果从request获取的为空值，那么使用从session中获取的值来存到setDicdataCode方法中
			//修改字典项的时候发现，必须判断是否为空，不然报空指针异常
			jxcDicdata.setDicdataCode(lastDicdataCode.toString());
		}
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断数据字典名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("dicdataName") && context != null && !"".equals(context)){
			jxcDicdata.setDicdataName(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//然后进行查询操作,如果查询出来,就显示全部对应的字典项
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcDicdata> page = null;
		try {
			List<JxcDicdata> resultDicData = dicDataService.selectAll(jxcDicdata);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcDicdata>(resultDicData, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemDicDataList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//字典项预先插入操作
	@RequestMapping(value="preInsertDicData",method=RequestMethod.GET)
	public ModelAndView preInsertDicData(JxcDicdata jxcDicdata,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		String dicdataCodeRequest = request.getParameter("dicdataCodeRequest");
		//System.out.println("预先获取到的字典项dicdataCodeRequest:" + dicdataCodeRequest);
		//判断是否获取到dicdataCode
		if(dicdataCodeRequest != null && !"".equals(dicdataCodeRequest)){
			//保存到request域中，只能执行一次
			//request.setAttribute("dicdataCode", dicdataCode);
			//这里选择保存到session中，然后再进行销毁的方法
			session.setAttribute("dicdataCodeRequest", dicdataCodeRequest);
		}
		mv.setViewName(Views.systemDicDataAdd);
		return mv;
	}
	
	
	//字典项插入操作
	@RequestMapping(value="insertDicData",method=RequestMethod.POST)
	public ModelAndView insertDicData(JxcDicdata jxcDicdata,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			//如果获取到的字典项的类型不会空,就执行插入操作
			if(jxcDicdata.getDicdataCode() != null && !"".equals(jxcDicdata.getDicdataCode())){
				boolean insertDicData = dicDataService.insert(jxcDicdata);
				//如果插入成功，就设置到查询出字典项的页面
				if(insertDicData){
					mv.setViewName(Views.systemDicDataSelect);
					//mv.setViewName("system/dictionary/dicdata_add");
				}
			}
		} catch (Exception e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//数据字典修改的方法datadictionaryUpdate
	@RequestMapping("/dicdataUpdate")
	public ModelAndView updateDatadictionary(JxcDicdata dicdata,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = dicDataService.update(dicdata);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到数据字典管理页面
				mv.setViewName(Views.systemDicDataSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//数据字典删除的方法datadictionaryDelete
	@RequestMapping("/dicdataDelete")
	public ModelAndView dicdataDelete(JxcDicdata jxcDicdata,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = dicDataService.delete(jxcDicdata);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到数据字典管理页面
				mv.setViewName(Views.systemDicDataSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//数据字典查询详细的方法
	@RequestMapping("/querydicdataBySingle")
	public ModelAndView querydicdataBySingle(JxcDicdata dicdata,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		try {
			JxcDicdata resultSingleJxcDicdata = dicDataService.select(dicdata);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleJxcDicdata != null && !"".equals(resultSingleJxcDicdata)){
				//设置到域中
				request.setAttribute("resultSingleJxcDicdata", resultSingleJxcDicdata);
				//设置返回页面
				mv.setViewName(Views.systemDicDataUpdate);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除数据字典信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="dicdataIds")List<Integer> dicdataIds,HttpServletRequest request,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//调用批量删除数据字典的方法
		try {
			boolean batchDelete = dicDataService.deleteList(dicdataIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemDicDataSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//先将员工类型查询出来
	@RequestMapping(value="preInsertEmployee",method=RequestMethod.GET)
	public ModelAndView preInsertEmployee(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcDicdata jxcDicdata = new JxcDicdata();
		jxcDicdata.setDicdataCode(Views.systemEmployee_employeeType);
		List<JxcDicdata> dicDataCodeByDataDicCode = new ArrayList<JxcDicdata>();
		try {
			dicDataCodeByDataDicCode = dicDataService.getDicDataCodeByDataDicCode(jxcDicdata);
			//System.out.println("预先插入员工的字典项:" + dicDataCodeByDataDicCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!dicDataCodeByDataDicCode.isEmpty() && dicDataCodeByDataDicCode.size() > 0){
			request.setAttribute("dicDataCodeByDataDicCode", dicDataCodeByDataDicCode);
			mv.setViewName(Views.systemEmployeeAdd);
		}
		return mv;
	}
	
	
	//先将仓库类型查询出来
	@RequestMapping(value="preInsertWarehouse",method=RequestMethod.GET)
	public ModelAndView preInsertWarehouse(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcDicdata jxcDicdata = new JxcDicdata();
		//查询出数据字典里面仓库的类型
		jxcDicdata.setDicdataCode(Views.systemWarehouse_warehouseType);
		List<JxcDicdata> dicDataCodeByDataDicCode = new ArrayList<JxcDicdata>();
		JxcEmployee jxcEmployee = new JxcEmployee();
		//查询出谁是仓库管理员
		//jxcEmployee.setEmployeeType(Views.systemEmployeeTypeByRoleType);
		try {
			dicDataCodeByDataDicCode = dicDataService.getDicDataCodeByDataDicCode(jxcDicdata);
			//System.out.println("预先插入仓库的字典项:" + dicDataCodeByDataDicCode);
			//查询员工是仓库管理员的
			List<JxcEmployee> resultEmployeeType = dicEmployeeService.selectAll(jxcEmployee);
			if(!resultEmployeeType.isEmpty() && resultEmployeeType.size() > 0){
				request.setAttribute("resultEmployeeType", resultEmployeeType);
			}
			if(!dicDataCodeByDataDicCode.isEmpty() && dicDataCodeByDataDicCode.size() > 0){
				request.setAttribute("dicDataCodeByDataDicCodeWarehouse", dicDataCodeByDataDicCode);
			}
			mv.setViewName(Views.systemWarehouseAdd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//先将商品类型和商品颜色查询出来
	@RequestMapping(value="preInsertGoods",method=RequestMethod.GET)
	public ModelAndView preInsertGoods(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcDicdata jxcDicdata = new JxcDicdata();
		JxcDicdata jxcDicdata2 = new JxcDicdata();
		//查询出数据字典里面仓库的类型
		jxcDicdata.setDicdataCode(Views.systemGoods_goodsType);
		jxcDicdata2.setDicdataCode(Views.systemGoods_goodsColor);
		List<JxcDicdata> dicDataCodeByDataDicCode = new ArrayList<JxcDicdata>();
		List<JxcDicdata> dicDataCodeByDataDicCode2 = new ArrayList<JxcDicdata>();
		try {
			dicDataCodeByDataDicCode = dicDataService.getDicDataCodeByDataDicCode(jxcDicdata);
			dicDataCodeByDataDicCode2 = dicDataService.getDicDataCodeByDataDicCode(jxcDicdata2);
			//System.out.println("预先插入仓库的字典项:" + dicDataCodeByDataDicCode);
			if(!dicDataCodeByDataDicCode.isEmpty() && dicDataCodeByDataDicCode.size() > 0){
				request.setAttribute("dicDataCodeByDataDicCode", dicDataCodeByDataDicCode);
			}
			if(!dicDataCodeByDataDicCode2.isEmpty() && dicDataCodeByDataDicCode2.size() > 0){
				request.setAttribute("dicDataCodeByDataDicCode2", dicDataCodeByDataDicCode2);
			}
			mv.setViewName(Views.systemGoodsAdd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
		
}
