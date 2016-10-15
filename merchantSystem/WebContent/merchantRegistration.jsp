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
<div class = "container">
<div id = "containerRegForm">
<h2>Registration</h2>
	<form action = "register" method = "post">
	<table id = "merchantRegTable">
		<tr>
			<td>Username</td>
			<td><input id="merchantUserName" name="merchantUserName" type="text" class="form-control"></td>
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
	</table>
	<!--<input type="submit" class ="btn"/>-->
	<br/>
	<c:if test="${not empty errorMsg}">
		<c:out value="${errorMsg}"/>
	</c:if>
	<br/>
	<input type="submit" value="Register" class="btn btn-default">
	</form>
</div>
</div>
</body>
</html>