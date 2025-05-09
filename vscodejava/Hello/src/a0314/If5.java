package a0314;

import java.util.Scanner;

public class If5 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("거리를 입력하세요: (km) ");
        int d = scan.nextInt();
        String ex;

        if (d <= 1) {
            ex = "도보";
        } else if (d <= 10) {
            ex = "자전거";
        } else if (d <= 25) {
            ex = "자동차";
        } else if (d > 100) { // 25 초과 100 이하인 경우
            ex = "비행기";
        } else {
            ex = "비행기를 이용하세요."; // 100km 초과 시 기본 값 설정
        }

        System.out.printf(ex + "를 이용하세요.");

        scan.close();
    }
}