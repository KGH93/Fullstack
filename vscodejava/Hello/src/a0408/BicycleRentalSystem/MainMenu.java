package a0408.BicycleRentalSystem;

class MainMenu extends AbstractMenu{
    private static final MainMenu instance = new MainMenu(null);
    
    public static MainMenu getInstance() {
        return instance;
    }   
    
    private static final String Main_Text =
        "1. 자전거 대여 \n"+"2. 대여 상태 확인 \n"+"3. 대여 반납\n\n"+"4. 관리자 메뉴\n"+"q: 종료\n\n"+"메뉴를 선택하세요 : ";
        
    private MainMenu(Menu preMenu){
        super(Main_Text, preMenu); 
    }



    @Override  // 메인메뉴에서 오버라이드
    public Menu next() {
        switch (scan.nextLine()) {
            case "1"://대여
                
                break;
            case "2"://상태확인
                
                break;
            case "3"://반납
                
                break;
            case "4"://관리자
                
                break;
            case "q"://종료
                
                break;
            default:
                System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
                break;
        }
    }

   

}

