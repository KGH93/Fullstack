package a0402.calendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateEx {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();  //현재 날짜와 시간
        System.out.println("기본 150 형식 : " + now);
        // 커스텀 format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM=dd hh:mm:ss a");
        String formattedDate = now.format(formatter);
        System.out.println("포맷팅된 날짜 :" + formattedDate);
    }
}
// MM을 소문자로 쓰면 분으로 인식됌
// MM dd 두개를 써야 04-02 처럼 앞에 0으로 채워짐
// HH 대문자를 쓴 이유는 24시간 표기  "yyyy-MM-dd HH:mm:ss "
// HH를 소문자로 쓰면 12시간 표기  "yyyy-MM-dd hh:mm:ss a"  뒤에 a는 am/pm 구분