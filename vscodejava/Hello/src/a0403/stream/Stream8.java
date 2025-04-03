package a0403.stream;

import java.util.ArrayList;
import java.util.List;

public class Stream8 {
    public static void main(String[] args) {
         List<Member> list = new ArrayList<>();
        Member m1 = new Member("박태호",Member.MALE,30);
        Member m2 = new Member("김연경",Member.FEMALE, 29);
        Member m3 = new Member("손유일", Member.MALE, 32);
        Member m4 = new Member("안재홍", Member.MALE, 27);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        // 남성의평균나이 구하기
        // 외부반복자
        int count = 0;
        double sum = 0;
        double ageavg;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getGender() == Member.MALE){
                sum = sum + list.get(i).getAge();
                count++;
            }
        }
        ageavg = sum / count;
        System.out.println("남성 평균 나이 :" + ageavg);
        System.out.println();
        // 내부반복자
        double ageAvg = list.stream()
                .filter(m->m.getGender() == Member.MALE)   // -> 중간연산
                .mapToInt(Member::getAge)  // 객체를 int 형태로 변환(회원객체를 나이로 매칭)
                .average()   //평균구함
                .getAsDouble();  // 평균값을 double로 변경 반환
                System.out.println("남성 멤버 평균 나이 " + ageAvg);
                
    }
}
