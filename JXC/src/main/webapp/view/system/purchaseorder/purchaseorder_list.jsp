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
<title>商品管理-商品查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<!-- 时间插件 -->
<script type="text/javascript" src="resource/My97Date/WdatePicker.js"></script>

<script type="text/javascript">
	$(function(){
	    //给全选的复选框添加事件
	    $("#all").click(function(){
	        // this 全选的复选框
	        var goodsIds=this.checked;
	        //打印true和false,只是判断全选和全不选的一种状态
	        //alert(goodsIds);
	        //获取name=box的复选框 遍历输出复选框
	        $("input[name=box]").each(function(){
	            this.checked=goodsIds;
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
	    
	    /*//点击批量删除按钮,批量删除操作
	    $("#batchDelete").click(function(){
	    	if(confirm('确认删除选中?请谨慎操作......')){
               //alert("确认批量删除,请谨慎操作.");
               //$("input[name=box]").each(function(){
               //定义一个数组用于接受商品的编号
               var checkValue = [];
               $("input[name=box]:checked").each(function(){
                   //关键点在于获取到复选框相邻的编号的id.
                   //将选中的商品存到数组中
                   checkValue.push($(this).val());
               })
               if(checkValue.length == 0){
            	   alert("如果批量删除请先选择您要删除的商品......");
               }
               //测试获取到的商品编号是否正确
               //alert(checkValue);
               if(checkValue.length > 0){
            	 window.location.href="goods/batchDelete.action?goodsIds=" + checkValue;  
               }
        	}
	    }); */
               
        //采购商品订单显示出来       
	    /* $("#selectIt").click(function(){
			//获取第一个表格，目的是为了动态构建这个空白表格
			var tab1 = $("#tab");
			//获取选择复选框勾上对号的，ids是一个数组
			var ids = $("input[id=all]:checked");
			
			var reimMoney = $("#reimMoney");//报销总金额
			//遍历动态构建第一个空白的表格
			ids.each(function(){
				//$(this)表示取当前的复选框，复选框的上一级的上一级的所有的td，即编号内容，名称内容，说明内容
				var td = $(this).parent().parent().find("td");
				alert(td);
				//"" <tr></tr> "" ++  "<tr><td>""  "</td><td>"
				tab1.append("<tr><td><input type='hidden' name='goodsId' value='"+td[1].innerHTML+"'>"
						+td[1].innerHTML+"</td><td>"
						+td[2].innerHTML+"</td><td>"
						+td[3].innerHTML+"</td><td>"
						+"<input type='text' value='0' id='reimDetailMoney' name='reimDetailMoney' class='form-control' style='width:100px;'></td><td>"
						
						+"<input type='text' name='reimDetailDesc' class='form-control'></td><td>"
						
						+"<a href='javascript:void(0)' onclick='del(this)' class='btn btn-danger'>删除</a>"
						+"</td></tr>");
				
				//自动计算总金额的功能
				$("input[id=reimDetailMoney]").blur(function(){
					//最好是能对输入的金额作出比较,先留在这里吧
					var  inputMoney= $("#reimDetailMoney").val();

					var sum = 0;//用于设置总金额最后得到的结果 哦
					$("input[id=reimDetailMoney]").each(function(){
						sum += parseFloat($(this).val());
					});
					//将计算的总金额写到报销的总金额的文本框中
					reimMoney.val(sum);
				});
				
			});
			
			//隐藏模态框
			$("#myModal").modal('hide');
		});
	     */
	     
	});

	   
	/*<!--采购商品先将商品信息全部查询出来-->  
	$("#purchaseorder").click(function(){   
		alert("aaaa");
		//window.location.href="purchaseorder/purchaseorderInsert.action";  	
	}); */
	
	//function purchaseorderFunction(goodsId){
		//alert("获取到的商品编号信息:" + goodsId);
		//window.location.href="purchaseorder/purchaseorderInsert.action?goodsId=" + goodsId;  	
	 	/* val goodsId = goodsId;
	 	alert("获取到的商品编号信息:" + goodsId);
		$.ajax({
            type : "POST",//post类型请求。
            data : {"goodsId":goodsId},//将每一次获取到角色id传递到后台。
            url : "purchaseorder/purchaseorderInsert.action",//请求后台的路径
            success : function(resourceByRole) {
            	//参数即后台返回的数据。
               
            },
        }); */
		
	//} 
	
	//采购商品的隐藏和显示功能
	$(document).ready(function(){
	  $("#toggle").click(function(){
	 	 $("#hide").toggle();
	  });
	});
</script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>采购管理</li>
			<li>采购订单</li>
		</ul>
	</div>
<form action="purchaseorder/purchaseorderInsert.action" id="f1" method="post" class="form-horizontal">
	
	<div id="toggle" class="row alert alert-info" style="margin: 0px; padding: 5px;">
		<input type="button" class="btn btn-success" value="隐藏和显示"> 
	</div>
	<!-- <h5 class="page-header alert-info" style="margin: 0px; padding: 10px; margin-bottom: 10px;">
		基本信息
	</h5> -->
	<div id="hide">
	<!-- 开始1 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">供应商</label>
				<div class="col-xs-9 ">
					<select class="form-control" name="supplierId">
						<option value="">请选择</option>
						<c:forEach items="${resultSupplier }" var="resultSupplier">
							<option value="${resultSupplier.supplierId }">${resultSupplier.supplierName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购员</label>
				<div class="col-xs-9 ">
					<select class="form-control" name="employeeId">
						<option value="">请选择</option>
						<c:forEach items="${resultEmployee }" var="resultEmployee">
							<option value="${resultEmployee.employeeId }">${resultEmployee.employeeName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<!--结束1 -->	
	<!-- 开始2 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">仓库名称</label>
				<div class="col-xs-9 ">
					<select class="form-control" name="warehouseId">
						<option value="">请选择</option>
						<c:forEach items="${resultWarehouse }" var="resultWarehouse">
							<option value="${resultWarehouse.warehouseId }">${resultWarehouse.warehouseName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购时间</label>
				<div class="col-xs-9 ">
					<input type="text" class="form-control" name="orderCreatetime" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:ss:mm'})" placeholder="请输入采购时间" />
				</div>
			</div>
		</div>
	</div>
	<!--结束2 -->
	<!-- 开始3 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">仓库编码</label>
				<div class="col-xs-9 ">
					<input type="text" name="orderCode" class="form-control" placeholder="请输入采购编码" />
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购扩展</label>
				<div class="col-xs-9 ">
					<input type="text" name="orderExtends" class="form-control" placeholder="请输入采购扩展" />
				</div>
			</div>
		</div>
	</div>
	<!--结束3 -->
	<!-- 开始4 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购数量</label>
				<div class="col-xs-9 ">
					<input type="text" name="orderNumber" class="form-control" placeholder="请输入采购数量" />
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购价格</label>
				<div class="col-xs-9 ">
					<input type="text" name="orderPrice" class="form-control" placeholder="请输入采购价格" />
				</div>
			</div>
		</div>
	</div>
	<!--结束4 -->
	<%-- <!-- 开始5 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购商品</label>
				<div class="col-xs-9 ">
					<select class="form-control" name="goodsId">
						<option value="">请选择</option>
						<c:forEach items="${pageInfo.list }" var="resultGoods">
							<option value="${resultGoods.goodsId }">
							名称:${resultGoods.goodsName},
							数量:${resultGoods.goodsExtend},
							品牌:${resultGoods.goodsBrand},
							价格:${resultGoods.goodsBuyprice}RMB
							</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
	</div>
	<!--结束5 --> --%>
	<!-- 开始5 -->
	<div class="row">
		<div class="col-xs-7">
		<div class="form-group ">
			<label class="col-xs-2 control-label">商品采购:</label>
			<div class="col-xs-10 ">
				<select class="form-control" name="goodsId">
					<option value="">请选择</option>
					<c:forEach items="${resultGoods }" var="resultGoods">
						<option value="${resultGoods.goodsId }">
						名称:${resultGoods.goodsName},
						数量:${resultGoods.goodsExtend},
						品牌:${resultGoods.goodsBrand},
						价格:${resultGoods.goodsBuyprice}RMB
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-xs-2"></div>
		</div>
		</div>
	</div>
	<!--结束5 -->
	</div>
	
	<!-- 采购商品信息： -->
	<h5 class="page-header alert-info" style="margin: 0px; padding: 10px; margin-bottom: 10px;">
		<input type="submit" class="btn btn-success" value="采购商品"> 
	</h5>
	<table id="tab" class="table table-striped table-hover table-bordered">
		<tr>
			<td>	
				<input type="Checkbox" id="all"/>全选
			</td>
			<td>订单编号</td>
			<td>采购人员</td>
			<td>采购人员</td>
			<td>所入仓库</td>
			<td>采购商品</td>
			<td>采购数量</td>
			<td>采购状态</td>
			<td>采购操作</td>
		</tr>
		<c:forEach items="${pageInfo.list }" var="resultPurchaseorder" >
			<tr class="info">
				<td><input type="Checkbox" name="box" value="${resultPurchaseorder.orderId }"/></td>
				<td>${resultPurchaseorder.orderId}</td>
				<td>${resultPurchaseorder.jxcSupplier.supplierName}</td>
				<td>${resultPurchaseorder.jxcEmployee.employeeName}</td>
				<td>${resultPurchaseorder.jxcWarehouse.warehouseName}</td>
				<td>${resultPurchaseorder.jxcGoods.goodsName}</td>
				<td>${resultPurchaseorder.orderNumber}</td>
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

	
	  <!-- 分页开始 goods/purchaseOrderByGoods.action-->
	  <!-- 使用mybatis的分页插件,分页信息,所以不用自己写实体类和方法,后期如果时间充足可以加上自己的分页 -->
	  <div class="row">
		<div class="col-md-4"></div>
		<!-- 分页条 -->
		<div class="col-md-4">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
				<!-- 首页点击功能/goods/purchaseOrderByGoods.action -->
				<li><a href="${basePath}goods/purchaseOrderByGoods.action?pn=1">首页</a></li>
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasPreviousPage }">
					 <li>
					  <a href="${basePath}goods/purchaseOrderByGoods.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
							<a href="${basePath}goods/purchaseOrderByGoods.action?pn=${ page_Num}">
								${ page_Num}
							</a>
						</li>
					</c:if>
				</c:forEach> 
				
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasNextPage }">
					<li>
					  <a href="${basePath}goods/purchaseOrderByGoods.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>   
				<!-- 末页点击功能 -->
				<li>
					<a href="${basePath}goods/purchaseOrderByGoods.action?pn=${pageInfo.pages}">
						末页
					</a>
				</li>
			  </ul>
			</nav>
		</div>
	  </div>
	  <div class="row">
		<!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
		<div class="col-md-4"></div>
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<span class="btn btn-primary">当前第:${pageInfo.pageNum}页,</span>
			<span class="btn btn-success">总共:${pageInfo.pages}页,</span>
			<span class="btn btn-warning">总共:${pageInfo.total}条记录</span>
		</div>
	  </div>
	  <!-- 分页结束 -->
	 	  
	  	  
	  	  
	<!-- 费用明细 -->
	<%-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">商品明细</h4>
	      </div>
	      <div class="modal-body">
			<table class="table table-striped table-hover table-bordered">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<td>商品名称</td>
					<td>商品数量</td>
					<td>商品价格</td>
				</tr>
				<c:forEach items="${pageInfo.list }" var="resultGoods" >
				<tr class="info">
					<td><input type="Checkbox" name="box" value="${resultGoods.goodsId }"/></td>
					<td>${resultGoods.goodsName}</td>
					<td>${resultGoods.goodsBrand}</td>
					<td>${resultGoods.goodsExtend}</td>
					<td>${resultGoods.goodsBuyprice}</td>
					<!-- <td>
						<input type="text" size="10"/>
					</td> -->
					<!-- <td>
						<input type="text" class="form-control" name="goodsUpdatetime" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:ss:mm'})" placeholder="请输入商品更新时间" />
					</td> -->
				</tr>
				</c:forEach>
			</table>		        
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" id="selectIt" class="btn btn-primary">确定</button>
	      </div>
	    </div>
	  </div>
	</div> --%>
	

</form>	

</body>
</html>