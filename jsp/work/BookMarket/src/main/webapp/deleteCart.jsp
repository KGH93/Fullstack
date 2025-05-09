<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>

<% 
String id = request.getParameter("cartId");
if(id == null || id.trim().equals("")){
	response.sendRedirect("cart.jsp");
	//1d값이 없으면 book.jsp로 리턴
	return;
}
session.invalidate();    //세션 통쨰로 지우기
response.sendRedirect("cart.jsp");
%>