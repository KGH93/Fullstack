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
	    String id = request.getParameter("id");
	    String password = request.getParameter("password");
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    String phone2 = request.getParameter("phone2");
	    String phone3 = request.getParameter("phone3");
	    String sex = request.getParameter("sex");
	    String[] hobby = request.getParameterValues("hobby");
	    String comment = request.getParameter("comment");
	%>
	<p>아이디 : <%=id %><br>
	<p>비번 : <%=password %><br>
	<p>이름 : <%=name %><br>
	<p>연락처 : <%=phone %>-<%=phone2 %>-<%=phone3 %><br>
	<p>성별 : <%=sex %>
	<p>취미 : <%
		        if(hobby != null) {
                	for(int i = 0; i < hobby.length; i++) {
                		out.print(" " + hobby[i]);
                	}
		        }
	         %>
	<p>가입인사 : <%=comment %><br>
</body>
</html>