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
<title>员工详细信息</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>员工管理</li>
			<li>员工查看</li>
		</ul>
	</div>
<form action="" class="form-horizontal">
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工姓名</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeName }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工年龄</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeAge }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工性别</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeSex }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工电话</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeePhone }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工邮箱</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeEmail }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工生日</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeBirthday }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工地址</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeAddress }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工编码</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeCode }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束4 -->
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工身份证</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeCardno }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工类型</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.jxRole.roleName }</p>
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->
		<!-- 开始6 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工薪资</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeeExtend }</p>
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
					<label class="col-xs-3 control-label">员工账号</label>
					<div class="col-xs-9">
						<p class="form-control-static">${queryEmployeeDetail.employeeAccount }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工密码</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryEmployeeDetail.employeePassword }</p>
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