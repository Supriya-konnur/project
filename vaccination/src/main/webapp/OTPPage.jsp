<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background-image:
		url('https://0fee0d1c5b52a13f8e96-30a303f53bdf01a25c7e0ba587cc52bc.ssl.cf2.rackcdn.com/istm_19d221412ae707e13249152e58b0803f.PNG');
}
.form-control {
	min-height: 41px;
	background: #fff;
	box-shadow: none !important;
	border-color: #e3e3e3;
}
.form-control:focus {
	border-color: black;
}
.form-control, .btn {
	border-radius: 2px;
}
.login-form {
	width: 350px;
	margin: 0 auto;
	padding: 100px 0 30px;
}
.login-form form {
	color: #7a7a7a;
	border-radius: 2px;
	margin-bottom: 15px;
	font-size: 13px;
	background: #ececec;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
	position: relative;
	opacity: 0.89;
}
.login-form h2 {
	font-size: 22px;
	margin: 35px 0 25px;
}
.login-form .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -50px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: dodgerblue;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}
.login-form .avatar img {
	width: 100%;
}
.login-form input[type="checkbox"] {
	margin-top: 2px;
}
.login-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: dodgerblue;
	border: none;
	margin-bottom: 20px;
}
.login-form .btn:hover, .login-form .btn:focus {
	background: #50b8b3;
	outline: none !important;
}
.login-form a {
	color: #fff;
	text-decoration: underline;
}
.login-form a:hover {
	text-decoration: none;
}
.login-form form a {
	color: #7a7a7a;
	text-decoration: none;
}
.login-form form a:hover {
	text-decoration: underline;
}
footer {
	position: absolute;
	text-align: center;
	bottom: 0;
	width: 100%;
	height: 2.5rem;
}

</style>

</head>
<body>
<header
		style="color: black; font-family: Lucida Console; font-size: 2.5em; background-color: #66b3ff">OTP Page </header>



	<div class="login-form">
		<form action="getotppage" method="post">



			<h2 class="text-center">Sign up for vaccination</h2>


			<div class="form-group">
				<input type="text" class="form-control" name="otp" placeholder="OTP">
			</div>
			<small style="color: red;"> Please enter OTP</small> <br> <small style="color: red;">${otpmsg}</small>

			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg btn-block">GetOtp</button>
			</div>

		</form>

		<footer>
			<marquee>Copyright@2021</marquee>
		</footer>
	</div>

</body>
</html>