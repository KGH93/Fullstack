package a0408.BicycleRentalSystem;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("자전거 대여 시스템을 시작합니다.");
        Menu menu = MainMenu.getInstance(); //메인메뉴가져오기
        while (menu != null) {
            menu.print();  //현재메뉴
            menu = menu.next();  //다음메뉴
        }
        System.out.println("자전거 대여 시스템을 종료합니다.");
        
    }
}


interface Menu{   //메뉴출력을 위한 인터페이스
    void print(); // 메뉴출력
    Menu next();  // 다음메뉴로 이동
}