package com.bie.service;

import com.bie.po.JxcPurchaseorder;
import com.bie.po.JxcSalesorder;

public interface SaleOrderService extends BaseService<JxcSalesorder>{

	public boolean beginSaleOrderInsertUpdate(JxcPurchaseorder jxcPurchaseorder, JxcSalesorder jxcSalesorder) throws Exception;
	
	//销售订单信息
	public boolean saleOrderReturn(JxcSalesorder jxcSalesorder) throws Exception;
}
