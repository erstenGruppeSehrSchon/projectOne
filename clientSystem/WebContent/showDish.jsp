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
  <br/>
	<table id="show-dish-table">
		<tr>
			<td>
				<p><b>Name:</b> ${dish.name}</p>
				<!--<p>Like Dislike</p>-->
				<p><b>Type:</b>  ${dish.type}</p>
				<p><b>Price:</b>  ${dish.price}</p>
				
				<p><b>Active:</b>
				<c:choose>
				    <c:when test="${dish.active == '1'}">
				        Yes
				    </c:when>    
				    <c:otherwise>
				    	No
				    </c:otherwise>
				</c:choose>
				</p>
			</td>
			<td>
				<c:forEach var="dishImage" items="${dish.dishImages}">
					<img src="${dishImage.imgPath}" />
				</c:forEach>
			</td>
			<tr>
			<tr>
				<td colspan="2"><div class="block-divider-index"></div></td>
			</tr>
			<td>
				<p>-Merchant-</p>
				<a href = "showmerchant?MerchantId=${merchant.mid}"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a>
			</td>
			<td>
				<p><b>Name:</b> <a href = "showmerchant?MerchantId=${merchant.mid}">${merchant.name}</a></p>
				<p><b>shop:</b> <a href="showshop?ShopId=${shop.sid}">${shop.name}</a></p>
			</td>
			</tr>
		</tr>
	</table>
  </div>
</div>
</body>
</html>