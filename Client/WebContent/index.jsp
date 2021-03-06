<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -Customer System-</title>
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


	<!--*********banner*********-->
	<div id="slider" class="carousel slide">
	
	<ol class="carousel-indicators">
	<!-- count of li is equaled to number of ads -->
		<li data-target="#slider" data-slide-to="0" class="active"></li>
		<li data-target="#slider" data-slide-to="1"></li>
		<li data-target="#slider" data-slide-to="2"></li>
		<li data-target="#slider" data-slide-to="3"></li>
	</ol>   
	
	<div class="carousel-inner" id="advList">
		<!-- <div class="item active">
			<img src="./img/banner1.jpg" alt="ads 1"/>
		</div>
		<div class="item">
			<img src="./img/banner2.jpg" alt="ads 2">
		</div>
		<div class="item">
			<img src="./img/banner3.jpg" alt="ads 3">
		</div>
		<div class="item">
			<img src="./img/banner4.jpg" alt="ads 4">
		</div>-->
	</div>
	
	<a class="carousel-control left" href="#slider" 
	   data-slide="prev"><span class="glyphicon glyphicon-chevron-left"/></a>
	<a class="carousel-control right" href="#slider" 
	   data-slide="next"><span class="glyphicon glyphicon-chevron-right"/></a>
</div> 
	
	
	<!--*********new shop*********--> <!-- THREE IN ONE LINK -->
	<div class=recommendShop>
		<h3 class="h3_title_index">- Recommended Shop -</h3>
		<table class="largeThumb">
			<tr>
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://www.oushop.com/warp_sites/oushop.g6/files/Shop2.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>New Shops</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>New Shops</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>New Shops</p></a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>New Shops</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>New Shops</p></a>
				</td>
				
				<td>
					<a href="#"><!-- Shop Link-->
					<img src="http://browzin.net/wp-content/uploads/2015/02/pictures-675-ESB_gift_shop.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>New Shops</p></a>
				</td>
			</tr>
		</table>
		<div id="shopList"></div>
	</div>
</div>
<script>
$(function(){
	
	$.ajax({
		type:'GET',
		url:'getAllShop',
		success:function(shopList){
			
			 if(shopList.length>0){
   			  
				  var tableOP = $('<table>');
                 $(tableOP).appendTo('#shopList');
                 
                 $.each(shopList, function(index, value){
               	  
               	                   
                     // open of new row
                     if(index % 3 == 0){
                         var rowOP = $('<tr>');
                         $(rowOP).appendTo('#shopList'); 
                     }
                     
					  var sid =  shopList[index].sid;
                     var name = shopList[index].name;
                     var type = shopList[index].type;
                     var description = shopList[index].description;
                     var img = shopList[index].imgPath;

                     var shopInfo = $('<td><a href="getShopInfoBySid?sid='+ sid+ '"><img src="'+ img +'" title="'+name+'"/></br><p>'+name+'</p></a></td>');
                     $(shopInfo).appendTo('#shopList');

                     // end of new row
                     if(i % 3 == 0){
                         var rowEn = $('</tr>');
                         $(rowEn).appendTo('#shopList');
                     }
                 });
                 
                 var tableEn = $('</table>');
                 $(tableEn).appendTo('#shopList');
                 
		   	  }else{
                 var noShop = $('<p>No Shop Show</p>');
                 $(noShop).appendTo('#shopList');
             }
			
		},
		error:function(){
			
		}
		
	});

	$.ajax({
		type:'GET',
		url:'getLatestAdv',
		success:function(advList){
			if (advList.length>0){
				$.each(advList, function(index, value){
					var divOp ='';
					if (index ==4){
						break;
					}
					if (index==0){
						divOp='<div class="item active">';
					} else {
						divOp = '<div class="item">';
					}
					var sid = advList[index].shop.sid;
					var imgStr = '<a href="getShopInfoBySid?sid='+ sid+ '"><img src='+advList[index].imgPath+' alt = "adv'+index+1+'"></a>';
					divOp+=imgStr;
					var divEn = '</div>'; 
					divOp += divEn;
					$(divOp).appendTo('#advList');
				});
			} else {
				var img = '<div class="item active"><a href="#"><img src="http://www.vishmax.com/en/innovattive-cms/themes/themax-theme-2015/images/no-image-found.gif"></a></div>';
				$(img).appendTo('#advList');
			}
		},
		error:function(){
		}
		
	});
	
	
});


</script>
</body>
</html>