package com.bie.service.impl;

import org.springframework.stereotype.Service;

import com.bie.po.JxcPurchaseorder;
import com.bie.po.JxcSalesorder;
import com.bie.service.SaleOrderService;
/***
 * 
 * @author 别先生
 *
 */
@Service("saleOrderService")
public class SaleOrderServiceImpl extends BaseServiceImpl<JxcSalesorder> implements SaleOrderService{

	@Override
	public boolean beginSaleOrderInsertUpdate(JxcPurchaseorder jxcPurchaseorder, JxcSalesorder jxcSalesorder) throws Exception {
		boolean saleOrder = jxcPurchaseorderMapper.saleOrder(jxcPurchaseorder);
		boolean insert = jxcSalesorderMapper.insert(jxcSalesorder);
		if(saleOrder && insert){
			return true;
		}
		return false;
	}

	@Override
	public boolean saleOrderReturn(JxcSalesorder jxcSalesorder) throws Exception {
		// TODO Auto-generated method stub
		return jxcSalesorderMapper.saleOrderReturn(jxcSalesorder);
	}

}
