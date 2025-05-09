package a0314;

import java.util.Scanner;

public class If3 {
    public static void main(String[] args) {
        // int price = 10000; //아이템가격
        // int age = 10; //나이
        // scanner 아이템가격과 나이르 입력받고
        // 총할인금액과 결제금액을 출력하시오
        int discount = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("아이템가격을 입력하세요: ");
        int price = scan.nextInt();

        System.out.print("나이를 입력하세요: ");
        int age = scan.nextInt();

        if (price >=10000){
            discount = discount + 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        }

        if (age <= 10){
            discount = discount + 1000;
            System.out.println("어린이 1000원 할인");
        }

        System.out.println("총 할인 금액: " + discount + "원");

        // System.out.println("총 결제 금액: " + (price-discount) + "원");

        price -= discount; //price = price - discount
        System.out.println("총 결제 금액: " + price + "원");

        scan.close();

    }
}
