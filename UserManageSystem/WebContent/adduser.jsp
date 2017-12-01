<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>please enter the information of a user</h1>
<form action="PageCl?flag=3" method="post">
 <table border="1">
    
    <tr><td>userName</td><td><input type="text" name="username"></td></tr>
    <tr><td>passWord</td><td><input type="text" name="password"></td></tr>
    <tr><td>E-mail</td><td><input type="text" name="emailaddress"></td></tr>
    <tr><td>Grade</td><td><input type="text" name="grade"></td></tr>
    <tr><td><input type="submit" value="submit"></td><td><input type="reset" value="reset"></td></tr>
    
 
 </table>
<br>
    


<input type="button" onclick="window.location.href='login.jsp'" value="return">
</form>
</center>
</body>
</html>