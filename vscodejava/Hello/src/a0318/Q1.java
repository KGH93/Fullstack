package a0318;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("첫번째 정수를 입력하세요");
        int a = scan.nextInt();
        System.out.println("두번째 정수를 입력하세요");
        int b = scan.nextInt();
        int num = max(a,b);
        System.out.printf("두 정수중에 큰 수는 %d입니다.",num);
                
            }
        
            // private static int max(int a, int b) {
            //     if ( a > b){
            //         return a;
            //     }else{ return b;}
            // }

            private static int max(int i, int j) {
                return ( i > j ) ? i : j;
            }
}
