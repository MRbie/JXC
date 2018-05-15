package com.bie.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:14:29
 * @Description: 库存实体类
 */
public class JxcStock implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer stockId;//库存编号

    private Integer warehouseId;//仓库编号

    private Integer goodsId;//商品编号

    private String stockCode;//库存编码

    private Integer stockAllowance;//库存余量

    private Integer stockSalecount;//库存销售数量

    private BigDecimal stockBuyprice;//库存进价

    private BigDecimal stockSaleprice;//库存销售价格

    private BigDecimal stockUpbuyprice;//商品上次进价

    private BigDecimal stockAvgbuyprice;//库存平均进价

    private BigDecimal stockCost;//库存成本

    private BigDecimal stockTotalcost;//库存总成本

    private String stockUpdater;//更新人

    private Date stockUpdatetime;//更新时间

    private String stockStatus;//库存状态

    private String stockExtends;//库存扩展

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Integer getStockAllowance() {
        return stockAllowance;
    }

    public void setStockAllowance(Integer stockAllowance) {
        this.stockAllowance = stockAllowance;
    }

    public Integer getStockSalecount() {
        return stockSalecount;
    }

    public void setStockSalecount(Integer stockSalecount) {
        this.stockSalecount = stockSalecount;
    }

    public BigDecimal getStockBuyprice() {
        return stockBuyprice;
    }

    public void setStockBuyprice(BigDecimal stockBuyprice) {
        this.stockBuyprice = stockBuyprice;
    }

    public BigDecimal getStockSaleprice() {
        return stockSaleprice;
    }

    public void setStockSaleprice(BigDecimal stockSaleprice) {
        this.stockSaleprice = stockSaleprice;
    }

    public BigDecimal getStockUpbuyprice() {
        return stockUpbuyprice;
    }

    public void setStockUpbuyprice(BigDecimal stockUpbuyprice) {
        this.stockUpbuyprice = stockUpbuyprice;
    }

    public BigDecimal getStockAvgbuyprice() {
        return stockAvgbuyprice;
    }

    public void setStockAvgbuyprice(BigDecimal stockAvgbuyprice) {
        this.stockAvgbuyprice = stockAvgbuyprice;
    }

    public BigDecimal getStockCost() {
        return stockCost;
    }

    public void setStockCost(BigDecimal stockCost) {
        this.stockCost = stockCost;
    }

    public BigDecimal getStockTotalcost() {
        return stockTotalcost;
    }

    public void setStockTotalcost(BigDecimal stockTotalcost) {
        this.stockTotalcost = stockTotalcost;
    }

    public String getStockUpdater() {
        return stockUpdater;
    }

    public void setStockUpdater(String stockUpdater) {
        this.stockUpdater = stockUpdater;
    }

    public Date getStockUpdatetime() {
        return stockUpdatetime;
    }

    public void setStockUpdatetime(Date stockUpdatetime) {
        this.stockUpdatetime = stockUpdatetime;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public String getStockExtends() {
        return stockExtends;
    }

    public void setStockExtends(String stockExtends) {
        this.stockExtends = stockExtends;
    }

	@Override
	public String toString() {
		return "JxcStock [stockId=" + stockId + ", warehouseId=" + warehouseId + ", goodsId=" + goodsId + ", stockCode="
				+ stockCode + ", stockAllowance=" + stockAllowance + ", stockSalecount=" + stockSalecount
				+ ", stockBuyprice=" + stockBuyprice + ", stockSaleprice=" + stockSaleprice + ", stockUpbuyprice="
				+ stockUpbuyprice + ", stockAvgbuyprice=" + stockAvgbuyprice + ", stockCost=" + stockCost
				+ ", stockTotalcost=" + stockTotalcost + ", stockUpdater=" + stockUpdater + ", stockUpdatetime="
				+ stockUpdatetime + ", stockStatus=" + stockStatus + ", stockExtends=" + stockExtends + "]";
	}
    
    
}