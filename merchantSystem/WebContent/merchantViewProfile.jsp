<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <div id="logo"><a href="./merchantIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="./merchantShowAllShop.jsp">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="./merchantViewProfile.jsp">My Profile</a></li>
      <li><a href="./merchantLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<h3>My Profile</h3>
	<form action="showEditProfile" method="get">
		<table class="index-show-merchant">
		<tr>
			<td rowspan="6" class="index-show-merchant-icon"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></td>
			<td>Merchant ID: <input type="text" name="mid" value="${merchant.mid}" readonly></td>
			<td><input type="hidden" name="password" value="${merchant.password}"></td>
			<td></td>
		</tr>
	<tr>
		<td>Merchant Name: <input type="text" name="name" value="${merchant.name }" readonly></td>
		<td></td>
	</tr>
	<tr>
		<td>Birthday: <input type="text" name="birth" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
            value="${merchant.birth}"/>" readonly></td>
		<td></td>
	</tr>
	<tr>
		<td>Gender: <input type="text" name="gender" value="${merchant.gender }" readonly></td> 
		<td></td>
	</tr>
	<tr>
		<td>Registration Date: <input type="text" name="regDate" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
            value="${merchant.regDate}"/>" readonly> </td>
		<td></td>
	</tr>
	<tr>
		<td>Status: <input type="text" name="status" value="${merchant.status }" readonly></td> 
		<td></td>
	</tr>
	</table>
	<c:if test="${not empty merchant.status and merchant.status eq 'Accepted'}">
		<input type="submit" value="Edit" class="btn btn-default">
	</c:if>
	</form>
  </div>
</div>
</body>
</html>