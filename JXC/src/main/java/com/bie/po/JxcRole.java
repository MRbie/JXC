package com.bie.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:14:09
 * @Description: 角色实体类
 */
public class JxcRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer roleId;//角色编号
	//roleName roleCode roleDesc roleStatus roleUpdater roleUpdatetime
	//roleExtend
    private String roleName;//角色名称

    private String roleCode;//角色编码

    private String roleDesc;//角色描述

    private String roleStatus;//角色状态

    private String roleUpdater;//更新人

    private String roleUpdatetime;//更新时间

    private String roleExtend;//角色扩展

    //角色和员工是多对多映射,直接创建后面可以直接使用
    private List<JxcEmployee> jxcEmployee = new ArrayList<JxcEmployee>();
    
    
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleUpdater() {
        return roleUpdater;
    }

    public void setRoleUpdater(String roleUpdater) {
        this.roleUpdater = roleUpdater;
    }

    public String getRoleUpdatetime() {
        return roleUpdatetime;
    }

    public void setRoleUpdatetime(String roleUpdatetime) {
        this.roleUpdatetime = roleUpdatetime;
    }

    public String getRoleExtend() {
        return roleExtend;
    }

    public void setRoleExtend(String roleExtend) {
        this.roleExtend = roleExtend;
    }

	public List<JxcEmployee> getJxcEmployee() {
		return jxcEmployee;
	}

	public void setJxcEmployee(List<JxcEmployee> jxcEmployee) {
		this.jxcEmployee = jxcEmployee;
	}

	@Override
	public String toString() {
		return "JxcRole [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + ", roleDesc="
				+ roleDesc + ", roleStatus=" + roleStatus + ", roleUpdater=" + roleUpdater + ", roleUpdatetime="
				+ roleUpdatetime + ", roleExtend=" + roleExtend + ", jxcEmployee=" + jxcEmployee + "]";
	}

	/*@Override
	public String toString() {
		return "JxcRole [roleId=" + roleId + ", roleName=" + roleName + ", roleCode=" + roleCode + ", roleDesc="
				+ roleDesc + ", roleStatus=" + roleStatus + ", roleUpdater=" + roleUpdater + ", roleUpdatetime="
				+ roleUpdatetime + ", roleExtend=" + roleExtend + "]";
	}*/
    
    
}