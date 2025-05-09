package dao;
//함수 (메서드) 집합
import dto.portDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection; 

public class portDAO {
	Connection conn = DBConnection.getConnection();  //db에 연결하기 위한 Connection 객체
	private ResultSet r; // 결과 집합을 저장하기 위한 ResultSet 객체
	
	
	
	public void insertContact(portDTO c) { //DB에 데이터 삽입을 위한 메서드
		String sql = "INSERT INTO contact (name, email, comment) VALUES (?, ?, ?)"; //SQL 쿼리문
		try {
			PreparedStatement ps = conn.prepareStatement(sql); //PreparedStatement 객체 생성
			ps.setString(1, c.getName()); //첫 번째 물음표에 이름 삽입
			ps.setString(2, c.getEmail()); //두 번째 물음표에 이메일 삽입
			ps.setString(3, c.getComment()); //세 번째 물음표에 댓글 삽입
			ps.executeUpdate(); //SQL 쿼리 실행
		} catch (SQLException e) {
			e.printStackTrace(); //예외 발생 시 스택 트레이스 출력
		}
	}
	
	
	
	public void updateContact(portDTO c) {// Contact 정보를 수정하는 메서드
		String sql = "update contact set name=?, email=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.executeUpdate(); // executeUpdate()는 insert, update, delete에 사용
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	public boolean deleteContact(String name,String email) {// 회원 정보를 삭제하는 메서드
		String sql = "delete from contact where name=? AND email = ?"; // 이름과 이메일을 기준으로 삭제
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name); // ?에 이름을 넣어줌
			ps.setString(2, email); // ?에 이메일을 넣어줌
			return ps.executeUpdate() > 0; // executeUpdate()는 insert, update, delete에 사용
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false; // 삭제 실패 시 false 반환
	}

	
	
	public portDTO getContact(String name) { // Contact 정보를 가져오는 메서드
		String sql = "select * from contact where name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name); // ?에 이름을 넣어줌
			r = ps.executeQuery(); // DB를 읽을 때는 executeQuery()를 사용
			if(r.next()) { // 결과 집합에서 다음 id가 있으면 정보 반환
				portDTO c = new portDTO();
				c.setName(r.getString("name"));
				c.setEmail(r.getString("email"));
				c.setComment(r.getString("comment"));
				return c;// 결과 집합에서 가져온 정보를 DTO에 저장
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public List<portDTO> getAllContact() { // 전체 회원 목록을 가져오는 메서드
		List<portDTO> list = new ArrayList<portDTO>(); // 회원 목록을 저장하기 위한 List 객체
		String sql = "select * from contact"; // 전체 회원 목록을 가져오는 SQL 쿼리문
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			r = ps.executeQuery();  //읽을 때는 executeQuery()를 사용
			while(r.next()) { 
				portDTO c = new portDTO();
				c.setName(r.getString("name"));
				c.setEmail(r.getString("email"));
				c.setComment(r.getString("comment"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}

