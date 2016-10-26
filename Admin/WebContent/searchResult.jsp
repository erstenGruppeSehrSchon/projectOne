<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-SAUSAGE HOUSE-</title>
<meta name="viewport" content="width=device-width">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="css/stylesheet.css">
<script src="/js/searchResult.js"></script>
</head>
<body>
<div class="container">
  <div>
	<table id = "searchResultTable" class = "table">
	<tr>
		<th>Merchant ID</th>
		<th>Merchant Name</th>
		<th>Status</th>
		<th>Edit</th>
	</tr>
	<c:forEach var="merchant" items="${merchants}">
		<tr>
			<td>${merchant.mid}</td>
			<td>${merchant.name}</td>
			<td>${merchant.status}</td>
			<th><a href="showMerchantDetails?mid=${merchant.mid}" class="btn btn-default">Edit</a></th>
		</tr>
	</c:forEach>
</table>
  </div>
</div>
</body>
</html>