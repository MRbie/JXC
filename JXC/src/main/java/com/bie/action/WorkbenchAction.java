package com.bie.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcEmployee;
import com.bie.po.JxcGoods;
import com.bie.service.EmployeeService;
import com.bie.service.GoodsService;
import com.bie.utils.JsonUtils;
import com.bie.utils.Views;

/***
 * 
 * @author 别先生
 * @date 2018年2月23日
 * 报表的action类 
 */
@Controller
@RequestMapping("/workbench")
public class WorkbenchAction {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private GoodsService goodsService;
	
	
	//ajax动态获取员工报表信息
	@RequestMapping(value="employeeTypeWorkbench",method=RequestMethod.POST)
	@ResponseBody
	public void employeeTypeWorkbench(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		//ModelAndView mv = new ModelAndView();
		try {
			List<JxcEmployee> employeeCharts = employeeService.selectByEmployeeRoleType();
			if(!employeeCharts.isEmpty() && employeeCharts!=null){
				request.setAttribute("employeeCharts", employeeCharts);
				response.getWriter().write(JsonUtils.object2String(employeeCharts));
				response.getWriter().flush();
				response.getWriter().close();
			}
			//mv.setViewName(Views.employeeWorkbenchCharts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return mv;
	}
	
	//员工薪资 selectByEmployeeSalary
	//ajax动态获取员工报表信息
	@RequestMapping(value="selectByEmployeeSalary",method=RequestMethod.POST)
	@ResponseBody
	public void selectByEmployeeSalary(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		//ModelAndView mv = new ModelAndView();
		try {
			List<JxcEmployee> employeeSalaryCharts = employeeService.selectByEmployeeSalary();
			if(!employeeSalaryCharts.isEmpty() && employeeSalaryCharts!=null){
				//request.setAttribute("employeeCharts", employeeCharts);
				response.getWriter().write(JsonUtils.object2String(employeeSalaryCharts));
				response.getWriter().flush();
				response.getWriter().close();
			}
			//mv.setViewName(Views.employeeWorkbenchCharts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return mv;
	}
	
	
	
	@RequestMapping(value="selectByGoodsByBuyPrice",method=RequestMethod.POST)
	@ResponseBody
	public void selectByGoodsByBuyPrice(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		//ModelAndView mv = new ModelAndView();
		try {
			List<JxcGoods> goodsCharts = goodsService.selectByGoodsByBuyPrice();
			if(!goodsCharts.isEmpty() && goodsCharts!=null){
				request.setAttribute("goodsCharts", goodsCharts);
				response.getWriter().write(JsonUtils.object2String(goodsCharts));
				response.getWriter().flush();
				response.getWriter().close();
			}
			//mv.setViewName(Views.employeeWorkbenchCharts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return mv;
	}
	
	
	@RequestMapping(value="selectByGoodsBySalePrice",method=RequestMethod.POST)
	@ResponseBody
	public void selectByGoodsBySalePrice(HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		//ModelAndView mv = new ModelAndView();
		try {
			List<JxcGoods> goodsCharts = goodsService.selectByGoodsBySalePrice();
			if(!goodsCharts.isEmpty() && goodsCharts!=null){
				request.setAttribute("goodsCharts", goodsCharts);
				response.getWriter().write(JsonUtils.object2String(goodsCharts));
				response.getWriter().flush();
				response.getWriter().close();
			}
			//mv.setViewName(Views.employeeWorkbenchCharts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return mv;
	}
		
		
		
}
