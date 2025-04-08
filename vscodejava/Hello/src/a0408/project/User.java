package a0408.project;

public class User {
    private int userId;
    private String name;
    private String phone;




    
    public User(int userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }


    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
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



    @Override
    public String toString() {
        return "[ " + userId + " , 회원명 : " + name + " 님, 전화번호 : " + phone + " ]";
    }
}
