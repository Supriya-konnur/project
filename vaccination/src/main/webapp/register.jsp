<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
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
		url('https://image.freepik.com/free-vector/cartoon-coronavirus-vaccine-illustration_23-2148849133.jpg');

	/* background-color: pink; */
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

footer p {
	color: #ff0000;
}
</style>
</head>
<body>
<header style="color: orange; font-family: cursive;font-size:  2.5em;" > WELCOME TO RGISTRATION PAGE</header>
  
    <h3 style="color: white; font-size:  2.5em;">${ msg}</h3>
    
<div class="login-form">
    <form action="signin.all" method="post">
    
    
		
       <!--  <h2 class="text-center">Sign In</h2>  --> 
        <div class="form-group">
        	<input type="text" class="form-control" name="name" placeholder="Name" required="required">
        	 <small style="color: red;">${namemsg}</small>
        </div> 
        <div class="form-group">
        	<input type="text" class="form-control" name="email" placeholder="Email Id" required="required">
        	<small
					style="color: red;">${emailmsg}</small>
        </div>
		 <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" type="hidden">
            <small style="color: red;">${passwordmsg}</small>
        </div> 
        <div class="form-group">
            <input type="password" class="form-control" name="confirmPassword" placeholder="ConfirmPassword" type="hidden">
            
        </div>
        <div class="form-group">
        	<input type="text" class="form-control" name="phone" placeholder="phone No" required="required">
        	<small style="color: red;">${phonemsg}</small>
        </div>
        <div class="form-group">
				<label>Gender</label> <br> <input type="radio" name="gender" value="Male">Male <br> <input
					type="radio" name="gender" value="Female">Female 
					<small style="color: red;">${gendermsg}</small>
			</div>



			<div class="form-group">
				<select class="form-control" name="typeOfVaccine">
					<option>Select vaccine type</option>
					<option value="Covaxin">Covaxin</option>
					<option value="Covishield">Covishield</option>
					<option value="Sputnik V">Sputnik V</option>
				</select> <small style="color: red;">${typemsg}</small>
			</div>

             
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block">Register</button>
        </div>
		
    </form>
    <footer>
			<p>Copyright@2021</p>
		</footer>
</div>
</body>
</html>