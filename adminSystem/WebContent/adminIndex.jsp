<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-Qing Mi Ji Rou Chang-</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href = "css/stylesheet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">

<!--JS-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "adminHeaderBar">
	<div>
		<h3>-Qing Mi Ji Rou Chang-</h3>
		<h4>Admin Page</h4>
	</div>
</div>
<div class="dropdown">
		<button class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span class = "glyphicon glyphicon-align-justify"></span>
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
		  <li><a href="#">Search</a></li>
		  <li class="divider"></li>
		  <li><a href="#">My Profile</a></li>
		  <li><a href="./adminLogin.html">Logout</a></li>
		</ul>
</div>
<div class = "adminContainer">
<table id = "adminContainerTable" border = "1">
	<tr>
		<td class = "adminContainerTableTitlte"><span class = "glyphicon glyphicon-user"></span> Outstanding List</td>
		<td class = "adminContainerTableTitlte"><span class = "glyphicon glyphicon-search"></span> Merchant Search</td>
	</tr>
	<tr>
		<td>
		<!-- subtable for user and status-->
		<table id = "adminContainerTableOutStandingList" class = "table table-striped">
			<c:forEach var="a" items="${am}">
				<tr>
					<td><a href = "#">${a.name}</a></td>
					<td><button class = "btn">Accept</button></td>
					<td><button class = "btn">Reject</button></td>
				</tr>
			</c:forEach>
		</table>
		</td>
		<td>
			<form action="" method="get">
				<table>
					<tr><td>Merchant Id:</td><td><input type="text" id="searchMerchantId" class="form-control"/></td></tr>
					<tr><td>Merchant Name:</td><td><input type="text" id="searchMerchantName" class="form-control"/></td></tr>
					<tr><td>Age:</td>
						<td>
							<select class="form-control">
							  <option value="volvo">0-20</option>
							  <option value="saab">21-40</option>
							  <option value="opel">40-60</option>
							  <option value="audi">60-80</option>
							  <option value="audi">80-100</option>
							</select>
						</td></tr>
					<tr><td>Gender:</td>
						<td>
							<select class="form-control">
							  <option value="M">M</option>
							  <option value="F">F</option>
							  <option value="Unknown">Unknown</option>
							</select>
						</td>
					</tr>
					<tr><td>Registration Date:</td><td><input type="date" id="searchMerchantRegistrationDate" class="form-control"></td></tr>
				</table>
			</form>
			<a href = "./adminSerachResult.html"><button class = "btn">Search</button></a>
		</td>
	</tr>
</table>
</div>
</body>
</html>