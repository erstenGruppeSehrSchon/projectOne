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
	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />
    <div>
        <form action="login" method="post">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" placeholder="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">Login</button></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>