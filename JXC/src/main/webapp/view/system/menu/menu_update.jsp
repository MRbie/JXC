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
<title>菜单管理-菜单修改</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<!-- 时间插件 -->
<script type="text/javascript" src="resource/My97Date/WdatePicker.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		//获取到值,用来判断是否选中
		var menuIsleaf = $("#menuIsleaf").val();
		if(menuIsleaf == "yes"){
			//如果读取到的值是yes就选择,否则就不选中
			$("#menuIsleaf").attr("checked",true);
		}else{
			//如果读取到的值是no就不选中
			$("#menuIsleaf").attr("checked",false);
		}
	});	
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>菜单管理</li>
			<li>菜单修改</li>
		</ul>
	</div>
<form action="menu/menuUpdate.action" class="form-horizontal" method="post">
		
		<input type="hidden" name="menuId" value="${resultSingleMenu.menuId }"/>	
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单名称</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleMenu.menuName }" name="menuName" class="form-control" placeholder="请输入菜单名称" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">菜单路径</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" value="${resultSingleMenu.menuPath }" name="menuPath" class="form-control digits" placeholder="请输入菜单路径" />
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label"></label>
					<div class="col-xs-9 ">
						<label class="checkbox-inline">
						  <input type="checkbox" name="menuIsleaf" id="menuIsleaf" value="${resultSingleMenu.menuIsleaf }"/>
						      是否导航节点
						</label>
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">权限代码</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="menuUpid" value="${resultSingleMenu.menuUpid }" class="form-control" placeholder="请输入菜单权限代码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束4 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-2">
				<input type="submit" class="btn btn-success" value="修改菜单" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>
		</div>

	</form>
</body>
</html>