package a0407;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ParkManager pm = new ParkManager();
        while (true) {
            System.out.println("\n1. 입차  2. 출차  3. 전체목록  0. 종료");
            int menu = scan.nextInt();

            if (menu == 1) {
                System.out.print("차량번호 입력: ");
                String number = scan.next();
                System.out.print("입차 시간 입력(분단위): ");
                int inTime = scan.nextInt();
                pm.parkCar(number, inTime);

            } else if (menu == 2) {
                System.out.print("차량번호 입력: ");
                String number = scan.next();
                System.out.print("출차 시간 입력(분단위)): ");
                int outTime = scan.nextInt();
                pm.exitCar(number, outTime);

            } else if (menu == 3) {
                pm.showCars();

            } else if (menu == 0) {
                System.out.println("프로그램 종료");
                break;

            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        scan.close();
    }
}
