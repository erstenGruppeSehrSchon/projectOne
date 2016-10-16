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
    <div id="logo"><a href="./clientIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="#">Search</a></li>
      <li><a href="#">Manage My Shops</a></li>
      <li><a href="#">Manage My Dishes</a></li>
      <li><a href=<%="showProfile?mid="+request.getAttribute("mid") %>>My Profile</a></li>
      <li><a href="./merchantLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<table class="index-show-merchant">
		<tr>
			<td class="index-show-merchant-icon"><a href=<%="showProfile?mid="+request.getAttribute("mid") %>><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a></td>
			<td>
			 <!-- request.getAttribute("mid") -->
				<h3>Name: ${merchant.name} </h3>
				<p>Registration date: ${merchant.regDate}</p> 
				<p>Number of Shops:  ${fn:length(merchant.shopList) }</p>
				<p>Number of Dishes: ${fn:length(dishes) }</p> 
			</td>
		</tr>
	</table>
	<div class="block-divider-index"></div>
	<h3>My Latest Shops</h3>
	<a href = "./merchantAddShop.html"><span class = "glyphicon glyphicon-plus"></span></a>
	<table class="index-show-latest">
		<!--<td>
			<a href = "./merchantShowShop.html"><p>name of shop 1</p>
			<img src="https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"></a>	
		</td>-->
		
		<c:choose>
			<c:when test="${fn:length(merchant.shopList) >0}">
				<tr>
				
				<c:forEach items="${merchant.shopList }" var="shop">
				<p>${ shop.name}</p>
				<img src="https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg">
				</c:forEach>
				</tr>
			</c:when>
			<c:otherwise>
				<p>You have no shops.</p>
			</c:otherwise>
		</c:choose>
	</table>
	<div class="block-divider-index"></div>
	<h3>My Latest Dishes</h3>
	<a href = "./merchantAddDish.html"><span class = "glyphicon glyphicon-plus"></span></a>
	<table class="index-show-latest">
		<tr>
			<td colspan = "2">
			<table id = "merchanIndexTableShowShop">
			<!--<td>
				<a href = "./merchantShowDish.html"><p>name of dish 1</p>
				<img src="https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"></a>
			</td> -->
			<c:choose>
				<c:when test="${fn:length(dishes) >0}">
					<tr>
					
					<c:forEach items="${dishes }" var="dish">
					<p>${ dish.name}</p>
					<img src="https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg">
					</c:forEach>
					
					</tr>
				</c:when>
				<c:otherwise>
					<p>You have no dishes.</p>
				</c:otherwise>
			</c:choose>
			</table>
			</td>
		</tr>
	</table>
  </div>
</div>
</body>
</html>