<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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


	<!--*********My shop*********--> <!-- THREE IN ONE LINK -->
	<div class="myShop">
		<h3 class="h3_title_index">- My Shop -</h3>
		
        <div id="shopList"><span>Loading......</span></div>

	</div>
	
	<br/>
	
	<!--*********My Advertisement*********--> <!-- THREE IN ONE LINK -->
	<div class="myAdvertisement">
		<h3 class="h3_title_index">- My Advertisement -</h3>
		
		<div id="advertList"><span>Loading......</span></div>
	</div>
	
	<br/>
	
	<!--*********My Order*********--> <!-- THREE IN ONE LINK -->
	<div class=myOrder>
		<h3 class="h3_title_index">- My Order -</h3>
		
		<div id="orderList"><span>Loading......</span></div>
	</div>
</div>	

<script>
	$(function(){
        loadShop();
        loadAdvert();
        loadOrder();
	});
    

    function loadShop(){
        $.ajax({
            type: 'GET',
            url: 'getMerchantByMid?mid=${merchant.mid}',
            success: function(data) {
                document.getElementById("shopList").innerHTML = '';
                
                var userName = data.username;
            
                if(!isEmpty(userName)){
                    
                    if(data.shops.length > 0){
						var tableOP = $('<table id="shopTable" class="largeThumb"></table>');
                        $(tableOP).appendTo('#shopList');
						
                        $.each(data.shops, function(i, ad){
							
                            var sid = data.shops[i].sid;
                            var ipath = data.shops[i].imgPath;
                            var shopName = data.shops[i].name;

                            var shopInfo = $('<td><a href="getShopBySid?sid='+ sid+ '"><img src="'+ipath+'" title="'+shopName+'"/></br><p>'+shopName+'</p></a></td>');
                            $(shopInfo).appendTo('#shopTable');
                         
                        });
						
						var tds = $("#shopTable > td");
						for(var i = 0; i < tds.length; i+=3) {
						  tds.slice(i, i+3).wrapAll("<tr></tr>");
						}
                    }
                    else{
                        document.getElementById("shopList").innerHTML = '';
                        
                        var noShop = $('<p>You have no shops now.</p>');
                        $(noShop).appendTo('#shopList');
                    }
                }
            },
            error:function(){
                alert('Fail to show shops!');
                
                document.getElementById("shopList").innerHTML = '';
                var noShop = $('<p>Fail to show shops!</p>');
                $(noShop).appendTo('#shopList');
            }  
        });    
    }
    
    function loadAdvert(){   
        $.ajax({
            type:'GET',
            url:'getAdvertisementByMid?mid=${merchant.mid}',
            success: function(data){
                document.getElementById("advertList").innerHTML = '';
                            
                if(!isEmpty(data)){
                    
                    if(data.length > 0){
                        var tableOP = $('<table id="advertTable" class="largeThumb"></table>');
                        $(tableOP).appendTo('#advertList');

                        $.each(data, function(i, ad){
                            var ipath = data[i].imgPath;
                            var shopName = data[i].shop.name;

                            var advertInfo = $('<td><img src="'+ipath+'" title="'+shopName+'"/></td>');
                            $(advertInfo).appendTo('#advertTable');
                         
                        });
						
						var tds = $("#advertTable > td");
						for(var i = 0; i < tds.length; i+=3) {
						  tds.slice(i, i+3).wrapAll("<tr></tr>");
						}

                    }
                    else{
                        document.getElementById("advertList").innerHTML = '';
                        
                        var noShop = $('<p>You have no advertisement now.</p>');
                        $(noShop).appendTo('#advertList');
                    }
                }
            },
            error: function(){
                document.getElementById("advertList").innerHTML = '';
                
                var error = $('<p>Error in getting advertisement.</p>');
                $(error).appendTo('#advertList');
            }
        });
    }
    
    function loadOrder(){        
         $.ajax({
            type:'GET',
            url:'getOrdersByMid?mid=${merchant.mid}',
            success: function(data){
                document.getElementById("orderList").innerHTML = '';
                            
                if(!isEmpty(data)){
                    
                    if(data.length > 0){
						var tableOP = $('<table id="orderTable" class="largeThumb"></table>');
                        $(tableOP).appendTo('#orderList');

                        $.each(data, function(i, ad){

                            var shopName = data[i].shop.name;
                            var orderId = data[i].oid;
                            var orderTime = data[i].orderTime;

                            var orderInfo= $("<td><p>"+shopName+"</p><p>"+orderId+"</p><p>"+orderTime+"</p></td>");
                            $(orderInfo).appendTo('#orderTable');
                         
                        });
						
						var tds = $("#orderTable > td");
						for(var i = 0; i < tds.length; i+=3) {
						  tds.slice(i, i+3).wrapAll("<tr></tr>");
						}
                    }
                    else{
                        document.getElementById("orderList").innerHTML = '';
                        
                        var noShop = $('<p>You have no orders now.</p>');
                        $(noShop).appendTo('#orderList');
                    }
                }

            },
            error: function(){
                document.getElementById("orderList").innerHTML = '';
                
                var error = $('<p>Fail in getting orders!</p>');
                $(error).appendTo('#orderList');
            }
        });
        
        
    }
    
    function isEmpty(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }
</script>
</body>
</html>