package a0314;

import java.util.Scanner;
public class Scanner3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
            System.out.print("첫번째 숫자를 입력하세요: ");
            int a = scan.nextInt();
            System.out.print("두번째 숫자를 입력하세요: ");
            int b = scan.nextInt();

            System.out.print( a + " " + b);



            scan.close();
    }
}
