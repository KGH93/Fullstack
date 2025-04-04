package a0402.movie;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CinemaManager {
    private static ArrayList<Cinema> cinemas;  //영화저장
    private static ArrayList<Customer> customers;  //고객저장
    private static Map<String, Cinema> reservationMap = new HashMap<>();   //전화번호,예매영화 객체
    private static FileS fs = new FileS();  //파일
    Scanner scan = new Scanner(System.in);

    public CinemaManager(){
        cinemas = new ArrayList<>();
        cinemas.add(new Cinema("반지의 제왕", "15:50", 10000, false));
        cinemas.add(new Cinema("백설공주", "16:30", 8000, false));
        cinemas.add(new Cinema("딥블루씨", "19:20", 10000, true));
        cinemas.add(new Cinema("거북이 달린다", "19:50", 10000, false));
        customers = new ArrayList<>();
        // 테스트용 
        Cinema co = cinemas.get(0);
        reservationMap.put("test", co);
    }

    public String theater = "===================================================================================\n" + "=================================| J | A | V | A |=================================\n" + "=============================| C | I | N | E | M | A |=============================\n"+"===================================================================================";


    public void displayCinemaList(String str) {  //영화목록출력메서드
        System.out.println("========================  " + str + " ========================");
        int count = 1;
        for(Cinema c : cinemas){
            System.out.println(count + "" + c); //영화번호 , 정보출력
            count++;
        }
        System.out.println("===========================================================");
    }


    public void reservCinema(String str) throws InterruptedException {  //예매메서드
        
        for(;;){  //무한반복루프
            displayCinemaList("영화예매");
            System.out.print("예매할 영화 선택 >> ");
            try {
                int titlenum = Integer.parseInt(scan.next());
                if(titlenum > cinemas.size() || titlenum < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
                System.out.println("선택한 영화");
                System.out.println("========================  " + str + " ========================");
                System.out.println(titlenum + "" + cinemas.get(titlenum-1));
                System.out.println("==============================================================");
                Cinema pick = cinemas.get(titlenum-1);
             
                customerInfo(pick);  //고객정보받기

                if(customers != null && !customers.isEmpty()){   // 고객정보가 null이 아니거나 비어있지않을때
                    String seatNum = Integer.toString(seatSelete(pick));
                    customers.get(customers.size()-1).setSeat(seatNum);
                    System.out.println("예매중입니다.");
                    Thread.sleep(2000);  //2초대기
                    System.out.println("=========================================================");
                    System.out.println("예매에 성공했습니다.");
                    System.out.println("[ " + customers.get(customers.size()-1).getPhone() + " ] 님의 예매정보");
                    System.out.println(titlenum + "" + pick);   //예매영화출력
                    System.out.println("=========================================================");
                    System.out.println("잠시 후 메인 화면으로 이동합니다.");
                    Thread.sleep(2000);  //2초대기
                    reservationMap.put(customers.get(customers.size()-1).getPhone(),pick);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }


    private void customerInfo(Cinema pick) {  //고객정보받기
        String phone = "";
        Boolean scphone = false;
        while (!scphone) {
            System.out.println("예매 정보 확인하겠습니다.");
            System.out.println("전화번호 뒤의 네자리 일력해주세요");
            System.out.print("전화번호(끝의 네자리) : ");
            phone = scan.next();
            if(phone.length() == 4){  //입력값이 4자리면 true;
                scphone = true;
            }else{
                System.out.println("잘못입력하셨습니다. 전화번호 4자리 입력해주세요.");
                continue;
            }
        }
        Boolean scbirthDate = false; 
        while (!scbirthDate) {
            System.out.println("생년월일6자리를 입력해주세요 (예)900101)");
            System.out.print("생년월일(6자리) : ");
            String birthDateStr = scan.next();
                if(birthDateStr.length()!=6){   //입력값이 6자리가 아니면
                    System.out.println("잘못입력하셨습니다. 생년월일 6자리 입력해주세요.");
                    continue;
                }
                try{
                    int birthDate = Integer.parseInt(birthDateStr);   //6자릿수확인 후 int로 변환
                    Customer p = new Customer(phone, birthDate);
                        if(!p.adult18(p) && pick.getAdultGrade()){  //성인등급 거르는 if문
                            System.out.println("청소년 관람불가 영화입니다.");
                                return;
                        }else{
                            System.out.print("결제 비밀번호 입력: ");
                            String pw = scan.next();
                            p = new Customer(phone, birthDate, pw);   
                            customers.add(p);
                            scbirthDate = true;
                        }
                    }catch (DateTimeException e) {
                        System.out.println("잘못입력하셨습니다. 생년월일 6자리 입력해주세요.");
                    }
        }
    } 



    private int seatSelete(Cinema pick) {   //좌석선택 메서드
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("==================================================");
                pick.seatToString();   //좌석 출력
                System.out.println("원하는 좌석번호를 입력해주세요");
                System.out.print("선택 >> ");
                int seatInt = scan.nextInt() - 1;   // 인덱스번호 맞추기위해 -1
                if(seatInt+1 <1 || seatInt+1 > 64){  //1~64숫자 외 거르기
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if(pick.getSeats().get(seatInt).equals("xx")){ //예매된 표시
                    System.out.println("이미 예매된 좌석입니다.");
                }else{
                    pick.getSeats().set(seatInt, "xx");  //예매성공
                    System.out.println("좌석 선택이 완료됐습니다.");
                    seatNum = seatInt+1;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scan.nextLine();
            }
        }
        return seatNum;
    }


    public void checkReservation() {   //예매확인메서드
        int index = searchReserve("예매표조회");
        checkPassword(index);
    }


    private int searchReserve(String str) {   //예매정보찾는 메서드
        System.out.println("========================  " + str + " ========================");
        System.out.println("예매하신 핸드폰번호 뒤의 네자리를 입력해주세요");
        System.out.print("전화번호(끝의 네자리) : ");
        String phone = scan.next();
        scan.nextLine();
        int index = -1;
        if (customers != null) {
            for(int i = 0; i < customers.size(); i++){
                if (customers.get(i).getPhone().equals(phone)) {
                    index = i;
                    System.out.println("[" + customers.get(i).getPhone() + "]" + "님 예매정보 확인합니다.");
                    break;
                }
            }
        }
        if (index == -1){
            System.out.println("해당 전화번호로 예매하신 정보가 없습니다.");
        }
        return index;
    }

    private void checkPassword(int index) {   //비밀번호 확인하는 메서드
        for(;;){
            if (index != -1) {
                System.out.println("결제 비밀번호를 입력해주세요");
                System.out.print("비밀번호 : ");
                String pw = scan.next();
                if(customers.get(index).getPw().equals(pw)){
                    System.out.println("비밀번호 확인됐습니다.");
                    System.out.println(ticketPrint(reservationMap, customers.get(index).getPhone()));
                    break;
                }else{
                    System.out.println("비밀번호가 틀렸습니다. 다시입력해주세요.");
                }
            }else{
                System.out.println("예매를 찾을 수 없습니다.");
                break;
            }
        } 
    }



    String ticketPrint(Map<String, Cinema> reservationMap, String phone) {   //예매된 티켓 출력하는 메서드
        int index = -1;
        if(customers != null){
            for(int i = 0; i < customers.size(); i++){
                if (customers.get(i).getPhone().equals(phone)) {
                    index = i;
                }
            }
        }
        int seat = Integer.parseInt(customers.get(index).getSeat());   //좌석번호
        return "===================================================\n\n" +
               "\t[ " + phone + " 님의 티켓정보 " + "| 좌석 : " + seat + "번]\n"+
               "[" + reservationMap.get(phone) + "\n\n" + 
               "===================================================";
    }


    public void ticketSave() {   //티켓저장 메서드
        int index = searchReserve("티켓조회");
        checkPassword(index);
        String phone = customers.get(index).getPhone();
        fs.ticketSaveFile(reservationMap, phone);  //파일로 저장
    }



    public void deleteReservation(String str) throws InterruptedException {    //예메 취소 메서드
        System.out.println("========================  " + str + " ========================");
        int index = searchReserve("예매표확인");
        if(index != -1){
            checkPassword(index);
            delete(index);  
        }else{
            System.out.println("예매정보를 찾을 수 없습니다.");
        }
    }


    private void delete(int index) throws InterruptedException {   //예매 고객삭제 메서드
        System.out.println("예매 취소하시겠습니까?");
        System.out.print("Y / N : ");
        String choice = scan.next();

        if( choice.equalsIgnoreCase("Y")){
            System.out.println("예매를 취소하겠습니다.");
            // index 값을 기준으로 고객의 전화번호를 호출
            String phone = customers.get(index).getPhone();
            // 전화번호를 이용해 해당 고객의 영화정보를 호출
            Cinema pick = reservationMap.get(phone);
            // 고객이 예약한 좌석번호
            String seatNum = customers.get(index).getSeat();
            System.out.println("예약된 좌석 번호 (seatNum): " + seatNum); 

            if (seatNum != null && !seatNum.equals("")) {  //좌석이 null이거나 비어있지 않으면
                int seatIndex = Integer.parseInt(seatNum) - 1; // 좌석 번호는 0부터 시작
                System.out.println("좌석 인덱스 (seatIndex): " + seatIndex); 
                
                // 좌석이 xx인 상태일때
                if (pick.getSeats().get(seatIndex).equals("xx")) {
                    pick.getSeats().set(seatIndex, String.valueOf(seatIndex + 1)); // 인덱스+1 좌석번호로 xx를 변경
                    System.out.println("선택된 좌석 " + (seatIndex + 1) + "번을 복원합니다.");
                }
            }      
            System.out.println(customers.get(index).getPhone()+ " 님의 예매를 취소합니다.");
            customers.remove(index);   //고객정보 인덱스제거
            System.out.println("잠시 후 메인 화면으로 이동합니다.");
            Thread.sleep(2000);
            return;
        }else if( choice.equalsIgnoreCase("N")){
            System.out.println("예매취소가 취소되었습니다.");   
            System.out.println("잠시 후 메인 화면으로 이동합니다.");
            Thread.sleep(2000);
            return;
        }else{
            System.out.println("잘못입력하셨습니다.");
            scan.nextLine();
        }
    }


    // 영화목록 반환메서드
    public static ArrayList<Cinema> getcinemas() {
        return cinemas;
    }
}
