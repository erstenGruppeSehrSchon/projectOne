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
	<script src="js/orderIndex.js"></script>
	<script>
		$(function() {
			getOrders("${shopId}", "${shopName}");
		});
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
		<table class="largeThumb" id="orderTable">
		</table>

	</div>
</div>

</body>
</html>