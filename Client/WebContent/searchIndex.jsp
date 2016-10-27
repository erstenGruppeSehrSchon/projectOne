<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -client System-</title>
	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" />
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/searchIndex.js"></script>
</head>
<body>
<jsp:include page="./header.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********Search form*********-->
	<div class="clientForm">
			<table class="searchTable">
				<tr>
                    <td colspan="2"><h3 class="h3_title_index">-Search-</h3></td>
                </tr>
				<tr>
                    <td><h4 class="form_title">Shop Name:</h4></td>
                    <td><input type="text" id="name"/></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Shop Type:</h4></td>
                    <td>
                    	<select type="select" class="form-control" id="type">
                    		<option value=""></option>
                    		<option value="Convenience Store">Convenience Store</option>
							<option value="Cantonese Restaurant">Cantonese Restaurant</option>
							<option value="Chinese Restaurant">Chinese Restaurant</option>
							<option value="Western Restaurant">Western Restaurant</option>
							<option value="African Restaurant">African Restaurant</option>
							<option value="Hotel">Hotel</option>
							<option value="Maid Cafe">Maid Cafe</option>
							<option value="Cross-dressing Cafe">Cross-dressing Cafe</option>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Shop Area:</h4></td>
                    <td><input type="text" id="address"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Search" onclick="search()"  /></td>
                </tr>
			</table>
	</div>
</div>

<div class="container">
	<div class="block-divider-index"></div>
</div>

<!-- Appear when search result back -->
<div>
	<table class="largeThumb" id="resultTable">
		<tr>
			<td colspan="3"><h3 class="h3_title_index">-Search Result-</h3></td>
		</tr>
	</table>
</div>

</body>
</html>