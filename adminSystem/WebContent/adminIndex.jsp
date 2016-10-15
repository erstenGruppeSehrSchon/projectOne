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
		  <li><a href="./adminLogin.jsp">Logout</a></li>
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
			<c:forEach var="merchant" items="${aMerchants}">
				<tr>
					<td><a href = "showMerchantDetails?id=${merchant.mid}">${merchant.name}</a></td>
					<td><a href = "updateMerchantStatus?id=${merchant.mid}&status=Accepted"><button class = "btn">Accept</button></a></td>
					<td><a href = "updateMerchantStatus?id=${merchant.mid}&status=Rejected"><button class = "btn">Reject</button></a></td>
				</tr>
			</c:forEach>
		</table>
		${message}
		</td>
		<td>
			<form action="SearchMerchantByCriteria" method="get">
				<table>
					<tr><td>Merchant Id:</td><td><input type="text" name="id" id="searchMerchantId" class="form-control"/></td></tr>
					<tr><td>Merchant Name:</td><td><input type="text" name="name" id="searchMerchantName" class="form-control"/></td></tr>
					<tr><td>Age:</td>
						<td>
							<select name="ageIndex" class="form-control">
							  <option value="0" selected></option>
							  <option value="1">0-20</option>
							  <option value="2">21-40</option>
							  <option value="3">40-60</option>
							  <option value="4">60-80</option>
							  <option value="5">80-100</option>
							</select>
						</td></tr>
					<tr><td>Gender:</td>
						<td>
							<select name="gender" class="form-control">
							  <option value="%" selected></option>
							  <option value="M">M</option>
							  <option value="F">F</option>
							  <option value="Unknown">Unknown</option>
							</select>
						</td>
					</tr>
					<tr><td>Registration Date:</td><td><input type="date" name="regDate" id="searchMerchantRegistrationDate" class="form-control"></td></tr>
				</table>
				<button class = "btn">Search</button>
			</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>