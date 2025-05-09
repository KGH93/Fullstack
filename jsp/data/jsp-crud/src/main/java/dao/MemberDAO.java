package dao;
//함수 (메서드) 집합
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dto.MemberDTO;
import util.DBConnection;

public class MemberDAO {
	Connection conn = DBConnection.getConnection();  //db에 연결하기 위한 Connection 객체
	private ResultSet rs; // 결과 집합을 저장하기 위한 ResultSet 객체
	
	
	public void insertMember(MemberDTO m) {// 회원 정보를 추가하는 메서드
		String sql = "insert into members (name,email) values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.executeUpdate(); // executeUpdate()는 insert, update, delete에 사용
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void updateMember(MemberDTO m) {// 회원 정보를 수정하는 메서드
		String sql = "update members set name=?, email=? where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getEmail());
			ps.setInt(3, m.getId());
			ps.executeUpdate(); // executeUpdate()는 insert, update, delete에 사용
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	public void deleteMember(int id) {// 회원 정보를 삭제하는 메서드
		String sql = "delete from members where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // ?에 id값을 넣어줌
			ps.executeUpdate(); // executeUpdate()는 insert, update, delete에 사용
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public List<MemberDTO> getAllMembers() { // 전체 회원 목록을 가져오는 메서드
		List<MemberDTO> list = new ArrayList<MemberDTO>(); // 회원 목록을 저장하기 위한 List 객체
		String sql = "select * from members";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();  //읽을 때는 executeQuery()를 사용
			while(rs.next()) { 
				MemberDTO m = new MemberDTO();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	public MemberDTO getMember(int id) { // 회원 정보를 가져오는 메서드
		String sql = "select * from members where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id); // ?에 id값을 넣어줌
			rs = ps.executeQuery(); // DB를 읽을 때는 executeQuery()를 사용
			if(rs.next()) { // 결과 집합에서 다음 id가 있으면 정보 반환
				MemberDTO m = new MemberDTO();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				return m;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

