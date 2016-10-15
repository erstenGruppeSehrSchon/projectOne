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
</head>
<body>
<div class="container">
  <header>
    <div id="logo"><a href="./adminIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="#">Search</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="Logout">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<table id = "adminContainerShowResult" class = "table">
	<tr>
		<th>User Id</th>
		<th>User Name</th>
		<th>Status</th>
		<th>Edit</th>
	</tr>		
	<c:forEach var="merchant" items="${aMerchants}">
		<tr>
			<td><a href="showMerchantDetails?id=${merchant.mid}">${merchant.mid}</a></td>
			<td><a href="showMerchantDetails?id=${merchant.mid}">${merchant.name}</a></td>
			<td>${merchant.status}</td>
			<th><a href="showMerchantDetails?id=${merchant.mid}" class="btn btn-default">Edit</a></th>
		</tr>
	</c:forEach>
</table>
  </div>
</div>
</body>
</html>