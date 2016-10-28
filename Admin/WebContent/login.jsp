<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
   	<link rel="stylesheet" type="text/css" href="./css/style.css" />
	<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="headerGuest.jsp" />
<!--*********container*********-->
<div class="container">
	<jsp:include page="menu.jsp" />
    <div class="clientForm">
		<form name="clientSearchForm" action="login" method="post">
			<table class="searchTable">
				<tr>
                    <td colspan="2"><h3 class="h3_title_index">-Login-</h3></td>
                </tr>
				<tr>
                    <td><h4 class="form_title">Login Name:</h4></td>
                    <td><input type="text" name="username" placeholder="username"/></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Login Password:</h4></td>
                    <td><input type="password" name="password" placeholder="password"/></td>
                </tr>
                <tr>
                	<td></td>
                    <td><input id="loginButton" type="submit" value="Login"  /></td>
                </tr>
                <tr>
                	<td><span id ="error"><font color="red"><b>${error}</b></font></span></td>
                </tr>
			</table>
		</form>		
</div>
</body>
</html>