<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>仓库详细信息</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>仓库管理</li>
			<li>仓库查看</li>
		</ul>
	</div>
<form action="" class="form-horizontal">
		<!-- 
			//warehouseId employeeId warehouseName warehouseCode warehouseAddress
			//warehouseDesc warehouseUpdater warehouseUpdatetime
			//warehouseStatus warehouseExtends warehousePersonLiable warehouseType
	 	-->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库名称</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryWarehouseDetail.warehouseName }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库管理者</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" name="employeeId" class="form-control" placeholder="请输入仓库管理者" /> -->
						<!-- <select class="form-control" name="employeeId">
							<option>保密</option>
						</select> -->
						<p class="form-control-static">${queryWarehouseDetail.warehousePersonLiable}</p>
						
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库地址</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryWarehouseDetail.warehouseAddress }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库编码</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryWarehouseDetail.warehouseCode }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新人</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryWarehouseDetail.warehouseUpdater }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新时间</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryWarehouseDetail.warehouseUpdatetime }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库扩展</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryWarehouseDetail.warehouseExtends }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库类型</label>
					<div class="col-xs-9 ">
						<!-- 仓库预插入操作 -->
						<%-- <select class="form-control" name="warehouseType">
							<option value="">请选择</option>
							<c:forEach items="${dicDataCodeByDataDicCode }" var="preInsertEmployee">
								<option value="${preInsertEmployee.dicdataName }">${preInsertEmployee.dicdataName }</option>
							</c:forEach>
						</select> --%>
						<p class="form-control-static">${queryWarehouseDetail.warehouseType}</p>
						
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">描述信息</h5>
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">描述信息</label>
					<div class="col-xs-9">
						<p class="form-control-static">${queryWarehouseDetail.warehouseDesc }</p>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束4 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
				<a href="javascript:window.history.go(-1)" class="btn btn-primary">返回上一级</a>
			</div>
		</div>

	</form>
</body>
</html>