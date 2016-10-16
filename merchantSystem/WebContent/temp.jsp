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
      <li><a href="#">Search</a></li>
      <li><a href="#">Manage My Shops</a></li>
      <li><a href="#">Manage My Dishes</a></li>
      <li><a href="#">My Profile</a></li>
      <li><a href="./adminLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<h3>Shop name: </h3>
		<table class="index-show-merchant">
			<tr>
				<td>-Description-</td>
				<td rowspan = "3" class="index-show-merchant-icon"><img src=  "https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"/></td>
			</tr>
			<tr>
				<td>Hi here is description...</td>
			</tr>
			<tr>
				<td><a href="./merchantShopEdit.html" class="btn btn-default">Edit</a></td>
			</tr>
		</table>
		<div class="block-divider-index"></div>
		<h4>Dishes in this shop</h4>
		<table class="index-show-latest show-border">
			<tr>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
			</tr>
			<tr>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
				<td><a href = "./merchantShowDish.html"><p>Dish 1</p><img width = "300px" src=  "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></a></td>
			</tr>
		</table>
  </div>
</div>
</body>
</html>