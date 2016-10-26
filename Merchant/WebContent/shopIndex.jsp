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

</head>
<body>
<jsp:include page="./header.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********My Shop*********--><!-- 3 in one line -->
	<div class="myShop">
		<h3 class="h3_title_index">- My Shop -</h3>
		<input type="button" value="Add Shop" onclick="location.href='./shopAdd.jsp';"/>
		
		<div id="shopList"></div>
		
	</div>
</div>

<script>

    $(function(){
	    window.onload = function(){
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
        };
	});
    
    function isEmpty(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }
</script>
</body>
</html>