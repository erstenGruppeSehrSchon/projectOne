<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>
<div class="container">
<header>
    <div id="logo"><a href="ShowAllDishes"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
     <!--<li><a href="#">Search</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>-->
    </ul>
  </nav>
  <div id="main">
	<table class="show-merchant-infor">
		<tr>		
			<th colspan = "3">-Merchant Information-</th>
		</tr>
		<tr>
			<td rowspan="6" class = "adminEditDetailsTableIcon"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></td>
			<td class = "adminEditDetailsTableColName">Merchant ID:</td>
			<td class = "adminEditDetailsTableInput">${merchant.mid}</td>
		</tr>
		<tr>
			<td>Merchant Name:</td>
			<td>${merchant.name}</td>
		</tr>
		<tr>
			<td>Brithday:</td>
			<td>${merchant.birth}</td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td>${merchant.gender}</td>
		</tr>
		<tr>
			<td>Registration Date:</td>
			<td>${merchant.regDate}</td>
		</tr>
		<tr>
			<td>Status:</td>
			<td>${merchant.status}</td>
		</tr>
	</table>
</div>
</body>
</html>