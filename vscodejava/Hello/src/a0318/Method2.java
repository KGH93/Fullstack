package a0318;

public class Method2 {
    public static void main(String[] args) {

        int sum1 = add(5, 10);
        System.out.println("결과1 출력: " + sum1);

        int sum2 = add(15, 20);
        System.out.println("결과2 출력: " + sum2);

        int sum3 = subtract(10, 5);
        System.out.println("결과3 출력: " + sum3);

        int sum4 = multiply(4, 5);
        System.out.println("결과4 출력: " + sum4);

        int sum5 = divide(10, 2);
        System.out.println("결과5 출력: " + sum5);

    }

    private static int divide(int i, int j) {
        System.out.println(i + "/" + j + "연산수행");
        int sum = i / j ;
        return sum;
    }

    public static int multiply(int i, int j) {
        System.out.println(i + "*" + j + "연산수행");
        int sum = i * j;
        return sum;
    }

    public static int subtract(int i, int j) {
        System.out.println(i + "-" + j + "연산수행");
        int sum = i - j;
        return sum;
    }

    public static int add(int a, int b) {
        System.out.println(a + "+" + b + "연산수행");
        int sum = a + b;
        return sum;
    }

    // add, subtract, multiply, divide
}
