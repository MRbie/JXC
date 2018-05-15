package com.bie.po;

import java.io.Serializable;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:14:45
 * @Description: 仓库实体类warehouse
 */
public class JxcWarehouse implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer warehouseId;//仓库编号
	//warehouseId employeeId warehouseName warehouseCode warehouseAddress
	//warehouseDesc warehouseUpdater warehouseUpdatetime
	//warehouseStatus warehouseExtends warehousePersonLiable warehouseType
    //private Integer adminId;//管理员编号
	//private Integer employeeId;//管理员编号
	
    private String warehouseName;//仓库名称

    private String warehouseCode;//仓库编码

    private String warehouseAddress;//仓库地址

    private String warehouseDesc;//仓库描述,备注

    private String warehouseUpdater;//更新人

    private String warehouseUpdatetime;//更新时间

    private String warehouseStatus;//仓库状态

    private String warehouseExtends;//仓库扩展
    
    //新加字段
    private String warehousePersonLiable;//仓库责任人
    
    private String warehouseType;//仓库类型
    
    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /*public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}*/

	public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public String getWarehouseDesc() {
        return warehouseDesc;
    }

    public void setWarehouseDesc(String warehouseDesc) {
        this.warehouseDesc = warehouseDesc;
    }

    public String getWarehouseUpdater() {
        return warehouseUpdater;
    }

    public void setWarehouseUpdater(String warehouseUpdater) {
        this.warehouseUpdater = warehouseUpdater;
    }

    public String getWarehouseUpdatetime() {
        return warehouseUpdatetime;
    }

    public void setWarehouseUpdatetime(String warehouseUpdatetime) {
        this.warehouseUpdatetime = warehouseUpdatetime;
    }

    public String getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(String warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public String getWarehouseExtends() {
        return warehouseExtends;
    }

    public void setWarehouseExtends(String warehouseExtends) {
        this.warehouseExtends = warehouseExtends;
    }

	public String getWarehousePersonLiable() {
		return warehousePersonLiable;
	}

	public void setWarehousePersonLiable(String warehousePersonLiable) {
		this.warehousePersonLiable = warehousePersonLiable;
	}

	public String getWarehouseType() {
		return warehouseType;
	}

	public void setWarehouseType(String warehouseType) {
		this.warehouseType = warehouseType;
	}

	/*@Override
	public String toString() {
		return "JxcWarehouse [warehouseId=" + warehouseId + ", employeeId=" + employeeId + ", warehouseName=" + warehouseName
				+ ", warehouseCode=" + warehouseCode + ", warehouseAddress=" + warehouseAddress + ", warehouseDesc="
				+ warehouseDesc + ", warehouseUpdater=" + warehouseUpdater + ", warehouseUpdatetime="
				+ warehouseUpdatetime + ", warehouseStatus=" + warehouseStatus + ", warehouseExtends="
				+ warehouseExtends + ", warehousePersonLiable=" + warehousePersonLiable + ", warehouseType="
				+ warehouseType + "]";
	}*/
	
	@Override
	public String toString() {
		return "JxcWarehouse [warehouseId=" + warehouseId + ", warehouseName=" + warehouseName
				+ ", warehouseCode=" + warehouseCode + ", warehouseAddress=" + warehouseAddress + ", warehouseDesc="
				+ warehouseDesc + ", warehouseUpdater=" + warehouseUpdater + ", warehouseUpdatetime="
				+ warehouseUpdatetime + ", warehouseStatus=" + warehouseStatus + ", warehouseExtends="
				+ warehouseExtends + ", warehousePersonLiable=" + warehousePersonLiable + ", warehouseType="
				+ warehouseType + "]";
	}
    
}