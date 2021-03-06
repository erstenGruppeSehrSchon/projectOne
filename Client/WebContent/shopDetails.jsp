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
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Comments in this shop-</h3>
	<!-- one comment one table -->
	<div id ="commentList"></div>
		
</div>
<script>
	$(function(){
    	window.onload = function(){
        	loadShop();
        	loadDish();
        	loadComment();
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

                        var dishInfo = '<td><a href="getDishInfoByDid?did='+ did+'&sid='+sid+'"><img src="'+ipath+'" title="'+shopName+'"/><p>'+shopName+'</p><p>'+dishName+'</p></a></td>';
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
                    var error = $('<p>Error in getting dish.</p>');
                    $(error).appendTo('#dishList');
                }
		});
	}

	function loadComment(){
		document.getElementById("commentList").innerHTML = '';
		var sid = '${shop.sid}';
		$.ajax({
			type:'GET',
            url:"getOrderWithCommentBySid?sid=" + sid,
            success:function(order){
                if (order.length>0){
                	$.each(order,function(i,ad){
                    	var tableOp = '<table class="largeThumb commentBox"><tr><td colspan="2"><h4 class="form_title">-Customer comment-</h4></td></tr>';

						var cm = order[i].comments;
						var cmTime = order[i].commentTime;
						var replyContent = order[i].reply;
						var replyTime = order[i].replyTime;
                    	
                    	var custCm ='<tr><td><p><b>Customer name:</b> name here</p><p><b>Date:</b>'+ cmTime+'</p></td><td><p><b>Content:</b></p><p>'+cm+'</p></td></tr>';
						tableOp +=custCm;

						var replyOp ='<tr><td colspan="2"><h4 class="form_title">-Merchant comment-</h4></td></tr>';
                    	tableOp += replyOp;

                    	var reply = '<tr><td><p><b>Date:</b>'+replyTime+'</p></td><td><p><b>Content:</b>'+replyContent+'</p></td></tr></table>';
						tableOp +=reply;
                    	
                    	$(tableOp).appendTo('#commentList');
                	});
                } else {
					var noCm = '<p>No comment on this shop yet</p>';
					$(noCm).appendTo('#commentList');
                }
            	
            },
            error: function(){
                var error = $('<p>Error in getting comment.</p>');
                $(error).appendTo('#commentList');
            }
		});
	}

	function isEmpty(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }

</script>
</body>
</html>