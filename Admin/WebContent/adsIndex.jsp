<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script>
        $(function(){
//         	$(":button").on("click", function(e) {
//             	alert('Hi');
//             	alert('clicked: ' + this.id);
//     			$.ajax({
//     				type : 'GET',
//     				url : 'updateAdvertisementStatus',
//     				data : {
//     					advId : this.id,
//     					status : 'Rejected'
//     				}
//     			}).done(function(msg) {
//                     alert(msg);
//     			})
//     		});
            $.ajax({
                type: 'GET',
                url: 'showAcceptedAdvertisement',
                success: function(data) {
                	$.each(data, function(i, ad){
                		$(".currentAdvList").append("<div class='curAdv'><img src='" + data[i].imgPath + "' /><a href='/Admin/updateAdvertisementStatus?advId=" + data[i].advImgId + "&status=Rejected'>Rejected</a></div>");
                    }); 
                },
                error:function(){
                    alert('Fail to show advertisement!');
                }  
            });
        });
        
        $(function(){
            $.ajax({
                type: 'GET',
                url: 'showRejectedAdvertisement',
                success: function(data) {
                	$.each(data, function(i, ad){
                		$(".pendingAdvList").append("<div class='pendingAdv'><img src='" + data[i].imgPath + "' /><a href='/Admin/updateAdvertisementStatus?advId=" + data[i].advImgId + "&status=Accepted'>Accepted</a><a href='/Admin/updateAdvertisementStatus?advId=" + data[i].advImgId + "&status=Rejected'>Rejected</a></div>");
                    }); 
                },
                error:function(){
                    alert('Fail to update advertisement!');
                }  
            });
        });
    </script>
</head>
<body>
<jsp:include page="./header.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<h3 class="h3_title_index">- Client Side Advertisement View -</h3>
	<!--*********banner*********-->
	<div id="slider" class="carousel slide">
	
	<ol class="carousel-indicators">
	<!-- count of li is equaled to number of ads -->
		<li data-target="#slider" data-slide-to="0" class="active"></li>
		<li data-target="#slider" data-slide-to="1"></li>
		<li data-target="#slider" data-slide-to="2"></li>
		<li data-target="#slider" data-slide-to="3"></li>
	</ol>   
	
	<div class="carousel-inner">
		<div class="item active">
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
		</div>
	</div>
	
	<a class="carousel-control left" href="#slider" 
	   data-slide="prev"><span class="glyphicon glyphicon-chevron-left"/></a>
	<a class="carousel-control right" href="#slider" 
	   data-slide="next"><span class="glyphicon glyphicon-chevron-right"/></a>
	</div> 
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>

<div class="container">
	<!--********Current ads**********--><!-- 3 in one line -->
	<div class="myShop">
		<h3 class="h3_title_index">- Current Advertisement -</h3>
		<div class="currentAdvList"></div>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>

<div class="container">
	<!--********Pending ads**********--><!-- 3 in one line -->
	<div class="myShop">
		<h3 class="h3_title_index">- Pending Advertisements -</h3>
		<div class="pendingAdvList"></div>
	</div>
</div>
</body>
</html>