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
<title>仓库管理-仓库添加</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<!-- 时间插件 -->
<script type="text/javascript" src="resource/My97Date/WdatePicker.js"></script>

<!-- 表单验证插件 -->
<script src="resource/jquery-validation-1.14.0/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="resource/jquery-validation-1.14.0/dist/localization/messages_zh.js" type="text/javascript"></script>
<!-- 必须引入这个样式，不然弹框提示不出现 -->
<script src="resource/js/jquery-ui.min.js" type="text/javascript"></script>


<style>
.error{
	color:red;
	font-size: 14px;
	
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$().ready(function() {
	    $("#f1").validate();
	});
});

</script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>仓库管理</li>
			<li>仓库添加</li>
		</ul>
	</div>
<form action="warehouse/insertWarehouse.action" id="f1" class="form-horizontal" method="post">
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
						<input type="text" required minlength="2" name="warehouseName" class="form-control" placeholder="请输入仓库名称" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库管理者</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" name="employeeId" class="form-control" placeholder="请输入仓库管理者" /> -->
						<select class="form-control" required name="warehousePersonLiable">
							<option value="">请选择</option>
							<c:forEach items="${resultEmployeeType }" var="preInsertAdminName">
								<option value="${preInsertAdminName.employeeName }">${preInsertAdminName.employeeName }</option>
							</c:forEach>
						</select>
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
						<input type="text" required minlength="2" name="warehouseAddress" class="form-control" placeholder="请输入仓库地址" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库编码</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="warehouseCode" class="form-control" placeholder="请输入仓库编码" />
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
						<input type="text" required minlength="2" name="warehouseUpdater" class="form-control" placeholder="请输入仓库更新人" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新时间</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" name="warehouseUpdatetime" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="请输入仓库更新时间" />
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
						<input type="text" name="warehouseExtends" class="form-control" placeholder="请输入仓库扩展" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">仓库类型</label>
					<div class="col-xs-9 ">
						<!-- 仓库预插入操作 -->
						<select class="form-control" required name="warehouseType">
							<option value="">请选择</option>
							<c:forEach items="${dicDataCodeByDataDicCodeWarehouse }" var="preInsertWarehouse">
								<option value="${preInsertWarehouse.dicdataName }">${preInsertWarehouse.dicdataName }</option>
							</c:forEach>
						</select>
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
						<textarea class="form-control" name="warehouseDesc" rows="8" placeholder="请输入仓库描述信息"></textarea>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束4 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="添加仓库" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>