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
<script>
$(function(){
    window.onload = function(){
    	alert('${merchant}');
    	if(!isEmpty('${merchant}')){
    		$.ajax({
    			type : 'GET',
    			url : 'getMerchantByMid?mid='+'${merchant.mid}',
    			success:function(Merchant){
    				//alert(Merchant.shops.length);
    				//alert(Merchant.shops[0]["name"]);
    				var selectElement = document.getElementById("shopSelectBar");
    				for(var x = 0; x < Merchant.shops.length ; x++){
    					var shopName = Merchant.shops[x]["name"];
    					var option = document.createElement("option");
    					option.text = shopName;
    					option.setAttribute("value", Merchant.shops[x]["sid"]);
    					selectElement.add(option);
    				}
    				
    			},
    			error:function(Merchant){
    				alert("Please login again.");
    			}
    			//need change addresses
    			});
    	}
   	};   
    });
function isEmpty(value) {
    return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
}	
</script>
</head>
<body>
<jsp:include page="./header.jsp" />
<!--*********container*********-->
<div class="container">
<jsp:include page="./menu.jsp" />

	<!--*********Edit profile form*********-->
	<div class="merchantForm">
		<form name="merchantAdsForm" method="post" action="addAdvertisement">
			<table class="AdsTable">
			<tr>
				<td colspan="2"><h3 class="h3_title_index">-Add Advertisement-</h3></td>
			</tr>
			<tr>
				<td><h4 class="form_title">Shop name: </h4></td>
				<td><select type="select" id = "shopSelectBar" name="sid"></select></td>
			</tr>
			
			<tr>
				<td><h4 class="form_title">Advertisement Image:</h4></td>
				<td>
					 <input type="file" name="files" multiple="multiple" />
				</td>
			</tr>
			
			<!-- <tr>
				<td><h4 class="form_title">From time:</h4></td>
				<td><input type = "date" name="adsFromTime" class = "form-control" value=""/></td></td>
			</tr>
			<tr>
				<td><h4 class="form_title">To time:</h4></td>
				<td><input type = "date" name="adsToTime" class = "form-control" value=""/></td></td>
			</tr> -->
              <tr>
                  <td></td>
                  <td><input type="submit" value="Submit"/></td>
              </tr>
			</table>
		</form>		
	</div>
</div>

</body>
</html>