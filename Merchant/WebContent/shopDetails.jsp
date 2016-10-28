<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<h3 class="h3_title_index">- My Shop details-</h3>
		<a href="./showShopUpdatePage?sid=${shop.sid}"><input type="submit" value="Edit Shop"/></a>
		<table class="largeThumb">
			<tr>
				<td>
					<p><h4 class="form_title">Shop Name :</h4> <span id="shopName"></span></p>
					<br/>
					<p><h4 class="form_title">Shop Phone :</h4> <span id="shopPhone"></span></p>
                    <br/>
                    <p><h4 class="form_title">Shop Address :</h4> <span id="shopAddress"></span></p>
					<br/>
					<p><h4 class="form_title">Shop available time :</h4> <span id="shopTime"></span></p>
					<br/>
					<p><h4 class="form_title">Shop Description:</h4> <span id="shopDescr"></span></p>
				</td>
				<td>
					<img id="shopPic"/>
				</td>
			</tr>
		</table>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Dishes in this shop-</h3>
	<form method="get" action="showAddDishPage">
        <input type="hidden" name="sid" value="${shop.sid}" />
	    <input type="submit" value="Add Dish"/>
	</form>
	
	<div id="dishList"><span>Loading......</span></div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>


<div class="container">
	<h3 class="h3_title_index">- All Comments in this shop-</h3>
	<!-- one comment one table -->
    
    <div id="commentList"><span>Loading......</span></div>
</div>
<br/>
<br/>

<script>

    $(function(){
        
        // load shop name
        if(isEmpty('${shop.name}'))
            $('#shopName').text(" --- ");
        else
            $('#shopName').text('${shop.name}');

        // load shop phone
        if(isEmpty('${shop.shopContact.phone}'))
            $('#shopPhone').text(" --- ");
        else
            $('#shopPhone').text('${shop.shopContact.phone}');

        // load shop address
        if(isEmpty('${shop.shopContact.address}'))
            $('#shopAddress').text(" --- ");
        else
            $('#shopAddress').text('${shop.shopContact.address}');

        // load shop available time
        if(isEmpty('${shop.openTime}') || isEmpty('${shop.closeTime}'))
            $('#shopTime').text(" --- ");
        else{
            var oTime = '<fmt:formatDate pattern="HH:mm:ss" value="${shop.openTime}" />';
            var eTime = '<fmt:formatDate pattern="HH:mm:ss" value="${shop.closeTime}" />';
            $('#shopTime').text(oTime+" - "+eTime);

        }
        
        // load shop description
        if(isEmpty('${shop.description}'))
            $('#shopDescr').text(" --- ");
        else
            $('#shopDescr').text('${shop.description}');

        // load shop pic
        if(isEmpty('${shop.imgPath}'))
            $('#shopPic').text("src", "http://www.icon2s.com/img256/256x256-black-white-android-user.png");
        else
            $('#shopPic').attr("src", '${shop.imgPath}');

        // load shop dishes
        loadDish();

        // load comments
        loadComment();
	});
    
    function loadDish(){
        $.ajax({
            type: 'GET',
            url: 'getDishesBySid?sid=${shop.sid}',
            success: function(data) {
                document.getElementById("dishList").innerHTML = '';
                            
                if(!isEmpty(data)){
                    
                    if(data.length > 0){
						var tableOP = $('<table id="dishTable" class="largeThumb"></table>');
                        $(tableOP).appendTo('#dishList');
						
                        $.each(data, function(i, ad){
							
                            var did = data[i].did;
                            var ipath = data[i].dishImages[0].imgPath;
                            var dishName = data[i].name;
                            var shopName = '${shop.name}';

                            var dishInfo = $('<td><a href="getDishByDid?did='+ did+'"><img src="'+ipath+'" title="'+dishName+'"/><br/><p>'+shopName+'</p><p>'+dishName+'</p></a></td>');
                            $(dishInfo).appendTo('#dishTable');
                         
                        });
						
						var tds = $("#dishTable > td");
						for(var i = 0; i < tds.length; i+=3) {
						  tds.slice(i, i+3).wrapAll("<tr></tr>");
						}
                       
                    }
                    else{
                        document.getElementById("dishList").innerHTML = '';
                        
                        var noDish = $('<p>You have no dishes now.</p>');
                        $(noDish).appendTo('#dishList');
                    }
                }
            },
            error:function(){
                alert('Fail to show dishes!');
                
                document.getElementById("dishList").innerHTML = '';
                var noDish = $('<p>Fail to show dishes!</p>');
                $(noDish).appendTo('#dishList');
            }  
        });
        
    }
    
    function loadComment(){
        document.getElementById("commentList").innerHTML = '';
        
        $.ajax({
            type:'GET',
            url:'getOrdersBySid?sid=${shop.sid}',
            success: function(data){
                document.getElementById("commentList").innerHTML = '';
                            
                if(!isEmpty(data)){                    
                    if(data.length > 0){

                        $.each(data, function(i, ad){
                            
                            var commentTime = data[i].commentTime;
                            var comments = data[i].comments;
                            var replyTime = data[i].replyTime;
                            var reply = data[i].reply;
                            
                            var table = $('<table class="largeThumb commentBox"><tr><td colspan="2"><h4 class="form_title">-Customer comment-</h4></td></tr><tr><td><p><b>Date:</b>'+ commentTime+'</p></td><td><p><b>Content:</b></p><p>'+comments+'</p></td></tr><tr><td colspan="2"><h4 class="form_title">-Merchant comment-</h4></td></tr><tr><td><p><b>Date:</b>'+replyTime+'</p></td><td><p><b>Content:</b>'+reply+'</p></td></tr></table>');
                            $(table).appendTo('#commentList');
                        });
                    }
                    else{
                        document.getElementById("commentList").innerHTML = '';
                        
                        var noComm = $('<p>You have no comments now.</p>');
                        $(noComm).appendTo('#commentList');
                    }
                }
            },
            error: function(){
                alert('Fail to show comments!');
                
                document.getElementById("commentList").innerHTML = '';
                var noComm = $('<p>Fail to show comments!</p>');
                $(noComm).appendTo('#commentList');
            }
        });
        
    }
    
    function isEmpty(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }
</script>
</body>
</html>