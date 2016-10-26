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
	<!--*********My Order*********--><!-- 1 in one line -->
	<div class=myOrder>
		<h3 class="h3_title_index">- My Order -</h3>
		
		<!-- one table for one order -->
		<table class="largeThumb">
			<tr>
				<td>
					<p>Order number: </p><p></p>
					<p>Order Time: </p><p></p>
					<p>Customer Name: </p><p></p>
					<p>Customer Address: </p><p></p>
					<p>Total Prices: </p><p></p>
				</td>
				<td>
					<b><p>Shop name: </p><p></p></b>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input type="submit" value="Delivered" onclick="" />
				<input type="submit" value="Reject" onclick="" />
				<input type="submit" value="Accept" onclick="" /></td>
			</tr>
		</table>
		
		<div class="block-divider-index"></div>
		
		<!-- Order 2 -->
		<table class="largeThumb">
			<tr>
				<td>
					<p>Order number: </p><p></p>
					<p>Order Time: </p><p></p>
					<p>Customer Name: </p><p></p>
					<p>Customer Address: </p><p></p>
					<p>Total Prices: </p><p></p>
				</td>
				<td>
					<b><p>Shop name: </p><p></p></b>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
				<input type="submit" value="Delivered" onclick="" />
				<input type="submit" value="Reject" onclick="" />
				<input type="submit" value="Accept" onclick="" /></td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>