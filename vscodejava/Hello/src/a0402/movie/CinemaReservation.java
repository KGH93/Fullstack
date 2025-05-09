package a0402.movie;

import java.util.Scanner;

public class CinemaReservation {
    public static void main(String[] args) {
        CinemaManager cm = new CinemaManager();
        Scanner scan = new Scanner(System.in);
        FileS fs = new FileS();
        System.out.println(cm.theater);
        System.out.println("=========================[Java Cinema]에 오신걸 환영합니다=========================");

        end:while (true){
            System.out.println("1. 영화목록\n2. 영화예매\n3. 예매표조회\n4. 예매취소\n5. 티켓Save\n6. 영화Uproad\n0. 종료\n");
            System.out.println("메뉴입력해주세요 >> ");
            String menuchoice = scan.next();
            scan.nextLine();

            int menu = -1;
            try {
                menu = Integer.parseInt(menuchoice);
            } catch (NumberFormatException e) {  
                menu = 0;  // 숫자변환안될때 0으로
            }
            switch (menu) {
                case 1:  //영화목록
                    cm.displayCinemaList("영화목록");
                    break;
                case 2:  //영화예매
                    try {
                    cm.reservCinema("영화예매");
                    } catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                    break;
                case 3:  //예매표조회
                    cm.checkReservation();
                    break;
                case 4:  //예매취소
                try {
                    cm.deleteReservation("예매취소");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    break;
                case 5:  //티켓저장
                    cm.ticketSave();
                    break;
                case 6:  //영화업로드
                    fs.movieUpload();
                    break;
                case 0:  //종료
                    System.out.println("예매프로그램을 종료합니다.");
                    scan.close();
                    break end;
                default:
                    break;
            }
        }
    }
}
