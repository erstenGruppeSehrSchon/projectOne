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

	<!--*********My Advertisement*********--><!-- 3 in one line -->
	<div class="myAdvertisement">
		<h3 class="h3_title_index">- My Advertisement -</h3>
		<a href="./adsAdd.jsp"><input type="submit" value="Add advertisement" /></a>
		<table class="largeThumb">
			<tr>
				<td>
					<img src="http://ralev.com/wp-content/uploads/2010/06/coke-tv-advertising.png" title=""/></br>
					<p>Time range</p>
					<p class="text_delete"><a href="#">Delete</a></p>
				</td>
				
				<td>
					<img src="http://freedesignfile.com/upload/2014/07/Juice-advertisement-publicize-poster-creative-vector-04.jpg" title=""/></br>
					<p>Time range</p>
					<p class="text_delete"><a href="#">Delete</a></p>
				</td>
				
				<td>
					<img src="http://3.bp.blogspot.com/-c7wopKrneAk/UFLQX8DqN0I/AAAAAAAAAFQ/vk1pZeSAS6Y/s1600/advertisement-copy.gif" title=""/></br>
					<p>Time range</p>
					<p class="text_delete"><a href="#">Delete</a></p>
				</td>
			</tr>
		</table>
	</div>
</div>

</body>
</html>