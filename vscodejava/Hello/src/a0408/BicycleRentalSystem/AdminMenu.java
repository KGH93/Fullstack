package a0408.BicycleRentalSystem;

class AdminMenu extends AbstractMenu{
    private static final AdminMenu instance = new AdminMenu(null);
    private static final String ADMENU_TEXT =
        "1. 자전거 등록\n"+"2. 자전거 목록\n"+"3.자전거 삭제\n"+"q: 관리자 메뉴 종료"+"메뉴를 선택하세요 : ";

    private AdminMenu(Menu prevMenu){
        super(ADMENU_TEXT, prevMenu);
    }

    public static AdminMenu getInstance(){
        return instance;
    }

    @Override //어드민 오버라이드
    public Menu next() {
        switch (scan.nextLine()) {
            case "1"://등록
                
                break;
            case "2"://목록
                
                break;
            case "3"://삭제
                
                break;
            case "q"://종료
                
                break;
            default:
                System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
                break;
        }
    }
}
