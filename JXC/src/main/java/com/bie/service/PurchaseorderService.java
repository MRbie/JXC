package com.bie.service;

import java.util.List;

import com.bie.po.JxcPurchaseorder;

public interface PurchaseorderService extends BaseService<JxcPurchaseorder>{

	public List<JxcPurchaseorder> selectAllStock(JxcPurchaseorder jxcPurchaseorder) throws Exception;
	
	public List<JxcPurchaseorder> purchaseorderPassAndRefuseAndReturn(JxcPurchaseorder jxcPurchaseorder) throws Exception;

	//销售订单信息
	public boolean saleOrder(JxcPurchaseorder jxcPurchaseorder) throws Exception; 
}
