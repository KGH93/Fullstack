package a0324.숙소;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        RoomManager manager = new RoomManager();
        boolean flag = true;
        while (flag) {
            System.out.println("\n숙소 예약 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 예약 가능한 숙소 보기");
            System.out.println("2. 숙소 예약하기");
            System.out.println("3. 예약한 숙소 보기");
            System.out.println("4. 숙소 추가하기");
            System.out.println("5. 숙소 삭제하기");
            System.out.println("6. 숙소 정보 수정하기");
            System.out.println("7. 숙소 정보 조회하기");
            System.out.println("8. 종료");
            System.out.print("원하는 작업을 선택하세요 > ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("예약 가능한 숙소 보기");
                    manager.allRoom();
                    break;
            
                case 2:
                    System.out.println("숙소 예약하기");
                    System.out.println("예약하려는 숙소의 이름을 입력하세요 : ");
                    String roomName = scan.nextLine();
                    if(manager.roomrented(roomName)){
                        System.out.println("숙소가 성공적으로 예약되었습니다.");
                    }else{
                        System.out.println("숙소가 이미 예약되었거나 존재하지 않습니다.");
                    }
                    break;
            
                case 3:
                    System.out.println("예약한 숙소 보기");
                    manager.roomrented();
                    break;
            
                case 4:
                    System.out.println("숙소 추가하기");
                    System.out.print("추가 숙소이름");
                    String newname = scan.nextLine();
                    System.out.print("추가 숙소위치");
                    String newlocation = scan.nextLine();
                    System.out.print("추가 숙소가격");
                    double newprice = scan.nextDouble();
                    scan.nextLine();
                    manager.addRoom(newname,newlocation,newprice);
                    System.out.println("숙소추가 완료");
                    break;
            
                case 5:
                    
                    break;
            
                case 6:
                    
                    break;
            
                case 7:
                    
                    break;
            
                case 8:
                    
                    break;
            
                default:
                    break;
            }

        }
    }


}
