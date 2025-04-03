package a0402.movie;

import java.util.Scanner;

public class MovieReservation {
    public static void main(String[] args) {
        CinemaManager cm = new CinemaManager();
        Scanner scan = new Scanner(System.in);
        FileS fs = new FileS();
        System.out.println(cm.theater);
        System.out.println("=============================[ Java Cinema]에 오신걸 환영합니다=============================");

        end:while (true){
            System.out.println("1. 영화 목록\n2. 영화 예매\n3. 예매 조회\n4. 예매 취소\n5. 티켓Save\n6. 티켓Uproad\n0. 종료\n");
            System.out.println("메뉴입력해주세요 > ");
            String menuchoice = scan.next();
            scan.nextLine();

            int menu = -1;
            try {
                menu = Integer.parseInt(menuchoice);
            } catch (NumberFormatException e) {
                menu = 0;
            }
            switch (menu) {
                case 1://영화목록
                    cm.displayCinemaList("영화목록");
                    break;
                case 2://영화예매
                    try {
                    cm.reservCinema();
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                    break;
                case 3://예약조회
                    cm.checkReservation();
                    break;
                case 4://예약취소
                    cm.deleteReservation();
                    break;
                case 5://티켓저장
                    
                    break;
                case 6://티켓업로드
                    
                    break;
                case 0:
                    System.out.println("예매프로그램을 종료합니다.");
                    scan.close();
                    break end;
                default:
                    break;
            }
        }
    }
}
