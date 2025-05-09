package a0402.movie;

import java.time.LocalDate;
import java.time.Period;

public class Customer {  //이용객
    private String phone;   // 전화번호 // 이름대신 전화번호4글자로 기록
    private int birthDate;  // 생년월일 6글자
    private String pw;      // 패스워드
    private String seat;    // 예매좌석

    
    public Customer(String phone, int birthDate, String pw) {    // 비밀번호 추가 데이터
        this.phone = phone;
        this.birthDate = birthDate;
        this.pw = pw;
    }


    public Customer(String phone, int birthDate) {   // 예매전 받는 데이터
        this.phone = phone;
        this.birthDate = birthDate;
    }


    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }



    public boolean adult18(Customer p){    // 성인미만 규제 메서드
        int y = p.birthDate / 10000;
        int m = (p.birthDate % 10000) / 100;
        int d = p.birthDate % 100;

        if(y>0 && y <=25){ y = y + 2000;}
        else{ y += 1900;}

        LocalDate birDates = LocalDate.of(y, m, d);
        LocalDate nowDate = LocalDate.now();
        int age = Period.between(birDates, nowDate).getYears();
        return age > 18;
    }
}
