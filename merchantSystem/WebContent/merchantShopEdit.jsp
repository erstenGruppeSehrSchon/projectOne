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
	<h3>Edit shop: Shop Name</h3>
	<div class="merchant-form-control">
	<form action = "" method = "post">
	<table>
		<tr>
			<td>Shop Name</td>
			<td><input type = "text" class = "form-control" value="${shop.name}"/></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><input type = "text" class = "form-control" value="${shop.description}"/></td>
		</tr>
		<tr>
			<td>Contact Type</td>
			<td>
				<select class="form-control">
				  <option value="email">Email</option>
				  <option value="tel">Tel</option>
				  <option value="address">Address</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Contact Information</td>
			<td>
				<input type="text" class="form-control">
			</td>
		</tr>
		<tr>
			<td rowspan="2"><button type="submit">Edit</button></td>
		</tr>
	</table>
	</form>
	</div>
  </div>
</div>
</body>
</html>