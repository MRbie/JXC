package com.bie.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcDicdata;
import com.bie.po.JxcEmployee;
import com.bie.po.JxcWarehouse;
import com.bie.service.DicDataService;
import com.bie.service.EmployeeService;
import com.bie.service.WarehouseService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:仓库的控制层
 */
@Controller
@RequestMapping(value="/warehouse")
public class WarehouseAction {

	@Resource
	private WarehouseService warehouseService;
	@Resource()
	public DicDataService warehouseDicDataService;
	@Resource()
	private EmployeeService warehouseEmployeeService;
	
	//查询仓库的方法
	@RequestMapping("/warehouseSelect")
	public ModelAndView selectWarehouse(JxcWarehouse jxcWarehouse,@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//warehouseId adminId warehouseName warehouseCode warehouseAddress
		//warehouseDesc warehouseUpdater warehouseUpdatetime
		//warehouseStatus warehouseExtends warehousePersonLiable warehouseType
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcWarehouse.setWarehouseName(context);
		}
		//判断仓库类型
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseType") && context != null && !"".equals(context)){
			jxcWarehouse.setWarehouseType(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		PageHelper.startPage(pn,5);
		PageInfo<JxcWarehouse> page = null;
		//调用业务逻辑层的方法
		try {
			List<JxcWarehouse> resultWarehouse = warehouseService.selectAll(jxcWarehouse);
			//将管理员的信息放入到PageInfo中
			page = new PageInfo<JxcWarehouse>(resultWarehouse, 5);
			//保存到域中
			request.setAttribute("pageInfo", page);
			//设置返回值
			mv.setViewName(Views.systemWarehouseList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//插入仓库的方法
	@RequestMapping("/insertWarehouse")
	public ModelAndView insertWarehouse(JxcWarehouse jxcWarehouse,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置仓库正常值为3000
		jxcWarehouse.setWarehouseStatus(Constants.warehouseStatusTrue);
		try {
			boolean flag = warehouseService.insert(jxcWarehouse);
			//如果返回为true,代表插入操作成功
			if(flag){
				mv.setViewName(Views.systemWarehouseSelect);
			}else{
				//如果插入失败,在仓库插入界面提示插入失败
				mv.setViewName(Views.systemWarehouseAdd);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//仓库修改的方法warehouseUpdate
	@RequestMapping("/warehouseUpdate")
	public ModelAndView updateWarehouse(JxcWarehouse jxcWarehouse,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//将要修改的信息保存到数据库中,完成修改操作
		try {
			boolean flag = warehouseService.update(jxcWarehouse);
			//如果为true,说明修改成功
			if(flag){
				//修改成功,返回到仓库管理页面
				mv.setViewName(Views.systemWarehouseSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	//仓库删除的方法warehouseDelete
	@RequestMapping("/warehouseDelete")
	public ModelAndView deleteWarehouse(JxcWarehouse jxcWarehouse,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置仓库异常值为3001
		jxcWarehouse.setWarehouseStatus(Constants.warehouseStatusFalse);
		//调用业务逻辑层完成删除操作
		try {
			boolean flag = warehouseService.delete(jxcWarehouse);
			//如果为true,说明删除成功
			if(flag){
				//删除成功,返回到仓库管理页面
				mv.setViewName(Views.systemWarehouseSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//仓库查询单个的方法
	@RequestMapping("/queryWarehouseBySingle")
	public ModelAndView queryWarehouseBySingle(JxcWarehouse jxcWarehouse,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcDicdata jxcDicdata = new JxcDicdata();
		//查询出数据字典里面仓库的类型
		jxcDicdata.setDicdataCode(Views.systemWarehouse_warehouseType);
		List<JxcDicdata> dicDataCodeByDataDicCode = new ArrayList<JxcDicdata>();
		JxcEmployee jxcEmployee = new JxcEmployee();
		//查询出谁是仓库管理员
		//jxcEmployee.setEmployeeType(Views.systemEmployeeTypeByRoleType);
		try {
			dicDataCodeByDataDicCode = warehouseDicDataService.getDicDataCodeByDataDicCode(jxcDicdata);
			JxcWarehouse resultSingleWarehouse = warehouseService.select(jxcWarehouse);
			//如果查询的值不为空,就显示在修改页面
			if(resultSingleWarehouse != null && !"".equals(resultSingleWarehouse)){
				//设置到域中
				request.setAttribute("resultSingleWarehouse", resultSingleWarehouse);
			}
			//查询出数据字典里面的数据项
			if(!dicDataCodeByDataDicCode.isEmpty() && dicDataCodeByDataDicCode.size() > 0){
				request.setAttribute("dicDataCodeByDataDicCode", dicDataCodeByDataDicCode);
			}
			//查询员工是仓库管理员的
			List<JxcEmployee> resultEmployeeType = warehouseEmployeeService.selectAll(jxcEmployee);
			if(!resultEmployeeType.isEmpty() && resultEmployeeType.size() > 0){
				request.setAttribute("resultEmployeeType", resultEmployeeType);
			}
			//设置返回页面
			mv.setViewName(Views.systemWarehouseUpdate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//批量删除仓库信息的操作
	@RequestMapping(value="batchDelete",method=RequestMethod.GET)
	public ModelAndView batchDelete(@RequestParam(value="warehouseIds")List<Integer> warehouseIds){
		ModelAndView mv = new ModelAndView();
		//调用批量删除仓库的方法
		try {
			boolean batchDelete = warehouseService.deleteList(warehouseIds);
			//如果为true代表批量删除成功
			if(batchDelete){
				mv.setViewName(Views.systemWarehouseSelect);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	//仓库查询单个详细信息的方法
	@RequestMapping(value="queryWarehouseIdsDetail",method=RequestMethod.GET)
	public ModelAndView queryWarehouseDetail(JxcWarehouse jxcWarehouse,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		try {
			JxcWarehouse queryWarehouseDetail = warehouseService.select(jxcWarehouse);
			//如果查询的值不为空,就显示在修改页面
			if(queryWarehouseDetail != null && !"".equals(queryWarehouseDetail)){
				//设置到域中
				request.setAttribute("queryWarehouseDetail", queryWarehouseDetail);
				//设置返回页面
				mv.setViewName(Views.systemWarehouseShow);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
}
