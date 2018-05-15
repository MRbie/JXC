package com.bie.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bie.po.JxcPurchaseorder;
import com.bie.service.PurchaseorderService;
/***
 * 
 * @author 别先生
 * 1:员工的业务层实现类,继承工具类,实现员工接口
 */
@Service("purchaseorderService")
public class PurchaseorderServiceImpl extends BaseServiceImpl<JxcPurchaseorder> implements PurchaseorderService{

	@Override
	public List<JxcPurchaseorder> selectAllStock(JxcPurchaseorder jxcPurchaseorder) throws Exception {
		return jxcPurchaseorderMapper.selectAllStock(jxcPurchaseorder);
	}

	@Override
	public List<JxcPurchaseorder> purchaseorderPassAndRefuseAndReturn(JxcPurchaseorder jxcPurchaseorder) throws Exception{
		return jxcPurchaseorderMapper.purchaseorderPassAndRefuseAndReturn(jxcPurchaseorder);
	}

	@Override
	public boolean saleOrder(JxcPurchaseorder jxcPurchaseorder) throws Exception {
		return jxcPurchaseorderMapper.saleOrder(jxcPurchaseorder);
	}

	
}
