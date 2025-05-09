package a0317;

import java.util.Scanner;

public class whileEx02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;

        while(run){
            System.out.println("-----------------------------------");
            System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4.나눗셈 | 5. 종료");
            System.out.println("-----------------------------------");
            System.out.print("선택 >");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 5) {
                System.out.println("선택> 5");
                System.out.print("프로그램 종료");
                run = false; 
                continue; 
            }
            System.out.print("첫번째 숫자를 입력하세요 :");
            int a = Integer.parseInt(scan.nextLine());
            System.out.print("두번째 숫자를 입력하세요 :");
            int b = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("선택> 1");
                    System.out.print("첫번째 숫자> " + a);
                    System.out.print("두번째 숫자> " + b);
                    System.out.print("결과: " + a + "+" + b + "= " + (a + b));
                    break;
                case 2:
                    System.out.println("선택> 2");
                    System.out.print("첫번째 숫자> " + a);
                    System.out.print("두번째 숫자> " + b);
                    System.out.print("결과: " + a + "-" + b + "= " + (a - b));
                    break;
                case 3:
                    System.out.println("선택> 3");
                    System.out.print("첫번째 숫자> " + a);
                    System.out.print("두번째 숫자> " + b);
                    System.out.print("결과: " + a + "*" + b + "= " + (a * b));
                    break;
                case 4:
                    System.out.println("선택> 4");
                    System.out.print("첫번째 숫자> " + a);
                    System.out.print("두번째 숫자> " + b);
                    if( a==0 || b == 0){
                        System.out.println(" 0으로 나눌 수 없습니다.");
                    }else{
                        System.out.print("결과: " + a + "/" + b + "= " + ((double)a / b));
                    }
                    break;
                default:
                    System.out.print("잘못입력하셨습니다. 다시 선택해주세요");
                    break;
            }
        }
        scan.close();
    }
}
