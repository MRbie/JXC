package com.bie.po;

import java.io.Serializable;

public class JxcEmployeeWarehouse implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer employeeId;//员工编号

    private Integer warehouseId;//仓库编号

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

	@Override
	public String toString() {
		return "JxcEmployeeWarehouse [employeeId=" + employeeId + ", warehouseId=" + warehouseId + "]";
	}
    
    
}