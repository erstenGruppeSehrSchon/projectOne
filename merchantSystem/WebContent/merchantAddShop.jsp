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
    <div id="logo"><a href="showIndex?mid=${mid }"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
   <ul id="nav">
      <li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="showAllShop?mid=${mid}">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="showProfile?mid=${mid}">My Profile</a></li>
      <li><a href="./merchantLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<h3>Add new Shop</h3>
	<div class="merchant-form-control">
	<form action = "addShop" method = "post">
	<input type="hidden" value = "" id = "dishesRegShopId"/>
	<input type="hidden" name="mid" value = "${mid}" />
	<table>
		<tr>
			<td>Shop Name</td>
			<td><input id="shopRegName" type="text" class="form-control"></td>
		</tr>
		<tr>
			<td>Description</td>
			<td><textarea id = "shopRegDescription" class="form-control" rows="6" cols="50"></textarea></td>
		</tr>
		<tr>
			<td>Contact Type</td>
			<td>
				<select id="shopContactType" name="shopContactType" class="form-control">
				  <option value="email">Email</option>
				  <option value="tel">Tel</option>
				  <option value="address">Address</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Contact Information</td>
			<td>
				<input id="shopContactInformation" type="text" class="form-control">
			</td>
		</tr>
		<tr>
			<td>Shop image:</td>
			<td>
			<form action="FileUpload" method="POST" enctype="multipart/form-data">
			<label class="btn btn-default">
				 Choose<input type="file" name="shopPicFile" style="display: none;">
			</label>
			</form>
			</td>
		</tr>
		
		<!--<tr>
			<td rowspan="2">
			<input type="submit" class ="btn"/>
			<button class ="btn">Submit</button>
			<input type="submit" value="Submit" class="btn btn-default">
			</td>
		</tr>-->
	</table>
	<br/>
	<br/>
	${errorMsg}
	<br/>
	<br/>
	<!--<input type="submit" class ="btn"/>-->
	<!--<button class ="btn">Submit</button>-->
	<input type="submit" value="Submit" class="btn btn-default">
	</form>
	
	</div>
  </div>
</div>
</body>
</html>