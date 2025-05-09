<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.portDTO, dao.portDAO" %>
<%
String name = request.getParameter("name");
String email = request.getParameter("email");
portDAO dao = new portDAO();
portDTO contact = dao.getContact(name); // 이름으로 연락처 정보 가져오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Contact Search</h2>
	<form action="update_process.jsp" method="post">
		이름: <input type="text" name="name" value="<%=contact.getName()%>"><br>
        이메일: <input type="email" name="email" value="<%=contact.getEmail()%>"><br>
        Comment: <input type="text" name="comment" value="<%= contact.getComment() %>"><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>