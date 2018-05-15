package com.bie.po;

import java.io.Serializable;

public class JxcMenuRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer menuId;

    private Integer roleId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

	@Override
	public String toString() {
		return "JxcMenuRole [menuId=" + menuId + ", roleId=" + roleId + "]";
	}
    
    
}