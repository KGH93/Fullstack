<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
         <h3>param2 액션 태그</h3>
   <jsp:forward page="param02_data.jsp">
      <jsp:param name="id" value="admin"/>
	  <jsp:param name="name" value='<%=java.net.URLEncoder.encode("관리자")%>' />
   </jsp:forward>
   <p> Jakarta Server Pages</p>
</html>