package com.bie.action;

import java.util.ArrayList;
import java.util.Date;
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

import com.bie.po.JxcEmployee;
import com.bie.po.JxcGoods;
import com.bie.po.JxcPurchaseorder;
import com.bie.po.JxcSupplier;
import com.bie.po.JxcWarehouse;
import com.bie.service.EmployeeService;
import com.bie.service.GoodsService;
import com.bie.service.PurchaseorderService;
import com.bie.service.SupplierService;
import com.bie.service.WarehouseService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:采购订单的控制层
 */
@Controller
@RequestMapping(value="/purchaseorder")
public class PurchaseorderAction {

	@Resource()
	private PurchaseorderService purchaseorderService;
	@Resource
	private GoodsService goodsPurchaseorderService;
	@Resource()
	private EmployeeService employeePurchaseorderService;
	@Resource()
	private SupplierService supplierPurchaseorderService;
	@Resource()
	private WarehouseService warehousePurchaseorderService;
	
	//@RequestParam(value="goodsId")Integer goodsId,
	@RequestMapping("purchaseorderInsert")
	public ModelAndView purchaseorderInsert(JxcPurchaseorder jxcPurchaseorder,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		System.out.println("获取到的采购订单信息:"+ jxcPurchaseorder);
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusAudit);
		try {
			boolean resultPurchaseorder = purchaseorderService.insert(jxcPurchaseorder);
			if(resultPurchaseorder){
				mv.setViewName(Views.systemSelectPurchaseorder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//采购订单审核purchaseorderAudit
	@RequestMapping(value="purchaseorderAuditPass",method=RequestMethod.GET)
	public ModelAndView purchaseorderAuditPass(JxcPurchaseorder jxcPurchaseorder,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置状态为采购订单通过
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusPass);
		try {
			boolean purchaseorderAuditPass = purchaseorderService.update(jxcPurchaseorder);
			if(purchaseorderAuditPass){
				mv.setViewName(Views.systemPurchaseorderQuery);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mv;
	}
	
	//采购订单审核purchaseorderAuditRefuse
	@RequestMapping(value="purchaseorderAuditRefuse",method=RequestMethod.GET)
	public ModelAndView purchaseorderAuditRefuse(JxcPurchaseorder jxcPurchaseorder,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置状态为采购订单通过
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusRefuse);
		try {
			boolean purchaseorderAuditPass = purchaseorderService.update(jxcPurchaseorder);
			if(purchaseorderAuditPass){
				mv.setViewName(Views.systemPurchaseorderQuery);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
		
	
	//退货purchaseorderAuditReturn
	@RequestMapping(value="purchaseorderAuditReturn",method=RequestMethod.GET)
	public ModelAndView purchaseorderAuditReturn(JxcPurchaseorder jxcPurchaseorder,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//设置状态为采购订单通过
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusReturn);
		try {
			boolean purchaseorderAuditPass = purchaseorderService.update(jxcPurchaseorder);
			if(purchaseorderAuditPass){
				mv.setViewName(Views.systemPurchaseorderQuery);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	
	//选择商品 choosePurchaseorder
	//如果时间允许，可以实现批量采购商品
	/*@RequestMapping(value="choosePurchaseorder",method=RequestMethod.GET)
	public ModelAndView choosePurchaseorder(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//获取到传递过来的goodsId值
		String goodsId = request.getParameter("goodsId");
		//商品的数量
		String orderNumber = request.getParameter("orderNumber");
		System.out.println("打印传递过来的商品编号:" + goodsId);
		JxcGoods jxcGoods = new JxcGoods();
		jxcGoods.setGoodsId(Integer.parseInt(goodsId));
		List<JxcGoods> list = new ArrayList<JxcGoods>();
		@SuppressWarnings("unchecked")
		List<JxcGoods> getResultJxcGoods = (List<JxcGoods>) session.getAttribute("resultJxcGoods");
		if(getResultJxcGoods != null && !"".equals(getResultJxcGoods)){
			list.addAll(getResultJxcGoods);
		}
		try {
			JxcGoods resultJxcGoods = goodsPurchaseorderService.select(jxcGoods);
			if(resultJxcGoods != null && !"".equals(resultJxcGoods)){
				list.add(resultJxcGoods);
				//request.setAttribute("resultJxcGoods", list);
				session.setAttribute("resultJxcGoods", list);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemPurchaseorderSelect);
		return mv;
	}
	*/
	
	//查询出商品,@RequestParam(value="pn",defaultValue="1")Integer pn,
	@RequestMapping(value="choosePurchaseorder",method=RequestMethod.GET)
	public ModelAndView choosePurchaseorder(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//获取到传递过来的goodsId值
		String goodsId = request.getParameter("goodsId");
		//商品的数量
		//String orderNumber = request.getParameter("orderNumber");
		System.out.println("打印传递过来的商品编号:" + goodsId);
		JxcGoods jxcGoods = new JxcGoods();
		jxcGoods.setGoodsId(Integer.parseInt(goodsId));
		//批量采购出现问题，所以先注释掉
		List<JxcGoods> list = new ArrayList<JxcGoods>();
		/*@SuppressWarnings("unchecked")
		List<JxcGoods> getResultJxcGoods = (List<JxcGoods>) session.getAttribute("resultJxcGoods");
		if(getResultJxcGoods != null && !"".equals(getResultJxcGoods)){
			list.addAll(getResultJxcGoods);
		}*/
		//从第一条开始，每页查询十条数据，参数设置默认值，从第一条查询
		//PageHelper.startPage(pn,5);
		//PageInfo<JxcGoods> page = null;
		try {
			//查询出商品弹出框弹出来显示商品信息
			JxcGoods resultJxcGoods = goodsPurchaseorderService.select(jxcGoods);
			if(resultJxcGoods != null && !"".equals(resultJxcGoods)){
				list.add(resultJxcGoods);
				request.setAttribute("resultJxcGoods", list);
				//session.setAttribute("resultJxcGoods", list);
				//将管理员的信息放入到PageInfo中
				//page = new PageInfo<JxcGoods>(list, 5);
				//保存到域中
				//request.setAttribute("pageInfo", page);
			}
			
			//查询员工是仓库管理员的
			List<JxcEmployee> resultEmployee = employeePurchaseorderService.selectByEmployeeRole(Views.systemEmployeeTypeByRoleType_Purchaseorder);
			System.out.println("查询出指定的管理员:"+ resultEmployee);
			if(!resultEmployee.isEmpty() && resultEmployee.size() > 0){
				request.setAttribute("resultEmployee", resultEmployee);
			}
			//查询出仓库
			List<JxcWarehouse> resultWarehouse = warehousePurchaseorderService.selectAll(null);
			if(!resultWarehouse.isEmpty() && resultWarehouse.size()>0){
				request.setAttribute("resultWarehouse", resultWarehouse);
			}
			
			//查询出所有的供应商
			List<JxcSupplier> resultSupplier = supplierPurchaseorderService.selectAll(null);
			if(!resultSupplier.isEmpty() && resultSupplier.size()>0){
				request.setAttribute("resultSupplier", resultSupplier);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemPurchaseorderSelect);
		return mv;
	}
	
	
	
	//采购订单的插入操作@RequestParam(value="goodsIds")List<Integer> goodsIds,
	@RequestMapping(value="jxcPurchaseorderInsert")
	public ModelAndView jxcPurchaseorderInsert(JxcPurchaseorder jxcPurchaseorder,HttpServletRequest request,HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
		ModelAndView mv = new ModelAndView();
		//获取到采购订单的信息
		System.out.println("获取到采购信息:" + jxcPurchaseorder);	
		//System.out.println("获取到的商品编号:" + goodsIds);
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusAudit);
		try {
			//插入采购订单信息
			boolean resultPurchaseorder = purchaseorderService.insert(jxcPurchaseorder);
			if(resultPurchaseorder){
				request.setAttribute("choiceGoodsSuccess", "商品选购成功");
				mv.setViewName(Views.systemSelectPurchaseorder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//查询出所有的商品信息
	@RequestMapping(value="jxcPurchaseorderSelect")
	public ModelAndView jxcPurchaseorderSelect(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setEmployeeName(context);
		}
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断商品名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setGoodsName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		PageHelper.startPage(pn,5);
		PageInfo<JxcPurchaseorder> page = null;
		try {
			//先将采购的商品信息查询出来
			List<JxcPurchaseorder> purchaseorder = purchaseorderService.selectAll(jxcPurchaseorder);
			System.out.println(new Date()+ "产生的订单信息展示:" + purchaseorder);
			if(!purchaseorder.isEmpty() && !"".equals(purchaseorder)){
				page = new PageInfo<JxcPurchaseorder>(purchaseorder, 5);
				//request.setAttribute("purchaseorder", purchaseorder);
				request.setAttribute("pageInfo", page);
			}
			mv.setViewName(Views.systemPurchaseorderShow);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//查询出所有的库存管理
	@RequestMapping(value="jxcPurchaseorderStockSelect")
	public ModelAndView jxcPurchaseorderStockSelect(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setEmployeeName(context);
		}
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断商品名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setGoodsName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		PageHelper.startPage(pn,5);
		PageInfo<JxcPurchaseorder> page = null;
		try {
			//先将采购的商品信息查询出来
			List<JxcPurchaseorder> purchaseorder = purchaseorderService.selectAllStock(jxcPurchaseorder);
			//System.out.println(new Date()+ "产生的订单信息展示:" + purchaseorder);
			if(!purchaseorder.isEmpty() && !"".equals(purchaseorder)){
				page = new PageInfo<JxcPurchaseorder>(purchaseorder, 5);
				//request.setAttribute("purchaseorder", purchaseorder);
				request.setAttribute("pageInfo", page);
			}
			mv.setViewName(Views.systemPurchaseorderStock);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//查询出通过，拒绝，退货的信息
	@RequestMapping(value="jxcPurchaseorderPass")
	public ModelAndView jxcPurchaseorderPass(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		//设置订单审核通过的信息
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusPass);
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setEmployeeName(context);
		}
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断商品名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setGoodsName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		PageHelper.startPage(pn,5);
		PageInfo<JxcPurchaseorder> page = null;
		try {
			//先将采购的商品信息查询出来
			List<JxcPurchaseorder> purchaseorder = purchaseorderService.purchaseorderPassAndRefuseAndReturn(jxcPurchaseorder);
			System.out.println(new Date()+ "产生的订单信息展示:" + purchaseorder);
			if(!purchaseorder.isEmpty() && !"".equals(purchaseorder)){
				page = new PageInfo<JxcPurchaseorder>(purchaseorder, 5);
				//request.setAttribute("purchaseorder", purchaseorder);
				request.setAttribute("pageInfo", page);
			}
			mv.setViewName(Views.systemPurchaseorderPass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	//查询出通过，拒绝，退货的信息
	@RequestMapping(value="jxcPurchaseorderRefuse")
	public ModelAndView jxcPurchaseorderRefuse(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		//设置订单审核通过的信息
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusRefuse);
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setEmployeeName(context);
		}
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断商品名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setGoodsName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		PageHelper.startPage(pn,5);
		PageInfo<JxcPurchaseorder> page = null;
		try {
			//先将采购的商品信息查询出来
			List<JxcPurchaseorder> purchaseorder = purchaseorderService.purchaseorderPassAndRefuseAndReturn(jxcPurchaseorder);
			System.out.println(new Date()+ "产生的订单信息展示:" + purchaseorder);
			if(!purchaseorder.isEmpty() && !"".equals(purchaseorder)){
				page = new PageInfo<JxcPurchaseorder>(purchaseorder, 5);
				//request.setAttribute("purchaseorder", purchaseorder);
				request.setAttribute("pageInfo", page);
			}
			mv.setViewName(Views.systemPurchaseorderRefuse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//查询出通过，拒绝，退货的信息
	@RequestMapping(value="jxcPurchaseorderReturn")
	public ModelAndView jxcPurchaseorderReturn(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		//设置订单审核通过的信息
		jxcPurchaseorder.setOrderStatus(Constants.purchaseorderStatusReturn);
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setEmployeeName(context);
		}
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setSupplierName(context);
		}
		//判断商品名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcPurchaseorder.setGoodsName(context);
		}
		
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		PageHelper.startPage(pn,5);
		PageInfo<JxcPurchaseorder> page = null;
		try {
			//先将采购的商品信息查询出来
			List<JxcPurchaseorder> purchaseorder = purchaseorderService.purchaseorderPassAndRefuseAndReturn(jxcPurchaseorder);
			System.out.println(new Date()+ "产生的订单信息展示:" + purchaseorder);
			if(!purchaseorder.isEmpty() && !"".equals(purchaseorder)){
				page = new PageInfo<JxcPurchaseorder>(purchaseorder, 5);
				//request.setAttribute("purchaseorder", purchaseorder);
				request.setAttribute("pageInfo", page);
			}
			mv.setViewName(Views.systemPurchaseorderReturn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	
}
