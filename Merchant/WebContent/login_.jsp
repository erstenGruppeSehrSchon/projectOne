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
<jsp:include page="./headerGuest.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********Search form*********-->
	<div class="merchantForm">
		<form name="merchantSearchForm" method="post" action="">
			<table class="searchTable">
				<tr>
                    <td colspan="2"><h3 class="h3_title_index">-Login-</h3></td>
                </tr>
				<tr>
                    <td><h4 class="form_title">Login Name:</h4></td>
                    <td><input type="text" name="loginName" id="loginName"/></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Login Password:</h4></td>
                    <td><input type="text" name="loginPassword" id="loginPassword"/></td>
                </tr>
                <tr>
                	<td></td>
                    <td><input type="submit" value="Login" />
                    <a href="./merchantAdd.jsp"><input type="submit" value="Join us!" /></a></td>
                </tr>
			</table>
		</form>		
	</div>
</div>
</body>
</html>