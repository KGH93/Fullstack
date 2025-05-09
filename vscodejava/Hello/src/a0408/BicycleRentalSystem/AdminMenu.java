package a0408.BicycleRentalSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 관리자메뉴
class AdminMenu extends AbstractMenu{
    private static final AdminMenu instance = new AdminMenu(null);   //싱글톤 선언
    private static List<Bicycle> bicycles = new ArrayList<>(); //자전거목록 리스트

    private static final String ADMENU_TEXT =
        "1. 자전거 목록\n"+
        "2. 자전거 등록\n"+
        "3. 자전거 삭제\n"+
        "q: 종료\n"+
        "메뉴를 선택하세요 : ";

    private AdminMenu(Menu prevMenu){  //관리자메뉴라 private사용
        super(ADMENU_TEXT, prevMenu);
        try {
            bicycles = Bicycle.findAll(); // bicycles 리스트 초기화
        } catch (IOException e) {
            System.out.println("자전거 목록을 불러오는 중 오류 발생");
        }
    }

    public static AdminMenu getInstance(){  //싱글톤
        return instance;
    }

    @Override //어드민 오버라이드
    public Menu next() {
        switch (scan.nextLine()) {
            case "1"://자전거 목록
                ListBicycle();
                return this;
            case "2"://자전거 등록
                addBicycle();
                return this;
            case "3"://자전거 삭제
                deleteBicycle();
                return this;
            case "q"://관리자 메뉴 종료
                return prevMenu;  //이전 메뉴 이동
            default:
                System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
                return this;
        }
    }


    
    //자전거 목록 메서드
    private void ListBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("자전거 목록");
            if(bicycles.isEmpty()){
                System.out.println("등록된 자전거가 아닙니다.");
                return;
            }
            for (Bicycle bicycle : bicycles) {
                System.out.println(bicycle);
            }
        } catch (Exception e) {
            System.out.println("조회 실패했습니다.");
        }
    }

    //자전거 등록 메서드
    private void addBicycle() {
        try {
            System.out.println("등록할 자전거 ID를 입력하세요 (숫자5자리):");
            String id = scan.nextLine();
            if (id.length() != 5) {
                System.out.println("잘못된 ID형식입니다. 다시 입력해주세요.");
                return;
            }
            Bicycle newbicycle = new Bicycle(id, BicycleStatus.AVAILABLE);
            if (Bicycle.add(newbicycle)) {
                System.out.println("신규 자전거 등록 완료");
                bicycles.add(newbicycle); // bicycles 리스트에 추가
            } else {
                System.out.println("자전거 등록 실패");
            }
        } catch (IOException e) {
            System.out.println("신규 자전거 등록 실패: " + e.getMessage());
        }
    }


     
    //자전거 삭제 메서드
    private void deleteBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            if (bicycles.isEmpty()) {
                System.out.println("등록된 자전거가 없습니다.");
                return;
            }

            System.out.println("삭제할 자전거 ID를 입력하세요 (숫자5자리)");
            String idToDelete = scan.nextLine();

            if (idToDelete.length() != 5) {
                System.out.println("잘못된 입력입니다. 5자리 숫자를 입력해주세요.");
                return;
            }

            for (Bicycle b : bicycles) {
                if (b.getId().equals(idToDelete)) {
                    bicycles.remove(b); // bicycles 리스트에서 삭제
                    b.updateData(); // 변경된 데이터 파일에 저장
                    System.out.println("자전거가 삭제되었습니다.");
                    return;
                }
            }
            System.out.println("삭제 실패");
        } catch (IOException e) {
            System.err.println("오류 발생");
        }
    }   

}
