<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<jsp:include page="header.jsp" />
<jsp:include page="menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********Dish*********--> <!-- THREE IN ONE LINK -->
	<div class="mydish">
		<h3 class="h3_title_index">- Dish Name here -</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<p><h4 class="form_title">Dishes Type :</h4> Dishes Type here</p>
					</br>
					<p><h4 class="form_title">Dishes Prices :</h4> Dishes Prices here</p>
					</br>
					<p><h4 class="form_title">Dishes Status :</h4> Dishes Status</p>
					</br>
					<p><h4 class="form_title">Dishes Description:</h4> Dishes Description</p>
				</td>
				<td><img src=  "http://www.foodmanufacture.co.uk/var/plain_site/storage/images/publications/food-beverage-nutrition/foodmanufacture.co.uk/npd/top-10-functional-food-trends/11097085-1-eng-GB/Top-10-functional-food-trends_strict_xxl.jpg"/></td>
			</tr>
			<tr>
			    <td></td>
				<td id="orderDishDiv">
				<p>Quantity: <input type="number" name="quantity" min="1" max="100"></input></br>
				<a href=""><input type="submit" value="Add to Cart"/></a></p>
				</td>
			</tr>
		</table>
	</div>
</div>	
</body>
</html>