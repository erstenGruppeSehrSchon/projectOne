<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-Qing Mi Ji Rou Chang-</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href = "css/stylesheet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.11.2/css/bootstrap-select.min.css">

<!--JS-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "headerBar">
	<div>
		<h3>-Qing Mi Ji Rou Chang-</h3>
		<h4>Merchant Page</h4>
	</div>
</div>
<div class="dropdown">
		<button class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span class = "glyphicon glyphicon-align-justify"></span>
		<span class="caret"></span></button>
		<ul class="dropdown-menu">
		  <li><a href="./merchantSearch.html">Search</a></li>
		  <li class="divider"></li>
		  <li><a href="./merchantShowAllShop.html">Manage My Shops</a></li>
		  <li><a href="./merchantShowAllDishes.html">Manage My Dishes</a></li>
		  <li class="divider"></li>
		  <li><a href="./merchantViewProfile.html">My Profile</a></li>
		  <li><a href="./merchantLogin.html">Logout</a></li>
		</ul>
</div>
<div class = "container">
<table id = "merchanIndexContainerIndexView">
	<div>
		<table id = "merchanIndexTable">
			<tr>
				<td><a href="./merchantViewProfile.html"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></a></td>
				<td>
					<h3>Name: </h3>
					<p>E-mail:</p>
					<p>Number of Shops:</p>
					<p>Number of Dishes:</p>
				</td>
			</tr>
			<tr>
				<td>My Latest Shops:   <a href = "./merchantAddShop.html"><span class = "glyphicon glyphicon-plus"></span></a></td>
			</tr>
			<tr>
				<td colspan = "2">
				<table id = "merchanIndexTableShowShop">
				<tr>
				<td>
					<a href = "./merchantShowShop.html"><p>name of shop 1</p>
					<img src="https://buffaloeats.files.wordpress.com/2012/02/front-store.jpg"></a>
				</td>
				<td>
					<a href = "./merchantShowShop.html"><p>name of shop 2</p>
					<img src="https://4feet2mouths.files.wordpress.com/2013/11/2013-05-07-06-06-living-in-chicago-044.jpg"></a>
				</td>
				<td>
					<a href = "./merchantShowShop.html"><p>name of shop 3</p>
					<img src="http://l7.alamy.com/zooms/6463a649b9f741ca9f3e25da576a9ec6/bath-sausage-shop-uk-e9nxbb.jpg"></a>
				</td>
				</table>
				</td>
				</tr>
			</tr>
			<tr>
				<td>My Latest dishes:   <a href = "./merchantAddDishes.html"><span class = "glyphicon glyphicon-plus"></span></a></td>
				<tr>
				<td colspan = "2">
				<table id = "merchanIndexTableShowShop">
				<tr>
				<td>
					<a href = "./merchantShowDish.html"><p>name of dish 1</p>
					<img src="https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"></a>
				</td>
				<td>
					<a href = "./merchantShowDish.html"><p>name of dish 2</p>
					<img src="http://szepuikee.com.hk/content/up-products-images/98/600x600/1_848e38aeb8.jpg"></a>
				</td>
				<td>
					<a href = "./merchantShowDish.html"><p>name of dish 3</p>
					<img src="http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"></a>
				</td>
				</table>
				</td>
				</tr>
			</tr>
			</tr>
		</table>
	</div>
</table>
</div>
</body>
</html>