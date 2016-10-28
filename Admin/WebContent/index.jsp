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
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<!--*********container*********-->
<div class="container">
	<jsp:include page="menu.jsp" />

	
	<!--*********outstanding List and sample search*********--> <!-- THREE IN ONE LINK -->
	<div class=recommendShop>
		<table border = "1" class = "largeThumb">
		<tr>
			<th><h3 class="h3_title_index"><span class = "glyphicon glyphicon-user"></span> Outstanding List</h3></th>
			<th><h3 class="h3_title_index"><span class = "glyphicon glyphicon-search"></span> Merchant Search</h3></th>
		</tr>
		<tr>
			<td>
			<table id="outstandingTable" class = "table">

			</table>
			</td>
			<td>
				<form action="searchMerchants" method="get">
					<table>
						<tr><td><p class = "form_title">Merchant Id:</p></td><td><input type="text" name="id" id="searchMerchantId" class="form-control"/></td></tr>
						<tr><td><p class = "form_title">Merchant Name:</p></td><td><input type="text" name="name" id="searchMerchantName" class="form-control"/></td></tr>
						<tr><td><p class = "form_title">Age:</p></td>
							<td>
								<select name="ageIndex" class="form-control" type="select">
								  <option value="0" selected></option>
								  <option value="1">0-20</option>
								  <option value="2">21-40</option>
								  <option value="3">40-60</option>
								  <option value="4">60-80</option>
								  <option value="5">80-100</option>
								</select>
							</td></tr>
						<tr><td><p class = "form_title">Gender:</p></td>
							<td>
								<select name="gender" class="form-control" type="select">
								  <option value="0" selected></option>
								  <option value="M">M</option>
								  <option value="F">F</option>
								  <option value="Unknown">Unknown</option>
								</select>
							</td>
						</tr>
						<tr><td><p class = "form_title">Registration Date:</p></td><td><input type="date" name="regDate" id="searchMerchantRegistrationDate" class="form-control"></td></tr>
					</table>
					<button class="btn btn-default">Search</button>
				</form>
			</td>
		</tr>
	</table>
	</div>
</div>
</body>
</html>