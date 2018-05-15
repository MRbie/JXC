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
<title>用户登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="resource/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="resource/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="resource/assets/css/ace.min.css" />
<link rel="stylesheet" href="resource/assets/css/ace-rtl.min.css" />
<!-- 表单验证插件 -->
<script src="resource/js/jquery.min.js" type="text/javascript"></script>
<script src="resource/jquery-validation-1.14.0/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="resource/jquery-validation-1.14.0/dist/localization/messages_zh.js" type="text/javascript"></script>
<!-- 必须引入这个样式，不然弹框提示不出现 -->
<script src="resource/js/jquery-ui.min.js" type="text/javascript"></script>


<script type="text/javascript">
	
	//登录页面特效
    ! function() {
    	//封装方法，压缩之后减少文件大小
    	function get_attribute(node, attr, default_value) {
    		return node.getAttribute(attr) || default_value;
    	}
    	//封装方法，压缩之后减少文件大小
    	function get_by_tagname(name) {
    		return document.getElementsByTagName(name);
    	}
    	//获取配置参数
    	function get_config_option() {
    		var scripts = get_by_tagname("script"),
    			script_len = scripts.length,
    			script = scripts[script_len - 1]; //当前加载的script
    		return {
    			l: script_len, //长度，用于生成id用
    			z: get_attribute(script, "zIndex", -1), //z-index
    			o: get_attribute(script, "opacity", 0.5), //opacity
    			c: get_attribute(script, "color", "0,0,0"), //color
    			n: get_attribute(script, "count", 99) //count
    		};
    	}
    	//设置canvas的高宽
    	function set_canvas_size() {
    		canvas_width = the_canvas.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth, 
    		canvas_height = the_canvas.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
    	}
    	//绘制过程
    	function draw_canvas() {
    		context.clearRect(0, 0, canvas_width, canvas_height);
    		//随机的线条和当前位置联合数组
    		var all_array = [current_point].concat(random_lines);
    		var e, i, d, x_dist, y_dist, dist; //临时节点
    		//遍历处理每一个点
    		random_lines.forEach(function(r) {
    			r.x += r.xa, 
    			r.y += r.ya, //移动
    			r.xa *= r.x > canvas_width || r.x < 0 ? -1 : 1, 
    			r.ya *= r.y > canvas_height || r.y < 0 ? -1 : 1, //碰到边界，反向反弹
    			context.fillRect(r.x - 0.5, r.y - 0.5, 1, 1); //绘制一个宽高为1的点
    			for (i = 0; i < all_array.length; i++) {
    				e = all_array[i];
    				//不是当前点
    				if (r !== e && null !== e.x && null !== e.y) {
    						x_dist = r.x - e.x, //x轴距离 l
    						y_dist = r.y - e.y, //y轴距离 n
    						dist = x_dist * x_dist + y_dist * y_dist; //总距离, m
    					dist < e.max && (e === current_point && dist >= e.max / 2 && (r.x -= 0.03 * x_dist, r.y -= 0.03 * y_dist), //靠近的时候加速
    						d = (e.max - dist) / e.max, 
    						context.beginPath(), 
    						context.lineWidth = d / 2, 
    						context.strokeStyle = "rgba(" + config.c + "," + (d + 0.2) + ")", 
    						context.moveTo(r.x, r.y), 
    						context.lineTo(e.x, e.y), 
    						context.stroke();//删除了)括号
    				}
    			}
    			all_array.splice(all_array.indexOf(r), 1);
    		}), frame_func(draw_canvas);
    	}
    	//创建画布，并添加到body中
    	var the_canvas = document.createElement("canvas"), //画布
    		config = get_config_option(), //配置
    		canvas_id = "c_n" + config.l, //canvas id
    		context = the_canvas.getContext("2d"), canvas_width, canvas_height, 
    		frame_func = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(func) {
    			window.setTimeout(func, 1000 / 45);
    		}, random = Math.random, 
    		current_point = {
    			x: null, //当前鼠标x
    			y: null, //当前鼠标y
    			max: 20000
    		};
    	the_canvas.id = canvas_id;
    	the_canvas.style.cssText = "position:fixed;top:0;left:0;z-index:" + config.z + ";opacity:" + config.o;
    	get_by_tagname("body")[0].appendChild(the_canvas);
    	//初始化画布大小
    	set_canvas_size(), window.onresize = set_canvas_size;
    	//当时鼠标位置存储，离开的时候，释放当前位置信息
    	window.onmousemove = function(e) {
    		e = e || window.event, current_point.x = e.clientX, current_point.y = e.clientY;
    	}, window.onmouseout = function() {
    		current_point.x = null, current_point.y = null;
    	};
    	//随机生成config.n条线位置信息
    	for (var random_lines = [], i = 0; config.n > i; i++) {
    		var x = random() * canvas_width, //随机位置
    			y = random() * canvas_height,
    			xa = 2 * random() - 1, //随机运动方向
    			ya = 2 * random() - 1;
    		random_lines.push({
    			x: x,
    			y: y,
    			xa: xa,
    			ya: ya,
    			max: 6000 //沾附距离
    		});
    	}
    	//0.1秒后绘制
    	setTimeout(function() {
    		draw_canvas();
    	}, 100);
    }();
</script>

<script type="text/javascript">
	//Js方法实现此功能,看不清,点击更换图片的方法
	function changeImg(){
	    var img = document.getElementById("img"); 
	    img.src = "admin/verificationCode.action?date=" + new Date();;
	} 

</script>


</head>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> 
								<span class="red">智慧企业进销存</span><br/>
								<span class="white">管理系统</span>
							</h1>
							<h4 class="blue"></h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的账号和密码
										</h4>

										<div class="space-6"></div>
										<!-- <form action="admin/login.action" id="f1" method="post" onsubmit="return check()"> -->
										<form action="admin/login.action" id="f1" method="post" onsubmit="return check()">
											<fieldset>
												<label class="block clearfix"> 
												<span class="block input-icon input-icon-right"> 
													<input id="adminAccount" required minlength="2" value="admin" name="employeeAccount" type="text" class="form-control" placeholder="请输入管理员账号" /> 
													<i class="icon-user"></i>
												</span>
												</label> 
												<label class="block clearfix"> 
												<span class="block input-icon input-icon-right"> 
													<input id="adminPassword" required minlength="6" value="123456" name="employeePassword" type="password" class="form-control" placeholder="请输入管理员密码" /> 
													<i class="icon-lock"></i>
												</span>
												</label>
												<label class="block clearfix"> 
													<span class="block input-icon input-icon-right"> 
														<input type="text" id="verifyCode" required minlength="4" name="verifyCode"  class="form-control" placeholder="请输入正确的验证码"/>
														<br/>
														<img id="img" src="admin/verificationCode.action" />
       			 										<a href='#' onclick="javascript:changeImg()" style="color:white;">
       			 										<span style="color:black;">看不清？</span></a>
													</span>
												</label>
												<div class="col-xs-12">
													<span style="color:red;font-size:15px;">
														${errorVerifyCode }
														<br/> ${errorAdminMessage }
													</span>
												</div>
												<div class="clearfix">
													<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登陆
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>

								</div>

							</div>


					</div>

				</div>
			</div>

		</div>
</div>
	</div>


<!-- <script src="http://open.sojson.com/common/js/canvas-nest.min.js" count="200" zindex="-2" opacity="0.5" color="47,135,193" type="text/javascript"></script>
 -->
 
<script src="resource/js/canvas-nest.js"
count="500" zindex="-2" opacity="0.5" color="47,135,193" 
type="text/javascript"></script>
 
<!-- 
	src="resource/js/canvas-nest.js"
	解释下script上的参数：
	count  ：线条数量。
	zindex ：层级。
	opacity：透明度。
	color   ：线条颜色。最好用RGB颜色。
 -->

<!-- <script type="text/javascript">
$(document).ready(function(){
	$("#f1").validate({
		rules:{
			adminAccount:{
				required:true,
			},adminPassword:{
				required:true,
			},verifyCode:{
				required:true,
			}
		},messages:{
			adminAccount:{
				required:'请输入账号~~~',
			},adminPassword:{
				required:'请输入密码~~~',
			},verifyCode:{
				required:'请输入验证码~~~',
			}
		}
	});

});
</script> -->

</body>
</html>
