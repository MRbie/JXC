package com.bie.po;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:14:37
 * @Description: 供应商实体类
 */
public class JxcSupplier implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer supplierId;//供应商编号
	//supplierName supplierIpone supplierAddress supplierEmail
	//supplierStatus supplierExtends supplierUpdater supplierUpdatetime
	//supplierType supplierRemark supplierAccount supplierPassword 
	//supplierStartPay supplierEndPay
    private String supplierName;//供应商姓名

    private String supplierIpone;//供应商电话

    private String supplierAddress;//供应商地址

    private String supplierEmail;//供应商邮箱

    private String supplierStatus;//供应商状态

    private String supplierExtends;//供应商扩展

    private String supplierUpdater;//更新人

    private String supplierUpdatetime;//更新时间
    
    //新加字段
    private String supplierType;//供应商类型
    
    private String supplierRemark;//供应商备注
    
    private String supplierAccount;//供应商账号
    
    private String supplierPassword;//供应商密码
    
    private Double supplierStartPay;//供应商首付
    
    private Double supplierEndPay;//供应商尾付
    
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierIpone() {
        return supplierIpone;
    }

    public void setSupplierIpone(String supplierIpone) {
        this.supplierIpone = supplierIpone;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(String supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    public String getSupplierExtends() {
        return supplierExtends;
    }

    public void setSupplierExtends(String supplierExtends) {
        this.supplierExtends = supplierExtends;
    }

    public String getSupplierUpdater() {
        return supplierUpdater;
    }

    public void setSupplierUpdater(String supplierUpdater) {
        this.supplierUpdater = supplierUpdater;
    }

    public String getSupplierUpdatetime() {
        return supplierUpdatetime;
    }

    public void setSupplierUpdatetime(String supplierUpdatetime) {
        this.supplierUpdatetime = supplierUpdatetime;
    }

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

	public String getSupplierRemark() {
		return supplierRemark;
	}

	public void setSupplierRemark(String supplierRemark) {
		this.supplierRemark = supplierRemark;
	}

	public String getSupplierAccount() {
		return supplierAccount;
	}

	public void setSupplierAccount(String supplierAccount) {
		this.supplierAccount = supplierAccount;
	}

	public String getSupplierPassword() {
		return supplierPassword;
	}

	public void setSupplierPassword(String supplierPassword) {
		this.supplierPassword = supplierPassword;
	}

	public Double getSupplierStartPay() {
		return supplierStartPay;
	}

	public void setSupplierStartPay(Double supplierStartPay) {
		this.supplierStartPay = supplierStartPay;
	}

	public Double getSupplierEndPay() {
		return supplierEndPay;
	}

	public void setSupplierEndPay(Double supplierEndPay) {
		this.supplierEndPay = supplierEndPay;
	}

	@Override
	public String toString() {
		return "JxcSupplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierIpone="
				+ supplierIpone + ", supplierAddress=" + supplierAddress + ", supplierEmail=" + supplierEmail
				+ ", supplierStatus=" + supplierStatus + ", supplierExtends=" + supplierExtends + ", supplierUpdater="
				+ supplierUpdater + ", supplierUpdatetime=" + supplierUpdatetime + ", supplierType=" + supplierType
				+ ", supplierRemark=" + supplierRemark + ", supplierAccount=" + supplierAccount + ", supplierPassword="
				+ supplierPassword + ", supplierStartPay=" + supplierStartPay + ", supplierEndPay=" + supplierEndPay
				+ "]";
	}

	
    
    
}