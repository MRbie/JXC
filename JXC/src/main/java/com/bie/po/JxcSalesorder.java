package com.bie.po;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:14:19
 * @Description: 销售订单实体类
 */
public class JxcSalesorder implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer salesorderId;//销售订单编码

    private Integer customerId;//客户编码

    private Integer warehouseId;//仓库编码

    private Integer goodsId;//商品编码

    private Integer salesorderNum;//销售订单数量

    private String salesorderCode;//销售订单编码

    private BigDecimal salesorderPrice;//销售订单单价

    private BigDecimal salesorderTotalprice;//销售订单总价

    private String salesorderDesc;//销售订单描述

    private String salesorderStatus;//销售订单状态

    private String salesorderExtends;//销售订单扩展

    private String salesorderCheckstatus;//销售订单审核状态

    private String salesorderCheckman;//销售订单审核人

    private String salesorderCheckResult;//销售订单审核结果

    private String salesorderType;//销售订单类型

    private String salesorderUpdater;//销售订单更新人

    private String salesorderUpdatetime;//销售订单更新时间
    
    //20180412
    private Integer supplierId;//供应商编号
    
    private Integer employeeId;//员工编号
    
    //伪造一下员工姓名，供应商姓名，仓库名称，商品名称
    private String employeeName;//员工姓名
    
    private String warehouseName;//仓库名称
    
    private String supplierName;//供应商姓名
    
    private String goodsName;//商品名称
    
    private JxcEmployee jxcEmployee;//员工
    
    private JxcWarehouse jxcWarehouse;//仓库
    
    private JxcSupplier jxcSupplier;//供应商
    
    private JxcGoods jxcGoods;//商品
    
    
    public JxcEmployee getJxcEmployee() {
		return jxcEmployee;
	}

	public void setJxcEmployee(JxcEmployee jxcEmployee) {
		this.jxcEmployee = jxcEmployee;
	}

	public JxcWarehouse getJxcWarehouse() {
		return jxcWarehouse;
	}

	public void setJxcWarehouse(JxcWarehouse jxcWarehouse) {
		this.jxcWarehouse = jxcWarehouse;
	}

	public JxcSupplier getJxcSupplier() {
		return jxcSupplier;
	}

	public void setJxcSupplier(JxcSupplier jxcSupplier) {
		this.jxcSupplier = jxcSupplier;
	}

	public JxcGoods getJxcGoods() {
		return jxcGoods;
	}

	public void setJxcGoods(JxcGoods jxcGoods) {
		this.jxcGoods = jxcGoods;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getSalesorderCheckResult() {
		return salesorderCheckResult;
	}

	public void setSalesorderCheckResult(String salesorderCheckResult) {
		this.salesorderCheckResult = salesorderCheckResult;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getSalesorderId() {
        return salesorderId;
    }

    public void setSalesorderId(Integer salesorderId) {
        this.salesorderId = salesorderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSalesorderNum() {
        return salesorderNum;
    }

    public void setSalesorderNum(Integer salesorderNum) {
        this.salesorderNum = salesorderNum;
    }

    public String getSalesorderCode() {
        return salesorderCode;
    }

    public void setSalesorderCode(String salesorderCode) {
        this.salesorderCode = salesorderCode;
    }

    public BigDecimal getSalesorderPrice() {
        return salesorderPrice;
    }

    public void setSalesorderPrice(BigDecimal salesorderPrice) {
        this.salesorderPrice = salesorderPrice;
    }

    public BigDecimal getSalesorderTotalprice() {
        return salesorderTotalprice;
    }

    public void setSalesorderTotalprice(BigDecimal salesorderTotalprice) {
        this.salesorderTotalprice = salesorderTotalprice;
    }

    public String getSalesorderDesc() {
        return salesorderDesc;
    }

    public void setSalesorderDesc(String salesorderDesc) {
        this.salesorderDesc = salesorderDesc;
    }

    public String getSalesorderStatus() {
        return salesorderStatus;
    }

    public void setSalesorderStatus(String salesorderStatus) {
        this.salesorderStatus = salesorderStatus;
    }

    public String getSalesorderExtends() {
        return salesorderExtends;
    }

    public void setSalesorderExtends(String salesorderExtends) {
        this.salesorderExtends = salesorderExtends;
    }

    public String getSalesorderCheckstatus() {
        return salesorderCheckstatus;
    }

    public void setSalesorderCheckstatus(String salesorderCheckstatus) {
        this.salesorderCheckstatus = salesorderCheckstatus;
    }

    public String getSalesorderCheckman() {
        return salesorderCheckman;
    }

    public void setSalesorderCheckman(String salesorderCheckman) {
        this.salesorderCheckman = salesorderCheckman;
    }

    /*public String getSalesorderResult() {
        return salesorderCheckResult;
    }

    public void setSalesorderResult(String salesorderResult) {
        this.salesorderCheckResult = salesorderResult;
    }*/

    public String getSalesorderType() {
        return salesorderType;
    }

    public void setSalesorderType(String salesorderType) {
        this.salesorderType = salesorderType;
    }

    public String getSalesorderUpdater() {
        return salesorderUpdater;
    }

    public void setSalesorderUpdater(String salesorderUpdater) {
        this.salesorderUpdater = salesorderUpdater;
    }

    public String getSalesorderUpdatetime() {
        return salesorderUpdatetime;
    }

    public void setSalesorderUpdatetime(String salesorderUpdatetime) {
        this.salesorderUpdatetime = salesorderUpdatetime;
    }

	@Override
	public String toString() {
		return "JxcSalesorder [salesorderId=" + salesorderId + ", customerId=" + customerId + ", warehouseId="
				+ warehouseId + ", goodsId=" + goodsId + ", salesorderNum=" + salesorderNum + ", salesorderCode="
				+ salesorderCode + ", salesorderPrice=" + salesorderPrice + ", salesorderTotalprice="
				+ salesorderTotalprice + ", salesorderDesc=" + salesorderDesc + ", salesorderStatus=" + salesorderStatus
				+ ", salesorderExtends=" + salesorderExtends + ", salesorderCheckstatus=" + salesorderCheckstatus
				+ ", salesorderCheckman=" + salesorderCheckman + ", salesorderCheckResult=" + salesorderCheckResult
				+ ", salesorderType=" + salesorderType + ", salesorderUpdater=" + salesorderUpdater
				+ ", salesorderUpdatetime=" + salesorderUpdatetime + ", supplierId=" + supplierId + ", employeeId="
				+ employeeId + ", employeeName=" + employeeName + ", warehouseName=" + warehouseName + ", supplierName="
				+ supplierName + ", goodsName=" + goodsName + ", jxcEmployee=" + jxcEmployee + ", jxcWarehouse="
				+ jxcWarehouse + ", jxcSupplier=" + jxcSupplier + ", jxcGoods=" + jxcGoods + "]";
	}

	
    
}