package a0313;

public class Operator1 {
    public static void main(String[] args) {
        //변수 초기화
        int a = 5;
        int b = 2;

        int sum = a + b;
        int sub = a - b;
        int mul = a * b;
        double div = a / b;
        double mod = a % b;

        System.out.println("a + b =" + sum);//출력
        System.out.println("a - b =" + sub);
        System.out.println("a * b =" + mul);
        System.out.println("a / b =" + div);
        System.out.println("a % b =" + mod);
    }
}
