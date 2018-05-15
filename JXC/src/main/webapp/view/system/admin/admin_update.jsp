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
<title>管理员管理-管理员修改</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<!-- 时间插件 -->
<script type="text/javascript" src="resource/My97Date/WdatePicker.js"></script>


</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>管理员管理</li>
			<li>管理员修改</li>
		</ul>
	</div>
<form action="admin/update.action" class="form-horizontal" method="post">
		<input type="hidden" name="adminId" value="${updateAdmin.adminId }"/>	
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员姓名</label>
					<div class="col-xs-9 ">
						<input type="text" value="${updateAdmin.adminName }" name="adminName" class="form-control" placeholder="请输入管理员姓名" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员年龄</label>
					<div class="col-xs-9 ">
						<input type="text" value="${updateAdmin.adminAge }" name="adminAge" class="form-control" placeholder="请输入管理员年龄" />
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
						<select class="form-control" name="adminSex">
							<option ${updateAdmin.adminSex=='保密'?'selected':'' }>保密</option>
							<option ${updateAdmin.adminSex=='男'?'selected':'' }>男</option>
		 					<option ${updateAdmin.adminSex=='女'?'selected':'' }>女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员电话</label>
					<div class="col-xs-9 ">
						<input type="text" value="${updateAdmin.adminPhone }" name="adminPhone" class="form-control" placeholder="请输入管理员电话" />
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
						<input type="text" value="${updateAdmin.adminEmail }" name="adminEmail" class="form-control" placeholder="请输入管理员邮箱" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员生日</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" class="form-control" name="adminBirthday" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy:MM:dd HH:mm:ss'})" placeholder="请输入管理员生日" /> -->
						<input type="text" value="${updateAdmin.adminBirthday }" class="form-control" name="adminBirthday" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="请输入管理员生日" />
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
						<input type="text" value="${updateAdmin.adminAddres }" name="adminAddres" class="form-control" placeholder="请输入管理员地址" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员编码</label>
					<div class="col-xs-9 ">
						<input type="text" value="${updateAdmin.adminCode }" name="adminCode" class="form-control" placeholder="请输入管理员编码" />
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
						<input type="text" value="${updateAdmin.adminCardno }" name="adminCardno" class="form-control" placeholder="请输入管理员身份证号码" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员类型</label>
					<div class="col-xs-9 ">
						<input type="text" value="${updateAdmin.adminType }" name="adminType" class="form-control" placeholder="请输入管理员类型" />
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
						<input type="text" value="${updateAdmin.adminExtend }" name="adminExtend" class="form-control" placeholder="请输入管理员扩展字段" />
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
						<input type="text" value="${updateAdmin.adminAccount }" name="adminAccount" class="form-control" placeholder="请输入管理员账号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">管理员密码</label>
					<div class="col-xs-9 ">
						<input type="text" value="${updateAdmin.adminPassword }" name="adminPassword" class="form-control" placeholder="请输入管理员密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束7 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="修改管理员" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>