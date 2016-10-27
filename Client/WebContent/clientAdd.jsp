<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-SAUSAGE HOUSE- | -client System-</title>
<link rel="stylesheet" type="text/css" href="./css/style.css" />
<link rel="stylesheet" type="text/css" href="./css/jquery.slider.css" />
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="./headerGuest.jsp" />
	<jsp:include page="./menu.jsp" />
	<!--*********container*********-->
	<div class="container">
		<!--*********Edit profile form*********-->
		<div class="clientForm">
			<form>
				<table>
					<tr>
						<td colspan="2"><h3 class="h3_title_index">-Registration-</h3></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Username</h4></td>
						<td><input id="clientUsername" name="clientUsername"
							type="text" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Password</h4></td>
						<td><input id="clientPassword" name="clientPassword"
							type="password" class="form-control"></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Re-enter Password</h4></td>
						<td><input id="clientrePassword" name="clientPassword"
							type="password" class="form-control"></td>
						<td><p id="validate-status" style="color: red;"></p></td>
					</tr>
					<tr>
						<td><h4 class="form_title">Address</h4>
					</tr>
					<tr>
						<td></td>
						<td id="addressList">
							<div id="addressBox0"></div>
						</td>
					</tr>
					<tr>
						<td><span class="glyphicon glyphicon-plus"
							onclick="addAddress()"></span></td>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="Register"
							class="btn btn-default" id="registerButton"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>

<script type="text/javascript">
	var countAddAddress = 0;
	var AddressArray = [];
	var Address = {};

	function addAddress() {
		countAddAddress++;
		var p = "<p>Address " + countAddAddress + ":</p>";
		
		var country = "<input id=\"addressBoxCountry"+countAddAddress+"\" name=\"addressBoxCountry"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Country\">";
		var city = "<input id=\"addressBoxCity"+countAddAddress+"\" name=\"addressBoxCity"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"City\">";
		var district = "<input id=\"addressBoxDistrict"+countAddAddress+"\" name=\"addressBoxDistrict"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"District\">";
		var street = "<input id=\"addressBoxStreet"+countAddAddress+"\" name=\"addressBoxStreet"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Street\">";
		var building = "<input id=\"addressBoxBuilding"+countAddAddress+"\" name=\"addressBoxBuilding"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Building\">";
		var room = "<input id=\"addressBoxRoom"+countAddAddress+"\" name=\"addressBoxRoom"+countAddAddress+"\" type=\"text\" class=\"form-control\" placeholder=\"Room\">";

		var div = document.createElement("div");
		div.setAttribute("id", "addressBox" + countAddAddress);
		div.setAttribute("name", "addressBox");

		div.innerHTML = p + country + city + district + street + building
				+ room;

		document.getElementById("addressBox" + (countAddAddress - 1))
				.appendChild(div);
	}

	function validate() {

		var password1 = $("#clientPassword").val();
		var password2 = $("#clientrePassword").val();

		if (!password1) {
			$("#validate-status").text("Password can't be empty");
		} else if (password1 == password2) {
			$("#validate-status").text("Password match");
		} else if (password1 != password2) {
			$("#validate-status").text("Password not match");
		}


	}

	$(document).ready(function() {

		$("#clientPassword").keyup(validate);
		$("#clientrePassword").keyup(validate);
	});

	window.onload = addAddress();

	$(function() {
		

		$("#registerButton")
				.on(
						'click',
						function(event) {
							
				        	event.preventDefault();
				        	
				        	
                            if(document.getElementById("clientPassword").value == document.getElementById("clientrePassword").value){
				        		
				        	
				        	
							
				   
							

							for (var i = 1; i <= countAddAddress; i++) {
								console.log(countAddAddress);
								Address.city = document
										.getElementById("addressBoxCity" + i).value;
								Address.room = document
										.getElementById("addressBoxRoom" + i).value;
								Address.street = document
										.getElementById("addressBoxStreet" + i).value;
								Address.building = document
										.getElementById("addressBoxBuilding"+ i).value;
								Address.district = document
										.getElementById("addressBoxDistrict" + i).value;
								Address.country = document
										.getElementById("addressBoxCountry" + i).value;
								
								AddressArray.push(Address);
								Address = {};
							}
							
							AddressList =JSON.stringify(AddressArray);
				
							

							$.ajax({
								contentType: 'application/json; charset=utf-8',
					            dataType: 'json',
								type : 'GET',
								url : 'clientRegister',
								data : {
									username : document
											.getElementById("clientUsername").value,
									password : document
											.getElementById("clientPassword").value,
									addresses :AddressList
								},
								success:function(client){
									
									if(client.password == "Empty"){
										
										alert("Your Empty Something");
									}
									
									else if(client.password == "Registered"){
										
										alert("Your Name is Registered");
					
									}else{
										
										alert("Login in as " + client.username);
										localStorage.setItem("username", client.username);
										console.log(localStorage.getItem("username"));
										window.location.assign("index.jsp");
										
									}
									
								},
								error:function(){
									alert("Error occur at Ajax");
								}
							//need change addresses

							});

						}else{
							
							
						}
                            
						});

	});
</script>
</html>