package com.bie.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.bie.dao.BaseMapper;
import com.bie.dao.JxcCustomerMapper;
import com.bie.dao.JxcDatadictionaryMapper;
import com.bie.dao.JxcDicdataMapper;
import com.bie.dao.JxcEmployeeMapper;
import com.bie.dao.JxcGoodsMapper;
import com.bie.dao.JxcMenuMapper;
import com.bie.dao.JxcPurchaseorderMapper;
import com.bie.dao.JxcRoleMapper;
import com.bie.dao.JxcSalesorderMapper;
import com.bie.dao.JxcSupplierMapper;
import com.bie.dao.JxcWarehouseMapper;
import com.bie.service.BaseService;
/**
 * 
 * @author 别先生
 *
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	
	protected BaseMapper<T> baseMapper;
	
	//第一个管理员操作是自己写的方法,其他的功能进行工具抽取。
	//@Autowired
	//protected JxcAdminMapper jxcAdminMapper;
	
	//员工的dao层Ioc注入
	@Autowired
	protected JxcEmployeeMapper jxcEmployeeMapper;
	
	//角色的dao层Ioc注入
	@Autowired
	protected JxcRoleMapper jxcRoleMapper;
	
	//数据字典的dao层Ioc注入
	@Autowired
	protected JxcDatadictionaryMapper jxcDatadictionaryMapper;
		
	//数据字典数据的dao层Ioc注入
	@Autowired
	protected JxcDicdataMapper jxcDicdataMapper;
	
	//@Autowired
	//public DicDataService dicDataAdminService;
	
	//商品的
	@Autowired
	protected JxcGoodsMapper jxcGoodsMapper;
	
	//供应商
	@Autowired
	protected JxcSupplierMapper jxcSupplierMapper;
	
	//客户
	@Autowired
	protected JxcCustomerMapper jxcCustomerMapper;
	
	//仓库
	@Autowired
	protected JxcWarehouseMapper jxcWarehouseMapper;
	
	//采购订单
	@Autowired
	protected JxcPurchaseorderMapper jxcPurchaseorderMapper;
	
	//菜单,即权限资源
	@Autowired
	protected JxcMenuMapper jxcMenuMapper;
	
	//销售订单
	@Autowired
	protected JxcSalesorderMapper jxcSalesorderMapper;
	
	
	//插入的方法
	@Override
	public boolean insert(T entity) throws Exception {
		return baseMapper.insert(entity);
	}

	//更新的方法
	@Override
	public boolean update(T entity) throws Exception {
		return baseMapper.update(entity);
	}
	
	//删除的方法
	@Override
	public boolean delete(T entity) throws Exception {
		return baseMapper.delete(entity);
	}
	
	//批量删除的方法
	@Override
	public boolean deleteList(List<Integer> pks) throws Exception {
		return baseMapper.deleteList(pks);
	}

	//查询的方法,查询个人的信息
	@Override
	public T select(T entity) {
		return baseMapper.select(entity);
	}
	
	//查询所有的方法
	@Override
	public List<T> selectAll(T entity) throws Exception {
		List<T> resultAll = baseMapper.selectAll(entity);
		if(resultAll != null && !"".equals(resultAll)){
			return resultAll;
		}
		return null;
	}

	
	//在构造方法后，初化前执行
	@PostConstruct
	private void initBaseMapper() throws Exception{
		//完成以下逻辑，需要对研发本身进行命名与使用规范
		//this关键字指对象本身，这里指的是调用此方法的实现类（子类）
		System.out.println("=======this :"+this);
		System.out.println("=======父类基本信息："+this.getClass().getSuperclass());
		System.out.println("=======父类和泛型的信息："+this.getClass().getGenericSuperclass());
		
		ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
		//获取第一个参数的class
		Class clazz = (Class)type.getActualTypeArguments()[0];
		System.out.println("=======class:"+clazz);
		//转化为属性名（相关的Mapper子类的引用名）Supplier  supplierMapper
		String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Mapper";
		System.out.println("=======localField:"+localField);
		//getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
		Field field=this.getClass().getSuperclass().getDeclaredField(localField);
		System.out.println("=======field:"+field);
		System.out.println("=======field对应的对象:"+field.get(this));
		Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
		
		System.out.println("=======baseField:"+baseField);
		System.out.println("=======baseField对应的对象:"+baseField.get(this));	
		//field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中		
		baseField.set(this, field.get(this));		
		System.out.println("========baseField对应的对象:"+baseMapper);
	}
	
	
}
