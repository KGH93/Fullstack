package a0314;

import java.util.Scanner;

public class Switch2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("회원등급을 입력해주세요: ");
        int grade = scan.nextInt();
        int coupon;
        //grade 2:3000으로 변경

        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2: 
            case 3:
                coupon = 3000;
                break;
        
            default:
                coupon = 500;

                break;
        }
        scan.close();

        System.out.println("발급받은 쿠폰 " + coupon);

    }
}
