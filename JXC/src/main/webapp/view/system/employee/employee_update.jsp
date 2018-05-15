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
<title>员工管理-员工修改</title>
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
			<li>员工管理</li>
			<li>员工修改</li>
		</ul>
	</div>
<form action="employee/employeeUpdate.action" id="f1" class="form-horizontal" method="post">
		
		<!-- 
			//employeeName employeeAccount employeePassword employeeAge employeeSex employeeBirthday
			//employeeAddress employeeStatus employeeCode employeeCardno employeePhone employeeEmail
			//employeeType employeeUpdater employeeUpdatetime employeeExtend
		 -->
		<input type="hidden" name="employeeId" value="${resultSingleEmployee.employeeId }"/>	
		<h5 class="page-header alert-info" 
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工姓名</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleEmployee.employeeName }" name="employeeName" class="form-control" placeholder="请输入员工姓名" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工年龄</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleEmployee.employeeAge }" name="employeeAge" class="form-control digits" placeholder="请输入员工年龄" />
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
						<select class="form-control" name="employeeSex">
							<option ${resultSingleEmployee.employeeSex=='保密'?'selected':'' }>保密</option>
							<option ${resultSingleEmployee.employeeSex=='男'?'selected':'' }>男</option>
		 					<option ${resultSingleEmployee.employeeSex=='女'?'selected':'' }>女</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工电话</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="11" value="${resultSingleEmployee.employeePhone }" name="employeePhone" class="form-control digits" placeholder="请输入员工电话" />
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
						<input type="email" value="${resultSingleEmployee.employeeEmail }" name="employeeEmail" class="form-control" placeholder="请输入员工邮箱" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工生日</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleEmployee.employeeBirthday }" class="form-control" name="employeeBirthday" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="请输入员工生日" />
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
						<input type="text" required minlength="6" value="${resultSingleEmployee.employeeAddress }" name="employeeAddress" class="form-control" placeholder="请输入员工地址" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工编码</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="5" value="${resultSingleEmployee.employeeCode }" name="employeeCode" class="form-control" placeholder="请输入员工编码" />
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
						<input type="text" required minlength="18" value="${resultSingleEmployee.employeeCardno }" name="employeeCardno" class="form-control digits" placeholder="请输入员工身份证号码" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工类型</label>
					<div class="col-xs-9 ">
						<%-- <input type="text" value="${resultSingleEmployee.employeeType }" name="employeeType" class="form-control" placeholder="请输入员工类型" /> --%>
						<!-- 员工预插入操作 -->
						<select class="form-control" name="roleId">
							<option value="">请选择</option>
							<c:forEach items="${employeeRoleType }" var="preInsertEmployee">
								<option value="${preInsertEmployee.roleId }" ${preInsertEmployee.roleId==resultSingleEmployee.roleId?'selected':'' }>${preInsertEmployee.roleName }</option>
							</c:forEach>
						</select>
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
						<input type="text" required minlength="4" value="${resultSingleEmployee.employeeExtend }" name="employeeExtend" class="form-control digits" placeholder="请输入员工薪资" />
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
						<input type="text" value="${resultSingleEmployee.employeeAccount }" name="employeeAccount" class="form-control" placeholder="请输入员工账号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">员工密码</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleEmployee.employeePassword }" name="employeePassword" class="form-control" placeholder="请输入管理员密码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束7 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="修改员工" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>