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
      <li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="./merchantShowAllShop.jsp">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="./merchantViewProfile.jsp">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<table class="index-show-merchant">
		<tr>
			<td class="index-show-merchant-icon"><a href="<%="showProfile?mid="+request.getParameter("mid") %>"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a></td>
			<td>
				<h3>Name: </h3> ${merchant.name} 
				<p>Registration date:</p> ${merchant.regDate}
				<p>Number of Shops:</p> ${fn:length(merchant.shopList) }
				<p>Number of Dishes:</p> ${fn:length(dishes.shopList) }
			</td>
		</tr>
	</table>
	<div class="block-divider-index"></div>
	<h3>My Latest Shops</h3>
	<a href = "./merchantAddShop.html"><span class = "glyphicon glyphicon-plus"></span></a>
	<table class="index-show-latest">
		<tr>
			<td>
				<a href = "./merchantShowShop.html"><p>name of shop 1</p>
				<img src="https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"></a>
			</td>
			<td>
				<a href = "./merchantShowShop.html"><p>name of shop 2</p>
				<img src="https://4feet2mouths.files.wordpress.com/2013/11/2013-05-07-06-06-living-in-chicago-044.jpg"></a>
			</td>
			<td>
				<a href = "./merchantShowShop.html"><p>name of shop 3</p>
				<img src="http://l7.alamy.com/zooms/6463a649b9f741ca9f3e25da576a9ec6/bath-sausage-shop-uk-e9nxbb.jpg"></a>
			</td>
		</tr>
	</table>
	<div class="block-divider-index"></div>
	<h3>My Latest Dishes</h3>
	<a href = "./merchantAddShop.html"><span class = "glyphicon glyphicon-plus"></span></a>
	<table class="index-show-latest">
		<tr>
			<td>
				<a href = "./merchantShowShop.html"><p>name of dish 1</p>
				<img src="https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"></a>
			</td>
			<td>
				<a href = "./merchantShowShop.html"><p>name of dish 2</p>
				<img src="https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"></a>
			</td>
			<td>
				<a href = "./merchantShowShop.html"><p>name of dish 3</p>
				<img src="https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"></a>
			</td>
		</tr>
	</table>
  </div>
</div>
</body>
</html>