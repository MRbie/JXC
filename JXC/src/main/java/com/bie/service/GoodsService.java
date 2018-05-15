package com.bie.service;

import java.util.List;

import com.bie.po.JxcGoods;
/**
 * 
 * @author 别先生
 *
 */
public interface GoodsService extends BaseService<JxcGoods>{

	//商品信息统计
	public List<JxcGoods> selectByGoodsByBuyPrice() throws Exception;
	
	//商品信息统计
	public List<JxcGoods> selectByGoodsBySalePrice() throws Exception;
}
