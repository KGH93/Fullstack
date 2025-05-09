<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.portDTO , dao.portDAO"%>
<% 
    request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String comment = request.getParameter("comment");
	portDTO c = new portDTO(); // portDTO 객체 생성
	c.setName(name); 
	c.setEmail(email);
	c.setComment(comment); // portDTO에 값 저장
	
	portDAO dao = new portDAO(); // portDAO 객체 생성
	dao.updateContact(c); // updateMember를 사용해 db에 저장
	response.sendRedirect("list.jsp"); // list.jsp로 리다이렉트 //새로고침
	
%>
    