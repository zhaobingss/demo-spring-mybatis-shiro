<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=baseUrl%>">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>weidea.net - Limitless - Responsive Web Application Kit by Eugene Kopyov</title>

	<!-- Global stylesheets -->
	<link href="static/third/assets/css/icons/icomoon/styles.css" 	rel="stylesheet" type="text/css">
	<link href="static/third/assets/css/minified/bootstrap.min.css" 	rel="stylesheet" type="text/css">
	<link href="static/third/assets/css/minified/core.min.css" 		rel="stylesheet" type="text/css">
	<link href="static/third/assets/css/minified/components.min.css" rel="stylesheet" type="text/css">
	<link href="static/third/assets/css/minified/colors.min.css" 	rel="stylesheet" type="text/css">
	<!-- /global stylesheets -->

	<!-- Core JS files -->
	<script type="text/javascript" src="static/third/assets/js/plugins/loaders/pace.min.js"></script>
	<script type="text/javascript" src="static/third/assets/js/core/libraries/jquery.min.js"></script>
	<script type="text/javascript" src="static/third/assets/js/core/libraries/bootstrap.min.js"></script>
	<script type="text/javascript" src="static/third/assets/js/plugins/loaders/blockui.min.js"></script>
	<!-- /core JS files -->

	<!-- Theme JS files -->
	<script type="text/javascript" src="static/third/assets/js/plugins/forms/styling/uniform.min.js"></script>

	<script type="text/javascript" src="static/third/assets/js/core/app.js"></script>
	<script type="text/javascript" src="static/third/assets/js/pages/login.js"></script>
	<!-- /theme JS files -->

	<script type="text/javascript" src="static/js/login.js"></script>

</head>

<body class="bg-slate-800">
	<!-- Page container -->
	<div class="page-container login-container">

		<!-- Page content -->
		<div class="page-content">

			<!-- Main content -->
			<div class="content-wrapper">

				<!-- Content area -->
				<div class="content">

					<!-- Advanced login -->
					<form action="/login/doLogin" method="get">
						<div class="panel panel-body login-form">
							<div class="text-center">
								<div class="icon-object border-warning-400 text-warning-400"><i class="icon-people"></i></div>
								<h5 class="content-group-lg">登录你的账户<small class="display-block">输入登录信息</small></h5>
							</div>

							<div class="form-group has-feedback has-feedback-left">
								<input type="text" class="form-control" placeholder="用户名" id="username" name="username">
								<div class="form-control-feedback">
									<i class="icon-user text-muted"></i>
								</div>
							</div>

							<div class="form-group has-feedback has-feedback-left">
								<input type="text" class="form-control" placeholder="密码" id="password" name="password">
								<div class="form-control-feedback">
									<i class="icon-lock2 text-muted"></i>
								</div>
							</div>

							<div class="form-group login-options">
								<div class="row">
									<div class="col-sm-6">
										<label class="checkbox-inline">
											<input type="checkbox" class="styled" checked="checked" id="remeberMe" name="remeberMe">
											记住我
										</label>
									</div>

									<div class="col-sm-6 text-right">
										<a href="login_password_recover.html">忘记了密码？</a>
									</div>
								</div>
							</div>

							<div class="form-group">
								<button type="button" id="login" class="btn bg-blue btn-block">登录<i class="icon-circle-right2 position-right"></i></button>
							</div>

							<div class="content-divider text-muted form-group"><span>还没有账户？</span></div>
							<a href="login_registration.html" class="btn bg-slate btn-block content-group">注册</a>
							<span class="help-block text-center no-margin">By continuing, you're confirming that you've read our <a href="#">Terms &amp; Conditions</a> and <a href="#">Cookie Policy</a></span>
						</div>
					</form>
					<!-- /advanced login -->


					<!-- Footer -->
					<div class="footer text-white">
						&copy; 2015. <a href="#" class="text-white">Limitless Web App Kit</a> by <a href="http://themeforest.net/user/Kopyov" class="text-white" target="_blank">Eugene Kopyov</a>
					</div>
					<!-- /footer -->

				</div>
				<!-- /content area -->

			</div>
			<!-- /main content -->

		</div>
		<!-- /page content -->

	</div>
	<!-- /page container -->

</body>
</html>
