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
<h4>Search Criteria: </h4>
<table id = "adminContainerShowResult" class = "table">
	<tr>
		<th>User Id</th>
		<th>User Name</th>
		<th>Status</th>
		<th>Edit</th>
	</tr>		
	<c:forEach var="merchant" items="${aMerchants}">
		<tr>
			<td><a href="./showMerchantDetails.html">${merchant.id}</a></td>
			<td><a href="./showMerchantDetails.html">${merchant.name}</a></td>
			<td>${merchant.status}</td>
			<th><a href="./editMerchantDetails.html" class="btn btn-default">Edit</a></th>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>