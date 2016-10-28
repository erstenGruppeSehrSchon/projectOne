<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -Merchant System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp" />

<!--*********container*********-->
<div class="container">
<jsp:include page="menu.jsp" />

	<!--*********Dish*********--> <!-- THREE IN ONE LINK -->
	<div class="mydish">
		<h3 class="h3_title_index" id = "dishname"></h3>
		<table class="largeThumb">
			<tr>
				<td>
					<p><h4 class="form_title">Dishes Type :</h4><p id = "dishtype"></p></p>
					</br>
					<p><h4 class="form_title">Dishes Prices :</h4><p id = "dishprice"></p></p>
					</br>
					<p><h4 class="form_title">Dishes Status :</h4><p id = "dishstatus"></p></p>
					</br>
					<p><h4 class="form_title">Dishes Description:</h4><p id = "dishdes"></p></p>
				</td>
				<td><img src=  "http://www.foodmanufacture.co.uk/var/plain_site/storage/images/publications/food-beverage-nutrition/foodmanufacture.co.uk/npd/top-10-functional-food-trends/11097085-1-eng-GB/Top-10-functional-food-trends_strict_xxl.jpg"/></td>
			</tr>
			<tr>
				<td id="orderDishDiv">
				<p>Quantity: <input type="number" name="quantity" min="1" max="100" id = "quantity"></input></br>
				<input type="submit" value="Add to Cart" id = "order"/></p>
				</td>
				<td></td>
			</tr>
		</table>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>

<div class="container">
	<!--*********Dish*********--> <!-- THREE IN ONE LINK -->
	<div class="mydish">
		<h3 class="h3_title_index">- Shop information -</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<p><a href="./shopDetails.jsp"><h4 class="form_title">Shop Name :</h4><p id = "shopname"></p></a></p>
					</br>
					<p><h4 class="form_title">Shop Address :</h4> <p id = "shopaddress"></p></p>
					</br>
					<p><h4 class="form_title">Shop Tels:</h4> <p id = "shoptel"></p></p>
					</br>
					<p><h4 class="form_title">Shop type:</h4> <p id = "shoptype"></p></p>
				</td>
				<td><img src=  "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></td>
			</tr>
		</table>
	</div>
</div>

<script>
var did ="${param.did}";
$(function(){
	$.ajax({
		type:'GET',
		url:'getDishByDid',
		data:{did:did},
		success:function(dish){
			$("#dishname").text(dish.name);
			$("#dishtype").text(dish.type);
			$("#dishprice").text(dish.price);
			$("#dishstatus").text(dish.status);
			$("#dishdes").text(dish.description);
			
		   
		    $.ajax({
		    	type:'GET',
		    	url:'getShopByDid',
		    	data:{did:did},
		    	success:function(shop){
		    		console.log(shop.merchant_id);
		    		$("#shopname").text(shop.name);
					$("#shoptype").text(shop.type);
					$("#shoptel").text(shop.shopContact.phone);
					$("#shopaddress").text(shop.shopContact.address);
					var sid = shop.sid;
					
		    		
		    	},error:function(){
		    		
		    	}
		    	
		    });
	
		},error:function(){
			
		}
		
	});
	
	
		$('#order').on('click',function(){
			
			$.ajax({
				type:'GET',
				url:'addOrder',
				data:{sid:sid}
				
			});
			
		});
		
	





});	


</script>
	
</body>
</html>