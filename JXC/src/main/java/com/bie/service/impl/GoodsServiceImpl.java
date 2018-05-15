package com.bie.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bie.po.JxcGoods;
import com.bie.service.GoodsService;
/***
 * 
 * @author 别先生
 * 1:商品的业务层实现类,继承工具类,实现商品接口
 */
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<JxcGoods> implements GoodsService{

	@Override
	public List<JxcGoods> selectByGoodsByBuyPrice() throws Exception {
		// TODO Auto-generated method stub
		return jxcGoodsMapper.selectByGoodsByBuyPrice();
	}

	@Override
	public List<JxcGoods> selectByGoodsBySalePrice() throws Exception {
		// TODO Auto-generated method stub
		return jxcGoodsMapper.selectByGoodsBySalePrice();
	}

}
