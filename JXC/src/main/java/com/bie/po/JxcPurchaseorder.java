package com.bie.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * 
 * @author: 别先生
 * @date:   2018年2月18日 下午3:13:56
 * @Description: 采购实体类
 */
public class JxcPurchaseorder implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer orderId;//采购订单编号

    private Integer employeeId;//员工编号
    //orderId employeeId warehouseId supplierId
    //orderCode orderNumber orderPrice orderToleprice
    //orderStatus orderCheckman orderCheckresult
    //orderCheckstatus orderDesc orderUpdater orderUpdatetime
    //orderType orderStoragetime orderCreatetime orderExtends
    //orderShouldPay orderActualPayment orderArrears
    private Integer warehouseId;//仓库编号

    private Integer supplierId;//供应商编号

    private String orderCode;//采购订单编码

    private Integer orderNumber;//采购订单数量

    private BigDecimal orderPrice;//采购订单单价

    private BigDecimal orderToleprice;//采购订单总价

    private String orderStatus;//采购订单状态

    private String orderCheckman;//审核人

    private String orderCheckresult;//审核结果

    private String orderCheckstatus;//审核状态

    private String orderDesc;//采购订单描述

    private String orderUpdater;//更新人,操作员

    private String orderUpdatetime;//更新时间

    private String orderType;//采购订单类型

    private String orderStoragetime;//采购订单入库时间,采购收货日期

    private String orderCreatetime;//采购订单创建时间

    private String orderExtends;//采购订单扩展
    
    //新加的字段
    private String orderShouldPay;//应该付款

    private String orderActualPayment;//实际付款
    
    private String orderArrears;//欠款
    
    private Integer goodsId;//商品编号
    
    private JxcEmployee jxcEmployee;//员工
    
    private JxcWarehouse jxcWarehouse;//仓库
    
    private JxcSupplier jxcSupplier;//供应商
    
    private JxcGoods jxcGoods;//商品
    
    //伪造一下员工姓名，供应商姓名，仓库名称，商品名称
    private String employeeName;//员工姓名
    
    private String warehouseName;//仓库名称
    
    private String supplierName;//供应商姓名
    
    private String goodsName;//商品名称
    
    
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

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderToleprice() {
        return orderToleprice;
    }

    public void setOrderToleprice(BigDecimal orderToleprice) {
        this.orderToleprice = orderToleprice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCheckman() {
        return orderCheckman;
    }

    public void setOrderCheckman(String orderCheckman) {
        this.orderCheckman = orderCheckman;
    }

    public String getOrderCheckresult() {
        return orderCheckresult;
    }

    public void setOrderCheckresult(String orderCheckresult) {
        this.orderCheckresult = orderCheckresult;
    }

    public String getOrderCheckstatus() {
        return orderCheckstatus;
    }

    public void setOrderCheckstatus(String orderCheckstatus) {
        this.orderCheckstatus = orderCheckstatus;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getOrderUpdater() {
        return orderUpdater;
    }

    public void setOrderUpdater(String orderUpdater) {
        this.orderUpdater = orderUpdater;
    }

    public String getOrderUpdatetime() {
        return orderUpdatetime;
    }

    public void setOrderUpdatetime(String orderUpdatetime) {
        this.orderUpdatetime = orderUpdatetime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStoragetime() {
        return orderStoragetime;
    }

    public void setOrderStoragetime(String orderStoragetime) {
        this.orderStoragetime = orderStoragetime;
    }

    public String getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(String orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    public String getOrderExtends() {
        return orderExtends;
    }

    public void setOrderExtends(String orderExtends) {
        this.orderExtends = orderExtends;
    }

	public String getOrderShouldPay() {
		return orderShouldPay;
	}

	public void setOrderShouldPay(String orderShouldPay) {
		this.orderShouldPay = orderShouldPay;
	}

	public String getOrderActualPayment() {
		return orderActualPayment;
	}

	public void setOrderActualPayment(String orderActualPayment) {
		this.orderActualPayment = orderActualPayment;
	}

	public String getOrderArrears() {
		return orderArrears;
	}

	public void setOrderArrears(String orderArrears) {
		this.orderArrears = orderArrears;
	}

	@Override
	public String toString() {
		return "JxcPurchaseorder [orderId=" + orderId + ", employeeId=" + employeeId + ", warehouseId=" + warehouseId
				+ ", supplierId=" + supplierId + ", orderCode=" + orderCode + ", orderNumber=" + orderNumber
				+ ", orderPrice=" + orderPrice + ", orderToleprice=" + orderToleprice + ", orderStatus=" + orderStatus
				+ ", orderCheckman=" + orderCheckman + ", orderCheckresult=" + orderCheckresult + ", orderCheckstatus="
				+ orderCheckstatus + ", orderDesc=" + orderDesc + ", orderUpdater=" + orderUpdater
				+ ", orderUpdatetime=" + orderUpdatetime + ", orderType=" + orderType + ", orderStoragetime="
				+ orderStoragetime + ", orderCreatetime=" + orderCreatetime + ", orderExtends=" + orderExtends
				+ ", orderShouldPay=" + orderShouldPay + ", orderActualPayment=" + orderActualPayment
				+ ", orderArrears=" + orderArrears + ", goodsId=" + goodsId + ", jxcEmployee=" + jxcEmployee
				+ ", jxcWarehouse=" + jxcWarehouse + ", jxcSupplier=" + jxcSupplier + ", jxcGoods=" + jxcGoods + "]";
	}

	/*@Override
	public String toString() {
		return "JxcPurchaseorder [orderId=" + orderId + ", employeeId=" + employeeId + ", warehouseId=" + warehouseId
				+ ", supplierId=" + supplierId + ", orderCode=" + orderCode + ", orderNumber=" + orderNumber
				+ ", orderPrice=" + orderPrice + ", orderToleprice=" + orderToleprice + ", orderStatus=" + orderStatus
				+ ", orderCheckman=" + orderCheckman + ", orderCheckresult=" + orderCheckresult + ", orderCheckstatus="
				+ orderCheckstatus + ", orderDesc=" + orderDesc + ", orderUpdater=" + orderUpdater
				+ ", orderUpdatetime=" + orderUpdatetime + ", orderType=" + orderType + ", orderStoragetime="
				+ orderStoragetime + ", orderCreatetime=" + orderCreatetime + ", orderExtends=" + orderExtends
				+ ", orderShouldPay=" + orderShouldPay + ", orderActualPayment=" + orderActualPayment
				+ ", orderArrears=" + orderArrears + ", goodsId=" + goodsId + "]";
	}*/

	/*@Override
	public String toString() {
		return "JxcPurchaseorder [orderId=" + orderId + ", employeeId=" + employeeId + ", warehouseId=" + warehouseId
				+ ", supplierId=" + supplierId + ", orderCode=" + orderCode + ", orderNumber=" + orderNumber
				+ ", orderPrice=" + orderPrice + ", orderToleprice=" + orderToleprice + ", orderStatus=" + orderStatus
				+ ", orderCheckman=" + orderCheckman + ", orderCheckresult=" + orderCheckresult + ", orderCheckstatus="
				+ orderCheckstatus + ", orderDesc=" + orderDesc + ", orderUpdater=" + orderUpdater
				+ ", orderUpdatetime=" + orderUpdatetime + ", orderType=" + orderType + ", orderStoragetime="
				+ orderStoragetime + ", orderCreatetime=" + orderCreatetime + ", orderExtends=" + orderExtends
				+ ", orderShouldPay=" + orderShouldPay + ", orderActualPayment=" + orderActualPayment
				+ ", orderArrears=" + orderArrears + "]";
	}*/
    
    
}