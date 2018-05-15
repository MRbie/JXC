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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>商品管理-商品添加</title>
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
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>商品管理</li>
			<li>商品添加</li>
		</ul>
	</div>
<form action="goods/insertGoods.action" id="f1" class="form-horizontal" method="post">
		<!-- 
			//goodsId goodsName goodsCode goodsType goodsBrand goodsColor
		  	//goodsSpecifications goodsPicture goodsMaterial  goodsBuyprice 
		  	//goodsSaleprice goodsModel goodsDesc goodsUpdater goodsUpdatetime
		    //goodsStatus goodsExtend goodsProducer goodsLowerLimit
	 	-->
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品名称</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsName" class="form-control" placeholder="请输入商品名称" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品编码</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="5" name="goodsCode" class="form-control" placeholder="请输入商品编码" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始2 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品类型</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" name="goodsType" class="form-control" placeholder="请输入商品类型" /> -->
						<select class="form-control" required name="goodsType">
							<option value="">请选择</option>
							<c:forEach items="${dicDataCodeByDataDicCode }" var="preInsertGoods">
								<option value="${preInsertGoods.dicdataName }">${preInsertGoods.dicdataName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品品牌</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsBrand" class="form-control" placeholder="请输入商品品牌" />
					</div>
				</div>
			</div>
		</div>
		<!--结束2 -->
		<!-- 开始3 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品颜色</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" name="goodsColor" class="form-control" placeholder="请输入商品颜色" /> -->
						<select class="form-control" name="goodsColor">
							<option value="">请选择</option>
							<c:forEach items="${dicDataCodeByDataDicCode2 }" var="preInsertGoods">
								<option value="${preInsertGoods.dicdataName }">${preInsertGoods.dicdataName }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品规格</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsSpecifications" class="form-control" placeholder="请输入商品规格" />
					</div>
				</div>
			</div>
		</div>
		<!--结束3 -->
		<!-- 开始4 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品图片</label>
					<div class="col-xs-9 ">
						<input type="text" name="goodsPicture" class="form-control" placeholder="请输入商品图片" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品材质</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsMaterial" class="form-control" placeholder="请输入商品材质" />
					</div>
				</div>
			</div>
		</div>
		<!--结束4 -->
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品进价</label>
					<div class="col-xs-9 ">
						<input type="text" required name="goodsBuyprice" class="form-control digits" placeholder="请输入商品进价" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品售价</label>
					<div class="col-xs-9 ">
						<input type="text" required name="goodsSaleprice" class="form-control digits" placeholder="请输入商品售价" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->
		<!-- 开始6 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新人</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsUpdater" class="form-control" placeholder="请输入商品更新人" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新时间</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" name="goodsUpdatetime" class="form-control" placeholder="请输入商品更新时间" /> -->
						<input type="text" class="form-control" name="goodsUpdatetime" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:ss:mm'})" placeholder="请输入商品更新时间" />
					</div>
				</div>
			</div>
			
		</div>
		<!--结束6 -->
		<!-- 开始7 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品型号</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsModel" class="form-control" placeholder="请输入商品型号" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品数量</label>
					<div class="col-xs-9 ">
						<input type="text" required name="goodsExtend" class="form-control digits" placeholder="请输入商品数量(扩展)" />
					</div>
				</div>
			</div>
		</div>
		<!--结束7 -->
		<!-- 开始8 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">生产厂商</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsProducer" class="form-control" placeholder="请输入商品生产厂商" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">库存下限</label>
					<div class="col-xs-9 ">
						<input type="text" required minlength="2" name="goodsLowerLimit" class="form-control digits" placeholder="请输入商品库存下限" />
					</div>
				</div>
			</div>
		</div>
		<!--结束8 -->
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">描述信息</h5>
		<!-- 开始7 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">描述信息</label>
					<div class="col-xs-9">
						<textarea class="form-control" name="goodsDesc" rows="8" placeholder="请输入商品描述信息"></textarea>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束7 -->

		<div class="row">
			<div class="col-xs-5 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="添加商品" /> 
				<input type="reset" class="btn btn-danger" value="重置信息" />
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
			</div>

		</div>

	</form>
</body>
</html>