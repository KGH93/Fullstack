package a0321;

public class MyMath1 {
    public static void main(String[] args) {

        // int a = MyMath.add(5,6);
        // 2. MyMath 객체 생성
        MyMath mm = new MyMath();
        // 3. Mymath 객체 사용가능
        int m1 = mm.add(5,6);
        int m2 = mm.subtract(9,5);
        int m3 = mm.multiply(4,5);
        double m4 = mm.divide(8,2);
        int m5 = mm.max(15,6);

        System.out.println("m1 += " + m1);
        System.out.println("m2 -= " + m2);
        System.out.println("m3 *= " + m3);
        System.out.println("m4 /= " + m4);
        System.out.println("m5 >= " + m5);

    }
}

// 사칙연산을 수해아는 메서드를 가진 MyMath Class
// 메서드 클래스 영역에 정의 가능
// 1. MyMath 클래스 작성

class MyMath {
    // static int add(int a, int b){ //static(공용,공유) 주면 객체 안만들고 메인에서 사용가능
    int add(int a, int b) {
        int result = a + b;
        return result;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    // 큰수 구하기
    int max(int a, int b) {
        return a > b ? a : b;
    }
}
