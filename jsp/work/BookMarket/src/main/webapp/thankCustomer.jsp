<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>주문 완료</title>
</head>
<body>
   <%
      String shopping_cartId = "";
      String shopping_name = "";
      String shopping_shoppingDate = "";
      String shopping_country = "";
      String shopping_zipCode = "";
      String shopping_addressName = "";      

      Cookie[] cookies = request.getCookies();

      if (cookies != null) {
         for (int i = 0; i < cookies.length; i++) {
            Cookie thisCookie = cookies[i];
            String n = thisCookie.getName();
            if (n.equals("Shopping_cartId"))
               shopping_cartId = URLDecoder.decode((thisCookie.getValue()), "utf-8");
            if (n.equals("Shopping_shoppingDate"))
               shopping_shoppingDate = URLDecoder.decode((thisCookie.getValue()), "utf-8");
         }
      }
   %>
   
   
<div class="container py-4">
   <%@ include file="menu.jsp"%>   

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">주문 완료</h1>
        <p class="col-md-8 fs-4">Order Completed</p>      
      </div>
    </div>
     
 
   
     <div class="row align-items-md-stretch ">
      <h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
      <p>주문은   <%   out.println(shopping_shoppingDate);   %>에 배송될 예정입니다! !   
      <p>주문번호 :   <%   out.println(shopping_cartId);   %>
   </div>
   <div class="container">
      <p><a href="./books.jsp" class="btn btn-secondary"> &laquo;도서 목록</a>
   </div>
   <%@ include file="footer.jsp"%>   
  </div>
</body>
</html>
<%
   session.invalidate();

   for (int i = 0; i < cookies.length; i++) {
      Cookie thisCookie = cookies[i];
      String n = thisCookie.getName();
      if (n.equals("Customer_Id"))
         thisCookie.setMaxAge(0);
      if (n.equals("Customer_name"))
         thisCookie.setMaxAge(0);
      if (n.equals("Customer_phoneNumber"))
         thisCookie.setMaxAge(0);
      if (n.equals("Customer_country"))
         thisCookie.setMaxAge(0);
      if (n.equals("Customer_zipCode"))
         thisCookie.setMaxAge(0);
      if (n.equals("Customer_addressName"))
         thisCookie.setMaxAge(0);

      if (n.equals("Shopping_cartId"))
         thisCookie.setMaxAge(0);
      if (n.equals("Shopping_name"))
         thisCookie.setMaxAge(0);
      if (n.equals("Shopping_shoppingDate"))
         thisCookie.setMaxAge(0);
      if (n.equals("Shopping_country"))
         thisCookie.setMaxAge(0);
      if (n.equals("Shopping_zipCode"))
         thisCookie.setMaxAge(0);
      if (n.equals("Shopping_addressName"))
         thisCookie.setMaxAge(0);
      
      response.addCookie(thisCookie);
   }
%>
