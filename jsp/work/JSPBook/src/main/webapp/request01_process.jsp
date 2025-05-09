<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	    String userid = request.getParameter("id");
	    String password = request.getParameter("password");
	%>
	<p>아이디 : <%=userid %></p><br>
	<p>비밀번호 : <%=password %></p><br>
	요청 정보 길이 : <%= request.getContentLength()%><br>
        클라이언트 전송 방식 : <%= request.getMethod()%><br>
        요청 URI : <%= request.getRequestURI()%><br>
        서버 이름 : <%=request.getServerName()%><br>
        서버 포트 : <%=request.getServerPort()%><br>
</body>
</html>