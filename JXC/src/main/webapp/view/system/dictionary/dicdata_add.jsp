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
<title>数据项管理-数据项添加</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
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
			<li>数据项管理</li>
			<li>数据项添加</li>
		</ul>
	</div>
<form action="dicdata/insertDicData.action" id="f1" class="form-horizontal" method="post">
		<input type="hidden" name="dicdataCode" value="${dicdataCodeRequest}" class="form-control"/>
		<!-- 
			//dicdataId dicdataName dicdataCode
			//dicdataDesc dicdataExtend
	 	-->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据项名称</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="dicdataName" class="form-control" placeholder="请输入数据项名称" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据项扩展</label>
					<div class="col-xs-9 ">
						<input type="text" name="dicdataExtend" class="form-control" placeholder="请输入数据项扩展" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		
		<!-- 开始3 -->
		<%-- <div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据项值</label>
					<div class="col-xs-9 ">
						<input type="hidden" name="dicdataCode" value="${dicdataCode}" class="form-control" placeholder="请输入数据项字段" />
						<p class="form-control-static">${dicdataCode}</p>
					</div>
				</div>
			</div>
		</div> --%>
		<!--结束3 -->
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">描述信息</h5>
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">描述信息</label>
					<div class="col-xs-9">
						<textarea class="form-control" name="dicdataDesc" rows="8" placeholder="请输入数据项描述信息"></textarea>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束4 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="添加数据项" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>