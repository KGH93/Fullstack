package a0401.ramda;

import java.util.Arrays;
import java.util.List;

public class Ramda2 {
    public static void main(String[] args) {
        
        List<String> names1 = Arrays.asList("apple", "banana", "orange");
        //이름을 기준으로 내림차순 정렬
        names1.sort((s1,s2)->s2.compareTo(s1));
        System.out.println("내림자순 정렬" + names1);


        //람다
        names1.sort(String::compareTo);
        System.out.println("오름차순 정렬" + names1);
        // s2.compareTo(s1) 대신 메서드 참조(:: 연산자)를 사용하여 더 간결하게 표시
    }
}
