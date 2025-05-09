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
   String encType = "UTF-8"; //인코딩 타입
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
   ResultSet rs = null;
   
   String sql = "select * from book where b_id = ?";

   pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, bookId);
   rs = pstmt.executeQuery();
   
   if(rs.next()){
	   if(fileName != null){  
		   sql = "UPDATE book SET b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=?, b_fileName=? WHERE b_id=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, name);
		   pstmt.setInt(2, price);
		   pstmt.setString(3, author);
		   pstmt.setString(4, description);
		   pstmt.setString(5, publisher);
		   pstmt.setString(6, category);
		   pstmt.setLong(7, stock);
		   pstmt.setString(8, releaseDate);   
		   pstmt.setString(9, condition);
		   pstmt.setString(10, fileName);
		   pstmt.setString(11, bookId);
		   pstmt.executeUpdate();
	   }else{  // 새 이미지 파일을 업로드하지 않았다면
		   sql = "UPDATE book SET b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=? WHERE b_id=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, name);
		   pstmt.setInt(2, price);
		   pstmt.setString(3, author);
		   pstmt.setString(4, description);
		   pstmt.setString(5, publisher);
		   pstmt.setString(6, category);
		   pstmt.setLong(7, stock);
		   pstmt.setString(8, releaseDate);   
		   pstmt.setString(9, condition);
		   pstmt.setString(10, bookId);
		   pstmt.executeUpdate();
	   }
   }
	   
   
   if (pstmt != null)
		pstmt.close();
   if (conn != null)
	   	conn.close();
   response.sendRedirect("editBook.jsp?edit=update");
%>
