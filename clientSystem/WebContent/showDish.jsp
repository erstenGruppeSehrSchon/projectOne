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
    <div id="logo"><a href="ShowAllDishes"><img src="img/logo.png" alt=""></a></div>
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
				<p>Name: ${dish.name}</p>
				<!--<p>Like Dislike</p>-->
				<p>Type:  ${dish.type}</p>
				<p>Price:  ${dish.price}</p>
				<p>Active:  ${dish.active}</p>
			</td>
			<td>
				<c:forEach var="dishImage" items="${dish.dishImages}">
					<img src="${dishImage.imgPath}" />
				</c:forEach>
			</td>
			<td>
				<p>-Merchant-</p>
				<a href = "showmerchant?MerchantId=${merchant.mid}"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a>
				<p><b>Name:</b> ${merchant.name}</p>
				<p><b>shop:</b> <a href="showshop?ShopId=${shop.sid}">${shop.name}</a></p>
			</td>
		</tr>
	</table>
  </div>
</div>
</body>
</html>