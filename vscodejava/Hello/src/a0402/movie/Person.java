package a0402.movie;

public class Person {
    private String name;
    private String phone;
    private String birth;
    private String id;
    private String pw;



    Person() {
		this.name = null;
		this.phone = null;
		this.birth = null;
		this.id = null;
		this.pw = null;
	}

    
    public Person(String name, String phone, String birth, String id, String pw) {
        this.name = name;
        this.phone = phone;
        this.birth = birth;
        this.id = id;
        this.pw = pw;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
}
