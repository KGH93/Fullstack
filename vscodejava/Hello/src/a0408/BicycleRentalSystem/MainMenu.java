package a0408.BicycleRentalSystem;

import java.util.ArrayList;
import java.util.List;

class MainMenu extends AbstractMenu{
    private static final MainMenu instance = new MainMenu(null);
    private static List<Bicycle> bicycles = new ArrayList<>();

    public static MainMenu getInstance() {
        return instance;
    }   
    
    private static final String Main_Text =
        "1. 자전거 대여 \n"+
        "2. 대여 가능 자전거 확인 \n"+
        "3. 대여 반납\n"+
        "4. 고장 신고\n"+
        "5. 관리자 메뉴\n"+
        "q: 종료\n\n"+
        "메뉴를 선택하세요 : ";
        
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
                showStatus();    
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
                System.out.println("프로그램을 종료합니다.");
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



    //자전거 대여 메서드
    private void rentBicycle(){
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("대여 가능한 자전거 목록: ");
            int availableCount = 0;

            for ( int i = 0; i < bicycles.size(); i++ ){
                if(bicycles.get(i).getStatus() == BicycleStatus.AVAILABLE){
                    System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
                    availableCount++;
                }
            }

            if(availableCount == 0){
                System.out.println("대여 가능한 자전가가 없습니다.");
                return;
            }

            System.out.println("대여 할 자전거 번호를 입력하세요 : ");
            int index = Integer.parseInt(scan.nextLine()) - 1;

            if(index < 0 || index >= bicycles.size()){
                System.out.println("잘못된 번호입니다. 다시 입력해주세요.");
                return;
            }
            
            Bicycle selectBicycle = bicycles.get(index);
            selectBicycle.rent();
            System.out.println("대여 완료 했습니다.");
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
        }catch (Exception e) {
            System.out.println("대여 실패 했습니다 ");
        } 
    }



    
    //대여 가능한 자전거 확인 메서드
    private void showStatus() {
        int total = bicycles.size();
        int availableCount = 0;
        int rentalCount = 0;
        int brokenCount = 0;

        for(Bicycle b : bicycles){
            switch (b.getStatus()) {
                case AVAILABLE:
                    availableCount++;
                    break;
                case RENTED:
                    rentalCount++;
                    break;
                case BROKEN:
                    brokenCount++;
                    break;
            }
        }

        System.out.println("총 자전거 수 : " + total + "대");
        System.out.println("대여 가능 자전거 수 : " + availableCount + "대");
        System.out.println("대여 중 자전거 수 : " + rentalCount + "대");
        System.out.println("고장 : " + brokenCount + "대");
    }



        //자전거 반납 메서드
    private void returnBicycle() {
        try {
            System.out.println("반납할 자전거 번호를 입력하세요:");
            String bicycleId = scan.nextLine();
            boolean returned = false;
    
            for (Bicycle b : bicycles) {
                if (b.getId().equals(bicycleId)) {
                    returned = true;
                    if (b.getStatus() == BicycleStatus.RENTED) {
                        b.setStatus(BicycleStatus.AVAILABLE);
                        b.updateData(); // 파일 저장
                        System.out.println("자전거가 정상적으로 반납되었습니다.");
                    } else {
                        System.out.println("이 자전거는 대여 중이 아닙니다.");
                    }
                    return;
                }
            }
    
            if (!returned) {
                System.out.println("입력하신 번호의 자전거를 찾을 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
    }
    

        //자전거 신고 메서드
    private void reportBicycle() {
        try {
            System.out.println("고장 신고할 자전거 번호를 입력하세요:");
            String bicycleId = scan.nextLine();
    
            for (Bicycle b : bicycles) {
                if (b.getId().equals(bicycleId)) {
                    b.setStatus(BicycleStatus.BROKEN);
                    b.updateData(); // 파일 저장
                    System.out.println("고장 신고가 완료되었습니다. 감사합니다.");
                    return;
                }
            }
    
            System.out.println("해당 번호의 자전거를 찾을 수 없습니다.");
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}