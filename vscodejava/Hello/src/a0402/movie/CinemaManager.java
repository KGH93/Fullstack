package a0402.movie;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CinemaManager {
    private static ArrayList<Cinema> cinemas;
    private static ArrayList<Customer> customers;
    private static Map<String, Cinema> reservationMap = new HashMap<>();
    private static FileS fs = new FileS();
    Scanner scan = new Scanner(System.in);

    public CinemaManager(){
        cinemas = new ArrayList<>();
        cinemas.add(new Cinema("스파이더맨노웨이홈", "20:30", 11000, false));
        cinemas.add(new Cinema("극한직업", "21:30", 11000, false));
        cinemas.add(new Cinema("양들의침묵", "22:45", 12000, true));
        cinemas.add(new Cinema("쏘우4", "23:30", 12000, true));
        customers = new ArrayList<>();
        Cinema co = cinemas.get(0);
        reservationMap.put("test", co);
    }
    public String theater = "\n" + "=============================    | J | A | V | A |    =============================\n" + "=============================| C | I | N | E | M | A |=============================\n";


    public void displayCinemaList(String str) {
        System.out.println("========================  " + str + " ========================");
        int count = 1;
        for(Cinema c : cinemas){
            System.out.println(count + "" + c);
            count++;
        }
        System.out.println("===========================================================");
    }


    public void reservCinema() throws InterruptedException {
        
        for(;;){
            displayCinemaList("영화예매");
            System.out.print("예매할 영화 선택 > ");
            try {
                int titlenum = Integer.parseInt(scan.next());
                if(titlenum > cinemas.size() || titlenum < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                }
                System.out.println("선택한 영화");
                System.out.println("=========================================================");
                System.out.println(titlenum + "" + cinemas.get(titlenum-1));
                System.out.println("=========================================================");
                Cinema pick = cinemas.get(titlenum-1);
                if(cinemas.get(titlenum-1).getAdultGrade()){
                    System.out.println("본 영화는 만18세이상 예매가능");
                    customerInfo(pick);
                }else{
                    customerInfo(pick);
                }
                if(customers != null && !customers.isEmpty()){
                    String seatNum = Integer.toString(seatSelete(pick));
                    customers.get(customers.size()-1).setSeat(seatNum);
                    System.out.println("예매중입니다.");
                    Thread.sleep(2000);
                    System.out.println("=========================================================");
                    System.out.println("예매에 성공했습니다.");
                    System.out.println("[ " + customers.get(customers.size()-1).getPhone() + " ] 님의 예매정보");
                    System.out.println(titlenum + "" + pick);
                    System.out.println("=========================================================");
                    System.out.println("잠시 후 메인 화면으로 이동합니다.");
                    Thread.sleep(2000);
                    reservationMap.put(customers.get(customers.size()-1).getPhone(),pick);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }


    private void customerInfo(Cinema pick) {
        System.out.println("예매 정보 확인하겠습니다.");
        System.out.println("핸드폰번호 뒤의 네자리 일력해주세요");
        System.out.print("전화번호(끝의 네자리) : ");
        String phone = scan.next();
        System.out.println("생년월일6자리를 입력해주세요 (예)900101)");
        System.out.print("생년월일(6자리) : ");
        try {
            int birthDate = Integer.parseInt(scan.next());
            Customer p = new Customer(phone, birthDate);
            if(!p.adult18(p) && pick.getAdultGrade()){
                System.out.println("청소년 관람불가 영화입니다.");
            }else{
                System.out.print("결제 비밀번호 입력: ");
                String pw = scan.next();
                p = new Customer(phone, birthDate, pw);
                customers.add(p);
            }
        } catch (DateTimeException e) {
            System.out.println("생년월일6자리를 입력해주세요 (예)900101)");
        }
    }


    private int seatSelete(Cinema pick) {
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("==================================================");
                pick.seatToString();
                System.out.println("원하는 좌석번호를 입력해주세요");
                System.out.print("선택 > ");
                int seatInt = scan.nextInt() - 1;
                if(seatInt+1 <1 || seatInt+1 > 48){
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if(pick.getSeats().get(seatInt).equals("xx")){
                    System.out.println("이미 예매된 좌석입니다.");
                }else{
                    pick.getSeats().set(seatInt, "xx");
                    System.out.println("좌석 선택이 완료됐습니다.");
                    seatNum = seatInt;
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scan.nextLine();
            }
        }
        return seatNum;
    }


    public void checkReservation() {
        int index = searchReserve("예매확인");
        checkPassword(index);
    }


    private int searchReserve(String str) {
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
                }
            }
        }
        return index;
    }

    private void checkPassword(int index) {
        for(;;){
            if (index != -1) {
                System.out.println("결제 비밀번호를 입력해주세요");
                System.out.print("비밀번호 : ");
                String pw = scan.next();
                if(customers.get(index).getPw().equals(pw)){
                    System.out.println("비밀번호 확인됬습니다.");
                    System.out.println(ticketPrint(reservationMap, customers.get(index).getPhone()));
                    break;
                }
            }
        } 
    }



    String ticketPrint(Map<String, Cinema> reservationMap, String phone) {
        int index = -1;
        if(customers != null){
            for(int i = 0; i < customers.size(); i++){
                if (customers.get(i).getPhone().equals(phone)) {
                    index = i;
                }
            }
        }
        int seat = Integer.parseInt(customers.get(index).getSeat())+1;
        return "===================================================\n\n" +
               "\t[" + phone + "님의 티켓정보" + "| 좌석 : " + seat + "번\n"+
               "." + reservationMap.get(phone) + "\n\n" + 
               "===================================================";
    }


    public void deleteReservation() {
        int index = searchReserve("예매확인");
        if(index != -1){
            checkPassword(index);
            delete(index);
        }else{
            System.out.println("예매를 찾을 수 없습니다.");
        }
    }


    private void delete(int index) throws InterruptedException {
        System.out.println("예매 취소하시겠습니까?");
        System.out.print("Y / N : ");
        String choice = scan.next();

        if( choice.equalsIgnoreCase("Y")){
            System.out.println("예매를 취소하겠습니다.");
            customers.remove(index);
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



}
