package a0314;

import java.util.Scanner;

public class Scanner4 {
       public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("실수를 입력하세요 : ");
        double num = scan.nextDouble();

        //1.59254

        num = (num + 0.005f)* 100;
        System.out.println(num); //159.754
        int i = (int) num;
        System.out.println(i); //159
        num = (float) i / 100;
        System.out.println(num);

        // System.out.printf("%.2f",num);

        
        scan.close();


       }    
}
