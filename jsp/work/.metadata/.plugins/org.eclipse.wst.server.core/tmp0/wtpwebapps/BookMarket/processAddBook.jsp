<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>

<%
   request.setCharacterEncoding("UTF-8");


   String filename = "";
   //String realFolder = "C:\\upload"; //웹 어플리케이션상의 절대 경로


   String realFolder = "D:\\KGH\\jsp\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BookMarket\\resources\\images";
   String encType = "utf-8"; //인코딩 타입
   int maxSize = 5 * 1024 * 1024; //최대 업로드될 파일의 크기5Mb
   
   MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());  //new DefaultFileRenamePolicy()) 파일명을 변경해줌
   

   String bookId = multi.getParameter("bookId");
   String name = multi.getParameter("name");
   String unitPrice = multi.getParameter("unitPrice");
   String author = multi.getParameter("author");
   String publisher = multi.getParameter("publisher");
   String releaseDate = multi.getParameter("releaseDate");   
   String description = multi.getParameter("description");   
   String category = multi.getParameter("category");
   String unitsInStock = multi.getParameter("unitsInStock");
   String condition = multi.getParameter("condition");

   int price;

   if (unitPrice.isEmpty())
      price = 0;
   else
      price = Integer.valueOf(unitPrice);

   long stock;

   if (unitsInStock.isEmpty())
      stock = 0;
   else
      stock = Long.valueOf(unitsInStock);
   
   
   //파일명 중복처리
   Enumeration files = multi.getFileNames();
   String fname = (String) files.nextElement();
   String fileName = multi.getFilesystemName(fname);
   
   PreparedStatement pstmt = null;
   String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";

   pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, bookId);
   pstmt.setString(2, name);
   pstmt.setInt(3, price);
   pstmt.setString(4, author);
   pstmt.setString(5, description);
   pstmt.setString(6, publisher);
   pstmt.setString(7, category);
   pstmt.setLong(8, stock);
   pstmt.setString(9, releaseDate);   
   pstmt.setString(10, condition);
   pstmt.setString(11, fileName);
   pstmt.executeUpdate();
   
   if (pstmt != null)
		pstmt.close();
   if (conn != null)
	   	conn.close();
   
   response.sendRedirect("books.jsp");
%>
