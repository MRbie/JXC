package com.bie.service;

import java.util.List;

import com.bie.po.JxcAdmin;
import com.bie.po.JxcDicdata;
/**
 * 数据字典的业务层的接口
 * @author 别先生
 *
 */
public interface DicDataService extends BaseService<JxcDicdata>{

	//预插入操作的方法
	public List<JxcDicdata> preInsertAdmin(JxcDicdata jxcDicdata) throws Exception; 
	
	//数据字典和数据项工具方法
	public List<JxcDicdata> getDicDataCodeByDataDicCode(JxcDicdata jxcDicdata) throws Exception;
}
