<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-Qing Mi Ji Rou Chang-</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href = "css/stylesheet.css">
</head>
<body>
	<div class = "adminHeaderBar">
		<h3>-Qing Mi Ji Rou Chang-</h3>
		<h4>Admin Page</h4>
	</div>
	<div class = "adminContainer">
		<div id = "adminContainerForm">
		<h5>-Admin Login-</h5>
			<form action="login" method="POST">
				<div class="input-group">
					<span class="input-group-addon"><span class = "glyphicon glyphicon-user"></span></span>
					<input name="adminLoginName" type="text" class="form-control" placeholder="Username">
				</div>
				<br/>
				<div class="input-group">
					<span class="input-group-addon"><span class = "glyphicon glyphicon-menu-right"></span></span>
					<input name="adminLoginPassword" type="text" class="form-control" placeholder="Password"> 
				</div>
				<br/>
				${errorMsg}
				<br/>
				<input type="submit" value="Login" class="btn btn-default">
			</form>
		</div>
	</div>
</body>
</html>