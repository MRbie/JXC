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
<title>数据字典管理-数据字典查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
	    //给全选的复选框添加事件
	    $("#all").click(function(){
	        // this 全选的复选框
	        var datadictionaryIds=this.checked;
	        //打印true和false,只是判断全选和全不选的一种状态
	        //alert(datadictionaryIds);
	        //获取name=box的复选框 遍历输出复选框
	        $("input[name=box]").each(function(){
	            this.checked=datadictionaryIds;
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
               //定义一个数组用于接受数据字典的编号
               var checkValue = [];
               $("input[name=box]:checked").each(function(){
                   //关键点在于获取到复选框相邻的编号的id.
                   //将选中的数据字典存到数组中
                   checkValue.push($(this).val());
               })
               if(checkValue.length == 0){
            	   alert("如果批量删除请先选择您要删除的数据字典......");
               }
               //测试获取到的数据字典编号是否正确
               //alert(checkValue);
               if(checkValue.length > 0){
            	 window.location.href="datadictionary/batchDelete.action?datadictionaryIds=" + checkValue;  
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
			<li>数据字典管理</li>
			<li>数据字典查询</li>
		</ul>
	</div>
	
	<form id="f1" action="datadictionary/datadictionarySelect.action" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select class="form-control" name="condition">
					<option value="">请选择</option>
					<option value="datadictionaryName" ${resultCondition=="datadictionaryName"?'selected':'' }>名称</option>
				</select> 
				<input type="text" value="${resultContext }" name="context" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-success" value="查询"> 
			<input type="reset" class="btn btn-danger" value="重置信息" />
			<a href="view/system/dictionary/dictionary_add.jsp" class="btn btn-primary">添加数据字典</a>
			<input type="button" value="批量删除" id="batchDelete" class="btn btn-warning">
			
		</div>
		<!-- 
			//datadictionaryCode datadictionaryValue datadictionaryText
			//datadictionaryExtend datadictionaryDesc
	 	-->
		<div class="row" style="padding: 15px;text-align: center;">
			<table class="table table-hover table-bordered table-striped table-condensed">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<td>数据字典编号</td>
					<td>数据字典名称</td>
					<td>数据字典字段</td>
					<!-- <td>数据字典值</td>
					<td>数据字典内容</td> -->
					<td>数据字典扩展</td>
					<td>数据字典描述</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${pageInfo.list }" var="resultdatadictionary" >
				<tr class="info">
					<td><input type="Checkbox" name="box" value="${resultdatadictionary.datadictionaryId }"/></td>
					<td>${resultdatadictionary.datadictionaryId }</td>
					<td>${resultdatadictionary.datadictionaryName}</td>
					<td>${resultdatadictionary.datadictionaryCode}</td>
					<%-- <td>${resultdatadictionary.datadictionaryValue}</td>
					<td>${resultdatadictionary.datadictionaryText}</td> --%>
					<td>${resultdatadictionary.datadictionaryExtend}</td>
					<td>${resultdatadictionary.datadictionaryDesc}</td>
					<td>
						<a class="btn btn-primary" href="datadictionary/queryDatadictionaryBySingle.action?datadictionaryId=${resultdatadictionary.datadictionaryId}">
							修改</a>
						<a class="btn btn-success" href="datadictionary/datadictionaryDelete.action?datadictionaryId=${resultdatadictionary.datadictionaryId}">
							删除</a>
						<a class="btn btn-danger" href="dicdata/maintainDatadictionary.action?dicdataCode=${resultdatadictionary.datadictionaryCode}">
							维护数据字典</a>
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
				<!-- 首页点击功能 -->
				<li><a href="${basePath}datadictionary/datadictionarySelect.action?pn=1">首页</a></li>
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasPreviousPage }">
					 <li>
					  <a href="${basePath}datadictionary/datadictionarySelect.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
							<a href="${basePath}datadictionary/datadictionarySelect.action?pn=${ page_Num}">
								${ page_Num}
							</a>
						</li>
					</c:if>
				</c:forEach> 
				
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasNextPage }">
					<li>
					  <a href="${basePath}datadictionary/datadictionarySelect.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>   
				<!-- 末页点击功能 -->
				<li>
					<a href="${basePath}datadictionary/datadictionarySelect.action?pn=${pageInfo.pages}">
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