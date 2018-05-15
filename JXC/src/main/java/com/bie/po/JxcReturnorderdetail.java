package com.bie.po;

import java.io.Serializable;

/**
 * 
 * @author 别先生
 *
 */
public class JxcReturnorderdetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer returnorderdetailId;//退货订单详情编号

    private Integer goodId;//商品编号

    private Long returnorderdetailSingleprice;//退货订单详情单价

    private Long returnorderdetailTotalprice;//退货订单详情总价

    private String returnorderdetailStatus;//退货订单详情状态

    private String returnorderdetailExtend;//退货订单详情扩展

    public Integer getReturnorderdetailId() {
        return returnorderdetailId;
    }

    public void setReturnorderdetailId(Integer returnorderdetailId) {
        this.returnorderdetailId = returnorderdetailId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Long getReturnorderdetailSingleprice() {
        return returnorderdetailSingleprice;
    }

    public void setReturnorderdetailSingleprice(Long returnorderdetailSingleprice) {
        this.returnorderdetailSingleprice = returnorderdetailSingleprice;
    }

    public Long getReturnorderdetailTotalprice() {
        return returnorderdetailTotalprice;
    }

    public void setReturnorderdetailTotalprice(Long returnorderdetailTotalprice) {
        this.returnorderdetailTotalprice = returnorderdetailTotalprice;
    }

    public String getReturnorderdetailStatus() {
        return returnorderdetailStatus;
    }

    public void setReturnorderdetailStatus(String returnorderdetailStatus) {
        this.returnorderdetailStatus = returnorderdetailStatus;
    }

    public String getReturnorderdetailExtend() {
        return returnorderdetailExtend;
    }

    public void setReturnorderdetailExtend(String returnorderdetailExtend) {
        this.returnorderdetailExtend = returnorderdetailExtend;
    }

	@Override
	public String toString() {
		return "JxcReturnorderdetail [returnorderdetailId=" + returnorderdetailId + ", goodId=" + goodId
				+ ", returnorderdetailSingleprice=" + returnorderdetailSingleprice + ", returnorderdetailTotalprice="
				+ returnorderdetailTotalprice + ", returnorderdetailStatus=" + returnorderdetailStatus
				+ ", returnorderdetailExtend=" + returnorderdetailExtend + "]";
	}
    
    
}