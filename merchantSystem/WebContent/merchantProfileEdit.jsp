<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>-SAUSAGE HOUSE-</title>
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
    <div id="logo"><a href="./merchantIndex.jsp"><img src="img/logo.png" alt=""></a></div>
  </header>
  <nav>
    <ul id="nav">
      <li><a href="./merchantSearch.jsp">Search</a></li>
      <li><a href="./merchantShowAllShop.jsp">Manage My Shops</a></li>
      <li><a href="./merchantShowAllDishes.jsp">Manage My Dishes</a></li>
      <li><a href="./merchantViewProfile.jsp">My Profile</a></li>
      <li><a href="./merchantLogin.jsp">Logout</a></li>
    </ul>
  </nav>
  <div id="main">
	<h3>Edit My Profile</h3>
	<div class="merchant-form-control">
<form action="editProfile" method="post"> 
<table>
	<tr>		
		<th colspan = "3">-My Profile-</th>
		<input type="hidden" name="mid" class = "form-control" value="${mid }"/>
	</tr>
	<tr>
		<td rowspan="6"><img src= "http://www.icon2s.com/img256/256x256-black-white-android-user.png"/></td>
		<td>Merchant Name:</td>
		<td><input type="text" name="merchantName" class = "form-control" value="${name }"/></td>
	</tr>
	<tr>
		<td>Old Password:</td>
		<td><input type = "text" name="merchantOldPassword" class = "form-control"/></td>
	</tr>
	<tr>
		<td>New password:</td>
		<td><input type = "text" name="merchantNewPassword" class = "form-control"/></td>
	</tr>
	<tr>
		<td>Birthday:</td>
		<td><input type = "text" name="merchantBirth" class = "form-control" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
            value="${merchant.birth}"/>"/></td>
	</tr>
	<tr>
		<td>Gender:</td>
		<td><input type = "text" name="merchantGender" class = "form-control" value="${gender}"/></td>
	</tr>
	<!--<tr>
		<td>Icon:</td>
		<td><form action="FileUpload" method="POST" enctype="multipart/form-data">
			<label class="btn btn-default">
				 Choose<input type="file" name="searchMerchantIconFile" style="display: none;">
			</label>
			</form></td>
	</tr>-->
</table>
<br/>
<br/>
{$errorMsg}
<br/>
<br/>
<input type="submit" value="Submit" class="btn btn-default">
</form>
	</div>
  </div>
</div>
</body>
</html>