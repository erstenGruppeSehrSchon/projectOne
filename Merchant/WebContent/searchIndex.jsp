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
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********Search form*********-->
	<div class="merchantForm">
		<form name="merchantSearchForm" method="post" action="">
			<table class="searchTable">
				<tr>
                    <td colspan="2"><h3 class="h3_title_index">-Search-</h3></td>
                </tr>
				<tr>
                    <td><h4 class="form_title">Shop Name:</h4></td>
                    <td><input type="text" name="shopName" id="shopName"/></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Shop Type:</h4></td>
                    <td><select type="select" class="form-control">
                    		<option value="1">convenience store</option>
							<option value="2">cantonese restaurant</option>
							<option value="3">chinese restaurant</option>
							<option value="4">western restaurant</option>
							<option value="5">african restaurant</option>
							<option value="6">hotel</option>
							<option value="7">女僕CAFE</option>
							<option value="8">偽娘CAFE</option>
                    </select></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Shop Area:</h4></td>
                    <td><input type="text" name="shopArea" id="shopArea"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search" onclick=""  /></td>
                </tr>
			</table>
		</form>		
	</div>
</div>
<div class="container">
	<div class="block-divider-index"></div>
</div>

<!-- Appear when search result back -->
<div>
	<table class="largeThumb">
			<tr>
                <td colspan="3"><h3 class="h3_title_index">-Search Result-</h3></td>
            </tr>
            <tr>
                    <td>
                    	<div>
                    		<a href="#"><img src="http://www.oushop.com/warp_sites/oushop.g6/files/Shop2.jpg"></img>
                    		<p>Shop Name</p>
                    		<p>Shop Type</p>
                    		<p>Shop Area</p></a>
                    	</div>
                    </td>
                    <td>
                    	<div>
                    		<a href="#"><img src="http://www.oushop.com/warp_sites/oushop.g6/files/Shop2.jpg"></img>
                    		<p>Shop Name</p>
                    		<p>Shop Type</p>
                    		<p>Shop Area</p></a>
                    	</div>
                    </td>
                    <td>
                    	<div>
                    		<a href="#"><img src="http://www.oushop.com/warp_sites/oushop.g6/files/Shop2.jpg"></img>
                    		<p>Shop Name</p>
                    		<p>Shop Type</p>
                    		<p>Shop Area</p></a>
                    	</div>
                    </td>
            </tr>
		</table>
</div>

</body>
</html>