<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!--*********container*********-->
<div class="container">
<jsp:include page="menu.jsp" />

	<!--*********Dish*********--> <!-- THREE IN ONE LINK -->
	<div class="mydish">
		<h3 class="h3_title_index">${dish.name}</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<p><h4 class="form_title">Dish Type :</h4>${dish.type}</p>
					</br>
					<p><h4 class="form_title">Dish Price :</h4>${dish.price}</p>
					</br>
					<p><h4 class="form_title">Dish Description:</h4>${dish.description}</p>
				</td>
				<td>
					<c:forEach var="dishImage" items="${dish.dishImages}">
						<img src="${dishImage.imgPath}" />
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<form action="removeDish" method="post">
						<input type="hidden" name="did" value="${dish.did}" />
						<input type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>	
</body>
</html>