package com.bie.dao;

import com.bie.po.JxcSalesorder;

/**
 * 
 * @author 别先生
 *
 */
public interface JxcSalesorderMapper extends BaseMapper<JxcSalesorder>{
   
	
	//销售订单信息
	public boolean saleOrderReturn(JxcSalesorder jxcSalesorder);
}