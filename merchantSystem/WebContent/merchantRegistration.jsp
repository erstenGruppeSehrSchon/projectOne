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
    <div id="logo"><a href="./merchantIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="#">Search</a></li>
      <li><a href="#">Manage My Shops</a></li>
      <li><a href="#">Manage My Dishes</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./merchantLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<h3>Registration</h3>
	<div class="merchant-form-control">
	<form action = "register" method = "post">
	<table>
		<tr>
			<td>Username</td>
			<td><input id="merchantUsername" name="merchantUsername" type="text" class="form-control"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input id="merchantPassword" name="merchantPassword" type="text" class="form-control"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input id="merchantRegName" name="merchantRegName" type="text" class="form-control"></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<select id="merchantGender" name="merchantGender" class="form-control">
				  <option value="M">M</option>
				  <option value="F">F</option>
				  <option value="Unknown">Unknown</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Birthday</td>
			<!--<td><input type="date" id="merchantBirthDate" name="merchantBirthDate" class="form-control"></td>-->
			<td><input type="text" id="merchantBirthDate" name="merchantBirthDate" class="form-control"></td>
		</tr>
		<tr>
			<td rowspan="2">
				<c:if test="${not empty errorMsg}">
					<c:out value="${errorMsg}"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td rowspan="2"><input type="submit" value="Register" class="btn btn-default"></td>
		</tr>
	</table>
	</form>
	</div>
  </div>
</div>
</body>
</html>