<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
          
          <% 
           	 String name = request.getParameter("title");
          %>
          <h3><%=java.net.URLDecoder.decode(name) %></h3>
          Today is <%=request.getParameter("date") %> 
</body>
</html>