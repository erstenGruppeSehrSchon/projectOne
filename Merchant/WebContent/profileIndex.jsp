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
		<h3 class="h3_title_index">- My Profile -</h3>
		<a href="./profileEdit.jsp"><input type="submit" value="Edit Profile"/></a>
		<table class="largeThumb">
			<tr>
				<td>
					<p class = "showInfortitle">Merchant Name: </p>
					<p class = "showInfortitle">Merchant Gender: </p>
					<p class = "showInfortitle">Merchant Birthday: </p>
					<p class = "showInfortitle">Number of Shops: </p>
					<p class = "showInfortitle">Number of Dishes: </p>
				</td>
				<td>
					<p>name</p>
					<p>gender</p>
					<p>birthday</p>
					<p>shop</p>
					<p>dish</p>
				</td>
				<td>
					<img src="http://www.icon2s.com/img256/256x256-black-white-android-user.png"></img>
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>