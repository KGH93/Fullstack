package dto;
//정보저장 및 전달을 위한 DTO(Data Transfer Object) 클래스
public class MemberDTO {
	
	private int id;
	private String name;
	private String email;
	
	// alt + shift + s -> Generate Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
