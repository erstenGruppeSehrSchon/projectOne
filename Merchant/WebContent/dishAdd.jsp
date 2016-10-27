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

	<!--*********add ads form*********-->
	<div class="merchantForm">
		<form method="post" action="addDish" enctype="multipart/form-data">
			<table>
			<tr>
				<td colspan="2"><h3 class="h3_title_index">-Add Dish-</h3></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dish Name: </h4></td>
				<td><input type="text" name="name" class = "form-control" /></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dish Type: </h4></td>
				<td>
					<select name="type" class="form-control">
						<option value="appetizer">appetizer</option>
						<option value="soup">soup</option>
						<option value="main dish">main dish</option>
						<option value="dessert">dessert</option>
						<option value="beverage">beverage</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dish Price:</h4></td>
				<td><input type="number" step="0.1" min="0" name="price" class = "form-control" /></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dish Description:</h4></td>
				<td><input type = "text" name="description" class = "form-control" value=""/>
				</td>
			</tr>
			<tr>
				<td><h4 class="form_title">Dish Image:</h4></td>
				<td>
					 <input type="file" name="files" multiple="multiple" />
				</td>
			</tr>
              <tr>
                  <td><input type="hidden" name="sid" value="${shop.sid}" /></td>
                  <td><input type="submit" value="Submit"/></td>
              </tr>
			</table>
		</form>		
	</div>
</div>

</body>
</html>