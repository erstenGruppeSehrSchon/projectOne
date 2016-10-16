<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-Qing Mi Ji Rou Chang-</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href = "css/stylesheet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">

<!--JS-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "headerBar">
	<div>
		<h3>-Qing Mi Ji Rou Chang-</h3>
		<h4>Merchant Page</h4>
	</div>
</div>
	<div class = "Container">
		<div id = "containerForm">
		<h5>-Merchant Login-</h5>
			<form action="login" method="POST">
				<div class="input-group">
					<span class="input-group-addon"><span class = "glyphicon glyphicon-user"></span></span>
					<input id="username" name="username" type="text" class="form-control" placeholder="Username">
				</div>
				<br/>
				<div class="input-group">
					<span class="input-group-addon"><span class = "glyphicon glyphicon-menu-right"></span></span>
					<input id="password" name="password" type="password" class="form-control" placeholder="Password"> 
				</div>
				<br/>
				<c:if test="${not empty errorMsg}">
				   <c:out value="${errorMsg}"/>
				</c:if>
				<br/>
				<br/>
				<input type="submit" value="Login" class="btn btn-default">
				<br/>
				<br/>
			</form>
			<p>Want to join us!? click <a href="./merchantRegistration.jsp">here!</a></p>
		</div>
	</div>
</body>
</html>