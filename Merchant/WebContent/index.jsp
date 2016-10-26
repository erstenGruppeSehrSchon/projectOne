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

	<!--*********My shop*********--> <!-- THREE IN ONE LINK -->
	<div class="myShop">
		<h3 class="h3_title_index">- My Shop -</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://www.oushop.com/warp_sites/oushop.g6/files/Shop2.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p></a>
				</td>
			</tr>
		</table>
	</div>
	
	<!--*********My Advertisement*********--> <!-- THREE IN ONE LINK -->
	<div class="myAdvertisement">
		<h3 class="h3_title_index">- My Advertisement -</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://ralev.com/wp-content/uploads/2010/06/coke-tv-advertising.png" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://freedesignfile.com/upload/2014/07/Juice-advertisement-publicize-poster-creative-vector-04.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://3.bp.blogspot.com/-c7wopKrneAk/UFLQX8DqN0I/AAAAAAAAAFQ/vk1pZeSAS6Y/s1600/advertisement-copy.gif" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p></a>
				</td>
			</tr>
		</table>
	</div>
	
	<!--*********My Order*********--> <!-- THREE IN ONE LINK -->
	<div class=myOrder>
		<h3 class="h3_title_index">- My Order -</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<a href="#">
					<p>New Shops</p></a><!-- Shop Link-->
					<p>Order number</p>
					<p>Order Time</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<p>New Shops</p></a><!-- Shop Link-->
					<p>Order number</p>
					<p>Order Time</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<p>New Shops</p></a><!-- Shop Link-->
					<p>Order number</p>
					<p>Order Time</p></a>
				</td>
			</tr>
		</table>
	</div>
</div>	
</body>
</html>