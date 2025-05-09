<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.portDTO, dao.portDAO" %>
<%
   request.setCharacterEncoding("UTF-8");  // 한글 출력을 위해 보조
   
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   portDAO dao = new portDAO();
   boolean success = dao.deleteContact(name, email);  // 삭제 메서드 호출
   if (success) {
       response.sendRedirect("list.jsp"); // 성공 시 리스트 페이지로 이동
   } else {
       out.println("삭제 실패");
   }
%>