package a0408.BicycleRentalSystem;

import java.util.Scanner;

abstract class AbstractMenu implements Menu{
    protected static final Scanner scan = new Scanner(System.in);
    
    protected String menuText;  //기본메뉴문구
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
