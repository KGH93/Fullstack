package a0408.BicycleRentalSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//부모클래스 상속
class MainMenu extends AbstractMenu{
    private static final MainMenu instance = new MainMenu(null); //싱글톤
    private List<Bicycle> bicycles = new ArrayList<>();  // 자전거목록
    private static List<Rental> rentals = new ArrayList<>();   //대여정보

    public static MainMenu getInstance() { //싱글톤 인스턴스
        return instance;
    }   
    
    private static final String Main_Text =
        "1. 대여 가능 자전거 확인 \n"+
        "2. 자전거 대여 \n"+
        "3. 대여 반납\n"+
        "4. 고장 신고\n"+
        "5. 관리자 메뉴\n"+
        "q: 종료\n\n"+
        "메뉴를 선택하세요 : ";
        
    private MainMenu(Menu preMenu){   //findall의 IOEXCEPTION 떄문에 TRY CATCH구문사용
         super(Main_Text, preMenu);   //부모 생성자 호출
    try {
        bicycles = Bicycle.findAll(); // 자전거 목록 초기화
        rentals = Rental.findAll(); // 대여 목록 초기화
    } catch (IOException e) {
        System.out.println("자전거 데이터를 불러오는 중 오류 발생");
    }
    }



    @Override  // 메인메뉴에서 오버라이드
    public Menu next() {
        switch (scan.nextLine()) {
            case "1"://대여가능 자전거확인
                showStatus();  
                return this;
            case "2"://대여
                rentBicycle();
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
                AdminMenu adminMenu = AdminMenu.getInstance();   //싱글톤
                adminMenu.setPrevMenu(this);  //이전메뉴 // 관리자메뉴 나올때
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


    //대여 가능한 자전거 확인 메서드
    private void showStatus() {
        int total = bicycles.size();
        int availableCount = 0;  //대여가능
        int rentalCount = 0;     //대여중
        int brokenCount = 0;     //고장

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

        System.out.println("--------------------------------------------------------------");
        System.out.println("총 자전거 수 : " + total + "대");
        System.out.println("대여 가능 자전거 수 : " + availableCount + "대");
        System.out.println("대여 중 자전거 수 : " + rentalCount + "대");
        System.out.println("고장 : " + brokenCount + "대");
        System.out.println("--------------------------------------------------------------");


    }





    //자전거 대여 메서드
    private void rentBicycle(){
        try {
            System.out.print("전화번호 뒷자리: ");
            String phone = scan.nextLine();
            if (phone == null || phone.length() != 4) {
                System.out.println("잘못된 전화번호 형식입니다.");
                return;
            }
            System.out.println("대여 가능한 자전거 목록: ");
            int availableCount = 0;
            List<Bicycle> availableBicycles = new ArrayList<>();
            
            for (Bicycle b : bicycles){
                if(b.getStatus() == BicycleStatus.AVAILABLE){
                    availableCount++;
                    availableBicycles.add(b); // 대여 가능한 자전거를 목록에 추가
                    System.out.printf("%d: %s\n", availableCount, b); // 목록 번호와 자전거 정보 출력
                }
            }

            if(availableCount == 0){
                System.out.println("대여 가능한 자전거가 없습니다.");
                return;
            }

            System.out.println("대여 할 자전거 번호를 입력하세요(앞에 숫자) : ");
            int index = Integer.parseInt(scan.nextLine()) - 1;

            if(index < 0 || index >= availableBicycles.size()){
                System.out.println("잘못된 번호입니다. 목록에 표시된 번호를 다시 입력해주세요.");
                return;
            }
            
            Bicycle selectBicycle = availableBicycles.get(index);
            System.out.println("대여 시간을 입력하세요(시간):");
            int rentalTimes = Integer.parseInt(scan.nextLine());
            Rental rental = new Rental(phone, selectBicycle.getId(), rentalTimes);
            rentals.add(rental);
            selectBicycle.rent();
            try {
                Rental.saveAll(rentals);
            } catch (IOException e) {
                System.out.println("렌탈 정보 저장 실패");
            }
            System.out.println("총 결제 금액: " + rental.getPayment() + "원");
            selectBicycle.updateData(); 
            System.out.println("대여 완료 했습니다.");
            System.out.println("--------------------------------------------------------------");
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
        }catch (Exception e) {
            System.out.println("대여 실패 했습니다 ");
            System.out.println("--------------------------------------------------------------");
        } 
    }



    //자전거 반납 메서드
    private void returnBicycle() {
    if (rentals == null || rentals.isEmpty()) {
        try {
            rentals = Rental.findAll();
        } catch (IOException e) {
            System.err.println("렌탈 데이터 로드 중 오류 발생: " + e.getMessage());
            return;
        }

        System.out.print("전화번호 뒷자리: ");
        String phone = scan.nextLine().trim();
        if (phone == null || phone.length() != 4) {
            System.out.println("잘못된 전화번호 형식입니다.");
            return;
        }

        List<Rental> userRentals = new ArrayList<>();
        for (Rental rental : rentals) {
            if (rental.getPhone().trim().equals(phone)) {
                userRentals.add(rental);
            }
        }
    
        if (userRentals.isEmpty()) {
            System.out.println("해당 전화번호로 대여한 자전거가 없습니다.");
            return;
        }

        System.out.println("반납할 자전거를 선택하세요:");
        for (int i = 0; i < userRentals.size(); i++) {
            Rental rental = userRentals.get(i);
            System.out.printf("%d: 자전거 번호 %s\n", i + 1, rental.getBicycleId());
        }
        System.out.println("반납할 자전거 번호를 입력하세요:(앞에 숫자)");
        int index = Integer.parseInt(scan.nextLine()) - 1;

        if (index < 0 || index >= userRentals.size()) {
            System.out.println("잘못된 번호입니다. 목록에 표시된 번호를 다시 입력해주세요.");
            return;
        }

        Rental selectedRental = userRentals.get(index);   //Rental에서 대여중인 자전거 아이디 가져옴
        String bicycleId = selectedRental.getBicycleId();

        for (Bicycle b : bicycles) {
            if (b.getId().equals(bicycleId)) {
                if (b.getStatus() == BicycleStatus.RENTED) {
                    b.setStatus(BicycleStatus.AVAILABLE);
                    try {
                        b.updateData();
                        System.out.println("자전거가 정상적으로 반납되었습니다.");
                        // 반납 후 rentals 목록에서 해당 rental 제거
                        rentals.remove(selectedRental);
                        Rental.saveAll(rentals);
                    } catch (IOException e) {
                        System.err.println("자전거 데이터 업데이트 중 오류 발생");
                        System.out.println("자전거 반납에 실패했습니다.");
                    }
                } else {
                    System.out.println("이 자전거는 대여 중이 아닙니다.");
                }
                return;
            }
        }
    }
        System.out.println("입력하신 번호의 자전거를 찾을 수 없습니다.");
    }
    
    

    //자전거 신고 메서드
    private void reportBicycle() {
        System.out.print("전화번호 뒷자리: ");
        String phone = scan.nextLine();
        if (phone == null || phone.length() != 4) {
            System.out.println("잘못된 전화번호 형식입니다.");
            return;
        }

        System.out.println("고장 신고할 자전거 번호를 입력하세요:");
        String bicycleId = scan.nextLine();

        for (Bicycle b : bicycles) {
            if (b.getId().equals(bicycleId)) {
                b.setStatus(BicycleStatus.BROKEN);
                try {
                    b.updateData();
                    System.out.println("고장 신고가 완료되었습니다. 감사합니다.");
                } catch (IOException e) {
                    System.err.println("자전거 데이터 업데이트 중 오류 발생");
                    System.out.println("고장 신고에 실패했습니다.");
                }
                return;
            }
        }
        System.out.println("해당 번호의 자전거를 찾을 수 없습니다.");
    }
}