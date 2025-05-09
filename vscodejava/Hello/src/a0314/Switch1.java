package a0314;

import java.util.Scanner;

public class Switch1 {
    public static void main(String[] args) {    //p.93
        Scanner scan = new Scanner(System.in);
        System.out.printf("회원등급을 입력해주세요: ");
        int grade = scan.nextInt();
        int coupon;

        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
                coupon = 2000;
                break;
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
