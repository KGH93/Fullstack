package a0408.BicycleRentalSystem;

import java.util.Scanner;
//추상클래스 //부모 클래스
abstract class AbstractMenu implements Menu{
    protected static final Scanner scan = new Scanner(System.in); //모든메뉴에서 쓰여 static사용
    
    protected String menuText;  //기본메뉴  //protected 접근자 : 같은 패키지안의 클래스 접근가능 , 자식클래스에도 상속가능  
    protected Menu prevMenu;  //이전메뉴
    
    public AbstractMenu(String menuText, Menu prevMenu) {
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    public void print(){
        System.out.println(menuText); //메뉴출력
    }

    public void setPrevMenu(Menu prevMenu){
        this.prevMenu = prevMenu;
    }
}
