<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.BookRepository" %>
<!--<jsp:useBean id="bookDAO" class="dao.BookRepository" scope="session"/>-->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container py-4">
   <%@ include file = "menu.jsp" %>    
    
   
   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
        <div class="container-fluid py-5">
            <h1 class="display-5 fw-bold">도서목록</h1>
            <p class="col-md-8 fs-4">BookList</p>
        </div>
    </div>

   <%@ include file = "dbconn.jsp" %>
    
    <div class="row align-items-md-stretch text-center">
 
      <%
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          String sql = "SELECT * FROM book";
          pstmt = conn.prepareStatement(sql);
          rs = pstmt.executeQuery();
          while(rs.next()){

      %>
       <div class="col-md-4">
          <div class="h-100 p-2">
             <img src="./resources/images/<%=rs.getString("b_filename")%>" style="width: 250px; height: 350px;">
             <h5><b><%=rs.getString("b_name")%></b></h5>
             <p><%=rs.getString("b_author")%></p>
             <p><%=rs.getString("b_publisher")%> | <%=("b_releaseDate")%></p>
             <p><%=rs.getString("b_description").substring(0,60) %>...</p>
             <p><%=rs.getString("b_unitPrice")%>원</p>
             <p><a href="./book.jsp?id=<%=rs.getString("b_id")%>" class="btn btn-secondary" role="button">상세정보 &raquo; </a></p>
                     
          </div>
       </div>
       <%
         }
       %>
    </div>
       
    <%@ include file = "footer.jsp" %>
</div>
</body>
</html>