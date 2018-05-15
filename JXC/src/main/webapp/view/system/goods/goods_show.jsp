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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>商品详细信息</title>
<link href="resource/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>系统管理</li>
			<li>商品管理</li>
			<li>商品查看</li>
		</ul>
	</div>
<form action="" class="form-horizontal">
		
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">基本信息</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品名称</label>
					<div class="col-xs-9 ">
						<!-- <input type="text" name="goodsName" class="form-control" placeholder="请输入商品名称" /> -->
						<p class="form-control-static">${queryGoodsDetail.goodsName }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品编码</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsCode }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsType }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品品牌</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsBrand }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsColor }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品规格</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsSpecifications }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsPicture }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品材质</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsMaterial }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsBuyprice }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品售价</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsSaleprice }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsUpdater }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">更新时间</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsUpdatetime }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsModel }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">商品扩展</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsExtend }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsProducer }</p>
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">库存下限</label>
					<div class="col-xs-9 ">
						<p class="form-control-static">${queryGoodsDetail.goodsLowerLimit }</p>
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
						<p class="form-control-static">${queryGoodsDetail.goodsDesc }</p>
					</div>
				</div>
			</div>
			
		</div>
		<!--结束7 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<a href="javascript:window.history.go(-1)" class="btn btn-warning">返回上一级</a>
				<a href="javascript:window.history.go(-1)" class="btn btn-primary">返回上一级</a>
			</div>
		</div>

	</form>
</body>
</html>