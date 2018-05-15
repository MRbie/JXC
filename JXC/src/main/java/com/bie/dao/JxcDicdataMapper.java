package com.bie.dao;

import java.util.List;

import com.bie.po.JxcDicdata;
/**
 * 
 * @author 别先生
 *
 */
public interface JxcDicdataMapper extends BaseMapper<JxcDicdata>{
    
	//管理员预先插入的方法
	public List<JxcDicdata> preInsertAdmin(JxcDicdata jxcDicdata);
	
	//提取的公共的方法查询字典项
	public List<JxcDicdata> getDicDataCode(JxcDicdata jxcDicdata);
}