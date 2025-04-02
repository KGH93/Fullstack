package a0402.optional;

import java.util.Optional;

public class Optional5 {
    public static void main(String[] args) {
        
        Optional<String> optionalName = findname("Mark");
        System.out.println(optionalName.orElse("Name not found"));


    }



    private static Optional<String> findname(String name) {
        if("Mark".equals(name)){  //mark 출력
        // if("John".equals(name)){  //Name not found 출력
            return Optional.of(name);
        }
        return Optional.empty();
    }
}