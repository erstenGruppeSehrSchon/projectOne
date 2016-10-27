<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--*********header*********-->
<div class="header">
	<div class="contact" id = "contact"><a href="#">Home</a></div>
	<div class="login"> <a href="#" id = "loggedin"></a> <a href="#" id = "logstatus"></a> </div>
</div>

<script>

var username = localStorage.getItem("username");

if(username!=null){
	
	$('#logstatus').text("Logout");
	$('#logstatus').addClass("Logout");
	$('#logstatus').attr("title","Login out");
	$('#logstatus').on('click',function(event){
		event.preventDefault();
		localStorage.clear();
		window.location.assign("login.jsp");
	});
	
	$('#loggedin').text("Logged in as " + username + " | ");
	$('#loggedin').attr("title","Details");
	$('#loggedin').on('click',function(event){
        event.preventDefault();
        //window.location.assign("") go to show detail page
    });
	
	
	
	
}else if(username == null){

	$('#logstatus').text("Login");
	$('#logstatus').attr("title", "Login");
    $('#logstatus').on('click',function(event){
    	event.preventDefault();
		window.location.assign("login.jsp");
	});
}

</script>

