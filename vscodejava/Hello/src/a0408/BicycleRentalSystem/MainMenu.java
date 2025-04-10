package a0408.BicycleRentalSystem;

import java.util.List;

class MainMenu extends AbstractMenu{
    private static final MainMenu instance = new MainMenu(null);
    
    public static MainMenu getInstance() {
        return instance;
    }   
    
    private static final String Main_Text =
        "1. 자전거 대여 \n"+"2. 대여 가능자전거 확인 \n"+"3. 대여 반납\n"+"4. 고장 신고\n"+"4. 관리자 메뉴\n"+"q: 종료\n\n"+"메뉴를 선택하세요 : ";
        
    private MainMenu(Menu preMenu){
        super(Main_Text, preMenu); 
    }



    @Override  // 메인메뉴에서 오버라이드
    public Menu next() {
        switch (scan.nextLine()) {
            case "1"://대여
                rentBicycle();
                return this;
            case "2"://대여가능한 자전거확인
                rentStatus();    
                return this;
            case "3"://반납
                returnBicycle();    
                return this;
            case "4"://고장신고
                reportBicycle();    
                return this;
            case "5"://관리자
                if(!AdminPassword()){
                    System.out.println("비밀번호가 틀렸습니다.");
                    return this;
                }    
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this);
                return adminMenu;
            case "q"://종료
                return null;
            default:
                System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
               return this;
        }
    }


    //관리자 비밀번호 확인 메서드
    private boolean AdminPassword() {
        System.out.println("관리자 비밀번호를 입력하세요 : ");
        return "0000".equals(scan.nextLine()); //관리자 비밀번호
    }



    
    //대여 가능한 자전거 확인 메서드
    private void rentStatus() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("대여 가능한 자전거 목록: ");
            boolean hasAvailable = false;

            for (Bicycle bicycle : bicycles){
                if(bicycle.getStatus() == BicycleStatus.AVAILABLE){
                    hasAvailable = true;
                    System.out.printf("자전거ID: %s\n", bicycle.getId());
                }
            }
            if(!hasAvailable){
                System.out.println("대여 가능한 자전거가 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("조회 실패했습니다.");
        }
    }


    //자전거 대여 메서드
    private void rentBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("대여 가능한 자전거 목록: ");
            for ( int i = 0; i < bicycles.size(); i++ )
                if(bicycles.get(i).getStatus() == BicycleStatus.AVAILABLE){
                    System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
                }
            System.out.println("대여 할 자전거 번호를 입력하세요 : ");
            int index = Integer.parseInt(scan.nextLine()) - 1;
            bicycles.get(index).rent();
            System.out.println("대여 완료 했습니다.");
        } catch (Exception e) {
            System.out.println("대여 실패 했습니다 ");
        }
    }





    //자전거 반납 메서드
private void returnBicycle() {
    List<Bicycle> bicycles = Bicycle.findAll();
    System.out.println("반납할 자전거 번호를 입력하세요");
}




    //자전거 신고 메서드
private void reportBicycle() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'reportBicycle'");
}













}