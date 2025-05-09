package dto;
//정보저장 및 전달을 위한 DTO(Data Transfer Object) 클래스
public class portDTO {
	private String Name;
	private String Email;
	private String Comment;
	
	// alt + shift + s -> Generate Getters and Setters
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
}
