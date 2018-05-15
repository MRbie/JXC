package com.bie.po;

import java.io.Serializable;
/***
 * 
 * @author 别先生
 *
 */
public class JxcFinancialstatement implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer financialstatementId;//财务表编号

    private Integer supplierId;//供应商编号

    private String financialstatementDate;//财务表日期

    private String financialstatementStatus;//财务表状态

    private String financialstatementExtend;//财务表扩展

    private String financialstatementUpdate;//财务表更新人

    private String financialstatementUpdatetime;//财务表更新时间

    private Long financialstatementShouldpay;//财务表应付金额

    private Long financialstatementActualpay;//财务表实付金额

    private Long financialstatementDiscountmoney;//财务表优惠金额

    private String financialstatementRemark;//财务表备注

    private String financialstatementType;//财务表类型

    public Integer getFinancialstatementId() {
        return financialstatementId;
    }

    public void setFinancialstatementId(Integer financialstatementId) {
        this.financialstatementId = financialstatementId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getFinancialstatementDate() {
        return financialstatementDate;
    }

    public void setFinancialstatementDate(String financialstatementDate) {
        this.financialstatementDate = financialstatementDate;
    }

    public String getFinancialstatementStatus() {
        return financialstatementStatus;
    }

    public void setFinancialstatementStatus(String financialstatementStatus) {
        this.financialstatementStatus = financialstatementStatus;
    }

    public String getFinancialstatementExtend() {
        return financialstatementExtend;
    }

    public void setFinancialstatementExtend(String financialstatementExtend) {
        this.financialstatementExtend = financialstatementExtend;
    }

    public String getFinancialstatementUpdate() {
        return financialstatementUpdate;
    }

    public void setFinancialstatementUpdate(String financialstatementUpdate) {
        this.financialstatementUpdate = financialstatementUpdate;
    }

    public String getFinancialstatementUpdatetime() {
        return financialstatementUpdatetime;
    }

    public void setFinancialstatementUpdatetime(String financialstatementUpdatetime) {
        this.financialstatementUpdatetime = financialstatementUpdatetime;
    }

    public Long getFinancialstatementShouldpay() {
        return financialstatementShouldpay;
    }

    public void setFinancialstatementShouldpay(Long financialstatementShouldpay) {
        this.financialstatementShouldpay = financialstatementShouldpay;
    }

    public Long getFinancialstatementActualpay() {
        return financialstatementActualpay;
    }

    public void setFinancialstatementActualpay(Long financialstatementActualpay) {
        this.financialstatementActualpay = financialstatementActualpay;
    }

    public Long getFinancialstatementDiscountmoney() {
        return financialstatementDiscountmoney;
    }

    public void setFinancialstatementDiscountmoney(Long financialstatementDiscountmoney) {
        this.financialstatementDiscountmoney = financialstatementDiscountmoney;
    }

    public String getFinancialstatementRemark() {
        return financialstatementRemark;
    }

    public void setFinancialstatementRemark(String financialstatementRemark) {
        this.financialstatementRemark = financialstatementRemark;
    }

    public String getFinancialstatementType() {
        return financialstatementType;
    }

    public void setFinancialstatementType(String financialstatementType) {
        this.financialstatementType = financialstatementType;
    }

	@Override
	public String toString() {
		return "JxcFinancialstatement [financialstatementId=" + financialstatementId + ", supplierId=" + supplierId
				+ ", financialstatementDate=" + financialstatementDate + ", financialstatementStatus="
				+ financialstatementStatus + ", financialstatementExtend=" + financialstatementExtend
				+ ", financialstatementUpdate=" + financialstatementUpdate + ", financialstatementUpdatetime="
				+ financialstatementUpdatetime + ", financialstatementShouldpay=" + financialstatementShouldpay
				+ ", financialstatementActualpay=" + financialstatementActualpay + ", financialstatementDiscountmoney="
				+ financialstatementDiscountmoney + ", financialstatementRemark=" + financialstatementRemark
				+ ", financialstatementType=" + financialstatementType + "]";
	}
    
    
}