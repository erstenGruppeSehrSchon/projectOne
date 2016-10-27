<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<script src="js/shopEdit.js"></script>
	<script>
		$(function() {
			setTypeValue("${shop.type}");
		});
	</script>
</head>
<body>
<jsp:include page="./header.jsp" />
<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<!--*********add ads form*********-->
	<div class="merchantForm">
		<form method="post" action="updateShop">
			<table>
			<tr>
				<td colspan="2"><h3 class="h3_title_index">-Edit Shop-</h3></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Shop Name:</h4></td>
				<td><input type="text" name="name" class = "form-control" value="${shop.name}"/></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Shop Type:</h4></td>
				<td>
                   	<select type="select" class="form-control" name="type" id="shopTypeSelect">
                   		<option value="Convenience Store">Convenience Store</option>
						<option value="Cantonese Restaurant">Cantonese Restaurant</option>
						<option value="Chinese Restaurant">Chinese Restaurant</option>
						<option value="Western Restaurant">Western Restaurant</option>
						<option value="African Restaurant">African Restaurant</option>
						<option value="Hotel">Hotel</option>
						<option value="Maid Cafe">Maid Cafe</option>
						<option value="Cross-dressing Cafe">Cross-dressing Cafe</option>
                   	</select>
                </td>
			</tr>
			<tr>
				<td><h4 class="form_title">Description:</h4></td>
				<td><input type="textarea" name="description" class = "form-control" value="${shop.description}"/></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Contact Information:</h4></td>
				<td><input type = "text" name="phone" class = "form-control" value="${shop.shopContact.phone}" placeholder="Phone" />
				<input type = "text" name="address" class = "form-control" value="${shop.shopContact.address}" placeholder="Address" /></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Opening Time:</h4></td>
				<td><input type="time" name="openTime" value="<fmt:formatDate value="${shop.openTime}" pattern="HH:mm" />" /></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Closing Time:</h4></td>
				<td><input type="time" name="closeTime" value="<fmt:formatDate value="${shop.closeTime}" pattern="HH:mm" />" /></td>
			</tr>
			<tr>
			    <td><input type="hidden" name="sid" value="${shop.sid}" /></td>
			    <td><input type="submit" value="Submit" /></td>
			</tr>
			</table>
		</form>		
	</div>
</div>

</body>
</html>