<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <div id="logo"><a href="showIndex?mid=${mid }"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="showAllShop?mid=${mid}">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="showProfile?mid=${mid}">My Profile</a></li>
      <li><a href="./merchantLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<h3>Shop name: </h3>
		<table class="index-show-merchant">
			<tr>
				<td><b>-Description-</b></td>
				<td rowspan = "5" class="index-show-merchant-icon"><img src="${shop.imagePath}"/></td>
				
				<!-- <td rowspan = "5" class="index-show-merchant-icon"><img src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></td>-->
			</tr>
			<tr>
				<td>${shop.descr }</td>
			</tr>
			<tr>
				<td><b>Contact Type:</b> Contact Type here</td>
			</tr>
			<tr>
				<td><b>Contact Information:</b> Contact Information here</td>
			</tr>
			<tr>
				<td><a href="./merchantShopEdit.html" class="btn btn-default">Edit</a></td>
			</tr>
			
			
			<!--<tr>
				<td>Hi here is description...Hi here is description...Hi here is description...Hi here is description...Hi here is description...Hi here is description...Hi here is description...Hi here is description...</td>
			</tr>
			<tr>
				<td><b>Contact Type:</b> Contact Type here</td>
			</tr>
			<tr>
				<td><b>Contact Information:</b> Contact Information here</td>
			</tr>
			<tr>
				<td><a href="./merchantShopEdit.html" class="btn btn-default">Edit</a></td>
			</tr> -->
		</table>
		<div class="block-divider-index"></div>
		<h4>Dishes in this shop</h4>
		<table class="index-show-latest show-border">
		
			<c:choose>
				<c:when test="${fn:length(dishes) >0}">
					<tr>
					
					<c:forEach items="${dishes }" var="dish">
					<c:if test="${fn:length(dish.dishImages) >0}">
						<a href = "./merchantShowDish.html"><p>${ dish.name}</p>
						<img width = "300px" src="${dish.dishImages[0]}"/></a>
					</c:if>
					</c:forEach>
					
					</tr>
				</c:when>
				<c:otherwise>
					<p>You have no dishes in this shop.</p>
				</c:otherwise>
			</c:choose>
			
			<!-- <tr>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
			</tr>
			<tr>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
			</tr> -->
		</table>
  </div>
</div>
</body>
</html>