package com.bie.utils;
/**
 * 视图跳转的接口
 * @author 别先生
 *
 */
public interface Views {

	//管理员的视图跳转静态变量Views.systemAdminSelect
	public static final String systemAdminAdd="system/admin/admin_add";
	public static final String systemAdminList="system/admin/admin_list";
	public static final String systemAdminShow="system/admin/admin_show";
	public static final String systemAdminUpdate="system/admin/admin_update";
	public static final String systemAdminSelect="redirect:/admin/adminPaging.action";
	//管理员登录验证的视图跳转
	public static final String systemMainIndex="main/index";
	public static final String systemMainErrorAccount="main/errorAccount";
	public static final String systemMainLogin="main/login";
	
	
	
	
	//员工的视图跳转静态变量
	public static final String systemEmployeeList="system/employee/employee_list";
	public static final String systemEmployeeAdd="system/employee/employee_add";
	public static final String systemEmployeeShow="system/employee/employee_show";
	public static final String systemEmployeeUpdate="system/employee/employee_update";
	public static final String systemEmployeeSelect="redirect:/employee/employeeSelect.action";
	
	//管理员修改密码
	public static final String systemEmployeeAdminModifyPassword="main/modifyPassword";
	public static final String systemEmployeeAdminErrorPassword="main/errorPassword";
	
	
	//供应商的视图跳转静态变量
	public static final String systemSupplierList="system/supplier/supplier_list";
	public static final String systemSupplierAdd="system/supplier/supplier_add";
	public static final String systemSupplierShow="system/supplier/supplier_show";
	public static final String systemSupplierUpdate="system/supplier/supplier_update";
	public static final String systemSupplierSelect="redirect:/supplier/supplierSelect.action";
		
	
	//商品的视图跳转静态变量
	public static final String systemGoodsList="system/goods/goods_list";
	public static final String systemGoodsAdd="system/goods/goods_add";
	public static final String systemGoodsShow="system/goods/goods_show";
	public static final String systemGoodsUpdate="system/goods/goods_update";
	public static final String systemGoodsSelect="redirect:/goods/goodsSelect.action";
	
	
	//数据字典的视图跳转静态变量
	public static final String systemDatadictionaryList="system/dictionary/dictionary_list";
	public static final String systemDatadictionaryAdd="system/datadictionary/datadictionary_add";
	public static final String systemDatadictionaryShow="system/dictionary/dictionary_show";
	public static final String systemDatadictionaryUpdate="system/dictionary/dictionary_update";
	public static final String systemDatadictionarySelect="redirect:/datadictionary/datadictionarySelect.action";
	
	
	//字典项的视图跳转静态变量
	public static final String systemDicDataList="system/dictionary/dicdata_list";
	public static final String systemDicDataAdd="system/dictionary/dicdata_add";
	//public static final String systemDicDataShow="system/dictionary/dicdata_show";
	public static final String systemDicDataUpdate="system/dictionary/dicdata_update";
	public static final String systemDicDataSelect="redirect:/dicdata/maintainDatadictionary.action";
	
	
	//角色的视图跳转静态变量
	public static final String systemRoleList="system/role/role_list";
	public static final String systemRoleAdd="system/role/role_add";
	public static final String systemRoleShow="system/role/role_show";
	public static final String systemRoleUpdate="system/role/role_update";
	public static final String systemRoleSelect="redirect:/role/roleSelect.action";
	
	
	//客户的视图跳转静态变量customer
	public static final String systemCustomerList="system/customer/customer_list";
	public static final String systemCustomerAdd="system/customer/customer_add";
	public static final String systemCustomerShow="system/customer/customer_show";
	public static final String systemCustomerUpdate="system/customer/customer_update";
	public static final String systemCustomerSelect="redirect:/customer/customerSelect.action";
	
	
	//仓库的视图跳转静态变量
	public static final String systemWarehouseList="system/warehouse/warehouse_list";
	public static final String systemWarehouseAdd="system/warehouse/warehouse_add";
	public static final String systemWarehouseShow="system/warehouse/warehouse_show";
	public static final String systemWarehouseUpdate="system/warehouse/warehouse_update";
	public static final String systemWarehouseSelect="redirect:/warehouse/warehouseSelect.action";
	
	//采购订单管理
	public static final String systemPurchaseorderSelect="system/purchaseorder/purchaseorder_list3";
	public static final String systemSelectPurchaseorder="forward:/goods/purchaseOrderByGoods.action";
	public static final String systemPurchaseorderQuery="forward:/purchaseorder/jxcPurchaseorderSelect.action";
	public static final String systemPurchaseorderShow="system/purchaseorder/purchaseorder_show";
	public static final String systemPurchaseorderMessage="system/purchaseorder/purchaseorder_message";
	//20180411
	public static final String systemPurchaseorderPass="system/purchaseorder/purchaseorder_pass";
	public static final String systemPurchaseorderRefuse="system/purchaseorder/purchaseorder_refuse";
	public static final String systemPurchaseorderReturn="system/purchaseorder/purchaseorder_return";
	
	
	//库存信息管理
	public static final String systemPurchaseorderStock="system/stock/stock_show";
	
	//销售订单信息管理
	public static final String systemSaleOrder="system/salesorder/salesorder_list";
	public static final String systemSaleOrderSuccess="redirect:/saleOrder/jxcPurchaseorderStockSelect.action";
	public static final String systemSaleOrderSingle="system/salesorder/salesorder_show";
	public static final String systemSaleOrderReturn="system/salesorder/salesorder_return";
	public static final String systemSaleOrderReturnSuccess="redirect:/saleOrder/saleOrderList.action";
	
	
	
	//数据字典项查询的字段
	public static final String systemAdmin_adminType="admin_type";
	public static final String systemEmployee_employeeType="employee_type";
	public static final String systemWarehouse_warehouseType="warehouse_type";
	public static final String systemGoods_goodsType="goods_type";
	public static final String systemGoods_goodsColor="goods_color";
	
	
	//菜单的视图跳转静态变量
	public static final String systemMenuList="system/menu/menu_list";
	public static final String systemMenuAdd="system/menu/menu_add";
	public static final String systemMenuShow="system/menu/menu_show";
	public static final String systemMenuUpdate="system/menu/menu_update";
	public static final String systemMenuSelect="redirect:/menu/menuSelect.action";
		
	
	//根据对应的类型查询出所需的信息
	public static final String systemEmployeeTypeByRoleType_Warehouse="仓库管理员";
	public static final String systemEmployeeTypeByRoleType_Purchaseorder="采购管理员";
	public static final String systemEmployeeTypeByRoleType_Sale="销售管理员";
	public static final String systemEmployeeTypeByRoleType_Admin="高级管理员";
	
	
	//报表的视图
	public static final String employeeWorkbenchCharts="system/workbench/employee_charts";
	
	//系统介绍的视图信息
	public static final String systemIntroduce="system/introduce/introduce";
	
	
}
