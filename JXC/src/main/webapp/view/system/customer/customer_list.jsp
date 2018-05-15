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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>客户管理-客户查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
	
	    //给全选的复选框添加事件
	    $("#all").click(function(){
	        // this 全选的复选框
	        var customerIds=this.checked;
	        //打印true和false,只是判断全选和全不选的一种状态
	        //alert(customerIds);
	        //获取name=box的复选框 遍历输出复选框
	        $("input[name=box]").each(function(){
	            this.checked=customerIds;
	        });
	    });
	    
	    //给name=box的复选框绑定单击事件
	    $("input[name=box]").click(function(){
	        //获取选中复选框长度
	        var length=$("input[name=box]:checked").length;
	        //未选中的长度
	        var len=$("input[name=box]").length;
	        if(length==len){
	            $("#all").get(0).checked=true;
	        }else{
	            $("#all").get(0).checked=false;
	        }
	    });
	    
	    //点击批量删除按钮,批量删除操作
	    $("#batchDelete").click(function(){
	    	if(confirm('确认删除选中?请谨慎操作......')){
               //alert("确认批量删除,请谨慎操作.");
               //$("input[name=box]").each(function(){
               //定义一个数组用于接受客户的编号
               var checkValue = [];
               $("input[name=box]:checked").each(function(){
                   //关键点在于获取到复选框相邻的编号的id.
                   //将选中的客户存到数组中
                   checkValue.push($(this).val());
               })
               if(checkValue.length == 0){
            	   alert("如果批量删除请先选择您要删除的客户......");
               }
               //测试获取到的客户编号是否正确
               //alert(checkValue);
               if(checkValue.length > 0){
            	 window.location.href="customer/batchDelete.action?customerIds=" + checkValue;  
               }
        	}
	    });
	});
	    
	
</script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>客户管理</li>
			<li>客户查询</li>
		</ul>
	</div>
	<!-- 
		//customerId customerName customerIphone customerEmail
		//customerAddress customerDesc customerStatus
		//customerUpdater customerUpdatetime customerExtends
	 -->
	<form action="customer/customerSelect.action" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select class="form-control" name="condition">
					<option value="">请选择</option>
					<option value="customerName" ${resultCondition=="customerName"?'selected':'' }>姓名</option>
				</select> 
				<input type="text" value="${resultContext }" name="context" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-success" value="查询"> 
			<input type="reset" class="btn btn-danger" value="重置信息" />
			<a href="view/system/customer/customer_add.jsp" class="btn btn-primary">添加客户</a>
			<input type="button" value="批量删除" id="batchDelete" class="btn btn-warning">
			<!-- <input type="button" value="批量导入" id="batchImport" class="btn btn-success">
			<input type="button" value="批量导出" id="batchExport" class="btn btn-danger"> -->
			<!-- 导出excel操作 -->
			<!-- <div class="form-group">
				<a href="employee/employeeExport.action" target="_self" class="btn btn-primary">导出Excel</a>
			</div> -->
			
		</div>
		<div class="row" style="padding: 15px;text-align: center;">
			<table class="table table-hover table-bordered table-striped table-condensed">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<td>客户编号</td>
					<td>客户姓名</td>
					<td>客户电话</td>
					<td>客户邮箱</td>
					<td>客户地址</td>
					<td>操作</td>
				</tr>
				<!-- 
					//customerId customerName customerIphone customerEmail
					//customerAddress customerDesc customerStatus
					//customerUpdater customerUpdatetime customerExtends
				 -->
				<c:forEach items="${pageInfo.list }" var="resultCustomer" >
				<tr class="info">
					<td><input type="Checkbox" name="box" value="${resultCustomer.customerId }"/></td>
					<td>${resultCustomer.customerId }</td>
					<td>
						<a href="customer/queryCustomerDetail.action?customerId=${resultCustomer.customerId}">
							${resultCustomer.customerName}
						</a>
					</td>
					<td>${resultCustomer.customerIphone}</td>
					<td>${resultCustomer.customerEmail}</td>
					<td>${resultCustomer.customerAddress}</td>
					<td>
						<a class="btn btn-primary" href="customer/queryCustomerBySingle.action?customerId=${resultCustomer.customerId}">
							修改</a>
						<a class="btn btn-success" href="customer/customerDelete.action?customerId=${resultCustomer.customerId}">
							删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	
	<!-- <form enctype="multipart/form-data" action="employee/employeeImport.action" class="form-inline" method="post">
		<div style="text-align: right;">
			导入excel数据
			<div class="form-group">
				<input type="file" id="uploadFile" name="uploadFile" class="btn btn-default"/>
			</div>
			文件下载模板
			<a href="employee/employeeTemplate.action?path=/resource/template/exportEmployeeTemplate.xlsx" class="btn btn-success">客户模板</a>
			<input type="submit" id="employeeImport" class="btn btn-danger" value="导入Excel数据">
		</div>	
	</form> -->
	
	<!-- 分页开始 -->
	<!-- 使用mybatis的分页插件,分页信息,所以不用自己写实体类和方法,后期如果时间充足可以加上自己的分页 -->
	<div class="row">
		<div class="col-md-4"></div>
		<!-- 分页条 -->
		<div class="col-md-4">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
				<!-- 首页点击功能 -->
				<li><a href="${basePath}customer/customerSelect.action?pn=1">首页</a></li>
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasPreviousPage }">
					 <li>
					  <a href="${basePath}customer/customerSelect.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
				</c:if>
				
				<!-- 数字点击按钮功能 -->
				<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
					<c:if test="${page_Num == pageInfo.pageNum }">
						<!-- 如果当前页数登录当前页数,这里设置为不可点击 -->
						<li class="active"><a href="javascript:void(0)">${ page_Num}</a></li>
					</c:if>
					<c:if test="${page_Num != pageInfo.pageNum }">
						<li>
							<a href="${basePath}customer/customerSelect.action?pn=${ page_Num}">
								${ page_Num}
							</a>
						</li>
					</c:if>
				</c:forEach> 
				
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasNextPage }">
					<li>
					  <a href="${basePath}customer/customerSelect.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>   
				<!-- 末页点击功能 -->
				<li>
					<a href="${basePath}customer/customerSelect.action?pn=${pageInfo.pages}">
						末页
					</a>
				</li>
			  </ul>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4"></div>
		<!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
		<div class="col-md-4">
			<span class="btn btn-primary">当前第:${pageInfo.pageNum}页,</span>
			<span class="btn btn-success">总共:${pageInfo.pages}页,</span>
			<span class="btn btn-warning">总共:${pageInfo.total}条记录</span>
		</div>
	</div>
  	<!-- 分页结束 -->
  	
</body>
</html>