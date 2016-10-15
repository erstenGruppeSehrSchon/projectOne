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
<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
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
		<tr>
			<td>
				<p>Name: ${Dish.name})</p>
				<!--<p>Like Dislike</p>-->
				<p>Type:  ${Dish.type}</p>
				<p>Price:  ${Dish.price}</p>
				<p>Active:  ${Dish.active}</p>
			</td>
			<td>
			 <img src="${DishImage.path}" />
			</td>
			<td>
				<p>-Merchant-</p>
				<a href = "showmerchant?MerchantId=${Merchant.mid}"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/>
				<p>Name: Merchant Name</p></img></a>
			</td>
		</tr>
	</table>
  </div>
</div>
</body>
</html>