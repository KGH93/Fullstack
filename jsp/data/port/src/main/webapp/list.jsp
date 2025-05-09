<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dto.portDTO, dao.portDAO" %>
<%
   	portDAO dao = new portDAO();
   	List<portDTO> list = dao.getAllContact(); // MemberDAO의 getAllMembers() 메서드를 호출하여 모든 회원 정보를 가져옴
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
<div class="container py-5">
<h2 class="mb-4">Contact List</h2>
<table class="table table-striped table-hover">
	<tr>
	    <th>이름</th>
        <th>이메일</th>
        <th>Comment</th>
    </tr>
    <%
    	for(portDTO c:list){
    %>
    <tr>
		<th><%=c.getName() %></th>
	    <th><%=c.getEmail() %></th>
        <th>
            <a href="update.jsp?id=<%=c.getName() %>" class="btn btn-sm btn-primary me-2">수정</a>
            <a href="delete.jsp?id=<%=c.getName() %>" class="btn btn-sm btn-danger">삭제</a>
        </th>
    </tr>
    <% } %>
</table>
<a href="insert.jsp" class="btn btn-success">Contact</a>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
</body>
</html>