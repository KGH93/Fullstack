package util;
import java.sql.*;
//mysql에 연결하기 위한 DBConnection 클래스
public class DBConnection {
	
	public static Connection getConnection() { //jsp에서 mysql에 연결하기 위한 메서드
		Connection conn = null;
		try {
			 String dbURL = "jdbc:mysql://localhost:3306/jsp_crud?serverTimezone=UTC"; //DB URL
	         String dbID = "root"; //DB ID
	         String dbPassword = "1234"; //DB Password
	         Class.forName("com.mysql.cj.jdbc.Driver"); //JDBC 드라이버 로드
	         conn = DriverManager.getConnection(dbURL, dbID, dbPassword); //DB에 연결
	   }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
			return conn; //DBConnection.getConnection() 메서드를 호출하면 DB에 연결된 Connection 객체를 반환
	}
}
