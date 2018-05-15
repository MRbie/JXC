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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作台</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resource/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resource/js/bootstrap.min.js"></script>

<!-- 报表引入的js文件 -->
<script src="resource/js/highcharts.js"></script>
<script src="resource/js/jquery.highchartTable.js"></script>


</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style=" padding:0px; padding-left:20px;" >
  <li ><a href="javascript:void(0)">首页</a></li>
  <li>工作台</li>
</ul>
</div>
<div class="row">
	<div class="col-xs-6" >
    	 <div class="panel panel-default" >
          <div class="panel-heading"  >
            <span class="glyphicon glyphicon-refresh"></span>图形报表
          </div>
              <div class="panel-body">
              	<img src="resource/img/test.png" height="200" width="100%">
              </div>
        </div>
    </div>
    <div class="col-xs-6" >
 	 <div class="panel panel-default" >
          <div class="panel-heading"  >
            <span class="glyphicon glyphicon-refresh"></span>图形报表
          </div>
              <div class="panel-body">
              	<img src="resource/img/test.png" height="200" width="100%">
              </div>
        </div>
    </div>


</div>

<!-- <script src="http://open.sojson.com/common/js/canvas-nest.min.js" 
	count="200" zindex="-2" opacity="0.5" color="139,0,139" 
	type="text/javascript"></script> -->
<!-- <script src="resource/js/canvas-nest.js" 
	count="500" zindex="5" opacity="0.5" color="0,0,0" 
	type="text/javascript"></script> -->	
	
<!-- 
	解释下script上的参数：
	count  ：线条数量。
	zindex ：层级。
	opacity：透明度。
	color   ：线条颜色。最好用RGB颜色。
 -->
</body>
</html>
