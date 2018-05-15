package com.bie.utils;

import java.util.ArrayList;
import java.util.List;

import com.bie.po.JxcMenu;

/**
 * 
 * @author 别先生
 * 菜单的工具类
 * 1、不适用权限框架，由于时间紧张，这里简单实现权限控制即可。
 */
public class MenuUtils {

	/***
	 * 构建后台权限数据
	 * @return
	 */
	public static List<JxcMenu> getData(){
		List<JxcMenu> list = new ArrayList<JxcMenu>();
		//JxcMenu的构造方法的	编号 	名称 	  url 父级id
		list.add(new JxcMenu(1,"系统管理","",0));
		list.add(new JxcMenu(2,"采购管理","",0));
		list.add(new JxcMenu(3,"库存管理","",0));
		list.add(new JxcMenu(4,"销售管理","",0));
		list.add(new JxcMenu(5,"仓库管理","",0));
		//list.add(new JxcMenu(6,"日志管理","",0));
		list.add(new JxcMenu(7,"统计管理","",0));
		list.add(new JxcMenu(8,"系统介绍","",0));
		
		//系统管理
		list.add(new JxcMenu(9,"管理员管理","admin/adminPaging.action",1));
		list.add(new JxcMenu(10,"角色管理 ","role/roleSelect.action",1));
		//list.add(new JxcMenu(11,"菜单管理","menu/menuSelect.action",1));
		list.add(new JxcMenu(12,"员工管理","employee/employeeSelect.action",1));
		list.add(new JxcMenu(13,"数据字典","datadictionary/datadictionarySelect.action",1));
		//list.add(new JxcMenu(14,"密码修改","admin/goModifyPassword.action",1));
		
		//采购管理
		list.add(new JxcMenu(15,"商品管理","goods/goodsSelect.action",2));
		list.add(new JxcMenu(16,"供应商管理","supplier/supplierSelect.action",2));
		list.add(new JxcMenu(17,"采购订单管理","goods/purchaseOrderByGoods.action",2));
		list.add(new JxcMenu(18,"订单审核管理","purchaseorder/jxcPurchaseorderSelect.action",2));
		//20180411 
		list.add(new JxcMenu(19,"订单通过管理","purchaseorder/jxcPurchaseorderPass.action",2));
		list.add(new JxcMenu(20,"订单拒绝管理","purchaseorder/jxcPurchaseorderRefuse.action",2));
		list.add(new JxcMenu(21,"订单退货管理","purchaseorder/jxcPurchaseorderReturn.action",2));
		
		
		//库存管理
		list.add(new JxcMenu(22,"库存管理","purchaseorder/jxcPurchaseorderStockSelect.action",3));
		
		//销售管理
		list.add(new JxcMenu(23,"客户管理","customer/customerSelect.action",4));
		list.add(new JxcMenu(24,"销售订单管理","saleOrder/jxcPurchaseorderStockSelect.action",4));
		list.add(new JxcMenu(25,"销售退货管理","saleOrder/saleOrderList.action",4));
		
		//仓库管理
		list.add(new JxcMenu(26,"仓库管理","warehouse/warehouseSelect.action",5));
		
		//日志管理
		//list.add(new JxcMenu(27,"日志管理","budget/budgetManage/budgetinsert",6));
				
		//统计管理
		//list.add(new JxcMenu(28,"员工报表","workbench/employeeTypeWorkbench.action",7));
		list.add(new JxcMenu(28,"员工报表","view/system/workbench/employee_charts.jsp",7));
		list.add(new JxcMenu(30,"商品报表","view/system/workbench/goods_charts.jsp",7));
		//list.add(new JxcMenu(28,"仓库报表","view/system/workbench/warehouse_charts.jsp",7));
		//list.add(new JxcMenu(28,"客户报表","view/system/workbench/customer_charts.jsp",7));
		
		
		//统计管理
		list.add(new JxcMenu(29,"系统介绍","admin/systemIntroduce",8));
		
		return list;
	}
	
	//提取公共的从权限里面获取权限
	public static List<JxcMenu> getAuth(int[] arr){
		//先获取所有的数据，即后台权限的数据
		List<JxcMenu> list = getData();
		//再创建一个集合，用于遍历和所有权限进行匹配操作
		List<JxcMenu> ordinaryList = new ArrayList<JxcMenu>();
		
		//首先获取全部进行循环，然后拿出数组里面的进行循环
		//如果相等，那么就添加到普通员工的集合中
		for(int i = 0;i < list.size();i++){
			for(int j = 0;j < arr.length;j++){
				//权限匹配的原理，深刻理解掌握
				if(list.get(i).getMenuId().equals(arr[j])){
					ordinaryList.add(list.get(i));
				}
			}
		}
		//返回普通员工的集合，里面即是普通员工的权限
		return ordinaryList;
	}
	
	//高级管理员的权限,高级管理员具有所有的权限
	public static List<JxcMenu> admin(){
		//高级管理员，直接赋给所有的权限
		//System.out.println("查看高级管理员的权限:" + getData());
		return getData();
	}
	
	//采购管理员
	public static List<JxcMenu> purchaseorderAdmin(){
		//第一先列出普通员工的权限,如果后期有更多的权限，这里直接添加编号即可
		int[] arr = {2,7,8,15,16,17,18,19,20,21,26,29,30};
		
		return getAuth(arr);
	}
	
	
	//销售管理员
	public static List<JxcMenu> saleAdmin(){
		//管理员的权限，和上面进行匹配即可
		int[] arr = {4,8,20,21,22,23,24,25,26,29};
		
		return getAuth(arr);
	}
	
	
	//仓库管理员
	public static List<JxcMenu> warehouseAdmin(){
		//仓库管理员的权限
		int[] arr ={2,3,5,8,19,20,21,22,23,26,29};
		
		return getAuth(arr);
	}
	
	
}
