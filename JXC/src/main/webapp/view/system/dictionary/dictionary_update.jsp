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
<title>数据字典管理-数据字典修改</title>
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
			<li>数据字典管理</li>
			<li>数据字典修改</li>
		</ul>
	</div>
<form action="datadictionary/datadictionaryUpdate.action" class="form-horizontal" method="post">
		
		<input type="hidden" name="datadictionaryId" value="${resultSingleDatadictionary.datadictionaryId }"/>	
		<h5 class="page-header alert-info"   
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据字典名称</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleDatadictionary.datadictionaryName }" name="datadictionaryName" class="form-control" placeholder="请输入数据字典名称" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据字典字段</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleDatadictionary.datadictionaryCode }" name="datadictionaryCode" class="form-control" placeholder="请输入数据字典字段" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		
		<!-- 开始2 -->
		<%-- <div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据字典值</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleDatadictionary.datadictionaryValue }" name="datadictionaryValue" class="form-control" placeholder="请输入数据字典邮箱" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据字典内容</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleDatadictionary.datadictionaryText }" name="datadictionaryText" class="form-control" placeholder="请输入数据字典内容" />
					</div>
				</div>
			</div>
		</div> --%>
		<!--结束2 -->
		
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">数据字典扩展</label>
					<div class="col-xs-9 ">
						<input type="text" value="${resultSingleDatadictionary.datadictionaryExtend }" name="datadictionaryExtend" class="form-control" placeholder="请输入数据字典扩展" />
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">描述信息</h5>
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">描述信息</label>
					<div class="col-xs-9">
						<textarea class="form-control" name="datadictionaryDesc" rows="8" placeholder="请输入角色描述信息">${resultSingleDatadictionary.datadictionaryDesc }</textarea>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束4 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="修改数据字典" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>