package a0318;

public class Method4 {
    public static void main(String[] args) {
        int num1 = 10, num2 = 5;

        Calculator1.add(num1,num2);
        System.out.println("뺼셈: " + Calculator1.subtract(num1,num2));
        System.out.println("곱셈: " + Calculator1.multiply(num1,num2));
        System.out.println("나눗셈: " + Calculator1.divide(num1,num2));
    }
}


class Calculator1 {
    public static void add(int a, int b){   
        //return 필요없을때 type(int,float,string) 대신 void
        System.out.println("덧셈:" + (a+b));
    }
    public static int subtract(int a, int b){
        return a-b;
    }
    public static int multiply(int a, int b){
        return a*b;
    }
    public static double divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return (double)a/b;
    }
}
