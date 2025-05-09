package a0318;

public class Ex01 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("x = " + x);  //(1) x = 5 출력
        print(x);                        //(2) print 함수호출
        System.out.println("x = " + x);  //(5) x = 5 출력  // 아래함수는 영향을주지못함
    }

    private static void print(int x) {
        System.out.println("x = " + x);  //(3) x = 5 출력 (mian의 x가 전)
        x = x + 10;                      //(4) x값 10증가 (지역변수)
        System.out.println("x = " + x);  //(4) x = 15 출력
    }
}
