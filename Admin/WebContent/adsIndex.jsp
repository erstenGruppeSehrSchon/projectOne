<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -Admin System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/advertisementDetails.js"></script>
</head>
<body>
<jsp:include page="./header.jsp" />
<div class="container">
<jsp:include page="./menu.jsp" />
</div>
<!-- *********container*********-->
 <div class="container">
 	<h3 class="h3_title_index">- Client Side Advertisement View -</h3>
 	<!-- *********banner*********--> 
 	<div id="slider" class="carousel slide">
	
 	<ol class="carousel-indicators">
 		<li data-target="#slider" data-slide-to="0" class="active"></li>
 		<li data-target="#slider" data-slide-to="1"></li>
 		<li data-target="#slider" data-slide-to="2"></li>
 		<li data-target="#slider" data-slide-to="3"></li>
 	</ol>   
	
 	<div class="carousel-inner" id = "sliderShow">
 	</div>
	
 	<a class="carousel-control left" href="#slider" 
 	   data-slide="prev"><span class="glyphicon glyphicon-chevron-left"/></a>
 	<a class="carousel-control right" href="#slider" 
 	   data-slide="next"><span class="glyphicon glyphicon-chevron-right"/></a>
 	</div> 
 </div>

 <div class="container">
 	<div class="block-divider-index"></div>
 </div>

<div class="container">
	<!--********Current ads**********--><!-- 3 in one line -->
	<div class="myShop">
		<h3 class="h3_title_index">- Current Advertisements -</h3>
		<table id="acceptedAdvertisementTable" class = "largeThumb"></table>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>

<div class="container">
	<!--********Pending ads**********--><!-- 3 in one line -->
	<div class="myShop">
		<h3 class="h3_title_index">- Pending Advertisements -</h3>
		<table id="pendingAdvertisementTable" class = "largeThumb"></table>
	</div>
</div>
</body>
</html>