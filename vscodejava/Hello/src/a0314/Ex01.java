package a0314;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("첫번째 정수를 입력하세요 : ");
        int num1 = scan.nextInt();
        System.out.println("두번째 정수를 입력하세요 : ");
        int num2 = scan.nextInt();
        System.out.println("세번째 정수를 입력하세요 : ");
        int num3 = scan.nextInt();

        if (num1 >= num2 && num1 >= num3){
            System.out.println("가장큰 수는 "+ num1 + " 입니다.");
        }
        else if( num1 <= num2 && num2 >= num3){
            System.out.println("가장큰 수는 "+ num2 + " 입니다.");
        }
        else
        {System.out.println("가장큰 수는 "+ num3 + " 입니다.");}
        scan.close();
    }
}