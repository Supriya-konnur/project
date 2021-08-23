<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
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
		url('https://www.paho.org/sites/default/files/styles/flexslider_full/public/2021-01/covid-19-vaccination-1500-991-2.jpg?h=33d2e14c&itok=Oyhv-gky');

	/* background-color: pink; */
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
<header style="color: orange; font-family: cursive;font-size:  2.5em;" > WELCOME TO SUCCESS RGISTRATION PAGE</header>

	<h6>
		<span style="color: Green;">${LoginSuccessMessage}</span>
	</h6>
	<form action="success.all"></form>
	<footer>
			<marquee>Copyright@2021</marquee>
		</footer>
</body>
</html>