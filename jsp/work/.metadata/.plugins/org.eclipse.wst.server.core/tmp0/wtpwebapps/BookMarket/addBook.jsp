	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="dto.Book" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<jsp:useBean id="bookDAO" class="dao.BookRepository" scope="session" />
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=request.getContextPath()%>/resources/js/validation.js"></script>
	<title>도서 등록</title>
	</head>
	<body>
	<fmt:setLocale value='<%=request.getParameter("language")%>'/>
	<fmt:bundle basename="bundle.message">
	<div class="container py-4">
		<%@ include file = "menu.jsp" %>
	     
	   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
	      <div class="container-fluid py-5">
	        <h1 class="display-5 fw-bold"><fmt:message key="title"/></h1>
	        <p class="col-md-8 fs-4">Book Addition</p>      
	      </div>
	    </div>
	    <%
	    	String id = request.getParameter("id");
	        Book book = bookDAO.getBookById(id);
	    %>
	
	
	
	    <div class="row align-items-md-stretch">
	    	<div class="text-end">
	    		<a href="?language=ko">Korean</a> | <a href="?language=en">English </a>
	    		<a href="logout.jsp" class="btn btn-sm btn-success pull right">logout</a>
	    	</div>
	    	<form name="newBook" action="./processAddBook.jsp" method="post" enctype ="multipart/form-data">
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="bookId"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="bookId" id="bookId">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="name"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="name" id="name">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="unitPrice"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="unitPrice" id="unitPrice">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="author"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="author">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="publisher"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="publisher">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="releaseDate"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="releaseDate">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="description"/></label>
	    			<div class="col-sm-5">
	    				<textarea name="description" id="description" class="form-control" cols="50" rows="2" placeholder="100자 이상 적어주세요"></textarea>
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="category"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="category">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="unitsInStock"/></label>
	    			<div class="col-sm-3">
	    				<input type="text" class="form-control" name="unitsInStock" id="unitsInStock" >
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="condition"/></label>
	    			<div class="col-sm-5">
	    				<input type="radio" name="condition" value="New"><fmt:message key="condition_New"/>
	    				<input type="radio" name="condition" value="Old"><fmt:message key="condition_Old"/>
	    				<input type="radio" name="condition" value="EBook"><fmt:message key="condition_Ebook"/>
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<label class="col-sm-2"><fmt:message key="bookImage"/></label>
	    			<div class="col-sm-3">
	    				<input type="file" class="form-control" name="bookImage">
	    			</div>
	    		</div>
	    		<div class="mb-3 row">
	    			<div class="col-sm-offset-2 col-sm-10">
	    				<input type="button" class="btn btn-primary" value="<fmt:message key="button"/>" onclick="CheckAddBook()"/>
	    			</div>
	    		</div>
	    	</form>
	    </div>  
	    
	    
	    
	    <%@ include file = "footer.jsp" %>
	</div>  
	</fmt:bundle>
	</body>
	</html>
