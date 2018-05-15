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
<title>订单管理-订单查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
	    //给全选的复选框添加事件
	    $("#all").click(function(){
	        // this 全选的复选框
	        var orderIds=this.checked;
	        //打印true和false,只是判断全选和全不选的一种状态
	        //alert(adminids);
	        //获取name=box的复选框 遍历输出复选框
	        $("input[name=box]").each(function(){
	            this.checked=orderIds;
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
	    $("#batchAdmin").click(function(){
	    	if(confirm('确认删除选中?请谨慎操作......')){
               //alert("确认批量删除,请谨慎操作.");
               //$("input[name=box]").each(function(){
               //定义一个数组用于接受订单的编号
               var checkValue = [];
               $("input[name=box]:checked").each(function(){
                   //关键点在于获取到复选框相邻的编号的id.
                   //将选中的订单存到数组中
                   checkValue.push($(this).val());
               })
               if(checkValue.length == 0){
            	   alert("如果批量删除请先选择您要删除的订单......");
               }
               //测试获取到的订单编号是否正确
               //alert(checkValue);
               if(checkValue.length > 0){
            	 window.location.href="purchaseorder/batchDelete.action?orderIds=" + checkValue;  
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
			<li>订单管理</li>
			<li>订单查询</li>
		</ul>
	</div>
<form action="purchaseorder/jxcPurchaseorderSelect.action" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select class="form-control" name="condition">
					<option value="">请选择</option>
					<option value="employeeName" ${resultCondition=="employeeName"?'selected':'' }>采购员</option>
					<option value="supplierName" ${resultCondition=="supplierName"?'selected':'' }>供应商</option>
					<option value="warehouseName" ${resultCondition=="warehouseName"?'selected':'' }>仓库名称</option>
					<option value="goodsName" ${resultCondition=="goodsName"?'selected':'' }>商品名称</option>
				</select> 
				<input type="text" value="${resultContext }" name="context" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-success" value="查询"> 
			<input type="reset" class="btn btn-danger" value="重置信息" />
			<!-- <a href="view/system/admin/admin_add.jsp" class="btn btn-primary">添加订单</a> -->
			<!-- <a href="#" class="btn btn-primary">添加订单</a> -->
			<!-- <input type="button" value="批量删除" id="batchAdmin" class="btn btn-warning"> -->
		</div>
		<div class="row" style="padding: 15px;text-align: center;">
			<table class="table table-hover table-bordered table-striped table-condensed">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<!-- <td>订单编号</td> -->
					<td>供应商</td>
					<td>采购人员</td>
					<td>入库名称</td>
					<td>商品名称</td>
					<td>订单数量</td>
					<td>订单状态</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${pageInfo.list }" var="resultPurchaseorder">
				<tr class="info">
					<td><input type="Checkbox" name="box" value="${resultPurchaseorder.orderId }"/></td>
					<%-- <td>${resultPurchaseorder.orderId }</td> --%>
					<td>${resultPurchaseorder.jxcSupplier.supplierName}</td>
					<td>${resultPurchaseorder.jxcEmployee.employeeName}</td>
					<td>${resultPurchaseorder.jxcWarehouse.warehouseName}</td>
					<td>${resultPurchaseorder.jxcGoods.goodsName}</td>
					<td>${resultPurchaseorder.orderNumber }</td>
					<c:if test="${resultPurchaseorder.orderStatus==1000}">
						<td>采购待审核</td>
					</c:if>
					<c:if test="${resultPurchaseorder.orderStatus==1001}">
						<td>审核通过</td>
					</c:if>
					<c:if test="${resultPurchaseorder.orderStatus==1002}">
						<td>审核拒绝</td>
					</c:if>
					<c:if test="${resultPurchaseorder.orderStatus==1003}">
						<td>订单已退货</td>
					</c:if>
					<td>
						<!-- <input type="button" id="purchaseorder"  value="采购商品" class="btn btn-success"/> -->
						<a class="btn btn-success" href="purchaseorder/purchaseorderAuditPass.action?orderId=${resultPurchaseorder.orderId}">
							审核通过</a>
						<a class="btn btn-danger" href="purchaseorder/purchaseorderAuditRefuse.action?orderId=${resultPurchaseorder.orderId}">
							审核拒绝</a>
						<a class="btn btn-primary" href="purchaseorder/purchaseorderAuditReturn.action?orderId=${resultPurchaseorder.orderId}">
							退货</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	
	
	
	<!-- 分页开始 -->
	  <!-- 使用mybatis的分页插件,分页信息,所以不用自己写实体类和方法,后期如果时间充足可以加上自己的分页 -->
	  <div class="row">
		<div class="col-md-4"></div>
		<!-- 分页条 -->
		<div class="col-md-4">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
				<!-- 首页点击功能purchaseorder/jxcPurchaseorderSelect.action -->
				<li><a href="${basePath}purchaseorder/jxcPurchaseorderSelect.action?pn=1">首页</a></li>
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasPreviousPage }">
					 <li>
					  <a href="${basePath}purchaseorder/jxcPurchaseorderSelect.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
							<a href="${basePath}purchaseorder/jxcPurchaseorderSelect.action?pn=${ page_Num}">
								${ page_Num}
							</a>
						</li>
					</c:if>
				</c:forEach> 
				
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasNextPage }">
					<li>
					  <a href="${basePath}purchaseorder/jxcPurchaseorderSelect.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>   
				<!-- 末页点击功能 -->
				<li>
					<a href="${basePath}purchaseorder/jxcPurchaseorderSelect.action?pn=${pageInfo.pages}">
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