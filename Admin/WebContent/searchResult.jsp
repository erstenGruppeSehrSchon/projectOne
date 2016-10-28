<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -Admin System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/index.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
		<div class="container">
	<jsp:include page="menu.jsp" />

	<h3 class="h3_title_index">- Search Result -</h3>
	  <div>
		<table id = "searchResultTable" class = "table">
		<tr>
			<td><p class="form_title">Merchant ID</p></td>
			<td><p class="form_title">Merchant Name</p></td>
			<td><p class="form_title">Status</p></td>
			<td><p class="form_title">Edit</p></td>
		</tr>
		<c:forEach var="merchant" items="${merchants}">
			<tr>
				<td>${merchant.mid}</td>
				<td>${merchant.name}</td>
				<td>${merchant.status}</td>
				<th><a type="submit" href="showMerchantDetails?mid=${merchant.mid}" class="btn btn-default">Edit</a></th>
			</tr>
		</c:forEach>
		</table>
	  </div>
	</div>
</body>
</html>