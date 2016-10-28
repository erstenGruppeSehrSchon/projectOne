<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        
    </script>
</head>
<body>
<jsp:include page="./header.jsp" />
<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<h3 class="h3_title_index">- Customer Complain -</h3>
	<!--*********Complaint details*********-->
	<table class="largeThumb commentBox">
		<tr>
			<td><p><b>Shop Name:</b></p></td>
			<td><p>I am Shop B</p></td>
		</tr>
		<tr>
			<td><p><b>Order ID:</b></p></td>
			<td><p>I am an order Id</p></td>
		</tr>
		<tr>
			<td><p><b>Dish</b></p></td>
			<td><p>
				dish 1 <br/>
				dish 2 <br/>
			</p></td>
		</tr>
		<tr>
			<td><p><b>Client Name:</b></p></td>
			<td><p>I am a client</p></td>
		</tr>
		<tr>
			<td><p><b>Client Contact:</b></p></td>
			<td><p>I am a client contact</p></td>
		</tr>
		<tr>
			<td><p><b>Detail:</b></p></td>
			<td><p>I am a compaint detail</p></td>
		</tr>
		<tr>
			<td><p><b>Complaint Time:</b></p></td>
			<td><p>I am a complaint time</p></td>
		</tr>
		<tr>
			<td><p><b>Complaint Status:</b></p></td>
			<td><p>Pending/backlist Merchant/Rejected</p></td>
		</tr>
		<tr>
			<td></td>
			<td><p><input type="submit" value="Pending" class="btn btn-default"><input type="submit" value="Backlist Merchant" class="btn btn-default"><input type="submit" value="Rejected" class="btn btn-default"></p></td>
		</tr>
	</table>
		
        <table class="largeThumb commentBox">
		<tr>
			<td colspan="2"><h4 class="form_title">-Customer Complain-</h4></td>
		</tr>
		<tr>
			<td><p><b>Shop Name:</b></p></td>
			<td><p>I am Shop B</p></td>
		</tr>
		<tr>
			<td><p><b>Order ID:</b></p></td>
			<td><p>I am an order Id</p></td>
		</tr>
		<tr>
			<td><p><b>Dish</b></p></td>
			<td><p>
				dish 1 <br/>
				dish 2 <br/>
			</p></td>
		</tr>
		<tr>
			<td><p><b>Client Name:</b></p></td>
			<td><p>I am a client</p></td>
		</tr>
		<tr>
			<td><p><b>Client Contact:</b></p></td>
			<td><p>I am a client contact</p></td>
		</tr>
		<tr>
			<td><p><b>Detail:</b></p></td>
			<td><p>I am a compaint detail</p></td>
		</tr>
		<tr>
			<td><p><b>Complaint Time:</b></p></td>
			<td><p>I am a complaint time</p></td>
		</tr>
		<tr>
			<td><p><b>Complaint Status:</b></p></td>
			<td><p>Pending/backlist Merchant/Rejected</p></td>
		</tr>
		<tr>
			<td></td>
			<td><p><input type="submit" value="Pending" class="btn btn-default"><input type="submit" value="Backlist Merchant" class="btn btn-default"><input type="submit" value="Rejected" class="btn btn-default"></p></td>
		</tr>
	</table>
	</div>
</div>
</body>
</html>