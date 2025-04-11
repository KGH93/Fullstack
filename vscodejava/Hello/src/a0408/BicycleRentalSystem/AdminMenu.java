package a0408.BicycleRentalSystem;

import java.util.List;

class AdminMenu extends AbstractMenu{
    private static final AdminMenu instance = new AdminMenu(null);
    private static final String ADMENU_TEXT =
        "1. 자전거 목록\n"+
        "2. 자전거 등록\n"+
        "3. 자전거 삭제\n"+
        "q: 종료\n"+
        "메뉴를 선택하세요 : ";

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
                deleteBicycle();
            case "q"://관리자 메뉴 종료
                return prevMenu;  //이전 메뉴 이동
            default:
                System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
                return this;
        }
    }


    
    //자전거 목록 메서드
    private void ListupBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("자전거 목록");
            if(bicycles.isEmpty()){
                System.out.println("등록된 자전거가 아닙니다.");
                return;
            }
            for (int i=0; i<bicycles.size(); i++){
                System.out.println(bicycles.get(i)+ " 자전거 입니다.");
            }
        } catch (Exception e) {
            System.out.println("조회 실패했습니다.");
        }
    }

    //자전거 등록 메서드
    private void addBicycle() {
        try {
            System.out.print("등록할 자전거 ID를 입력하세요 (B+숫자5자리):");
            String id = scan.nextLine();
            if(id.length()!=6){
                System.out.println("잘못된 ID형식입니다. 다시 입력해주세요.");
                return;
            }
            Bicycle newbicycle = new Bicycle(id, BicycleStatus.AVAILABLE); //새 자전거 만들기
            Bicycle.add(newbicycle);
            System.out.println("신규 자전거 등록 완료");
        } catch (Exception e) {
            System.out.println("신규 자전거 등록 실패");
        }
    }


     
    //자전거 삭제 메서드
    private void deleteBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.print("삭제할 자전거 ID를 입력하세요: (B+숫자5자리)");
            if(bicycles.isEmpty()){
                System.out.println("입력된 자전거ID는 존재하지 않습니다.");
                return;
            }
            for(int i = 0; i < bicycles.size(); i++){
                System.out.println(bicycles.get(i)+"자전거 입니다.");
            }
            int index = Integer.parseInt(scan.nextLine()) - 1;
            if(index < 0 || index >= bicycles.size()){
                System.out.println("잘못 입력하셨습니다.");
                return;
            }
            Bicycle.delete(bicycles.get(index).getId()); //자전거 삭제
            System.out.println("자전거 삭제 완료");
        } catch (Exception e) {
            System.out.println("삭제 실패");
        }
    }

}
