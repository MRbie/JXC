package com.bie.po;

import java.io.Serializable;
/**
 * 
 * @author 别先生
 *
 */
public class JxcPurchaseorderdetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer orderdetailId;//订单详情编号

    private Integer goodId;//商品编号

    private Integer orderId;//订单编号

    private Integer orderdetailNumber;//订单详情数量

    private Long orderdetailBuyprice;//订单详情买入价格
    
    private Long orderdetailTotalprice;//订单详情总价格

    private String orderdetailStatus;//订单详情状态

    private String orderdetailExtend;//订单详情扩展

    public Integer getOrderdetailId() {
        return orderdetailId;
    }

    public void setOrderdetailId(Integer orderdetailId) {
        this.orderdetailId = orderdetailId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderdetailNumber() {
        return orderdetailNumber;
    }

    public void setOrderdetailNumber(Integer orderdetailNumber) {
        this.orderdetailNumber = orderdetailNumber;
    }

    public Long getOrderdetailBuyprice() {
        return orderdetailBuyprice;
    }

    public void setOrderdetailBuyprice(Long orderdetailBuyprice) {
        this.orderdetailBuyprice = orderdetailBuyprice;
    }

    public Long getOrderdetailTotalprice() {
        return orderdetailTotalprice;
    }

    public void setOrderdetailTotalprice(Long orderdetailTotalprice) {
        this.orderdetailTotalprice = orderdetailTotalprice;
    }

    public String getOrderdetailStatus() {
        return orderdetailStatus;
    }

    public void setOrderdetailStatus(String orderdetailStatus) {
        this.orderdetailStatus = orderdetailStatus;
    }

    public String getOrderdetailExtend() {
        return orderdetailExtend;
    }

    public void setOrderdetailExtend(String orderdetailExtend) {
        this.orderdetailExtend = orderdetailExtend;
    }

	@Override
	public String toString() {
		return "JxcPurchaseorderdetail [orderdetailId=" + orderdetailId + ", goodId=" + goodId + ", orderId=" + orderId
				+ ", orderdetailNumber=" + orderdetailNumber + ", orderdetailBuyprice=" + orderdetailBuyprice
				+ ", orderdetailTotalprice=" + orderdetailTotalprice + ", orderdetailStatus=" + orderdetailStatus
				+ ", orderdetailExtend=" + orderdetailExtend + "]";
	}
    
    
}