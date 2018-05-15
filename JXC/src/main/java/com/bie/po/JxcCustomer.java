package com.bie.po;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:12:49
 * @Description: 客户实体类
 */
public class JxcCustomer implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer customerId;//客户编号
	
	//customerId customerName customerIphone customerEmail
	//customerAddress customerDesc customerStatus
	//customerUpdater customerUpdatetime customerExtends
    private String customerName;//客户姓名

    private String customerIphone;//客户电话

    private String customerEmail;//客户邮箱

    private String customerAddress;//客户地址

    private String customerDesc;//客户描述

    private String customerStatus;//客户状态

    private String customerUpdater;//更新人

    private String customerUpdatetime;//更新时间

    private String customerExtends;//客户扩展

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerUpdater() {
        return customerUpdater;
    }

    public void setCustomerUpdater(String customerUpdater) {
        this.customerUpdater = customerUpdater;
    }

    public String getCustomerUpdatetime() {
        return customerUpdatetime;
    }

    public void setCustomerUpdatetime(String customerUpdatetime) {
        this.customerUpdatetime = customerUpdatetime;
    }

    public String getCustomerExtends() {
        return customerExtends;
    }

    public void setCustomerExtends(String customerExtends) {
        this.customerExtends = customerExtends;
    }

	@Override
	public String toString() {
		return "JxcCustomer [customerId=" + customerId + ", customerName=" + customerName + ", customerIphone="
				+ customerIphone + ", customerEmail=" + customerEmail + ", customerAddress=" + customerAddress
				+ ", customerDesc=" + customerDesc + ", customerStatus=" + customerStatus + ", customerUpdater="
				+ customerUpdater + ", customerUpdatetime=" + customerUpdatetime + ", customerExtends="
				+ customerExtends + "]";
	}
    
    
}