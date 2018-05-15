package com.bie.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.wuwz.poi.annotation.ExportConfig;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:12:59
 * @Description: 员工实体类
 */
public class JxcEmployee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExportConfig(value="员工编号",width=70)
	private Integer employeeId;//员工编号
    
	@ExportConfig(value="角色编号",width=70)
    private Integer roleId;//角色编号
    //employeeName employeeAccount employeePassword employeeAge employeeSex employeeBirthday
    //employeeAddress employeeStatus employeeCode employeeCardno employeePhone employeeEmail
    //employeeType employeeUpdater employeeUpdatetime employeeExtend
	@ExportConfig(value="员工姓名",width=70)
	private String employeeName;//员工姓名

	@ExportConfig(value="员工账户",width=70)
    private String employeeAccount;//员工账户

	@ExportConfig(value="员工密码",width=70)
    private String employeePassword;//员工密码

	@ExportConfig(value="员工年龄",width=70)
    private Integer employeeAge;//员工年龄

	@ExportConfig(value="员工性别",width=70)
    private String employeeSex;//员工性别

	@ExportConfig(value="员工生日",width=70)
    private String employeeBirthday;//员工生日

	@ExportConfig(value="员工地址",width=70)
    private String employeeAddress;//员工地址

	@ExportConfig(value="员工状态",width=70)
    private String employeeStatus;//员工状态

	@ExportConfig(value="员工编码",width=70)
    private String employeeCode;//员工编码

	@ExportConfig(value="员工身份证号码",width=70)
    private String employeeCardno;//员工身份证号码

	@ExportConfig(value="员工电话",width=70)
    private String employeePhone;//员工电话

	@ExportConfig(value="员工邮箱",width=70)
    private String employeeEmail;//员工邮箱

	@ExportConfig(value="员工类型",width=70)
    private String employeeType;//员工类型

	@ExportConfig(value="更新人",width=70)
    private String employeeUpdater;//更新人

	@ExportConfig(value="更新时间",width=70)
    private String employeeUpdatetime;//更新时间

	@ExportConfig(value="员工扩展",width=70)
    private String employeeExtend;//员工扩展

	//员工和角色是多对多映射,创建出来可以直接使用
	//private List<JxcRole> jxcrole = new ArrayList<JxcRole>();
	
	//角色数量统计
	private Integer roleCount;
	private Integer salaryCount;
	
	
	public Integer getSalaryCount() {
		return salaryCount;
	}

	public void setSalaryCount(Integer salaryCount) {
		this.salaryCount = salaryCount;
	}

	public Integer getRoleCount() {
		return roleCount;
	}

	public void setRoleCount(Integer roleCount) {
		this.roleCount = roleCount;
	}

	private JxcRole jxRole;

	
	public JxcRole getJxRole() {
		return jxRole;
	}

	public void setJxRole(JxcRole jxRole) {
		this.jxRole = jxRole;
	}

	public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCardno() {
        return employeeCardno;
    }

    public void setEmployeeCardno(String employeeCardno) {
        this.employeeCardno = employeeCardno;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeUpdater() {
        return employeeUpdater;
    }

    public void setEmployeeUpdater(String employeeUpdater) {
        this.employeeUpdater = employeeUpdater;
    }

    public String getEmployeeUpdatetime() {
        return employeeUpdatetime;
    }

    public void setEmployeeUpdatetime(String employeeUpdatetime) {
        this.employeeUpdatetime = employeeUpdatetime;
    }

    public String getEmployeeExtend() {
        return employeeExtend;
    }

    public void setEmployeeExtend(String employeeExtend) {
        this.employeeExtend = employeeExtend;
    }

	@Override
	public String toString() {
		return "JxcEmployee [employeeId=" + employeeId + ", roleId=" + roleId + ", employeeName=" + employeeName
				+ ", employeeAccount=" + employeeAccount + ", employeePassword=" + employeePassword + ", employeeAge="
				+ employeeAge + ", employeeSex=" + employeeSex + ", employeeBirthday=" + employeeBirthday
				+ ", employeeAddress=" + employeeAddress + ", employeeStatus=" + employeeStatus + ", employeeCode="
				+ employeeCode + ", employeeCardno=" + employeeCardno + ", employeePhone=" + employeePhone
				+ ", employeeEmail=" + employeeEmail + ", employeeType=" + employeeType + ", employeeUpdater="
				+ employeeUpdater + ", employeeUpdatetime=" + employeeUpdatetime + ", employeeExtend=" + employeeExtend
				+ ", roleCount=" + roleCount + ", salaryCount=" + salaryCount + ", jxRole=" + jxRole + "]";
	}

//	@Override
//	public String toString() {
//		return "JxcEmployee [employeeId=" + employeeId + ", roleId=" + roleId + ", employeeName=" + employeeName
//				+ ", employeeAccount=" + employeeAccount + ", employeePassword=" + employeePassword + ", employeeAge="
//				+ employeeAge + ", employeeSex=" + employeeSex + ", employeeBirthday=" + employeeBirthday
//				+ ", employeeAddress=" + employeeAddress + ", employeeStatus=" + employeeStatus + ", employeeCode="
//				+ employeeCode + ", employeeCardno=" + employeeCardno + ", employeePhone=" + employeePhone
//				+ ", employeeEmail=" + employeeEmail + ", employeeType=" + employeeType + ", employeeUpdater="
//				+ employeeUpdater + ", employeeUpdatetime=" + employeeUpdatetime + ", employeeExtend=" + employeeExtend
//				+ ", roleCount=" + roleCount + ", jxRole=" + jxRole + "]";
//	}

	/*@Override
	public String toString() {
		return "JxcEmployee [employeeId=" + employeeId + ", roleId=" + roleId + ", employeeName=" + employeeName
				+ ", employeeAccount=" + employeeAccount + ", employeePassword=" + employeePassword + ", employeeAge="
				+ employeeAge + ", employeeSex=" + employeeSex + ", employeeBirthday=" + employeeBirthday
				+ ", employeeAddress=" + employeeAddress + ", employeeStatus=" + employeeStatus + ", employeeCode="
				+ employeeCode + ", employeeCardno=" + employeeCardno + ", employeePhone=" + employeePhone
				+ ", employeeEmail=" + employeeEmail + ", employeeType=" + employeeType + ", employeeUpdater="
				+ employeeUpdater + ", employeeUpdatetime=" + employeeUpdatetime + ", employeeExtend=" + employeeExtend
				+ ", jxRole=" + jxRole + "]";
	}*/


	/*public List<JxcRole> getJxcrole() {
		return jxcrole;
	}

	public void setJxcrole(List<JxcRole> jxcrole) {
		this.jxcrole = jxcrole;
	}*/

	/*@Override
	public String toString() {
		return "JxcEmployee [employeeId=" + employeeId + ", roleId=" + roleId + ", employeeName=" + employeeName
				+ ", employeeAccount=" + employeeAccount + ", employeePassword=" + employeePassword + ", employeeAge="
				+ employeeAge + ", employeeSex=" + employeeSex + ", employeeBirthday=" + employeeBirthday
				+ ", employeeAddress=" + employeeAddress + ", employeeStatus=" + employeeStatus + ", employeeCode="
				+ employeeCode + ", employeeCardno=" + employeeCardno + ", employeePhone=" + employeePhone
				+ ", employeeEmail=" + employeeEmail + ", employeeType=" + employeeType + ", employeeUpdater="
				+ employeeUpdater + ", employeeUpdatetime=" + employeeUpdatetime + ", employeeExtend=" + employeeExtend
				+ ", jxcrole=" + jxcrole + ", jxRole=" + jxRole + "]";
	}*/
    
    
}