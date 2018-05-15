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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统介绍</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resource/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resource/js/bootstrap.min.js"></script>

<style type="text/css">
	ol li{
		font-size: 20px;
	}

</style>

</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style=" padding:0px; padding-left:20px;" >
  <li ><a href="javascript:void(0)">系统介绍</a></li>
  <li>系统介绍</li>
 </ul>
</div>

<div class="row" style="padding: 15px;text-align: center;">
	<div class="col-xs-12" >
    	<table class="table table-hover table-bordered table-striped">
			<caption>
				<h2>
					基于J2EE的智慧企业进销存管理系统的设计与实现
				</h2>
			</caption>
			<thead>
				<tr class="danger">
					<td>系统名称</td>
					<td>版本号</td>
					<td>前端技术</td>
					<td>后端技术</td>
					<td>数据库</td>
					<td>服务器</td>
					<td>开发工具</td>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>智慧企业进销存管理系统</td>
					<td>1.0.0</td>
					<td>html+css+jsp</td>
					<td>Java(Jdk1.7)+SpringMvc+Spring+Mybitas</td>
					<td>Mysql5.0</td>
					<td>tomcat7.0</td>
					<td>Eclise Mars.2 Release (4.5.2)</td>
				</tr>	
			</tbody>
			<tfoot>
				
			</tfoot>
		</table>	
    </div>
    
</div>

<div class="row" style="padding: 15px;text-align: left;">
	<ol>
	  <li>
	  	系统管理&nbsp;:&nbsp;管理员管理&nbsp;,&nbsp;角色管理&nbsp;,&nbsp;菜单管理&nbsp;,&nbsp;员工管理
	  </li>
	  <li>
	  	采购管理&nbsp;:&nbsp;供应商管理&nbsp;,&nbsp;采购订单管理
	  </li>
	  <li>
	  	销售管理&nbsp;:&nbsp;客户管理&nbsp;,&nbsp;销售订单管理,
	  </li>
	  <li>
	  	库存管理&nbsp;:&nbsp;库存管理&nbsp;,&nbsp;采购审核管理&nbsp;,&nbsp;销售审核管理
	  </li>
	  <li>
	  	商品管理&nbsp;:&nbsp;商品管理
	  </li>
	  <li>
	  	仓库管理&nbsp;:&nbsp;仓库管理
	  </li>
	  <li>
	  	日志管理&nbsp;:&nbsp;日志管理
	  </li>
	  <li>统计管理</li>
	  <li>系统介绍</li>
	</ol>

</div>

</body>
</html>