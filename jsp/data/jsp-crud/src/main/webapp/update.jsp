<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.MemberDTO, dao.MemberDAO" %>
<%
int id = Integer.parseInt(request.getParameter("id"));
MemberDAO dao = new MemberDAO();
MemberDTO member = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 조회</h2>
	<form action="update_process.jsp" method="post">
	    <input type="hidden" name="id" value="<%=member.getId()%>"><br>
        이름: <input type="text" name="name" value="<%=member.getName()%>"><br>
        이메일: <input type="email" name="email" value="<%=member.getEmail()%>"><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>