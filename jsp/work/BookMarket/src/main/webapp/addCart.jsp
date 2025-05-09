<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
Book product = dao.getBookById(id);
//해당 id에 해당하는 book 객체를 가져와 product에 담는다.
if (product == null) {
   response.sendRedirect("exceptionNoBookId.jsp");
}

ArrayList<Book> goodsList = dao.getAllBooks();
//모든 책을 가져와서 goodList 저장
Book goods = new Book();
for (int i = 0; i < goodsList.size(); i++) {
   goods = goodsList.get(i);
   if (goods.getBookId().equals(id)) {          
      break;
   }
}
//주문하기에서 클릭한 id 해당하는 리스트를 돌면서 goods(book)을 불러옴


ArrayList<Book> list = (ArrayList<Book>) session.getAttribute("cartlist");
// cartlist 있을경우  list에 담는다. 
if (list == null) { 
   list = new ArrayList<Book>();
   session.setAttribute("cartlist", list);
   //cartlist 없을경우 새로운 장바구니를 만들어 비어있는 장바구니를 반환
}

int cnt = 0;
Book goodsQnt = new Book();
for (int i = 0; i < list.size(); i++) {
   goodsQnt = list.get(i);
   if (goodsQnt.getBookId().equals(id)) {
      cnt++; 
      int orderQuantity = goodsQnt.getQuantity() + 1;
      goodsQnt.setQuantity(orderQuantity);
      //list에 이미 책이 있으면 수량만 변경
   }
}



if (cnt == 0) { 
   goods.setQuantity(1);
   list.add(goods);
}
//cnt == 0 새책이면 goods(book객체) 수량을 하나 넣고 list에 goods를 추가

//list.add(goods); 를 호출하더라도
//list는 세션에 저장된 리스트와 같은 객체(참조)이기 때문에
//session.setArrtribute()를 하지 않아도 세션 내 리스트가 변경된다.  list와 cartlist는 같은 

response.sendRedirect("book.jsp?id=" + id);
%>