package com.bie.dao;

import java.util.List;

import com.bie.po.JxcGoods;
/**
 * 
 * @author 别先生
 *
 */
public interface JxcGoodsMapper extends BaseMapper<JxcGoods>{
    
	public List<JxcGoods> selectByGoodsByBuyPrice();
	
	public List<JxcGoods> selectByGoodsBySalePrice();
}