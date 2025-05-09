package a0317;

import java.util.Scanner;

public class whileEx01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int dol = 0;

        while (run) {
            System.out.println("-----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4.종료");
            System.out.println("-----------------------------------");
            System.out.print("선택 >");
            int menunum = Integer.parseInt(scan.nextLine());    

            switch (menunum) {
                case 1:
                    System.out.println("선택> 1");
                    System.out.print("예금액> ");
                    dol += Integer.parseInt(scan.nextLine());
                    break;
                case 2:
                    System.out.println("선택> 2");
                    System.out.println("출금액> ");
                    dol -= Integer.parseInt(scan.nextLine());
                    System.out.println(dol);
                    break;
                case 3:
                    System.out.println("선택> 3");
                    System.out.println("잔고> ");
                    System.out.println(dol);
                    break;
                case 4:
                    System.out.println("선택> 4");
                    System.out.println();
                    System.out.println("프로그램 종료");
                    run = false;
                    break;

                default:
                    System.out.println("잘못입력하셨습니다");
                    break;
            }
        }
        scan.close();
    }
}
