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
<script>
function commentBoxShow(boxId) {
    var div = document.getElementById("commentBox"+boxId);
    var p = "</br><p>Comment:</p>";
    var textarea = "<textarea rows=\"4\" cols=\"50\"></textarea>";
    var button = "</br><input type=\"submit\" value=\"Submit\"/>";
    div.innerHTML = p + textarea + button;
}

function ratingBoxShow(boxId) {
	var div = document.getElementById("ratingBox"+boxId);
    var p = "</br><p>Rating:</p>";
    var rating = "<input type=\"number\" name=\"rating\" min=\"1\" max=\"5\">";
    var button = "</br><input type=\"submit\" value=\"Submit\"/>";
    div.innerHTML = p + rating + button;
}


</script>
</head>
<body>
<jsp:include page="./header.jsp" />

<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<!--*********My Order*********--><!-- 1 in one line -->
	<div class=myOrder>
		<h3 class="h3_title_index">- My Order -</h3>
		
		<!-- one table for one order -->
		<table class="largeThumb">
			<tr>
				<td>
					<p>Order number: </p><p></p>
					<p>Order Time: </p><p></p>
					<p>Merchant Name: </p><p></p>
					<p>Receiver Name: </p><p></p>
					<p>Delivery Address: </p><p></p>
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
				<td><p><b>Status: </b></p>z.b: waiting for order<p></p></td>
				<td>
				<input type="submit" value="Order Confirm" onclick="ratingBoxShow(1)" />
				<input type="submit" value="Delete Order" onclick="" />
				<input type="submit" value="Give Comment" onclick="commentBoxShow(1)" />
				</td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "ratingBox1"></div></td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "commentBox1"></div></td>
			</tr>
		</table>
		
		<div class="block-divider-index"></div>
		
		<!-- Order 2 -->
		<table class="largeThumb">
			<tr>
				<td>
					<p>Order number: </p><p></p>
					<p>Order Time: </p><p></p>
					<p>Merchant Name: </p><p></p>
					<p>Receiver Name: </p><p></p>
					<p>Delivery Address: </p><p></p>
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
				<td><p><b>Status: </b></p>z.b: waiting for order<p></p></td>
				<td>
				<input type="submit" value="Order Confirm" onclick="ratingBoxShow(2)" />
				<input type="submit" value="Delete Order" onclick="" />
				<input type="submit" value="Give Comment" onclick="commentBoxShow(2)" />
				</td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "ratingBox2"></div></td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "commentBox2"></div></td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>