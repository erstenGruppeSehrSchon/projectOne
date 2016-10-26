<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -Merchant System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="./header.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********My Shop*********--><!-- 3 in one line -->
	<div class="myShop">
		<h3 class="h3_title_index">- My Advertisement-</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<a href="./dishDetails.jsp"><!-- Advertisement Link-->
					<img src="http://www.foodmanufacture.co.uk/var/plain_site/storage/images/publications/food-beverage-nutrition/foodmanufacture.co.uk/npd/top-10-functional-food-trends/11097085-1-eng-GB/Top-10-functional-food-trends_strict_xxl.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p>
					<p>Dish Name</p></a>
				</td>
				
				<td>
					<a href="./dishDetails.jsp"><!-- Advertisement Link-->
					<img src="http://www.gordonconwell.edu/hamilton/current/images/01.jpg" title=""/></br> <!-- Dish img and shop name -->
					<p>Shops Name</p>
					<p>Dish Name</p></a>
				</td>
				
				<td>
					<a href="./dishDetails.jsp"><!-- Advertisement Link-->
					<img src="http://www.noblecatering.co.uk/upload/food-066.jpg" title=""/></br> <!-- Dish img and shop name -->
					<p>Shops Name</p>
					<p>Dish Name</p></a>
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>