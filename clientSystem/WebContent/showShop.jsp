<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <div id="logo"><a href="ShowAllDishes"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <!--<li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="./merchantShowAllShop.jsp">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="./merchantViewProfile.jsp">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>-->
    </ul>
  </nav>
  <div id="main">
	<h3>Shop name: ${shop.name}</h3>
		<table class="index-show-merchant">
			<tr>
				<td><b>-Description-</b></td>
				<td rowspan = "10" class="index-show-merchant-icon"><img src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></td>
			</tr>
			<tr>
				<td>${shop.descr}</td>
			</tr>
			<c:forEach var="contact" items="${shop.shopContactList}"> 
				<tr>
					<td><b>Contact Type:</b> ${contact.type} </td>
				</tr>
				<tr>
					<td><b>Contact Information:</b> ${contact.info}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div class="block-divider-index"></div>
		<h4>Dishes in this shop</h4>
		<table class="index-show-latest show-border">
		
		<tr>
		<c:forEach var="dish" items="${dishes}">
			<td>
				<c:forEach var="dishImage" items="${dish.dishImages}">
				<a href="ShowDish?shopId=${dish.sid}&dishId=${dish.did}">
					<h5>-${dish.name}-</h5>
					<img src="${dishImage.imgPath}"/>
				</a>
				</c:forEach>
			</td>	
		</c:forEach>
		</tr>
		
		</table>
  </div>
</div>
</body>
</html>