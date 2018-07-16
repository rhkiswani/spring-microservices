<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<meta charset="utf-8">
	<meta name="author" content="kiswanim">
	<meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.8.13/i18n/jquery-ui-i18n.min.js" />
</head>
<style>
html,body {
	height: 100%;
}

body.login-page {
	background-color: #f7f9fb;
	font-size: 14px;
}

.login-page .brand {
	height: 90px;
	overflow: hidden;
	margin: 0 auto;
	margin: 40px auto;
	box-shadow: 0 0 40px rgba(0,0,0,.05);
}

.login-page .brand img {
	width: 100%;
}

.login-page .card-wrapper {
	width: 400px;
	margin: 0 auto;
}

.login-page .card {
	border-color: transparent;
	box-shadow: 0 0 40px rgba(0,0,0,.05);
}

.login-page .card.fat {
	padding: 10px;
}

.login-page .card .card-title {
	margin-bottom: 30px;
}

.login-page .form-control {
	border-width: 2.3px;
}

.login-page .form-group label {
	width: 100%;
}

.login-page .btn.btn-block {
	padding: 12px 10px;
}

.login-page .margin-top20 {
	margin-top: 20px;
}

.login-page .no-margin {
	margin: 0;
}

.login-page .footer {
	margin: 40px 0;
	color: #888;
	text-align: center;
}

@media screen and (max-width: 425px) {
	.login-page .card-wrapper {
		width: 90%;
		margin: 0 auto;
	}
}

@media screen and (max-width: 320px) {
	.login-page .card.fat {
		padding: 0;
	}

	.login-page .card.fat .card-body {
		padding: 15px;
	}
}
</style>
<body class="login-page">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="https://backbase.com/wp-content/uploads/2017/10/Backbase_Logo_Dark.svg">
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">Login</h4>
							<form action="login" method='POST'>

								<div class="form-group">
									<label for="email">Username</label>

									<input id="username" type="text" class="form-control" name="username" value="" required autofocus>
								</div>

								<div class="form-group">
									<label for="password">Password
										<a href="forgot.html" class="float-right">
											Forgot Password?
										</a>
									</label>
									<input id="password" type="password" class="form-control" name="password" required data-eye>
								</div>

								<div class="form-group no-margin">
									<button type="submit" class="btn btn-primary btn-block">
										Login
									</button>
								</div>
							</form>
						</div>
					</div>
					<div class="footer">
						Copyright &copy; 2018 &mdash; Mohamed Kiswani
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>