package com.bie.po;

import java.io.Serializable;

public class JxcRoleEmployee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer roleId;

    private Integer employeeId;
    
    private JxcEmployee jxcEmployee;
    
    private JxcRole jxcRole;
    
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

	public JxcEmployee getJxcEmployee() {
		return jxcEmployee;
	}

	public void setJxcEmployee(JxcEmployee jxcEmployee) {
		this.jxcEmployee = jxcEmployee;
	}

	public JxcRole getJxcRole() {
		return jxcRole;
	}

	public void setJxcRole(JxcRole jxcRole) {
		this.jxcRole = jxcRole;
	}

	@Override
	public String toString() {
		return "JxcRoleEmployee [roleId=" + roleId + ", employeeId=" + employeeId + ", jxcEmployee=" + jxcEmployee
				+ ", jxcRole=" + jxcRole + "]";
	}

//	@Override
//	public String toString() {
//		return "JxcRoleEmployee [roleId=" + roleId + ", employeeId=" + employeeId + "]";
//	}
    
    
}