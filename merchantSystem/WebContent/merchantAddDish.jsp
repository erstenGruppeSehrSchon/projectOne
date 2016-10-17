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
    <div id="logo"><a href="./merchantIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="./merchantShowAllShop.jsp">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="./merchantViewProfile.jsp">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<div class="merchant-form-control"><h3>Add new dish</h3>
	<form action = "AddDish" method = "post" enctype="multipart/form-data">
	<input type="hidden" value = "" id = "dishesRegShopId"/>
	<table id = "merchantRegTable">
		<tr>
			<td>Shop</td>
			<td>
				<select name="shopId">
					<c:forEach var="shop" items="${shops}">>
						<option value="${shop.sid}">${shop.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<c:if test="${shop != null}">
			<tr>
				<td>Dishes Name</td>
				<td><input id="dishesRegName" name="dishName" type="text" class="form-control"></td>
			</tr>
			<tr>
				<td>Dishes Type</td>
				<td>
				<select name="dishType" class="form-control">
						<option value="AU">Australia</option>
						<option value="AT">Austria</option>
						<option value="BE">Belgium</option>
						<option value="BR">Brazil</option>
						<option value="KH">Cambodia</option>
						<option value="CA">Canada</option>
						<option value="CN">China</option>
						<option value="HR">Croatia</option>
						<option value="CY">Cyprus</option>
						<option value="CZ">Czech Republic</option>
						<option value="DK">Denmark</option>
						<option value="EG">Egypt</option>
						<option value="EE">Estonia</option>
						<option value="FI">Finland</option>
						<option value="FR">France</option>
						<option value="DE">Germany</option>
						<option value="GR">Greece</option>
						<option value="HK">Hong Kong</option>
						<option value="IS">Iceland</option>
						<option value="IN">India</option>
						<option value="ID">Indonesia</option>
						<option value="IT">Italy</option>
						<option value="JP">Japan</option>
						<option value="KP">Korea, Democratic People's Republic of</option>
						<option value="LU">Luxembourg</option>
						<option value="MO">Macao</option>
						<option value="MX">Mexico</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Prices</td>
				<td><input id="dishesRegPrices" name="dishPrice" type="text" class="form-control"></td>
			</tr>
			<tr>
				<td>Dishes image:</td>
				<td>
				<!--<form action="FileUpload" method="POST" enctype="multipart/form-data">-->
				<!--  <label class="btn btn-default"> -->
					 Choose<input type="file" name="dishImage" style="display: none;">
				<!--  </label>-->
				</form>
				</td>
			</tr>
			<tr>
			<td>
				<!--<input type="submit" class ="btn"/>-->
				<!--<button class ="btn">Submit</button>-->
				<!--<a href="./merchantIndex.html" class="btn btn-default" rowspan="2">Submit</a>-->
				<button type="submit" class ="btn">Submit</button>
			</td>
			</tr>
		</c:if>
	</table>
	
	</form>
	</div>
	
  </div>
</div>
</body>
</html>