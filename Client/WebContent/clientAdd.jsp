<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -client System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	var countAddAddress = 1;
	function addAddress() {
		countAddAddress++;
		
		var p = "<p>Address "+countAddAddress+":</p>";
		var country = "<input id=\"addressBoxCountry"+countAddAddress+"\" name=\"addressBoxCountry"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Country\">";
		var city = "<input id=\"addressBoxCity"+countAddAddress+"\" name=\"addressBoxCity"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"City\">";
		var district = "<input id=\"addressBoxDistrict"+countAddAddress+"\" name=\"addressBoxDistrict"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"District\">";
		var street = "<input id=\"addressBoxStreet"+countAddAddress+"\" name=\"addressBoxStreet"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Street\">";
		var building = "<input id=\"addressBoxBuilding"+countAddAddress+"\" name=\"addressBoxBuilding"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Building\">";
		var room = "<input id=\"addressBoxRoom"+countAddAddress+"\" name=\"addressBoxRoom"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Room\">";
		
		var div = document.createElement("div");
		div.setAttribute("id", "addressBox"+countAddAddress);
		div.setAttribute("name", "addressBox");
		
		div.innerHTML = p + country + city + district + street + building + room;
		
		
		document.getElementById("addressBox"+(countAddAddress-1)).appendChild(div);
	
	}
	</script>
</head>
<body>
<jsp:include page="./headerGuest.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********Edit profile form*********-->
	<div class="clientForm">
		<form method="post" action="">
			<table>
					<tr>
						<td colspan="2"><h3 class="h3_title_index">-Registration-</h3></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Username</h4></td>
						<td><input id="clientUsername" name="clientUsername" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Password</h4></td>
						<td><input id="clientPassword" name="clientPassword" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Re-enter Password</h4></td>
						<td><input id="clientrePassword" name="clientPassword" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Address</h4>
						<span class="glyphicon glyphicon-plus" onclick="addAddress()"></span></td>
						<td id = "addressList">
							<div name="addressBox" id="addressBox1">
								<p>Address 1:</p>
								<input id="addressBoxCountry1" name="addressBoxCountry1" type="text" class="form-control" placeholder="Country">
								<input id="addressBoxCity1" name="addressBoxCity1" type="text" class="form-control" placeholder="City">
								<input id="addressBoxDistrict1" name="addressBoxDistrict1" type="text" class="form-control" placeholder="District">
								<input id="addressBoxStreet1" name="addressBoxStreet1" type="text" class="form-control" placeholder="Street">
								<input id="addressBoxBuilding1" name="addressBoxBuilding1" type="text" class="form-control" placeholder="Building">
								<input id="addressBoxRoom1" name="addressBoxRoom1" type="text" class="form-control" placeholder="Room">
							</div>
						</td>
					</tr>
					<tr>
						<td rowspan="2"><input type="submit" value="Register" class="btn btn-default"></td>
					</tr>
			</table>
		</form>		
	</div>
</div>

</body>
</html>