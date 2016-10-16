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
	<h3>All my shops:</h3>
		<table class="index-show-latest show-border">
			<c:choose>
				<c:when test="${fn:lengthshops) >0}">
					<tr>
					
					<c:forEach items="${shops }" var="shop">
					<p>${ shop.name}</p>
					<c:if test="${fn:length(shop.imagePath) >0}">
						<img src="${shop.imagePath.get(0)}">
					</c:if>
					</c:forEach>
					</tr>
				</c:when>
				<c:otherwise>
					<p>You have no shops.</p>
				</c:otherwise>
			</c:choose>
			<!--<tr>
				<td><a href = "./merchantShowShop.html"><p>Shop name 1</p><img width = "300px" src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></a></td>
				<td><a href = "./merchantShowShop.html"><p>Shop name 2</p><img width = "300px" src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></a></td>
				<td><a href = "./merchantShowShop.html"><p>Shop name 3</p><img width = "300px" src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></a></td>
			</tr>
			<tr>
				<td><a href = "./merchantShowShop.html"><p>Shop name 4</p><img width = "300px" src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></a></td>
				<td><a href = "./merchantShowShop.html"><p>Shop name 5</p><img width = "300px" src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></a></td>
				<td><a href = "./merchantShowShop.html"><p>Shop name 6</p><img width = "300px" src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></a></td>
			</tr>-->
		</table>
  </div>
</div>
</body>
</html>