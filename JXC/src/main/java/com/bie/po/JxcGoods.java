package com.bie.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.wuwz.poi.annotation.ExportConfig;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:13:31
 * @Description: 商品实体类
 */
public class JxcGoods implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExportConfig(value="商品编号",width=70)
	private Integer goodsId;//商品编号
	
	@ExportConfig(value="商品名称",width=70)
    private String goodsName;//商品名称

	@ExportConfig(value="商品编码",width=70)
    private String goodsCode;//商品编码

	@ExportConfig(value="商品类型",width=70)
    private String goodsType;//商品类型

	@ExportConfig(value="商品品牌",width=70)
    private String goodsBrand;//商品品牌

	@ExportConfig(value="商品颜色",width=70)
    private String goodsColor;//商品颜色

	@ExportConfig(value="商品规格",width=70)
    private String goodsSpecifications;//商品规格

	@ExportConfig(value="商品图片",width=70)
    private String goodsPicture;//商品图片

	@ExportConfig(value="商品材质",width=70)
    private String goodsMaterial;//商品材质

	@ExportConfig(value="商品进价",width=70)
    private Double goodsBuyprice;//商品买入价格goodsBuyPrice

	@ExportConfig(value="商品售价",width=70)
    private Double goodsSaleprice;//商品销售价格goodsSalePrice

	@ExportConfig(value="商品型号",width=70)
    private String goodsModel;//商品型号

	@ExportConfig(value="商品描述",width=70)
    private String goodsDesc;//商品描述,备注

	@ExportConfig(value="更新人",width=70)
    private String goodsUpdater;//更新人

	@ExportConfig(value="更新时间",width=70)
    private String goodsUpdatetime;//更新时间

	@ExportConfig(value="商品状态",width=70)
    private String goodsStatus;//商品状态

	@ExportConfig(value="商品扩展",width=70)
    private String goodsExtend;//商品扩展
    
    //新加字段
	@ExportConfig(value="商品的生产商",width=70)
    private String goodsProducer;//商品的生产商
    
	@ExportConfig(value="商品的库存下限",width=70)
    private Integer goodsLowerLimit;//商品的库存下限

    private Integer goodsBuyPrice;
    private Integer goodsSalePrice;
	
	
    
    public Integer getGoodsBuyPrice() {
		return goodsBuyPrice;
	}

	public void setGoodsBuyPrice(Integer goodsBuyPrice) {
		this.goodsBuyPrice = goodsBuyPrice;
	}

	public Integer getGoodsSalePrice() {
		return goodsSalePrice;
	}

	public void setGoodsSalePrice(Integer goodsSalePrice) {
		this.goodsSalePrice = goodsSalePrice;
	}

	public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public String getGoodsSpecifications() {
        return goodsSpecifications;
    }

    public void setGoodsSpecifications(String goodsSpecifications) {
        this.goodsSpecifications = goodsSpecifications;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getGoodsMaterial() {
        return goodsMaterial;
    }

    public void setGoodsMaterial(String goodsMaterial) {
        this.goodsMaterial = goodsMaterial;
    }

    public Double getGoodsBuyprice() {
        return goodsBuyprice;
    }

    public void setGoodsBuyprice(Double goodsBuyprice) {
        this.goodsBuyprice = goodsBuyprice;
    }

    public Double getGoodsSaleprice() {
        return goodsSaleprice;
    }

    public void setGoodsSaleprice(Double goodsSaleprice) {
        this.goodsSaleprice = goodsSaleprice;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsUpdater() {
        return goodsUpdater;
    }

    public void setGoodsUpdater(String goodsUpdater) {
        this.goodsUpdater = goodsUpdater;
    }

    public String getGoodsUpdatetie() {
        return goodsUpdatetime;
    }

    public void setGoodsUpdatetie(String goodsUpdatetie) {
        this.goodsUpdatetime = goodsUpdatetie;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsExtend() {
        return goodsExtend;
    }

    public void setGoodsExtend(String goodsExtend) {
        this.goodsExtend = goodsExtend;
    }

	public String getGoodsUpdatetime() {
		return goodsUpdatetime;
	}

	public void setGoodsUpdatetime(String goodsUpdatetime) {
		this.goodsUpdatetime = goodsUpdatetime;
	}

	public String getGoodsProducer() {
		return goodsProducer;
	}

	public void setGoodsProducer(String goodsProducer) {
		this.goodsProducer = goodsProducer;
	}

	public Integer getGoodsLowerLimit() {
		return goodsLowerLimit;
	}

	public void setGoodsLowerLimit(Integer goodsLowerLimit) {
		this.goodsLowerLimit = goodsLowerLimit;
	}

	@Override
	public String toString() {
		return "JxcGoods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsCode=" + goodsCode + ", goodsType="
				+ goodsType + ", goodsBrand=" + goodsBrand + ", goodsColor=" + goodsColor + ", goodsSpecifications="
				+ goodsSpecifications + ", goodsPicture=" + goodsPicture + ", goodsMaterial=" + goodsMaterial
				+ ", goodsBuyprice=" + goodsBuyprice + ", goodsSaleprice=" + goodsSaleprice + ", goodsModel="
				+ goodsModel + ", goodsDesc=" + goodsDesc + ", goodsUpdater=" + goodsUpdater + ", goodsUpdatetime="
				+ goodsUpdatetime + ", goodsStatus=" + goodsStatus + ", goodsExtend=" + goodsExtend + ", goodsProducer="
				+ goodsProducer + ", goodsLowerLimit=" + goodsLowerLimit + ", goodsBuyPrice=" + goodsBuyPrice
				+ ", goodsSalePrice=" + goodsSalePrice + "]";
	}

	
	
    
    
}