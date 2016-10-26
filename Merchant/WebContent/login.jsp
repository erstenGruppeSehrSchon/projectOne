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
<form id='loginForm' action="login" method="post">
    Username: <input id='uname' name="username" /><br/>
    Password: <input id='pwd' name="password"/><br/>
    <input type='submit' value='LOGIN'/>
</form>
<span id ='error'>${error}</span>
</body>
</html>