<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>-SAUSAGE HOUSE- | -client System-</title>
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
	<!--*********Edit profile form*********-->
	<div class="clientForm">
		<form method="post" action="">
			<table>
					<tr>
						<td colspan="2"><h3 class="h3_title_index">-Registration-</h3></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Username</h4></td>
						<td><input id="clientUsername" name="clientUsername" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Password</h4></td>
						<td><input id="clientPassword" name="clientPassword" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Re-enter Password</h4></td>
						<td><input id="clientrePassword" name="clientPassword" type="text" class="form-control"></td>
						<td><p id="validate-status" style="color:red;"></p></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Gender</h4></td>
						<td>
							<select type = "select" id="clientGender" name="clientGender" class="form-control">
							  <option value="M">M</option>
							  <option value="F">F</option>
							  <option value="Unknown">Unknown</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><h4 class="form_title">Birthday</h4></td>
						<!--<td><input type="date" id="clientBirthDate" name="clientBirthDate" class="form-control"></td>-->
						<td><input type="text" id="clientBirthDate" name="clientBirthDate" class="form-control"></td>
					</tr>
					<tr>
						<td rowspan="2"><input type="submit" value="Register" class="btn btn-default" id ="registerButton"></td>
					</tr>
			</table>
		</form>		
	</div>
</div>
<script>



function validate() {
	
	  var password1 = $("#clientPassword").val();
	  var password2 = $("#clientrePassword").val();

	    
	 
	    if(password1 == password2) {
	       $("#validate-status").text("valid");        
	    }
	    else {
	        $("#validate-status").text("invalid");  
	    }
	    
	}
	
$(document).ready(function() {
	
	  $("#clientPassword").keyup(validate);
	  $("#clientrePassword").keyup(validate);
	});
	
	
$(function(){
	
	
	$("#registerButton").on('click',function(){
		
		$ajax({
			type:'GET',
			url:'clientRegister',
			data:{username:document.getElementById("clientUsername").value,password:document.getElementById("clientPassword").value}
			
		})
		
	});
	
});


</script>

</body>
</html>