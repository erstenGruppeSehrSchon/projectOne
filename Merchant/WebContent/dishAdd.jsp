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
	<!--*********add ads form*********-->
	<div class="merchantForm">
		<form name="merchanAddShopForm" method="post" action="">
			<table>
			<tr>
				<td colspan="2"><h3 class="h3_title_index">-Add Dish-</h3></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dishes Type: </h4></td>
				<td><input type="text" name="editDishType" class = "form-control"/></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dishes Prices:</h4></td>
				<td><input type="text" name="editDishPrices" class = "form-control"/></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dishes Status:</h4></td>
				<td><input type = "text" name="editDishStatus" class = "form-control" value=""/>
				</td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dishes Description:</h4></td>
				<td><input type = "text" name="editDishesDescription" class = "form-control" value=""/>
				</td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dishes Image:</h4></td>
				<td><form action="FileUpload" enctype="multipart/form-data">
				<label class="btn btn-default">
					 Choose<input type="file" name="addDishImg" style="display: none;">
				</label>
				</form></td>
			</tr>
              <tr>
                  <td></td>
                  <td><input type="submit" value="Submit" onclick=""  /></td>
              </tr>
			</table>
		</form>		
	</div>
</div>

</body>
</html>