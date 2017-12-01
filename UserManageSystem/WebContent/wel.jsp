<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,com.jxy.model.*,com.jxy.controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#CED3FE">
<img src="img/logo1.jpg" style="width:50px">
<center>
<%
String u=(String)session.getAttribute("myName");
if(u==null){
	response.sendRedirect("login.jsp?err=1");
	return ;
}



%>




login sucessfully!!<br>
 <%=u %>
<a href="login.jsp">return to login page</a>
<a href="main.jsp">return to controlling page</a>
<hr>
<h1>list of userinformation</h1>
<%
   






   /*int pageNow=1;
   
   String s_pageNow=request.getParameter("pageNow");
   if(s_pageNow!=null){
	   pageNow=Integer.parseInt(s_pageNow);
   }*/
   
   
   ArrayList al=(ArrayList)request.getAttribute("al");
   %>
   <table border="1">
   <tr bgcolor="grey"><td>UserId</td><td>UserName</td><td>PassWord</td><td>Email address</td><td>Grade</td><td>modify</td><td>delete</td></tr>
   <% String []color={"silver","grey"};
      for(int i=0;i<al.size();i++){
    	  userbean ub=(userbean)al.get(i);
             %>
     <tr bgcolor=<%=color[i%2]%>><td><%=ub.getUserId()%></td><td><%=ub.getUserName() %></td><td><%=ub.getPassword() %></td><td><%=ub.getEmail() %></td><td><%=ub.getGrade() %></td>
     <td><a href="edit.jsp?id=<%=ub.getUserId()%>">modify</a></td><td><a onclick="return alert();" href="PageCl?flag=2&id=<%=ub.getUserId()%>">delete</a></td></tr>
     <%
   }
     %>
   </table>
   <%
   int pageNow=(Integer)request.getAttribute("pageNow");
   if(pageNow!=1){
   out.println("<a href=PageCl?flag=1&pageNow="+(pageNow-1)+">last page</a>");
   }
   int pageCount=(Integer)request.getAttribute("pageCount");
  
   for(int i=1;i<=pageCount;i++){
	   out.println("<a href=PageCl?flag=1&pageNow="+i+">["+i+"]</a>");
   }
   if(pageNow<pageCount){
   out.println("<a href=PageCl?flag=1&pageNow="+(pageNow+1)+">next page</a>"); 
   }
  

%>

</center>
<hr>
<script type="text/javascript">
function alert(){
	return window.confirm("are you sure to delete this account?");
}



</script>
</body>
</html>