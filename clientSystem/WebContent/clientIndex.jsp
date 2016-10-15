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
<<<<<<< HEAD
<div class="container">
  <header>
    <div id="logo"><a href="./clientIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <!--<li><a href="#">Search</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>-->
    </ul>
  </nav>
  <div id="main">
	<table>
	<c:forEach var="dish" items="${dishs}">
=======
<div class = "headerBar">
	<div>
		<h3>-Qing Mi Ji Rou Chang-</h3>
		<h4>Client Page</h4>
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
<div class = "container">

<table id = "clientContainerIndexView">
	<c:forEach var="dish" items="${dishes}">
>>>>>>> Client_clientIndex
		<tr>
			<td colspan="3"><h3>-${dish.name}-</h3></td>
		</tr>
		<tr>
<<<<<<< HEAD
			<c:forEach var="dishImage" items="${dish.images}">
				<td><a href="showdish?MerchantId=${dish.sid}& DishId=${dish.did"}></a><img src="${disImage.imgPath}"/></td>
=======
			<c:forEach var="dishImage" items="${dish.dishImages}">
				<td><a href="showDish?merchantId=${dish.sid}&dishId=${dish.did}"><img src="${dishImage.imgPath}"/></td>
>>>>>>> Client_clientIndex
			</c:forEach>
		</tr>
	</c:forEach>
	</table>
  </div>
</div>
</body>
</html>