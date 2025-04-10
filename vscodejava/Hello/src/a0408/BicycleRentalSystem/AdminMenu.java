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
            case "1"://자전거 목록
                ListupBicycle();
                return this;
            case "2"://자전거 등록
                addBicycle();
                return this;
            case "3"://자전거 삭제
                dropBicycle();
            case "q"://관리자 메뉴 종료
                return prevMenu;  //이전 메뉴 이동
            default:
                System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
                return this;
        }
    }


    
    //자전거 목록 메서드
    private void ListupBicycle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ListupBicycle'");
    }

    //자전거 등록 메서드
    private void addBicycle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBicycle'");
    }


     
    //자전거 삭제 메서드
    private void dropBicycle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dropBicycle'");
    }

}
