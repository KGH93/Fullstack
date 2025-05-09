<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:useBean id="person" class="dao.Person" scope="request" />
   <p>아이디 : <%=person.getId()%>
   <p>이 름 : <%=person.getName()%>
   <%
      person.setId(20230824);
      person.setName("홍길동");
   %>
   <jsp:include page="useBean03.jsp"/>
   <%-- 기존 person 객체를 사용해서 id, name 출력 --%>
</body>
</html>
