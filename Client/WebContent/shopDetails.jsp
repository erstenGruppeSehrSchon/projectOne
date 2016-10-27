<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="./header.jsp" />

<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<!--*********My Shop details*********--><!-- 3 in one line -->
	<div class="myShop">
	<a href="./cartIndex.jsp"><input type="submit" value="My Cart in this shop"/></a>
		<h3 class="h3_title_index">- Shop details-</h3>
		<div id ="shopInfo"></div>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Dishes in this shop-</h3>
	<div id = "dishList"></div>
		<table class="largeThumb">
			<tr>
				<td>
					<a href="./dishDetails.jsp"><!-- Advertisement Link-->
					<img src="http://www.foodmanufacture.co.uk/var/plain_site/storage/images/publications/food-beverage-nutrition/foodmanufacture.co.uk/npd/top-10-functional-food-trends/11097085-1-eng-GB/Top-10-functional-food-trends_strict_xxl.jpg" title=""/></br> <!-- Shop img and shop name -->
					<p>Shops Name</p>
					<p>Dish Name</p></a>
				</td>
				
				<td>
					<a href="./dishDetails.jsp"><!-- Advertisement Link-->
					<img src="http://www.gordonconwell.edu/hamilton/current/images/01.jpg" title=""/></br> <!-- Dish img and shop name -->
					<p>Shops Name</p>
					<p>Dish Name</p></a>
				</td>
				
				<td>
					<a href="./dishDetails.jsp"><!-- Advertisement Link-->
					<img src="http://www.noblecatering.co.uk/upload/food-066.jpg" title=""/></br> <!-- Dish img and shop name -->
					<p>Shops Name</p>
					<p>Dish Name</p></a>
				</td>
			</tr>
		</table>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Comments in this shop-</h3>
	<!-- one comment one table -->
		<table class="largeThumb commentBox">
		<tr>
			<td colspan="2"><h4 class="form_title">-Customer comment-</h4></td>
		</tr>
			<tr>
				<td>
					<p><b>Customer name:</b> name here</p>
					<p><b>Date:</b> date here</p>
				</td>
				<td><p><b>Content:</b></p><p>Content here</p></td>
			</tr>
			<tr>
			<td colspan="2"><h4 class="form_title">-Merchant comment-</h4></td>
		</tr>
			<tr>
				<td><p><b>Date:</b> date here</p></td>
				<td><p><b>Content:</b> Content here</p></td>
			</tr>
		</table>
		
		<!-- other comment -->
		<table class="largeThumb commentBox">
		<tr>
			<td colspan="2"><h4 class="form_title">-Customer comment-</h4></td>
		</tr>
			<tr>
				<td>
					<p><b>Customer name:</b> name here</p>
					<p><b>Date:</b> date here</p>
				</td>
				<td><p><b>Content:</b></p><p>Content here</p></td>
			</tr>
			<tr>
			<td colspan="2"><h4 class="form_title">-Merchant comment-</h4></td>
		</tr>
			<tr>
				<td><p><b>Date:</b> date here</p></td>
				<td><p><b>Content:</b> Content here</p></td>
			</tr>
		</table>
</div>
<script>
	$(function(){
    	window.onload = function(){
        	loadShop();
        	loadDish();
        	//loadOrder();
    	};
	});

	function loadShop(){
        document.getElementById("shopInfo").innerHTML = '';
        
        if(!isEmpty('${shop}')){
        	var tableOP = '<table class="largeThumb"><tr>';
            //$(tableOP).appendTo('#shopInfo');
            var shopName = '<td><p><h4 class="form_title">Shop Name :</h4> ${shop.name}</p></br>';
            tableOP+=shopName;
            
            var shopAddr = '<p><h4 class="form_title">Shop Address :</h4> ${shop.shopContact.address}</p></br>';
            tableOP+=shopAddr;
            var shopHour = '<p><h4 class="form_title">Shop Available Time :</h4> ${opening}</p></br>'
            tableOP+=shopHour;
            var shopScore = '<p><h4 class="form_title">Shop Marks :</h4> ${score}</p></br>';
            tableOP+=shopScore;
            var shopDescr = '<p><h4 class="form_title">Shop Description :</h4> ${shop.description}</p></td>';
            tableOP+=shopDescr;
            var shopImg = '<td><img src="${shop.imgPath}"/></td>';
            tableOP+=shopImg;
            var tableEn = '</tr></table>';
            tableOP+=tableEn;
            $(tableOP).appendTo('#shopInfo');
        }
	}

	function loadDish(){
		document.getElementById("dishList").innerHTML = '';
		var sid = '${shop.sid}';
		$.ajax({
			type:'GET',
            url:"getDishesBySid?sid=" + sid,
            success:function(msg){
                if (msg.length>0){
                	var tableOp = '<table class="largeThumb">';

               	 $.each(msg,function(i,ad){
               		 if(i % 3 == 0){
                            // open of new row
                            var rowOP = '<tr>';
                            tableOp+=rowOP;   
                        }
               		 var ipath= msg[i].dishImages[0].imgPath;
                        var shopName = '${shop.name}';
                        var dishName = msg[i].name;
                        var did = msg[i].did;

                        var dishInfo = '<td><a href="./dishDetails.jsp?did='+ did+'"><img src="'+ipath+'" title="'+shopName+'"/><p>'+shopName+'</p><p>'+dishName+'</p></a></td>';
                        tableOp+=dishInfo;

                        if(i % 3 == 0){
                            // end of new row
                            var rowEn = $('</tr>');
                            tableOp+=rowEn;    
                        }
                        
               	 });
               	 var tableEn = $('</table>');
               	 tableOp+=tableEn;   
               	
                   $(tableOp).appendTo('#dishList');
                   }
            	
                },
                error: function(){
                    var error = $('<p>Error in getting advertment.</p>');
                    $(error).appendTo('#advertList');
                }
		});
	}

	function isEmpty(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }

</script>
</body>
</html>