package com.bie.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/***
 * 
 * @author 别先生
 * 1:系统初始化的时候加载数据字典值
 * 2:如果可以，自己可以写一个页面来实现这个功能
 */
public class SystemInitServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//初始化的方法
	@Override
	public void init() throws ServletException {
		//首先创建一个整体的map类型的变量
		Map<String, Object> systemParam = new HashMap<String, Object>();
		
		//创建管理员类的数据字典值
		Map<String, Object> adminType = new HashMap<String, Object>();
		adminType.put("firstAdmin", "一级管理员");
		adminType.put("secondAdmin", "二级管理员");
		adminType.put("threeAdmin", "三级管理员");
		adminType.put("fourAdmin", "四级管理员");
		
		//创建地区的数据字典值
		Map<String, Object> addressType = new HashMap<String, Object>();
		
		
		//供应商的数据字典
		Map<String,String> supplierType = new HashMap<String,String>();
		supplierType.put("ordinarySupplier", "普通供应商");
		supplierType.put("firstSupplier", "一级供应商");
		supplierType.put("secondSupplier", "二级供应商");
		
		//颜色的数据字典项
		Map<String,String> goodsColor = new HashMap<String,String>();
    	goodsColor.put("red", "红色");
    	goodsColor.put("green", "绿色");
    	goodsColor.put("blue", "蓝色");    	
    	
    	//将每个的数据字典项添加到系统的map对象中
    	systemParam.put("goodsColor", goodsColor);
    	systemParam.put("supplierType", supplierType);
    	systemParam.put("adminType", adminType);
    	
    	//然后将系统的map添加到ServletContext(application)中进行初始化操作
    	ServletContext application =this.getServletContext();
    	application.setAttribute("systemParam",systemParam);
		System.out.println("=======初始化完成，已加载数据字典数据=======");
	}

	
}
