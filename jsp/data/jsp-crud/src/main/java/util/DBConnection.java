package util;
//mysql에 연결하기 위한 DBConnection 클래스
import java.sql.*;

public class DBConnection {
	public static Connection getConnection() { //jsp에서 mysql에 연결하기 위한 메서드
		Connection conn = null;
		try {
	         String dbURL = "jdbc:mysql://localhost:3306/jsp_crud?serverTimezone=UTC";
	         String dbID = "root";
	         String dbPassword = "1234";
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
		
		return conn;
	}
}
