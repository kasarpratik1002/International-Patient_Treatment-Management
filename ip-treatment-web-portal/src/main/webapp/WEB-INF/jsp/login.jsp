<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!doctype html>
<html lang="en">
	<head>
		<title></title>
		<%@ include file="headlink.jsp"%>
		<link href="css/basic.css" rel="stylesheet" type="text/css">
		<script src="js/basic.js"></script>
	</head>
	<body>
	
			<div class="container-fluid">
		<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"><img
			src="https://media.istockphoto.com/vectors/medical-hospital-plus-sign-map-pointer-icon-vector-id1277216918?k=6&m=1277216918&s=170667a&w=0&h=_CQyN-gVkTFv6pYkm_5-QRgW0qyq8l-dWVZsQ1R-dOo="
			height="50px" width="50px">IPTMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
<!-- 		<div class="collapse navbar-collapse" id="navbarResponsive"> -->

	</nav>
</header>


		<div class="row">
			<div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4 text-center login-box-alignment">
				<form id="contact" action="/login" model="user"  method="post">
					<h3>Login</h3>
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="User name" name="userid" type="text" tabindex="1" required>
						</div>
					</fieldset>
					
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Password" name="upassword" type="password" tabindex="1" required>
						</div>
					</fieldset>
		
					<fieldset>
						<button name="submit" type="submit" id="contact-submit"
							data-submit="...Sending">Submit</button>
					</fieldset>
					<fieldset>
					<h6 style="color: red;">${error}</h6>
					</fieldset>
					
				</form>
			</div>
		</div>
	</div>
	</body>
</html>
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>IPTMS</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />

<link rel="stylesheet" type="text/css" href="css/basic.css">

</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('https://image.shutterstock.com/image-vector/male-patient-lying-on-bed-260nw-1767929627.jpg');">
			<div class="wrap-login100 p-t-190 p-b-30">
				<form   action="/login" model="user"  method="post" class="login100-form validate-form" >
					<div class="login100-form-avatar">
						<img src="images/logo.webp" alt="AVATAR">
					</div>

					<span class="login100-form-title p-t-30 p-b-55"> <strong>International
							Patient Management System</strong>
					</span>

					<div class="wrap-input100 validate-input m-b-10"
						style="margin: 4; padding: 4" data-validate="Username is required">
						<input class="input100" type="text" name="userid"
							placeholder="Username"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-user"></i>
						</span>
					</div>
					

					<div class="wrap-input100 validate-input m-b-10"
						style="margin: 4; padding: 4" data-validate="Password is required">
						<input class="input100" type="password" name="upassword"
							placeholder="Password"> <span class="focus-input100"></span>
						<span class="symbol-input100"> <i class="fa fa-lock"></i>
						</span>
					</div>
					

					<div class="container-login100-form-btn p-t-10" id="contact-submit">
						<button class="login100-form-btn">
							<strong>Login</strong>
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<!--===============================================================================================-->
	<script src="js/basic.js"></script>

</body>
</html>




x
