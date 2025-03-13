package a0313;

public class Comp1 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println( a == b); //false , a와 b는 같지않음
        System.out.println( a != b); //true , a와 b는 다르다
        System.out.println( a > b); //false
        System.out.println( a < b); //true
        System.out.println( a >= b); //false
        System.out.println( a <= b); //true

        //결과를 boolean 변수에 담음
        boolean result = a == b; //false
        System.out.println(result);  //false
    }
}
