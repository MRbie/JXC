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
<script type="text/javascript">
	function getJsonLength(json){
	    var jsonLength=0;
	    for (var i in json) {
	        jsonLength++;
	    }
	    return jsonLength;
	}
	
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
	    
	    //点击批量采购订单
	    /* $("#jxcPurchaseorder").click(function(){
	    	if(confirm('确认采购选中?请谨慎操作......')){
               //定义一个数组用于接受商品的编号
               var checkValue = [];
               $("input[name=box]:checked").each(function(){
                   //关键点在于获取到复选框相邻的编号的id.
                   //将选中的商品存到数组中
                   checkValue.push($(this).val());
               })
               if(checkValue.length == 0){
            	   alert("如果批量采购请先选择您要采购的商品......");
               }
               //测试获取到的商品编号是否正确
               //alert(checkValue);
               if(checkValue.length > 0){
            	 alert(checkValue);
            	 window.location.href="purchaseorder/jxcPurchaseorderInsert.action?goodsIds=" + checkValue;  
               }
        	}
	    }); */
               
	    
	     $("#purchaseorder").click(function(){
	    	 //alert("测试");
	    	 $.ajax({
	             type : "POST",//post类型请求。
	             //data : {"goodsId":goodsId},//将每一次获取到角色id传递到后台。
	             url : "goods/ajaxPurchaseOrderByGoods.action",//请求后台的路径
	             success : function(resultGoods) {
	            	 //必须先转换为json格式，不然无法获取值
	            	 var json = eval("(" + resultGoods + ")");
	            	 //alert(json.length);
	            	 var html = '<tr>' +
	            	 /* '<td>' + '<input type="Checkbox" id="all"/>全选' + '</td>' + */
                     '<td>' + "商品编号" + '</td>' +
                     '<td>' + "商品名称" + '</td>' +
                     '<td>' + "商品进价" + '</td>' +
                     '<td>' + "商品数量" + '</td>' +
                     '<td>' + "商品类型" + '</td>' +
                     /* '<td>' + "商品数量" + '</td>' + */
                     '<td>' + "操作" + '</td>' +
                     '</tr>'; 
	            	 //清空table里面的数据
	                 $('#returnGoods').empty();
	            	 //参数即后台返回的数据。value='"+ json[i].goodsId.innerHTML +"'
	            	 for(var i=0;i<json.length;i++){
	            		 var goodsId = json[i].goodsId;
	            		 var goodsName = json[i].goodsName;
	            		 var goodsSaleprice = json[i].goodsSaleprice;
	            		 var goodsExtend = json[i].goodsExtend;
	            		 var goodsType = json[i].goodsType;
	            		 html += '<tr>' +
	            		 /* '<td>' + '<input type="Checkbox"  name="box" value="'+ goodsId +'"/>' + '</td>' + */
	                     '<td>' + goodsId + '<input type="hidden" value="'+ goodsId +'" />' + '</td>' +
	                     '<td>' + goodsName + '</td>' +
	                     '<td>' + goodsSaleprice + '</td>' +
	                     '<td>' + goodsExtend + '</td>' +
	                     '<td>' + goodsType + '</td>' +
	                     /* '<td>' + '<input type="text" name="orderNumber" size="3"/>个' + '</td>' + */
	                     '<td>' + '<a href="purchaseorder/choosePurchaseorder.action?goodsId='+goodsId+'" class="btn btn-success">选择商品<a>' + '</td>' +
	                     '</tr>';
	            	 }
	            	 $('#returnGoods').append(html);
	             },
	         });
	     });
	     
	    //获取采购商品数量的功能mouseout mouseleave
	    $("#orderNumber").mouseout(function(){
	    	var orderNumber = $("#orderNumber").val();
	        //alert(orderNumber);
	        //将获取到的数量赋值到相应的位置
	        $("#setOrderNumberValue").val(orderNumber);
	    });	
	    
	    //将商品编号传递到控制层的作用
	    $("input[name=goodsBox]").click(function(){
	        //choiceBox获取选中复选框长度$("input[name=box]:checked")
	        //alert($("#choiceBox").is(':checked'));
	        //如果复选框被选中，那么就将商品编号传递到后台
	        if($("#choiceBox").is(':checked')){
	        	//alert($("#choiceBox").val());
	        	//将获取到的商品编号赋值到相对应的位置
	        	var goodsId = $("#choiceBox").val();
	        	$("#setGoodsId").val(goodsId);
	        }
	        
	    });
	    
	});

	<!--采购商品先将商品信息全部查询出来-->    
	/* $("#purchaseorder").click(function(){   
		window.location.href="goods/ajaxPurchaseOrderByGoods.action";  	
	});  */
	

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
<form action="purchaseorder/jxcPurchaseorderInsert.action" id="f1" method="get" class="form-horizontal">
	
	<h5 class="page-header alert-info" style="margin: 0px; padding: 10px; margin-bottom: 10px;">
		选择商品：&nbsp;&nbsp;
		<input type="button" id="purchaseorder" value="选择商品" style="margin-right:40px;" data-toggle="modal" data-target="#myModal" class="btn btn-danger"/>
		<input type="submit" id="jxcPurchaseorder" value="采购商品" class="btn btn-success"/>
	</h5>
	<!-- 查询出的商品列表resultGoods -->
	<table id="tab" class="table table-striped table-hover table-bordered">
		<tr>
			<td>	
				<span style="color:red;font-weight: bold;">请选中</span>
				<!-- <input type="Checkbox" id="all"/>全选 -->
			</td>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品数量</td>
			<td>商品类型</td>
			<td>采购数量</td>
		</tr>
		<c:forEach items="${resultJxcGoods }" var="resultJxcGoods">
		<tr>
			<td>
				<input type="Checkbox" id="choiceBox" name="goodsBox" value="${resultJxcGoods.goodsId }"/>
			</td>
			<td>
				${resultJxcGoods.goodsId }
				<%-- <input type="hidden" name="goodsId" value="${resultJxcGoods.goodsId }"/>	 --%>
			</td>
			<td>
				${resultJxcGoods.goodsName }
				<%-- <input type="hidden" name="goodsName" value="${resultJxcGoods.goodsName }"/>		 --%>
			</td>
			<td>${resultJxcGoods.goodsSaleprice }</td>
			<td>${resultJxcGoods.goodsExtend }</td>
			<td>${resultJxcGoods.goodsType }</td>
			<td>
				<input type="text" required size="8" id="orderNumber" name="orderNumber"/>
			</td>
		</tr>
		</c:forEach>
	</table>

	
	
	<!-- 商品明细 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">商品明细</h4>
	      </div>
	      <div class="modal-body">
			<table id="returnGoods" class="table table-striped table-hover table-bordered">
				<tr class="danger">
					<!-- <td>	
						<input type="Checkbox" id="all"/>全选
					</td> -->
					<td>商品编号</td>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>商品数量</td>
					<td>商品类型</td>
				</tr>
				<%-- <c:forEach items="${pageInfo.list }" var="resultGoods" >
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
				</c:forEach> --%>
			</table>		        
	      </div>
	      
	      
	      
	      <!-- 分页开始 -->
		  <!-- 使用mybatis的分页插件,分页信息,所以不用自己写实体类和方法,后期如果时间充足可以加上自己的分页 -->
		  <div class="row">
			<div class="col-md-4"></div>
			<!-- 分页条 -->
			<div class="col-md-4">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
					<!-- 首页点击功能goods/ajaxPurchaseOrderByGoods.action -->
					<li><a href="${basePath}goods/ajaxPurchaseOrderByGoods.action?pn=1">首页</a></li>
					<!-- 上一页点击功能 -->
					<c:if test="${pageInfo.hasPreviousPage }">
						 <li>
						  <a href="${basePath}goods/ajaxPurchaseOrderByGoods.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
								<a href="${basePath}goods/ajaxPurchaseOrderByGoods.action?pn=${ page_Num}">
									${ page_Num}
								</a>
							</li>
						</c:if>
					</c:forEach> 
					
					<!-- 上一页点击功能 -->
					<c:if test="${pageInfo.hasNextPage }">
						<li>
						  <a href="${basePath}goods/ajaxPurchaseOrderByGoods.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						  </a>
						</li>
					</c:if>   
					<!-- 末页点击功能 -->
					<li>
						<a href="${basePath}goods/ajaxPurchaseOrderByGoods.action?pn=${pageInfo.pages}">
							末页
						</a>
					</li>
				  </ul>
				</nav>
			</div>
		  </div>
		  <div class="row">
			<!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<span class="btn btn-primary">当前第:${pageInfo.pageNum}页,</span>
			</div>
			<div class="col-md-2">
				<span class="btn btn-success">总共:${pageInfo.pages}页,</span>
			</div>
			<div class="col-md-2">
				<span class="btn btn-warning">总共:${pageInfo.total}条记录</span>
			</div>
			<div class="col-md-2"></div>
		  </div>
	  	  <!-- 分页结束 -->
  	
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" id="selectIt" class="btn btn-primary">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	<input type="hidden" name="orderNumber" id="setOrderNumberValue" class="form-control" placeholder="请输入采购数量" />
	<input type="hidden" name="goodsId" id="setGoodsId" class="form-control" placeholder="请输入商品编号" />
	
	<h5 class="page-header alert-info" style="margin: 0px; padding: 10px; margin-bottom: 10px;">
		基本信息
	</h5>
	<!-- 开始1 -->
	<div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">供应商姓名</label>
				<div class="col-xs-9 ">
					<select class="form-control" required name="supplierId">
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
				<label class="col-xs-3 control-label">采购员姓名</label>
				<div class="col-xs-9 ">
					<select class="form-control" required name="employeeId">
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
					<select class="form-control" required name="warehouseId">
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
					<input type="text" required class="form-control" name="orderCreatetime" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:ss:mm'})" placeholder="请输入采购时间" />
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
					<input type="text" required name="orderCode" class="form-control" placeholder="请输入采购编码" />
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
	<!-- <div class="row">
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">采购数量</label>
				<div class="col-xs-9 ">
					<input type="hidden" name="orderNumber" id="setOrderNumberValue" class="form-control" placeholder="请输入采购数量" />
				</div>
			</div>
		</div>
		<div class="col-xs-5">
			<div class="form-group ">
				<label class="col-xs-3 control-label">商品编号</label>
				<div class="col-xs-9 ">
					<input type="hidden" name="goodsId" id="setGoodsId" class="form-control" placeholder="请输入商品编号" />
				</div>
			</div>
		</div>
	</div> -->
	<!--结束4 -->
	
</form>	

</body>
</html>