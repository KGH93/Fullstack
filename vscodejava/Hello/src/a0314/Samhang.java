package a0314;

public class Samhang {
    public static void main(String[] args) {   //삼항연산자 p.75
        int age = 18;
     
        String status = age >= 18 ? "성인":"미성년자";

        System.out.println("age = "+age+"status= "+status);

        //삼항연산자
        //(조건식) ? 참_표현식 : 거짓_표현식;
    }
}
