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
<<<<<<< HEAD:merchantSystem/WebContent/merchantIndex.html
<div class="container">
<header>
    <div id="logo"><a href="./clientIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="#">Search</a></li>
      <li><a href="#">Manage My Shops</a></li>
      <li><a href="#">Manage My Dishes</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<table class="index-show-merchant">
		<tr>
			<td class="index-show-merchant-icon"><a href="./merchantViewProfile.html"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a></td>
			<td>
				<h3>Name: </h3>
				<p>E-mail:</p>
				<p>Number of Shops:</p>
				<p>Number of Dishes:</p>
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
=======
<div class = "headerBar">
	<div>
		<h3>-Qing Mi Ji Rou Chang-</h3>
		<h4>Merchant Page</h4>
	</div>
</div>
<div class="dropdown">
		<button class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span class = "glyphicon glyphicon-align-justify"></span>
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
		  <li><a href="./merchantSearch.html">Search</a></li>
		  <li class="divider"></li>
		  <li><a href="./merchantShowAllShop.html">Manage My Shops</a></li>
		  <li><a href="./merchantShowAllDishes.html">Manage My Dishes</a></li>
		  <li class="divider"></li>
		  <li><a href="./merchantViewProfile.jsp">My Profile</a></li>
		  <li><a href="./merchantLogin.jsp">Logout</a></li>
		</ul>
</div>
<div class = "container">
<table id = "merchanIndexContainerIndexView">
	<div>
		<table id = "merchanIndexTable">
			<tr>
				<td><a href="<%="showProfile?mid="+request.getParameter("mid") %>"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a></td>
				<td>
					<h3>Name: </h3> ${merchant.name} 
					<p>Registration date:</p> ${merchant.regDate}
					<p>Number of Shops:</p> ${fn:length(merchant.shopList) }
					<p>Number of Dishes:</p> ${fn:length(dishes.shopList) }
				</td>
			</tr>
			<tr>
				<td>My Latest Shops:   <a href = "./merchantAddShop.html"><span class = "glyphicon glyphicon-plus"></span></a></td>
			</tr>
			<tr>
				<td colspan = "2">
				<table id = "merchanIndexTableShowShop">
				<td>
					<a href = "./merchantShowShop.html"><p>name of shop 1</p>
					<img src="https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"></a>
				</td>
				</table>
				</td>
			</tr>
			<tr>
				<td>My Latest dishes:   <a href = "./merchantAddDishes.html"><span class = "glyphicon glyphicon-plus"></span></a></td>
				<tr>
				<td colspan = "2">
				<table id = "merchanIndexTableShowShop">
				<td>
					<a href = "./merchantShowDish.html"><p>name of dish 1</p>
					<img src="https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"></a>
				</td>
				
				</table>
				</td>
				</tr>
			</tr>
			</tr>
		</table>
	</div>
</table>
>>>>>>> b33be0af5acc1f992747bad7fcf6db9d1642f8a8:merchantSystem/WebContent/merchantIndex.jsp
</div>
</body>
</html>