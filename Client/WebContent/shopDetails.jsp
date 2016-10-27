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

<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<!--*********My Shop details*********--><!-- 3 in one line -->
	<div class="myShop">
	<a href="./cartIndex.jsp"><input type="submit" value="My Cart in this shop"/></a>
		<h3 class="h3_title_index">- Shop details-</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<p><h4 class="form_title">Shop Name :</h4> Shop Name here</p>
					</br>
					<p><h4 class="form_title">Shop Address :</h4> Shop Address here</p>
					</br>
					<p><h4 class="form_title">Shop available time :</h4> Shop available time</p>
					</br>
					<p><h4 class="form_title">Shop Marks :</h4> Shop Marks</p>
					</br>
					<p><h4 class="form_title">Shop Description:</h4> Shop Description</p>
				</td>
				<td>
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg"/>
				</td>
			</tr>
		</table>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Dishes in this shop-</h3>
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

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Comments in this shop-</h3>
	<!-- one comment one table -->
		<table class="largeThumb commentBox">
		<tr>
			<td colspan="2"><h4 class="form_title">-Customer comment-</h4></td>
		</tr>
			<tr>
				<td>
					<p><b>Customer name:</b> name here</p>
					<p><b>Date:</b> date here</p>
				</td>
				<td><p><b>Content:</b></p><p>Content here</p></td>
			</tr>
			<tr>
			<td colspan="2"><h4 class="form_title">-Merchant comment-</h4></td>
		</tr>
			<tr>
				<td><p><b>Date:</b> date here</p></td>
				<td><p><b>Content:</b> Content here</p></td>
			</tr>
		</table>
		
		<!-- other comment -->
		<table class="largeThumb commentBox">
		<tr>
			<td colspan="2"><h4 class="form_title">-Customer comment-</h4></td>
		</tr>
			<tr>
				<td>
					<p><b>Customer name:</b> name here</p>
					<p><b>Date:</b> date here</p>
				</td>
				<td><p><b>Content:</b></p><p>Content here</p></td>
			</tr>
			<tr>
			<td colspan="2"><h4 class="form_title">-Merchant comment-</h4></td>
		</tr>
			<tr>
				<td><p><b>Date:</b> date here</p></td>
				<td><p><b>Content:</b> Content here</p></td>
			</tr>
		</table>
</div>

</body>
</html>