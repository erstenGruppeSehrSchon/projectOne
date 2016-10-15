<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h4>Client Page</h4>
	</div>
</div>
<div class="dropdown">
		<button class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span class = "glyphicon glyphicon-align-justify"></span>
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
		  <li><a href="#">Search</a></li>
		  <li class="divider"></li>
		  <li><a href="#">My Profile</a></li>
		  <li><a href="./adminLogin.html">Logout</a></li>
		</ul>
</div>



<div class = "container">
	<table id = "containerColume" style = "width:100%">
		<tr>
			<td>
			<div>
				<p>Name: ${Dish.name})</p>
				<p>Like Dislike</p>
				<p>Type:  ${Dish.type}</p>
				<p>Price:  ${Dish.price}</p>
				<p>Active:  ${Dish.active}</p>
			</div>
			</td>
			<td>
			<div>
                 <img src="${DishImage.path}" />		
                 </div>
			</td>
		</tr>
		<tr>
			<td>
				<p>
					-Comments-
				</p>
			</td>
			<td>
			<div>
			<p>-Merchant-</p>
			<a href = "showmerchant?MerchantId=${Merchant.mid}"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/>
			<p>Name: Merchant Name</p></img></a>		
			</div>
			</td>
		</tr>
	</table>
</div>
</body>
</html>