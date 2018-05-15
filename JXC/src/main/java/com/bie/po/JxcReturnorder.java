package com.bie.po;

import java.io.Serializable;
/**
 * 
 * @author 别先生
 *
 */
public class JxcReturnorder implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer returnorderId;//退货订单编号

    private String returnorderDate;//退货订单日期

    private Long returnorderShouldmoney;//退货订单应付金额

    private Long returnorderActualmoney;//退货订单实付金额

    private String returnorderStatus;//退货订单状态

    private String returnorderExtend;//退货订单扩展

    private String returnorderDesc;//退货订单描述

    private String returnorderUpdate;//退货订单操作员

    private String returnorderUpdatetime;//退货订单更新时间

    private Integer supplierId;//供应商编号

    private Integer warehouseId;//仓库编号

    public Integer getReturnorderId() {
        return returnorderId;
    }

    public void setReturnorderId(Integer returnorderId) {
        this.returnorderId = returnorderId;
    }

    public String getReturnorderDate() {
        return returnorderDate;
    }

    public void setReturnorderDate(String returnorderDate) {
        this.returnorderDate = returnorderDate;
    }

    public Long getReturnorderShouldmoney() {
        return returnorderShouldmoney;
    }

    public void setReturnorderShouldmoney(Long returnorderShouldmoney) {
        this.returnorderShouldmoney = returnorderShouldmoney;
    }

    public Long getReturnorderActualmoney() {
        return returnorderActualmoney;
    }

    public void setReturnorderActualmoney(Long returnorderActualmoney) {
        this.returnorderActualmoney = returnorderActualmoney;
    }

    public String getReturnorderStatus() {
        return returnorderStatus;
    }

    public void setReturnorderStatus(String returnorderStatus) {
        this.returnorderStatus = returnorderStatus;
    }

    public String getReturnorderExtend() {
        return returnorderExtend;
    }

    public void setReturnorderExtend(String returnorderExtend) {
        this.returnorderExtend = returnorderExtend;
    }

    public String getReturnorderDesc() {
        return returnorderDesc;
    }

    public void setReturnorderDesc(String returnorderDesc) {
        this.returnorderDesc = returnorderDesc;
    }

    public String getReturnorderUpdate() {
        return returnorderUpdate;
    }

    public void setReturnorderUpdate(String returnorderUpdate) {
        this.returnorderUpdate = returnorderUpdate;
    }

    public String getReturnorderUpdatetime() {
        return returnorderUpdatetime;
    }

    public void setReturnorderUpdatetime(String returnorderUpdatetime) {
        this.returnorderUpdatetime = returnorderUpdatetime;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

	@Override
	public String toString() {
		return "JxcReturnorder [returnorderId=" + returnorderId + ", returnorderDate=" + returnorderDate
				+ ", returnorderShouldmoney=" + returnorderShouldmoney + ", returnorderActualmoney="
				+ returnorderActualmoney + ", returnorderStatus=" + returnorderStatus + ", returnorderExtend="
				+ returnorderExtend + ", returnorderDesc=" + returnorderDesc + ", returnorderUpdate="
				+ returnorderUpdate + ", returnorderUpdatetime=" + returnorderUpdatetime + ", supplierId=" + supplierId
				+ ", warehouseId=" + warehouseId + "]";
	}
    
    
}