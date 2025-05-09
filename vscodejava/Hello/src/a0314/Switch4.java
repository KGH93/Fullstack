package a0314;

import java.util.Scanner;

public class Switch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("학점 등급을 입력하세요: ");
        String grade = scan.nextLine();
        switch (grade) {
            case "A","a":
                System.out.println("탁월한 성과입니다!");
                break;
            case "B","b":
                System.out.println("좋은 성과입니다!");
                break;
            case "C","c":
                System.out.println("준수한 성과입니다!");
                break;
            case "D","d":
                System.out.println("향상이 필요합니다");
                break;
            case "F","f":
                System.out.println("불합격입니다");
                break;
            default:
                System.out.println("잘못된 학점입니다"); 
                break;
        }
        scan.close();

    }
    
}
