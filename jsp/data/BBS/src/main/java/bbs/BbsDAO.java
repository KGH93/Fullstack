package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BbsDAO {
			
	private Connection conn;	//자바와 데이터베이스를 연결
	private PreparedStatement pstmt; //쿼리문 대기및 설정
	private ResultSet rs;	//결과 값 받아오기
	   
	   public BbsDAO() { //Db 연결
	      try {
	         String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
	         String dbID = "root";
	         String dbPassword = "1234";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      
	   }
	   
	   public String getDate() {
	      String SQL = "SELECT NOW()";
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(SQL);
	         
	         rs= pstmt.executeQuery();
	         
	         if(rs.next()) {
	            return rs.getString(1);
	         }
	                  
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return ""; // 데이터베이스 오류
	   }
	   
	   public int getNext() {
	      String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(SQL);
	         
	         rs= pstmt.executeQuery();
	         
	         if(rs.next()) {
	            return rs.getInt(1) + 1;
	         }
	         return 1; // 첫 번째 게시물인 경우
	                  
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return -1; // 데이터베이스 오류
	   }
	   
	   public int write(String bbsTitle, String userID, String bbsContent) {
	      String SQL = "INSERT INTO BBS VALUES (?, ?, ?, ?, ?, ?)"; 
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(SQL);
	         
	         pstmt.setInt(1,  getNext()); // 다음 글 번호 // 위에 자동 증가 함수 만듬
	         pstmt.setString(2,  bbsTitle); // 제목 
	         pstmt.setString(3,  userID); // 작성자
	         pstmt.setString(4,  getDate()); // 작성일
	         pstmt.setString(5,  bbsContent); // 내용
	         pstmt.setInt(6,  1); // 사용 가능 여부
	         return pstmt.executeUpdate(); 
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return -1; // 데이터베이스 오류
	   }
	   
	   
	   public ArrayList<Bbs> getList(int pageNumber) {
	      String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 10"; // 페이지당 10개씩
	      ArrayList<Bbs> list = new ArrayList<Bbs>();
	      try {
	         PreparedStatement pstmt = conn.prepareStatement(SQL);
	         pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // 페이지 번호에 따라 글 번호를 설정
	         rs = pstmt.executeQuery();
		      while(rs.next()) {
		    	  Bbs bbs = new Bbs(); // Bbs 객체 생성
		    	  bbs.setBbsID(rs.getInt(1));  // 글 번호
		    	  bbs.setBbsTitle(rs.getString(2));  // 제목
		    	  bbs.setUserID(rs.getString(3));  // 작성자
		    	  bbs.setBbsDate(rs.getString(4));  // 작성일
		    	  bbs.setBbsContent(rs.getString(5));  // 내용
		    	  bbs.setBbsAvailable(rs.getInt(6));  // 사용 가능 여부
		    	  list.add(bbs); // 리스트에 추가
		      }
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return list; 
	   }
	   // 가정: 현재 bbsID가 24개 존재한다면 (즉, getNext() = 25)
	   // getList(1) -> bbsID < 25 -> 24부터 15까지 최신순 10개 
	   // getList(2) -> bbsID < 15 -> 14부터 5까지 최신순 10개
	   // getList(3) -> bbsID < 5 -> 4부터 1까지 최신순 4개
	   
	   
	   //페이징 처리 메소드
	   public boolean nextPage(int pageNumber) {
		   String SQL = "SELECT * FROM BBS WHERE bbsID < ? AND bbsAvailable = 1";
		   try {
			   PreparedStatement pstmt = conn.prepareStatement(SQL);
			   pstmt.setInt(1, getNext() - (pageNumber - 1) * 10); // 페이지 번호에 따라 글 번호를 설정
			   rs = pstmt.executeQuery();
			   
			   if(rs.next()) {
				   return true; // 다음 페이지가 존재함
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return false; // 다음 페이지가 존재하지 않음
	   }
	   
	   
	   //하나의 게시글을 보는 메서드
	   public Bbs getBbs(int bbsID) {
		   String SQL = "SELECT * FROM BBS WHERE bbsID = ?";
		   try {
			   PreparedStatement pstmt = conn.prepareStatement(SQL);
			   pstmt.setInt(1, bbsID);
			   rs = pstmt.executeQuery();
			   if(rs.next()) {
				   Bbs bbs = new Bbs(); // Bbs 객체 생성
				   bbs.setBbsID(rs.getInt(1));  // 글 번호
				   bbs.setBbsTitle(rs.getString(2));  // 제목
				   bbs.setUserID(rs.getString(3));  // 작성자
				   bbs.setBbsDate(rs.getString(4));  // 작성일
				   bbs.setBbsContent(rs.getString(5));  // 내용
				   bbs.setBbsAvailable(rs.getInt(6));  // 사용 가능 여부
				   return bbs; // 게시글 반환
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   return null; 
	   }
	   
	  
	   
	   
	   
	   //게시글 수정 메서드
	   public int update(int bbsID, String bbsTitle, String bbsContent) { // id와 글제목, 글내용을 받아옴
		   //실제 데이터를 삭제하는 것이 아니라 게시글 유효숫자를 '0'으로 수정한다.
		   String SQL = "update bbs set bbsTitle = ?, bbsContent = ? where bbsID = ?";
		   try {
			   PreparedStatement pstmt = conn.prepareStatement(SQL);
			   pstmt.setString(1, bbsTitle);
			   pstmt.setString(2, bbsContent);
			   pstmt.setInt(3, bbsID);
			   return pstmt.executeUpdate(); // 성공적으로 삭제된 행의 수를 반환
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   return -1; // 데이터베이스 오류
	   }
	   
	   
	   
	   //게시글 삭제 메서드
	   public int delete(int bbsID) {
		   //실제 데이터를 삭제하는 것이 아니라 게시글 유효숫자를 '0'으로 수정한다.
		   String SQL = "update bbs set bbsAvailable = 0 where bbsID = ?";
		   try {
			   PreparedStatement pstmt = conn.prepareStatement(SQL);
			   pstmt.setInt(1, bbsID);
			   return pstmt.executeUpdate(); // 성공적으로 삭제된 행의 수를 반환
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
		   return -1; // 데이터베이스 오류
	   }
	   
	   
	   
}