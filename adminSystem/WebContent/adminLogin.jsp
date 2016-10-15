<!DOCTYPE html>
<head>
<title>-SAUSAGE HOUSE-</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<div class="container">
  <header>
    <div id="logo"><a href="index.html"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="#">Search</a></li>
      <li><a href="#">My Profile</a></li>
    </ul>
  </nav>
  <div id="main">
	 <div class="block-divider"></div>
		<form id="admin-login-form" action="login" method="POST">
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
			<div id="admin-logn-form-error">${errorMsg}</div>
			<br/>
			<input type="submit" value="Login" class="btn btn-default">
		</form>
  </div>
</div>
</body>
</html>