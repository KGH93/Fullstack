<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Book"%>
<%@ page import="dao.BookRepository"%>

<% 
String id = request.getParameter("id");
if(id == null || id.trim().equals("")){
	response.sendRedirect("books.jsp");
	//1d값이 없으면 book.jsp로 리턴
	return;
}

BookRepository dao = BookRepository.getInstance();
Book book = dao.getBookById(id);
//해당 id에 해당하는 book 객체를 가져와 product에 담는다.
if (book == null) {
   response.sendRedirect("exceptionNoBookId.jsp");
}

ArrayList<Book> cartList = (ArrayList<Book>)session.getAttribute("cartlist");
Book goodsQnt = new Book();
for(int i=0; i < cartList.size(); i++){
	goodsQnt = cartList.get(i);
	if(goodsQnt.getBookId().equals(id)){
		cartList.remove(goodsQnt);
	}
}

response.sendRedirect("cart.jsp");
%>