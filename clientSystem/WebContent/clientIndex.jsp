<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<tr>
			<td colspan="3"><h3>-${dish.name}-</h3></td>
		</tr>
		<tr>
			<c:forEach var="dishImage" items="${dish.dishImages}">
				<td><a href="showDish?merchantId=${dish.sid}&dishId=${dish.did}"><img src="${dishImage.imgPath}"/></td>
			</c:forEach>
		</tr>
	</c:forEach>
	<!--
	<tr>
		<td colspan="3"><h3>-雞肉腸-</h3></td>
	</tr>
	<tr>
		<td><img src = "https://g-search2.alicdn.com/bao/uploaded/i2/18451023137110950/T1RBSCXDtgXXXXXXXX_!!0-item_pic.jpg_240x240q50"/></td>
		<td><img src = "http://szepuikee.com.hk/content/up-products-images/98/600x600/1_848e38aeb8.jpg"/></td>
		<td><img src = "http://commune.server239.com/products_pic/080014.jpg"/></td>
	</tr>
	<tr>
		<td colspan="3"><h3>-豬肉腸-</h3></td>
	</tr>
	<tr>
		<td><img src = "http://www.elders.com.cn/wp-content/uploads/2013/03/28460-964.jpg"/></td>
		<td><img src = "http://img.zhuyun.cn/M00/58/60/wKgJNFVXBjmAf_WSAAYgIWHSMdE689.png"/></td>
		<td><img src = "http://sadia.com.hk/sites/sadiahk/files/styles/product/public/products/cheddar_pork_sausage_b.png?itok=SUjYxDvZ"/></td>
	</tr>
	-->
</table>
</div>
</body>
</html>