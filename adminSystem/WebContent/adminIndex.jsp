<!--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>-->
<!DOCTYPE html>
<head>
<title>-SAUSAGE HOUSE-</title>
<meta charset="BIG5">
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
    <div id="logo"><a href="index.html"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="#">Search</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	 ${message}
	 <table border = "1">
		<tr>
			<th><span class = "glyphicon glyphicon-user"></span> Outstanding List</th>
			<th><span class = "glyphicon glyphicon-search"></span> Merchant Search</th>
		</tr>
		<tr>
			<td>
			<!-- subtable for user and status-->
			<table class = "table">
				<c:forEach var="merchant" items="${aMerchants}">
					<tr>
						<td><a href = "showMerchantDetails?id=${merchant.mid}">${merchant.name}</a></td>
						<td><a href = "updateMerchantStatus?id=${merchant.mid}&status=Accepted"><button class="btn btn-default">Accept</button></a></td>
						<td><a href = "updateMerchantStatus?id=${merchant.mid}&status=Rejected"><button class="btn btn-default">Reject</button></a></td>
					</tr>
				</c:forEach>
			</table>
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
					<button class="btn btn-default">Search</button>
				</form>
			</td>
		</tr>
	</table>
  </div>
</div>
</body>
</html>