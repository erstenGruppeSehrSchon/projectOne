<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-SAUSAGE HOUSE-</title>
<meta name="viewport" content="width=device-width">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div class="container">
<header>
    <div id="logo"><a href="./clientIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <!--<li><a href="#">Search</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>-->
    </ul>
  </nav>
  <div id="main">
  <div class="block-divider"></div>
	<form id="merchant-login-form" action="login" method="POST">
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
		<div id="admin-logn-form-error"><c:if test="${not empty errorMsg}">
		   <c:out value="${errorMsg}"/>
		</c:if></div>
		
		<c:if test="${empty status}">
			<div id="merchant-logn-form-error"><p>Want to join us!? click <a href="./merchantRegistration.jsp">here!</a></p></div>
		</c:if>
		<input type="submit" value="Login" class="btn btn-default">
		<br/>
		<br/>
	</form>
</div>
</body>
</html>