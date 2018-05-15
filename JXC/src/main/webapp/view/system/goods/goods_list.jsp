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
	    
	    //点击批量删除按钮,批量删除操作
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
	    });
	});

</script>

</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>商品管理</li>
			<li>商品查询</li>
		</ul>
	</div>
	<form action="goods/goodsSelect.action" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select class="form-control" name="condition">
					<option value="">请选择</option>
					<option value="goodsName">名称</option>
					<option value="goodsBrand">品牌</option>
					<option value="goodsColor">颜色</option>
				</select> 
				<input type="text" value="${resultContext }" name="context" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-success" value="查询"> 
			<input type="reset" class="btn btn-danger" value="重置信息" />
			<a href="dicdata/preInsertGoods.action" class="btn btn-primary">添加商品</a>
			<input type="button" value="批量删除" id="batchDelete" class="btn btn-warning">
			<!-- 导出excel操作 -->
			<div class="form-group">
				<a href="goods/goodsExport.action" target="_self" class="btn btn-primary">导出Excel</a>
			</div>
		</div>
		<div class="row" style="padding: 15px;text-align: center;">
			<table class="table table-hover table-bordered table-striped table-condensed">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<td>商品编号</td>
					<td>商品名称</td>
					<td>商品品牌</td>
					<td>商品颜色</td>
					<td>商品规格</td>
					<td>商品数量</td>
					<td>操作</td>
				</tr>
				<!-- 
					//goodsId goodsName goodsCode goodsType goodsBrand goodsColor
				  	//goodsSpecifications goodsPicture goodsMaterial  goodsBuyprice 
				  	//goodsSaleprice goodsModel goodsDesc goodsUpdater goodsUpdatetime
				    //goodsStatus goodsExtend goodsProducer goodsLowerLimit
    			-->
				<c:forEach items="${pageInfo.list }" var="resultGoods" >
				<tr class="info">
					<td><input type="Checkbox" name="box" value="${resultGoods.goodsId }"/></td>
					<td>${resultGoods.goodsId }</td>
					<td>
						<a href="goods/queryGoodsDetail.action?goodsId=${resultGoods.goodsId}">
							${resultGoods.goodsName}
						</a>
					</td>
					<td>${resultGoods.goodsBrand}</td>
					<td>${resultGoods.goodsColor}</td>
					<td>${resultGoods.goodsSpecifications}</td>
					<td>${resultGoods.goodsExtend}</td>
					<td>
						<a class="btn btn-primary" href="goods/queryGoodsBySingle.action?goodsId=${resultGoods.goodsId}">
							修改</a>
						<a class="btn btn-success" href="goods/goodsDelete.action?goodsId=${resultGoods.goodsId}">
							删除</a>
						<!-- <a class="btn btn-danger" href="#"></a> -->
						<!-- 采购模态框 -->
						<!-- <span class="page-header alert-info">
							<input type="button" value="采购" data-toggle="modal" data-target="#myModal" class="btn btn-default"/>
						</span> -->
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	
	<form enctype="multipart/form-data" action="goods/goodsImport.action" class="form-inline" method="post">
		<div style="text-align: right;">
			<!-- 导入excel数据 -->
			<div class="form-group">
				<input type="file" id="uploadFile" name="uploadFile" class="btn btn-default"/>
			</div>
			<!-- 文件下载模板 -->
			<a href="goods/goodsTemplate.action?path=/resource/template/exportGoodsTemplate.xlsx" class="btn btn-success">商品模板</a>
			<input type="submit" id="goodsImport" class="btn btn-danger" value="导入Excel数据">
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
				<!-- 首页点击功能 -->
				<li><a href="${basePath}goods/goodsSelect.action?pn=1">首页</a></li>
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasPreviousPage }">
					 <li>
					  <a href="${basePath}goods/goodsSelect.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
							<a href="${basePath}goods/goodsSelect.action?pn=${ page_Num}">
								${ page_Num}
							</a>
						</li>
					</c:if>
				</c:forEach> 
				
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasNextPage }">
					<li>
					  <a href="${basePath}goods/goodsSelect.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>   
				<!-- 末页点击功能 -->
				<li>
					<a href="${basePath}goods/goodsSelect.action?pn=${pageInfo.pages}">
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
  	
	
	<!-- 采购模态框-->
	<!-- 开始1 -->
	<%-- <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">费用明细</h4>
	      </div>
	      <div class="modal-body">
			<table class="table table-striped table-hover table-bordered">
				<tr>
					<th></th>
					<th>报销编号</th>
					<th>报销名称</th>
					<th>报销描述</th>
				</tr>
				<c:forEach items="${list }" var="cost">
				<tr>
					<td><input type="checkbox" id="ids" value="${cost.costId }"></td>
					<td>${cost.costId }</td>
					<td>${cost.costName }</td>
					<td>${cost.costDesc }</td>
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
	<!-- 结束1 -->
	
</body>
</html>