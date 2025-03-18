package a0318;


public class Fact1 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorial(3));
            }
        
            // private static int factorial(int n) {
            //     int x = 1;
            //     for( int i = 1;i<=n; i++){
            //         x *= i;
            //     } return x;
            // }
            private static int factorial(int n) {
                if(n==0 || n ==1){
                    return 1;
                }
                return n*factorial(n-1);  //재귀함수
            }
}

//factorial(5) = 5 *factorial(4);
//factorial(4) = 4 *factorial(3);
//factorial(3) = 3 *factorial(2);
//factorial(2) = 2 *factorial(1);
// factorial(1) (종료조건)
// 역순으로 계산
// factorial(1) = 1
// factorial(2) = 2x1
// factorial(3) = 3x2
// factorial(4) = 4x6
// factorial(5) = 5x24 = 120
