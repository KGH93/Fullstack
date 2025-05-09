<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.MemberDTO , dao.MemberDAO"%>
<% 
    request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	MemberDTO m = new MemberDTO(); // MemberDTO 객체 생성
	m.setName(name); 
	m.setEmail(email);
	
	MemberDAO dao = new MemberDAO(); // MemberDAO 객체 생성
	dao.insertMember(m); // insertMember를 사용해 db에 저장
	response.sendRedirect("list.jsp"); // list.jsp로 리다이렉트 //새로고침
%>
    