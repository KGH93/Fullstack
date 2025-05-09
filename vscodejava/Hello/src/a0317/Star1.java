package a0317;
import java.util.Scanner;
public class Star1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("삼각형 높이를 입력하세요");
        int rows = scan.nextInt();
        for(int i = 1 ; i <= rows; i++){
            for(int j= 1; j<=rows-i;j++){
                System.out.print(" ");
            }
            for(int k = 1; k<=(2*i-1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
        scan.close();
    }
}


