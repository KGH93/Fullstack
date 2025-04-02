package a0402.optional;
// Optional null 값으로 인한 문제 방지, 안전하게 값을 처리 
// Optional 은 null이 될 수있는 객체를 감싸는 래퍼클래스

import java.util.Optional;

public class Optional1 {
    public static void main(String[] args) {
        
        Optional<String> name = Optional.of("John");
        System.out.println("Name " + name.get());

        // Optional.empty();  // 빈 Optional 생성
        Optional<String> emptyname = Optional.empty();
        System.out.println("is empty : " + emptyname.isPresent());  //false
        
        //3. Optional.ofNUllable() = null 을 허용하는 Optional 생성
        Optional<String> nullablename = Optional.ofNullable(null);
        System.out.println("is null : " + nullablename.isPresent());  //false




    }
}
