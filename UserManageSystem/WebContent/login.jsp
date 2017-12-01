<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#CED3FE;">
<img src="img/logo1.jpg" style="width:50px">
<center >
login 
<% 
String err=request.getParameter("err");

if(err!=null){
   if(err.equals("1")){
	   out.println(" (you should login first!)");
   }

}
%>

<br>

   <hr>
   <form action="LoginClServlet" method="post">
   username:<input type="text" name="username"><br>
   password:<input type="password" name="password"><br>
   <input type="submit" value="login">
   <input type="reset" value="reset">
   <input type="button" onclick="window.location.href='adduser.jsp'" value="register">
   </form>
   <hr/>
 </center>
 
</body>
</html>