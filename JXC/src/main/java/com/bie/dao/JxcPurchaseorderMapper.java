package com.bie.dao;

import java.util.List;

import com.bie.po.JxcPurchaseorder;

/**
 * 
 * @author 别先生
 *
 */
public interface JxcPurchaseorderMapper extends BaseMapper<JxcPurchaseorder>{
    
	//查询出库存信息
	public List<JxcPurchaseorder> selectAllStock(JxcPurchaseorder jxcPurchaseorder);
	
	//查询通过,拒绝和退货的信息
	public List<JxcPurchaseorder> purchaseorderPassAndRefuseAndReturn(JxcPurchaseorder jxcPurchaseorder);
	
	//销售订单信息
	public boolean saleOrder(JxcPurchaseorder jxcPurchaseorder);
}