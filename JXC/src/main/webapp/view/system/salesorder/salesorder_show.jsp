<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//获取绝对路径路径 
	String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>订单销售详细信息</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

<!-- 表单验证插件 -->
<!-- <script src="resource/js/jquery.min.js"></script> -->
<script src="resource/jquery-validation-1.14.0/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="resource/jquery-validation-1.14.0/dist/localization/messages_zh.js" type="text/javascript"></script>
<!-- 必须引入这个样式，不然弹框提示不出现 -->
<script src="resource/js/jquery-ui.min.js" type="text/javascript"></script>


</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>订单销售管理</li>
			<li>订单销售查看</li>
		</ul>
	</div>
<form action="saleOrder/saleOrderSuccess.action" class="form-horizontal">
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商：</label>
					<div class="col-xs-9 ">
						<!-- name="${resultPurchaseorder.jxcSupplier.supplierId}" -->
						<%-- <input type="text" name="supplierId" value="${resultPurchaseorder.jxcSupplier.supplierName != null?resultPurchaseorder.jxcSupplier.supplierId:''}" readonly="readonly" class="form-control"/> --%>
						<input type="text" value="${resultPurchaseorder.jxcSupplier.supplierName}" readonly="readonly" class="form-control"/>
						<input type="hidden" name="supplierId" value="${resultPurchaseorder.jxcSupplier.supplierId}" readonly="readonly" class="form-control"/>
					
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">采购人员：</label>
					<div class="col-xs-9 ">
						<!-- name="${resultPurchaseorder.jxcEmployee.employeeId}" -->
						<input type="text" value="${resultPurchaseorder.jxcEmployee.employeeName}" readonly="readonly" class="form-control"/>
						<input type="hidden" name="employeeId" value="${resultPurchaseorder.jxcEmployee.employeeId}" readonly="readonly" class="form-control"/>
					
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">入库名称：</label>
					<div class="col-xs-9 ">
					    <!-- name="${resultPurchaseorder.jxcWarehouse.warehouseId}" -->
						<input type="text" value="${resultPurchaseorder.jxcWarehouse.warehouseName}" readonly="readonly" class="form-control"/>
						<input type="hidden" name="warehouseId" value="${resultPurchaseorder.jxcWarehouse.warehouseId}" readonly="readonly" class="form-control"/>
					
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品名称：</label>
					<div class="col-xs-9 ">
						<!-- name="${resultPurchaseorder.jxcGoods.goodsId}" -->
						<input type="text" value="${resultPurchaseorder.jxcGoods.goodsName}" readonly="readonly" class="form-control"/>
						<input type="hidden" name="goodsId" value="${resultPurchaseorder.jxcGoods.goodsId}" readonly="readonly" class="form-control"/>
						
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">订单数量：</label>
					<div class="col-xs-9 ">
						<input type="text" name="orderNumber" value="${resultPurchaseorder.orderNumber }" readonly="readonly" class="form-control"/>
						<input type="hidden" name="orderId" value="${resultPurchaseorder.orderId}" readonly="readonly" class="form-control"/>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">客户姓名：</label>
					<div class="col-xs-9 ">
						<%-- <p class="form-control-static">${customer.customerName }</p> --%>
						<select class="form-control" required name="customerId">
							<option value="">请选择</option>
							<c:forEach items="${customer }" var="customer">
								<option value="${customer.customerId }">${customer.customerName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="销售商品" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-primary">返回上一级</a>
			</div>
		</div>

	</form>
</body>
</html>