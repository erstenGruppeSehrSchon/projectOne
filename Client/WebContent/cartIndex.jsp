<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="./header.jsp" />

<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<!--*********My Order*********--><!-- 1 in one line -->
	<div class=myOrder>
	
		<h3 class="h3_title_index">- My Order -</h3>
		
		
		
		<!-- one table for one order -->
		<table class="largeThumb">
			<tr>
				<td>
					<p>Order number: </p><p></p>
					<p>Order Time: </p><p></p>
					<p>Merchant Name: </p><p></p>
					<p>Receiver Name: </p><p></p>
					<p>Delivery Address: </p><p></p>
					<p>Total Prices: </p><p></p>
				</td>
				<td>
					<b><p>Shop name: </p><p></p></b>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
				</td>
			</tr>
			<tr>
				<td><p><b>Status: </b></p>z.b: waiting for order<p></p></td>
				<td>
				<input type="submit" value="Order Confirm" onclick="ratingBoxShow(1)" />
				<input type="submit" value="Delete Order" onclick="" />
				<input type="submit" value="Give Comment" onclick="commentBoxShow(1)" />
				</td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "ratingBox1"></div></td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "commentBox1"></div></td>
			</tr>
		</table>
		
		<div class="block-divider-index"></div>
		
		<!-- Order 2 -->
		<table class="largeThumb">
			<tr>
				<td>
					<p>Order number: </p><p></p>
					<p>Order Time: </p><p></p>
					<p>Merchant Name: </p><p></p>
					<p>Receiver Name: </p><p></p>
					<p>Delivery Address: </p><p></p>
					<p>Total Prices: </p><p></p>
				</td>
				<td>
					<b><p>Shop name: </p><p></p></b>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
					<p>Dish: </p><p></p>
				</td>
			</tr>
			<tr>
				<td><p><b>Status: </b></p>z.b: waiting for order<p></p></td>
				<td>
				<input type="submit" value="Order Confirm" onclick="ratingBoxShow(2)" />
				<input type="submit" value="Delete Order" onclick="" />
				<input type="submit" value="Give Comment" onclick="commentBoxShow(2)" />
				</td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "ratingBox2"></div></td>
			</tr>
			<tr>
			    <td></td>
			    <td><div id = "commentBox2"></div></td>
			</tr>
			
		
			
		</table>
		
		<div id = "orderList"></div>
		
	</div>
</div>
<script>



$(function(){
	
	var orderList = getSessionChart();
	$.each(orderList,function(index,value){
		

		
		
		
		 var tableOP = $('<table>');
         $(tableOP).appendTo('#orderList');
		 $('<tr>').appendTo('#orderList');
		
		 $('<td><p>Order Dish Name:</p><p>'+ orderList[index].name + 
	       '</p>' + '<p>Order Dish Type:</p><p>'+ orderList[index].type + 
	       '</p>' + '<p>Order Dish Price:</p><p>'+ orderList[index].price + 
	       '</p></td>').appendTo('#orderList');
		 
		 $('</tr>').appendTo('#orderList');
		 
		 $('<tr>').appendTo('#orderList');
		 	
		 $('<td><input type = "submit" value ="Order Confirm"  onclick = "" /> <input type = "submit" value ="Delete Order"  onclick = "" /> <input type = "submit" value ="Give Comment"  onclick = "" /></td>').appendTo('#orderList');
		 
		 $('</tr>').appendTo('#orderList');
		var tableEND = $('</table>');
        $(tableEND).appendTo('#orderList');
		
	});
	
});

function commentBoxShow(boxId) {
    var div = document.getElementById("commentBox"+boxId);
    var p = "</br><p>Comment:</p>";
    var textarea = "<textarea rows=\"4\" cols=\"50\"></textarea>";
    var button = "</br><input type=\"submit\" value=\"Submit\"/>";
    div.innerHTML = p + textarea + button;
}

function ratingBoxShow(boxId) {
	var div = document.getElementById("ratingBox"+boxId);
    var p = "</br><p>Rating:</p>";
    var rating = "<input type=\"number\" name=\"rating\" min=\"1\" max=\"5\">";
    var button = "</br><input type=\"submit\" value=\"Submit\"/>";
    div.innerHTML = p + rating + button;
}

function getSessionChart(){
	var orderArray = JSON.parse(localStorage.getItem("orderObj"));
	if (orderArray===null){
		console.log("no Added Chart");
		return null;
	}else{
		console.log(orderArray);
		return orderArray;
	}
}

function getAllChart (){
	
	   document.getElementById("orderList").innerHTML = '';
		

    $.ajax({
 	   type:'GET',
 	   url:'getAllOrder',
 	   success: function(orderList){
 		      
 		   	  if(!(orderList[0].name)){
 			  
 				  var tableOP = $('<table>');
                   $(tableOP).appendTo('#orderList');
                   
                   $.each(orderList, function(index, value){
                 	  
                 	                   
                       // open of new row
                       if(index % 3 == 0){
                           var rowOP = $('<tr>');
                           $(rowOP).appendTo('#orderList'); 
                       }
                       

                       
                    var oid = orderList[i].oid;
       				var status = orderList[i].status;
       				var orderTime = orderList[i].orderTime;
       				var comments = orderList[i].comments;
       				var commentTime = orderList[i].commentTime;
       				var reply = orderList[i].reply;
       				var replyTime = orderList[i].replyTime;
       				var rating = orderList[i].rating;
       				var orderDetails = orderList[i].orderDetails;
       				
       			  $.each(orderDetails, function(index, value){
       				  
       				  var dish = orderDetails[index].dish;
       				  var quantity = orderDetails[index].quantity;
       				  
       			  });
       				
       				var Detail = '<p>Order number: </p><p>'+orderDetails.length()+'</p>'+'<p>Order time: </p><p>'+orderTime+'</p>'+'<p>Receiver Name: </p><p>'+localStorage.getItem("username") + '</p>';
       			

                       var shopInfo = $('<td><a href="getOrderByOid?oid='+ oid+ '"></br><p>'+name+'</p></a></td>');
                       $(shopInfo).appendTo('#orderList');

                       // end of new row
                       if(i % 3 == 0){
                           var rowEn = $('</tr>');
                           $(rowEn).appendTo('#orderList');
                       }
                   });
                   
                   var tableEn = $('</table>');
                   $(tableEn).appendTo('#orderList');
                   
 		   	  }else{
                   var noShop = $('<p>No Dishes Show</p>');
                   $(noShop).appendTo('#orderList');
               }
		   
 	   },
 	   error:function(){
 		   console.log("Error");
 	   }
    });
    
};



</script>
</body>
</html>