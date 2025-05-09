<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.portDTO , dao.portDAO"%>
<% 
    request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String comment = request.getParameter("comment");

	
	portDTO m = new portDTO(); // portDTO 객체 생성
	m.setName(name); 
	m.setEmail(email);
	m.setComment(comment); // portDTO에 값 저장
	
	portDAO dao = new portDAO(); // portDAO 객체 생성
	dao.insertContact(m); // insertCOntact를 사용해 db에 저장
	
    %>