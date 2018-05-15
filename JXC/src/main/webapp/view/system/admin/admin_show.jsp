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
<title>管理员详细信息</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>管理员管理</li>
			<li>管理员查看</li>
		</ul>
	</div>
<form action="" class="form-horizontal">
		<!-- 
			//adminName adminType adminStatus adminExtend adminAccount adminPassword adminCardno
			//adminAge adminSex  adminPhone adminEmail adminBirthday adminAddres adminCode
		 -->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员姓名</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminName }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员年龄</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminAge }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员性别</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminSex }</p>
						<!-- <select class="form-control">
							<option>保密</option>
							<option>男</option>
							<option>女</option>
						</select> -->
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员电话</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminPhone }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员邮箱</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminEmail }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员生日</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminBirthday }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员地址</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminAddres }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员编码</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminCode }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束4 -->
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员身份证</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminCardno }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员类型</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminType }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->
		<!-- 开始6 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员扩展</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminExtend }</p>
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
					<label class="col-xs-3 control-label">管理员账号</label>
					<div class="col-xs-9">
						<p class="form-control-static">${queryBySingleAdmin.adminAccount }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员密码</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryBySingleAdmin.adminPassword }</p>
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