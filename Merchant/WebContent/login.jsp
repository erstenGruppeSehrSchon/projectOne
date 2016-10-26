<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<form id='loginForm'>
    Username: <input id='uname' /><br/>
    Password: <input id='pwd' /><br/>
    <input type='button' id='loginBut' value='LOGIN'/>
</form>
<span id ='text'></span>

<script>
    $(function(){
        $("#loginBut").on("click", function(e){
            alert($("#uname").val() + " ... " +$("#pwd").val());
            $.ajax({
                type:'POST',
                url:'login',
                data:{username:$("#uname").val(),password:$("#pwd").val()}
            }).done(function(msg){

                // = accepted
                if(msg.status === "Accepted"){
                    $('#text').text(msg.mid + " ... " +msg.status);
                }
                else{
                    $('#text').text(msg.mid + " ... " +msg.status);
                }
            });  
        }); 
    });
</script>
</body>
</html>