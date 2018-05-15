<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作台</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resource/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resource/js/bootstrap.min.js"></script>

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
	
	$().ready(function() {
	    $("#f1").validate();
	});


/* $(document).ready(function(){
	var newPassword=null;
	var surePassword=null;
	//当鼠标离开的时候
	$("#surePassword").mouseleave(function(){
		//新密码
		newPassword = $("#newPassword").val();
		//确认密码
		newPassword = $("#surePassword").val();
		//判断如果两次密码不一致,就提示密码不一致
		if(newPassword!= null &&  surePassword != null &&
				newPassword != "" && surePassword != ""){
			if(newPassword != surePassword){
				$("#errorPassword").html("两次输入不一致，请重新输入");
			}
		}
	});
	
});
 */
</script>

</head>
<body>
<div style="padding:0px; margin:0px;">
	 <ul class="breadcrumb" style=" padding:0px; padding-left:20px;" >
		  <li ><a href="javascript:void(0)">首页</a></li>
		  <li>修改密码</li>
	</ul>
</div>

	
	<h5 class="page-header alert-info" style="margin: 0px; padding: 10px; margin-bottom: 10px;">
		修改密码
	</h5>
	<form action="admin/modifyPassword.action" id="f1" class="form-horizontal" method="post">
	<!-- 开始1 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">旧密码</label>
				<div class="col-xs-9 ">
					<input type="text" value="${employeePassword }" name="employeePassword" required minlength="6" class="form-control" placeholder="请输入旧密码" />
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label"></label>
				<div class="col-xs-9 ">
					<span style="color:red;font-size:24px;" id="errorPassword">
						${errorPassword }
					</span>
				</div>
			</div>
		</div>
	</div>
	<!--结束1 -->
	<!-- 开始2 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">新密码</label>
				<div class="col-xs-9 ">
					<input type="text" value="${newPassword }" required minlength="6" id="newPassword" name="newPassword" class="form-control" placeholder="请输入新密码" />
				</div>
			</div>
		</div>
	</div>
	<!--结束2 -->
	<!-- 开始3 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">密码确认</label>
				<div class="col-xs-9 ">
					<input type="text" value="${surePassword }" required minlength="6" id="surePassword"  name="surePassword" class="form-control" placeholder="请输入再次确认密码" />
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label"></label>
				<div class="col-xs-9 ">
					<span style="color:red;font-size:24px;" id="errorPassword">
						${secondPasswordError } ${successPassword }
					</span>
				</div>
			</div>
		</div>
		
	</div>
	<!--结束3-->
	<!-- 开始4 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">本地时间和Ip:</label>
				<div class="col-xs-9 ">
					<span style="color:red;font-size:18px;">
						${nowTime } 
						<%-- <c:if test="${nowTime != null}  ">
							${nowTime } 
						</c:if> --%>
						<br/>
						${localIp }
						<%-- <c:if test="${localIp != null} ">
							${localIp }
						</c:if> --%>
						<br/>
						${outerNetIp }
						<%-- <c:if test="${outerNetIp != null} ">
							${outerNetIp }
						</c:if> --%>
					</span>
				</div>
			</div>
		</div>
	</div>
	<!--结束4-->
	
	<div class="row">
		<div class="col-xs-5 col-xs-offset-2">
			<input type="submit" id="submit" class="btn btn-success" value="修改密码" /> 
			<input type="reset" class="btn btn-danger" value="重置信息" />
			<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
		</div>
		
    </div>

</form>

</body>
</html>
