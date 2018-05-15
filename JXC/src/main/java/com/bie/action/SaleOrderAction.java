package com.bie.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bie.po.JxcCustomer;
import com.bie.po.JxcPurchaseorder;
import com.bie.po.JxcSalesorder;
import com.bie.service.CustomerService;
import com.bie.service.PurchaseorderService;
import com.bie.service.SaleOrderService;
import com.bie.utils.Constants;
import com.bie.utils.Views;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 
 * @author 别先生
 * 1:销售订单的控制层
 */
@Controller
@RequestMapping(value="/saleOrder")
public class SaleOrderAction {

	@Resource()
	private PurchaseorderService purchaseorderService;
	@Resource
	private CustomerService customerService;
	@Resource
	private SaleOrderService saleOrderService;
	
	
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
			mv.setViewName(Views.systemSaleOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	
	//订单销售信息，saleOrderSuccess
	@RequestMapping(value="saleOrderSuccess")
	public ModelAndView saleOrderSuccess(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//获取到订单编号的信息
		String orderId = request.getParameter("orderId");
		//获取到数量信息
		String orderNumber = request.getParameter("orderNumber");
		String supplierId = request.getParameter("supplierId");
		String employeeId = request.getParameter("employeeId");
		String warehouseId = request.getParameter("warehouseId");
		String goodsId = request.getParameter("goodsId");
		String customerId = request.getParameter("customerId");
		
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		jxcPurchaseorder.setOrderId(Integer.parseInt(orderId));
		//销售订单数量减1
		jxcPurchaseorder.setOrderNumber(Integer.parseInt(orderNumber)-1);
		
		//设置销售订单
		JxcSalesorder jxcSalesorder = new JxcSalesorder();
		jxcSalesorder.setSupplierId(Integer.parseInt(supplierId));
		jxcSalesorder.setEmployeeId(Integer.parseInt(employeeId));
		jxcSalesorder.setWarehouseId(Integer.parseInt(warehouseId));
		jxcSalesorder.setGoodsId(Integer.parseInt(goodsId));
		jxcSalesorder.setCustomerId(Integer.parseInt(customerId));
		//设置销售订单的状态,设置为500
		jxcSalesorder.setSalesorderStatus(Constants.saleOrderStatusYes);
		
		try {
			/*boolean flag = purchaseorderService.saleOrder(jxcPurchaseorder);
			//如果成功就跳转到展示所有信息的界面
			if(flag){
				request.setAttribute("saleOrderSucess", "销售订单成功......");
			}
			boolean saleOrder = saleOrderService.insert(jxcSalesorder);
			if(saleOrder){
				request.setAttribute("saleOrderInsert", "销售订单插入成功......");
			}*/
			saleOrderService.beginSaleOrderInsertUpdate(jxcPurchaseorder,jxcSalesorder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemSaleOrderSuccess);
		return mv;
	}
	
	//saleOrderSingle 查询订单详细信息
	@RequestMapping(value="saleOrderSingle")
	public ModelAndView saleOrderSingle(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		//获取到订单编号的信息
		String orderId = request.getParameter("orderId");
		JxcPurchaseorder jxcPurchaseorder = new JxcPurchaseorder();
		jxcPurchaseorder.setOrderId(Integer.parseInt(orderId));
		try {
			JxcPurchaseorder result = purchaseorderService.select(jxcPurchaseorder);
			//查询出客户姓名，不为查询条件
			List<JxcCustomer> customer = customerService.selectAll(null);
			//System.out.println(result.toString());
			if(result != null && !"".equals(result)){
				request.setAttribute("resultPurchaseorder", result);
			}
			if(customer != null && !"".equals(customer)){
				request.setAttribute("customer", customer);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemSaleOrderSingle);
		return mv;
	}
	
	
	@RequestMapping(value="saleOrderList")
	public ModelAndView saleOrderList(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcSalesorder jxcSalesorder = new JxcSalesorder();
		//接受将查询的条件和内容
		String condition = request.getParameter("condition");
		String context = request.getParameter("context");
		//判断员工姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("employeeName") && context != null && !"".equals(context)){
			jxcSalesorder.setEmployeeName(context);
		}
		//判断供应商姓名
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("supplierName") && context != null && !"".equals(context)){
			jxcSalesorder.setSupplierName(context);
		}
		//判断仓库名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("warehouseName") && context != null && !"".equals(context)){
			jxcSalesorder.setSupplierName(context);
		}
		//判断商品名称
		if(condition !=null && !"".equals(condition) 
				&& condition.equals("goodsName") && context != null && !"".equals(context)){
			jxcSalesorder.setGoodsName(context);
		}
		//将查询条件回显
		if(context != null &&!"".equals(context)){
			request.setAttribute("resultCondition", condition);
			request.setAttribute("resultContext", context);
		}
		PageHelper.startPage(pn,5);
		PageInfo<JxcSalesorder> page = null;
		//设置销售订单
		jxcSalesorder.setSalesorderStatus(Constants.saleOrderStatusYes);
		try {
			List<JxcSalesorder> result = saleOrderService.selectAll(jxcSalesorder);
			if(result != null && !"".equals(result)){
				//request.setAttribute("saleOrderList", result);
				page = new PageInfo<JxcSalesorder>(result, 5);
				request.setAttribute("pageInfo", page);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemSaleOrderReturn);
		return mv;
	}
	
	
	//saleOrderReturn 退货操作
	@RequestMapping(value="saleOrderReturn")
	public ModelAndView saleOrderReturn(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		JxcSalesorder jxcSalesorder = new JxcSalesorder();
		String salesorderId = request.getParameter("salesorderId");
		jxcSalesorder.setSalesorderId(Integer.parseInt(salesorderId));
		jxcSalesorder.setSalesorderStatus(Constants.saleOrderStatusNo);
		try {
			boolean saleOrderReturn = saleOrderService.saleOrderReturn(jxcSalesorder);
			if(saleOrderReturn){
				request.setAttribute("systemSaleOrderReturnSuccess", "销售订单退货成功......");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName(Views.systemSaleOrderReturnSuccess);
		return mv;
	}
	
	
}
