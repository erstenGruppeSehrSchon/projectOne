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
		
        <div id="shopList"></div>

	</div>
	
	<!--*********My Advertisement*********--> <!-- THREE IN ONE LINK -->
	<div class="myAdvertisement">
		<h3 class="h3_title_index">- My Advertisement -</h3>
		
		<div id="advertList"></div>
	</div>
	
	<!--*********My Order*********--> <!-- THREE IN ONE LINK -->
	<div class=myOrder>
		<h3 class="h3_title_index">- My Order -</h3>
		
		<div id="orderList"></div>
	</div>
</div>	

<script>
	$(function(){
	    window.onload = function(){
            loadShop();
            loadAdvert();
            loadOrder();
        };
	});
    
    function loadShop(){
        document.getElementById("shopList").innerHTML = '';
        
        if(!isEmpty('${merchant}')){
            
            if(${fn:length(merchant.shops)} > 0){
                
                var tableOP = $('<table class="largeThumb">');
                $(tableOP).appendTo('#shopList');
                
                for(var i = 0; i< ${fn:length(merchant.shops)}; i++){
                    if(i % 3 == 0){
                        // open of new row
                        var rowOP = $('<tr>');
                        $(rowOP).appendTo('#shopList');   
                    }
                    
                    var sid = '${merchant.shops[i].sid}';
                    var ipath = '${ merchant.shops[i].imgPath}';
                    var shopName = '${merchant.shops[i].name}';
                    
                    var shopInfo = $('<td><a href="getShopBySid?sid='+ sid+ '"><img src="'+ipath+'" title="'+shopName+'"/></br><p>'+shopName+'</p></a></td>');
                    $(shopInfo).appendTo('#shopList');
                    
                    if(i % 3 == 0){
                        // end of new row
                        var rowEn = $('</tr>');
                        $(rowEn).appendTo('#shopList');   
                    }
                }
                
                var tableEn = $('</table>');
                $(tableEn).appendTo('#shopList');
            }
            else{
                var noShop = $('<p>You have no shops now.</p>');
                $(noShop).appendTo('#shopList');
               
            }
        }
    }
    
    function loadAdvert(){
        document.getElementById("advertList").innerHTML = '';
        var mid = '${merchant.mid}';
        
        $.ajax({
            type:'GET',
            url:"getAdvertisementByMid?mid=" + mid,
            success: function(msg){
                var tableOp = $('<table class="largeThumb">');
                $(tableOp).appendTo('#advertList');

                for(var i = 0; i< ${fn:length(msg)}; i++){
                    if(i % 3 == 0){
                        // open of new row
                        var rowOP = $('<tr>');
                        $(rowOP).appendTo('#advertList');   
                    }
                    
                    var ipath= '${msg[i].imgPath}';
                    var shopName = '${msg[i].shop.name}';
                    
                    var advertInfo = $('<td><img src="'+ipath+'" title="'+shopName+'"/></td>');
                    $(advertInfo).appendTo('#advertList');
                    
                    if(i % 3 == 0){
                        // end of new row
                        var rowEn = $('</tr>');
                        $(rowEn).appendTo('#advertList');   
                    }
                }
                
                var tableEn = $('</table>');
                $(tableEn).appendTo('#advertList');
              
            },
            error: function(){
                var error = $('<p>Error in getting advertment.</p>');
                $(error).appendTo('#advertList');
            }
        });
    }
    
    function loadOrder(){
        document.getElementById("orderList").innerHTML = '';
        var mid = '${merchant.mid}';
        
         $.ajax({
            type:'GET',
            url:"getOrderByMid?mid="+mid,
            success: function(msg){

                var tableOp = $('<table class="largeThumb">');
                $(tableOp).appendTo('#orderList');

                for(var i = 0; i< ${fn:length(msg)}; i++){
                    if(i % 3 == 0){
                        // open of new row
                        var rowOP = $('<tr>');
                        $(rowOP).appendTo('#orderList');   
                    }
                    
                    var shopName = '${msg[i].shop.name}';
                    var orderId = '${msg[i].oid}';
                    var orderTime = '${msg[i].orderTime}';
                    
                    var orderInfo= $("<td><p>"+shopName+"</p><p>"+orderId+"</p><p>"+orderTime+"</p></td>");
                    $(orderInfo).appendTo('#orderList');

                    if(i % 3 == 0){
                        // end of new row
                        var rowEn = $('</tr>');
                        $(rowEn).appendTo('#orderList');   
                    }
                }

                var tableEn = $('</table>');
                $(tableEn).appendTo('#orderList');

            },
            error: function(){
                var error = $('<p>Error in getting order.</p>');
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