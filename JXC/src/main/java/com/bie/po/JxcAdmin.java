package com.bie.po;

import java.io.Serializable;
import java.util.Date;
/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午2:55:09
 * @Description:  管理员实体类
 */
public class JxcAdmin implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer adminId;//0管理员编号
	//adminName adminType adminStatus adminExtend adminAccount adminPassword adminCardno
	//adminAge adminSex  adminPhone adminEmail adminBirthday adminAddres adminCode  
    private String adminName;//1管理员姓名
    	
    private String adminType;//2管理员类型

    private String adminStatus;//3管理员状态

    private String adminExtend;//4管理员扩展
    
    //根据开发需求新加字段
    private String adminAccount;//5管理员账号
    
    private String adminPassword;//6管理员密码
    
    private Integer adminAge;//7管理员年龄
    
    private String adminSex;//8管理员性别
    
    private String adminPhone;//9管理员电话
    
    private String adminEmail;//10管理员邮箱
    
    private String adminBirthday;//11管理员生日
    
    private String adminAddres;//12管理员地址
    
    private String adminCode;//13管理员编码
    
    private String adminCardno;//14管理员省份证号码
    
    
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        this.adminType = adminType;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getAdminExtend() {
        return adminExtend;
    }

    public void setAdminExtend(String adminExtend) {
        this.adminExtend = adminExtend;
    }

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getAdminAge() {
		return adminAge;
	}

	public void setAdminAge(Integer adminAge) {
		this.adminAge = adminAge;
	}

	public String getAdminSex() {
		return adminSex;
	}

	public void setAdminSex(String adminSex) {
		this.adminSex = adminSex;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminBirthday() {
		return adminBirthday;
	}

	public void setAdminBirthday(String adminBirthday) {
		this.adminBirthday = adminBirthday;
	}

	public String getAdminAddres() {
		return adminAddres;
	}

	public void setAdminAddres(String adminAddres) {
		this.adminAddres = adminAddres;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getAdminCardno() {
		return adminCardno;
	}

	public void setAdminCardno(String adminCardno) {
		this.adminCardno = adminCardno;
	}

	@Override
	public String toString() {
		return "JxcAdmin [adminId=" + adminId + ", adminName=" + adminName + ", adminType=" + adminType
				+ ", adminStatus=" + adminStatus + ", adminExtend=" + adminExtend + ", adminAccount=" + adminAccount
				+ ", adminPassword=" + adminPassword + ", adminAge=" + adminAge + ", adminSex=" + adminSex
				+ ", adminPhone=" + adminPhone + ", adminEmail=" + adminEmail + ", adminBirthday=" + adminBirthday
				+ ", adminAddres=" + adminAddres + ", adminCode=" + adminCode + ", adminCardno=" + adminCardno + "]";
	}

	
    
}