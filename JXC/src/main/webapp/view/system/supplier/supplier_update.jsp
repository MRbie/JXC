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
<title>供应商管理-供应商修改</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<!-- 时间插件 -->
<script type="text/javascript" src="resource/My97Date/WdatePicker.js"></script>

<!-- 表单验证插件 -->
<!-- <script src="resource/js/jquery.min.js"></script> -->
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
			<li>供应商管理</li>
			<li>供应商修改</li>
		</ul>
	</div>
<form action="supplier/supplierUpdate.action" id="f1" class="form-horizontal" method="post">
		<input type="hidden" name="supplierId" value="${resultSingleSupplier.supplierId }"/>	
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商姓名</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleSupplier.supplierName }" name="supplierName" class="form-control" placeholder="请输入供应商姓名" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商类型</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleSupplier.supplierType }" name="supplierType" class="form-control" placeholder="请输入供应商电话" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商邮箱</label>
					<div class="col-xs-9 ">
						<input type="email" required minlength="6" value="${resultSingleSupplier.supplierEmail }" name="supplierEmail" class="form-control" placeholder="请输入供应商邮箱" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商电话</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="11" value="${resultSingleSupplier.supplierIpone }" name="supplierIpone" class="form-control" placeholder="请输入供应商电话" />
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
						<input type="text" required minlength="2" value="${resultSingleSupplier.supplierUpdater }" name="supplierUpdater" class="form-control" placeholder="请输入供应商更新人" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新时间</label>
					<div class="col-xs-9 ">
						<%-- <input type="text" value="${resultSingleSupplier.supplierUpdatetime }" name="supplierUpdatetime" class="form-control" placeholder="请输入供应商更新时间" />	 --%>
						<input type="text" class="form-control" value="${resultSingleSupplier.supplierUpdatetime }" name="supplierUpdatetime" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:ss:mm'})" placeholder="请输入供应商更新时间" />
					
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商地址</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="5" value="${resultSingleSupplier.supplierAddress }" name="supplierAddress" class="form-control" placeholder="请输入供应商地址" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商扩展</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleSupplier.supplierExtends }" name="supplierExtends" class="form-control" placeholder="请输入供应商扩展字段" />
					</div>
				</div>
			</div>
		</div>
		<!--结束4 -->
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商首款</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleSupplier.supplierStartPay }" name="supplierStartPay" class="form-control" placeholder="请输入供应商首款" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商尾款</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleSupplier.supplierEndPay }" name="supplierEndPay" class="form-control" placeholder="请输入供应商尾款" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">描述信息</h5>
		<!-- 开始6 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">描述信息</label>
					<div class="col-xs-9">
						<textarea class="form-control" name="supplierRemark" rows="8" placeholder="请输入供应商描述信息">${resultSingleSupplier.supplierRemark }</textarea>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束6 -->
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">账号信息</h5>
		<!-- 开始7 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商账号</label>
					<div class="col-xs-9">
						<input type="text" value="${resultSingleSupplier.supplierAccount }" name="supplierAccount" class="form-control" placeholder="请输入供应商账号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商密码</label>
					<div class="col-xs-9 ">
						<input type="password" value="${resultSingleSupplier.supplierPassword }" name="supplierPassword" class="form-control" placeholder="请输入供应商密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束7 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="修改供应商" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>