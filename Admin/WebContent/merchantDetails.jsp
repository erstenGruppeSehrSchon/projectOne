<!--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>!-->
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
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/merchantDetails.js"></script>
<script>
	$(function() {
		createButtons("${merchant.mid}", "${merchant.status}")
	});
</script>
</head>
<body>
<div class="container">

  <div>
	<table>
	<tr>		
		<th colspan = "3">-Merchant Information-</th>
	</tr>
	<tr>
		<td rowspan="7" class = "adminEditDetailsTableIcon"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></td>
		<td class = "adminEditDetailsTableColName">Merchant ID:</td>
		<td class = "adminEditDetailsTableInput">${merchant.mid}</td>
	</tr>
	<tr>
		<td>Merchant Name:</td>
		<td>${merchant.name}</td>
	</tr>
	<tr>
		<td>Birth Date:</td>
		<td>${merchant.birthDate}</td>
	</tr>
	<tr>
		<td>Gender:</td>
		<td>${merchant.gender}</td>
	</tr>
	<tr>
		<td>Registration Date:</td>
		<td>${merchant.regDate}</td>
	</tr>
	<tr>
		<td>Status:</td>
		<td id="statusCol">${merchant.status}</td>
	</tr>
	<tr>
		<td>Action:</td>
		<td id="actionCol">
		
		</td>
	</tr>
	</table>
  </div>
</div>
</body>
</html>