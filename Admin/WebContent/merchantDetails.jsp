<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<script src="js/merchantDetails.js"></script>
<script>
	$(function() {
		createButtons("${merchant.mid}", "${merchant.status}")
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
	<jsp:include page="menu.jsp" />

	<table class= "largeThumb">
	<tr>		
		<td colspan = "3"><h3 class="h3_title_index">-Merchant Information-</h3></td>
	</tr>
	<tr>
		<td rowspan="7" class = "adminEditDetailsTableIcon"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></td>
		<td class = "adminEditDetailsTableColName"><p class="form_title">Merchant ID:</p></td>
		<td class = "adminEditDetailsTableInput"><p>${merchant.mid}</p></td>
	</tr>
	<tr>
		<td><p class="form_title">Merchant Name:</p></td>
		<td><p>${merchant.name}</p></td>
	</tr>
	<tr>
		<td><p class="form_title">Birth Date:</p></td>
		<td><p>${merchant.birthDate}</p></td>
	</tr>
	<tr>
		<td><p class="form_title">Gender:</p></td>
		<td><p>${merchant.gender}</p></td>
	</tr>
	<tr>
		<td><p class="form_title">Registration Date:</p></td>
		<td><p>${merchant.regDate}</p></td>
	</tr>
	<tr>
		<td><p class="form_title">Status:</p></td>
		<td id="statusCol"><p>${merchant.status}</p></td>
	</tr>
	<tr>
		<td><p class="form_title">Action:</p></td>
		<td id="actionCol">
			
		</td>
	</tr>
	</table>
 
</div>
</body>
</html>