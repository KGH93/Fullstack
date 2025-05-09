package a0318;

import java.util.Scanner;
public class Cylinder2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("정육면체의 한 변의 길이를 입력하세요");
        int n = scan.nextInt();
        int v = volume(n);
        System.out.printf("한 변의 길이가 %d인 정육각형의 부피 : %d", n,v);
            }
        
            private static int volume(int n) {
                return(n*n*n);
            }
}
