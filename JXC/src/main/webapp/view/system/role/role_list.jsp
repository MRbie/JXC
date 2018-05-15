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
<title>角色管理-角色查询</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
	    //给全选的复选框添加事件
	    $("#all").click(function(){
	        // this 全选的复选框
	        var adminids=this.checked;
	        //打印true和false,只是判断全选和全不选的一种状态
	        //alert(adminids);
	        //获取name=box的复选框 遍历输出复选框
	        $("input[name=box]").each(function(){
	            this.checked=adminids;
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
	    
	    
	    //点击授权列出所有的菜单信息
	    $("#roleToMenu").click(function(){
	    	 //alert("测试");
	    	 $.ajax({
	             type : "POST",//post类型请求。
	             //data : {"goodsId":goodsId},//将每一次获取到角色id传递到后台。
	             url : "role/roleToMenu.action",//请求后台的路径
	             success : function(resultMenu) {
	            	 alert(eval("(" + resultMenu + ")"));
	            	 //必须先转换为json格式，不然无法获取值
	            	 //menuId menuName menuUpid menuPath menuStatus
   	 				 //menuIsleaf menuUpdater menuUpdatetime menuExtend
	            	 var json = eval("(" + resultMenu + ")");
	            	 //alert(json.length);
	            	 var html = '<tr>' +
	            	 /* '<td>' + '<input type="Checkbox" id="all"/>全选' + '</td>' + */
                    '<td>' + "菜单编号" + '</td>' +
                    '<td>' + "菜单名称" + '</td>' +
                    '<td>' + "菜单路径" + '</td>' +
                    '<td>' + "权限代码" + '</td>' +
                    '<td>' + "操作" + '</td>' +
                    '</tr>'; 
	            	 //清空table里面的数据
	                 $('#returnMenu').empty();
	            	 //参数即后台返回的数据。value='"+ json[i].goodsId.innerHTML +"'
	            	 for(var i=0;i<json.length;i++){
	            		 var menuId = json[i].menuId;
	            		 var menuName = json[i].menuName;
	            		 var menuPath = json[i].menuPath;
	            		 var menuUpid = json[i].menuUpid;
	            		 html += '<tr>' +
	            		 /* '<td>' + '<input type="Checkbox"  name="box" value="'+ goodsId +'"/>' + '</td>' + */
	                     '<td>' + menuId + '<input type="hidden" value="'+ menuId +'" />' + '</td>' +
	                     '<td>' + menuName + '</td>' +
	                     '<td>' + menuPath + '</td>' +
	                     '<td>' + menuUpid + '</td>' +
	                     '<td>' + '<a href="purchaseorder/choosePurchaseorder.action?goodsId='+menuId+'" class="btn btn-success">选中商品<a>' + '</td>' +
	                     '</tr>';
	            	 }
	            	 $('#returnMenu').append(html);
	             },
	         });
	     });
	     
	    
	    
	    //点击批量删除按钮,批量删除操作
	    $("#batchAdmin").click(function(){
	    	if(confirm('确认删除选中?请谨慎操作......')){
               //alert("确认批量删除,请谨慎操作.");
               //$("input[name=box]").each(function(){
               //定义一个数组用于接受角色的编号
               var checkValue = [];
               $("input[name=box]:checked").each(function(){
                   //关键点在于获取到复选框相邻的编号的id.
                   //将选中的角色存到数组中
                   checkValue.push($(this).val());
               })
               if(checkValue.length == 0){
            	   alert("如果批量删除请先选择您要删除的角色......");
               }
               //测试获取到的角色编号是否正确
               //alert(checkValue);
               if(checkValue.length > 0){
            	 window.location.href="role/batchDelete.action?roleIds=" + checkValue;  
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
			<li>角色管理</li>
			<li>角色查询</li>
		</ul>
	</div>
	<form action="role/roleSelect.action" class="form-inline" method="post">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>条件:</label> 
				<select class="form-control" name="condition">
					<option value="">请选择</option>
					<option value="roleName" ${resultCondition=="roleName"?'selected':'' }>名称</option>
				</select> 
				<input type="text" value="${resultContext }" name="context" class="form-control" placeholder="请输入查询条件" />
			</div>
			<input type="submit" class="btn btn-success" value="查询"> 
			<input type="reset" class="btn btn-danger" value="重置信息" />
			<a href="view/system/role/role_add.jsp" class="btn btn-primary">添加角色</a>
			<input type="button" value="批量删除" id="batchAdmin" class="btn btn-warning">
			<!-- 
			<input type="button" value="批量导入" id="batchImport" class="btn btn-success">
			<input type="button" value="批量导出" id="batchExport" class="btn btn-danger">
			-->
		</div>
		<div class="row" style="padding: 15px;text-align: center;">
			<table class="table table-hover table-bordered table-striped table-condensed">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<td>角色编号</td>
					<td>角色名称</td>
					<td>更新者</td>
					<td>更新时间</td>
					<td>操作</td>
				</tr>
				<!-- 
					//roleName roleCode roleDesc roleStatus roleUpdater roleUpdatetime
					//roleExtend roleId
				 -->
				<c:forEach items="${pageInfo.list }" var="resultRole" >
				<tr class="info">
					<td><input type="Checkbox" name="box" value="${resultRole.roleId }"/></td>
					<td>${resultRole.roleId }</td>
					<td>
						<a href="role/queryRoleDetail.action?roleId=${resultRole.roleId}">
							${resultRole.roleName}
						</a>
					</td>
					<td>${resultRole.roleUpdater}</td>
					<td>${resultRole.roleUpdatetime}</td>
					<td>
						<a class="btn btn-primary" href="role/queryRoleBySingle.action?roleId=${resultRole.roleId}">
							修改</a>
						<a class="btn btn-success" href="role/roleDelete.action?roleId=${resultRole.roleId}">
							删除</a>
						<%-- <a class="btn btn-success" href="role/roleToMenu.action?roleId=${resultRole.roleId}">
							授权</a> --%>
						<!-- <input type="button" id="roleToMenu" value="授权" style="margin-right:40px;" data-toggle="modal" data-target="#myModal" class="btn btn-danger"/> -->
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	
	
	<!-- 商品明细 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">菜单列表</h4>
	      </div>
	      <div class="modal-body">
			<table id="returnMenu" class="table table-striped table-hover table-bordered">
				<tr class="danger">
					<td>	
						<input type="Checkbox" id="all"/>全选
					</td>
					<td>菜单编号</td>
					<td>菜单名称</td>
					<td>菜单路径</td>
					<td>权限代码</td>
				</tr>
			</table>		        
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" id="selectIt" class="btn btn-primary">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	<!-- 分页开始 -->
	<!-- 使用mybatis的分页插件,分页信息,所以不用自己写实体类和方法,后期如果时间充足可以加上自己的分页 -->
	<div class="row">
		<div class="col-md-4"></div>
		<!-- 分页条 -->
		<div class="col-md-4">
			<nav aria-label="Page navigation">
			  <ul class="pagination">
				<!-- 首页点击功能 -->
				<li><a href="${basePath}role/roleSelect.action?pn=1">首页</a></li>
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasPreviousPage }">
					 <li>
					  <a href="${basePath}role/roleSelect.action?pn=${pageInfo.pageNum-1}" aria-label="Previous">
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
							<a href="${basePath}role/roleSelect.action?pn=${ page_Num}">
								${ page_Num}
							</a>
						</li>
					</c:if>
				</c:forEach> 
				
				<!-- 上一页点击功能 -->
				<c:if test="${pageInfo.hasNextPage }">
					<li>
					  <a href="${basePath}role/roleSelect.action?pn=${pageInfo.pageNum+1}" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				</c:if>   
				<!-- 末页点击功能 -->
				<li>
					<a href="${basePath}role/roleSelect.action?pn=${pageInfo.pages}">
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