package a0408.BicycleRentalSystem;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("자전거 대여 시스템을 시작합니다.");
        Menu menu = MainMenu.getInstance();
        while (menu != null) {
            menu.print();
            menu = menu.next();
        }
        System.out.println("자전거 대여 시스템을 종료합니다.");
        
    }
}


interface Menu{
    void print(); // 메뉴출력
    Menu next();  // 다음메뉴로 이동
}