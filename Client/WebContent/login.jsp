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
<jsp:include page="./headerGuest.jsp" />
<jsp:include page="./menu.jsp" />
<!--*********container*********-->
<div class="container">
	<!--*********Search form*********-->
	<div class="clientForm">
		<form name="clientSearchForm">
			<table class="searchTable">
				<tr>
                    <td colspan="2"><h3 class="h3_title_index">-Login-</h3></td>
                </tr>
				<tr>
                    <td><h4 class="form_title">Login Name:</h4></td>
                    <td><input type="text" name="username" id="username"/></td>
                </tr>
                <tr>
                    <td><h4 class="form_title">Login Password:</h4></td>
                    <td><input type="password" name="password" id="password"/></td>
                </tr>
                <tr>
                	<td><p id="validate-status" style="color:red;"></p></td>
                    <td><input id="loginButton" type="submit" value="Login"  /></td>
                    <td><input type="submit" value="Join us!" id = "registerButton"/></td>

                </tr>
			</table>
		</form>		
		
	</div>
</div>
<script>

      function isSet(val) { 
	   return ((val != undefined) && (val != null));
	   }
      
      function ClearLocal(){
    	  localStorage.clear();
      }

   window.onload = ClearLocal();
   
   $(function(){
        
         $("#loginButton").on("click",function(event){
        	event.preventDefault();
             $.ajax({
                 type:'GET',
                 url:'clientLogin',
                 data:{username:document.getElementById("username").value,password:document.getElementById("password").value},
                 success:function(client){
                     console.log(client.username);
                	 if(client.username != undefined){
                		 localStorage.setItem("username", client.username);
                		 localStorage.setItem("userObj", client);
                		 window.location.assign('index.jsp');
                	 }else{
                		 
                		 $("#validate-status").text("Login Failed");
                		 console.log("Login fail");
                		 
                	 }
                	 
                 },
                 error:function(){
                	 
                 }
                 
                        
                 
             });
             
           
              });
         
         
         $("#registerButton").on('click',function(event){
        	 event.preventDefault();
        	 window.location.assign('clientAdd.jsp');
         });
             
  
    });
    
    
</script>
</body>
</html>