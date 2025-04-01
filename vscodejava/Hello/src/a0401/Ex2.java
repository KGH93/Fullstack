package a0401;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex2 {
    public static void main(String[] args) {
        // 문자열 배열
        String[] arr = new String[]{"a","b","c","d","e","f"};
        Stream<String> stream1 = Arrays.stream(arr);
        stream1.forEach(s -> System.out.print(s+" "));   //가로로 공백 띄어쓰기로 출력
        // stream1.forEach(System.out::println);   //줄바꿈으로 세로로 출력
        
    }
}
