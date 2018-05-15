package com.bie.utils;

/**
 * 常量工具类
 * @author 别先生
 *
 */
public interface Constants {

	//管理员正常的常量
	public static final String adminStatusTrue = "2000";
	//管理员被删除的常量
	public static final String adminStatusFalse = "2001";
	
	//员工正常的常量
	public static final String employeeStatusTrue = "3000";
	//员工被删除的常量
	public static final String employeeStatusFalse = "3001";
	
	//角色正常的常量
	public static final String roleStatusTrue = "4000";
	//角色被删除的常量
	public static final String roleStatusFalse = "4001";
	
	//商品正常的状态
	public static final String goodStatusTrue = "5000";
	//商品被删除的状态
	public static final String goodStatusFalse = "5001";
	
	//供应商正常的状态
	public static final String supplierStatusTrue = "6000";
	//供应商被删除的状态
	public static final String supplierStatusFalse = "6001";
	
	//客户正常的状态
	public static final String customerStatusTrue = "7000";
	//客户被删除的状态
	public static final String customerStatusFalse = "7001";
	
	//仓库正常的状态
	public static final String warehouseStatusTrue = "8000";
	//仓库被删除的状态
	public static final String warehouseStatusFalse = "8001";
	
	
	//采购订单录入待审核
	public static final String purchaseorderStatusAudit = "1000";
	//采购订单审核通过
	public static final String purchaseorderStatusPass = "1001";
	//采购订单审核拒绝
	public static final String purchaseorderStatusRefuse = "1002";
	//采购订单退货
	public static final String purchaseorderStatusReturn = "1003";
	//不显示的采购订单
	public static final String purchaseorderStatusFalse = "1004";
	
	//菜单正常的常量
	public static final String menuStatusTrue = "9000";
	//菜单被删除的常量
	public static final String menuStatusFalse = "9001";

	//销售订单正常的状态
	public static final String saleOrderStatusYes = "500";
	//销售订单退货的状态
	public static final String saleOrderStatusNo = "501";
	
	
}
