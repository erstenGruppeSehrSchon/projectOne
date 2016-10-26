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
	<!--*********Edit profile form*********-->
	<div class="merchantForm">
		<form method="post" action="register" onsubmit="return validateForm()">
			<table>
                <tr>
                    <td colspan="2"><h3 class="h3_title_index">-Registration-</h3></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Username</h4></td>
                    <td><input id="merchantUsername" name="username" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Password</h4></td>
                    <td><input id="merchantPassword" name="password" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Re-enter Password</h4></td>
                    <td><input id="merchantrePassword" name="merchantPassword" type="text" class="form-control"></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Gender</h4></td>
                    <td>
                        <select type = "select" id="merchantGender" name="merchantGender" class="form-control">
                          <option value="M">M</option>
                          <option value="F">F</option>
                          <option value="Unknown">Unknown</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Birthday</h4></td>
                    <!--<td><input type="date" id="merchantBirthDate" name="merchantBirthDate" class="form-control"></td>-->
                    <td><input type="text" id="merchantBirthDate" name="merchantBirthDate" class="form-control"></td>
                </tr>
                <tr>
                    <td rowspan="2"><input type="submit" value="Register" class="btn btn-default"></td>
                </tr>
                <tr>
                    <span id="error"></span>
                </tr>
			</table>
		</form>		
	</div>
</div>

<script>
    // validate registration form
    function validateForm(){
        if(isEmpty($('#merchantUsername').text() ||
            isEmpty($('#merchantPassword').text() ||
            isEmpty($('#merchantrePassword').text() ||
            isEmpty($('#merchantBirthDate').text()){
           $('#error').text("Field cannot be empty");
            return false;
        }
        else if ($('#merchantPassword').text() != $('#merchantrePassword').text()){
           $('#error').text("Invalid password");
            return false;
        }
        return true;
    }
    
    function isEmpty(value) {
        return typeof value == 'string' && !value.trim() || typeof value == 'undefined' || value === null;
    }
</script>

</body>
</html>