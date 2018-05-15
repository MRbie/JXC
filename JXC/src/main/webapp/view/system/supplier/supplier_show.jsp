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
<title>供应商详细信息</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>供应商管理</li>
			<li>供应商查看</li>
		</ul>
	</div>
<form action="" class="form-horizontal">
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商姓名：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierName }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商类型：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierType }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商邮箱：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierEmail }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商电话：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierIpone }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新人：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierUpdater }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新时间：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierUpdatetime }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商地址：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierAddress }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商扩展：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierExtends }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束4 -->
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商首款：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierStartPay }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商尾款：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierEndPay }</p>
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
					<label class="col-xs-3 control-label">描述信息：</label>
					<div class="col-xs-9">
						<p class="form-control-static">${querySupplierDetail.supplierRemark }</p>
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
					<label class="col-xs-3 control-label">供应商账号：</label>
					<div class="col-xs-9">
						<p class="form-control-static">${querySupplierDetail.supplierAccount }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">供应商密码：</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${querySupplierDetail.supplierPassword }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束7 -->
		
		

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
				<a href="javascript:window.history.go(-1)" class="btn btn-primary">返回上一级</a>
			</div>
		</div>

	</form>
</body>
</html>