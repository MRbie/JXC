package com.bie.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bie.po.JxcDicdata;
import com.bie.service.DicDataService;
/***
 * 
 * @author 别先生
 * 1:数据字典存值的业务层实现类,继承工具类,实现数据字典存值接口
 */
@Service("dicDataService")
public class DicDataServiceImpl extends BaseServiceImpl<JxcDicdata> implements DicDataService{

	@Override
	public List<JxcDicdata> preInsertAdmin(JxcDicdata jxcDicdata) throws Exception {
		// TODO Auto-generated method stub
		return jxcDicdataMapper.preInsertAdmin(jxcDicdata);
	}
	
	//封装，将数据字典类型参数传入进来，要求可以查询出字典项的值
	@Override
	public List<JxcDicdata> getDicDataCodeByDataDicCode(JxcDicdata jxcDicdata){
		List<JxcDicdata> dicDataCode = jxcDicdataMapper.getDicDataCode(jxcDicdata);
		System.out.println("查询出的结果:" + dicDataCode + dicDataCode.isEmpty() + dicDataCode.size());
		if(!dicDataCode.isEmpty() && dicDataCode.size() > 0){
			return dicDataCode;
		}else
			return null;
		}
	}
