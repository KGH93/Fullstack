<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.MemberDTO, dao.MemberDAO" %>
<%
   request.setCharacterEncoding("UTF-8");  // 한글 깨지지 마라고 써줌
   
   int id = Integer.parseInt(request.getParameter("id"));
   MemberDAO dao = new MemberDAO();
   dao.deleteMember(id);  // MemberDAO의 updateMember 메소드를 호출하여 DB에 저장
   response.sendRedirect("list.jsp");  // list.jsp로 이동
   // sendRedirect : list.jsp로 이동하면서 새로고침
%>