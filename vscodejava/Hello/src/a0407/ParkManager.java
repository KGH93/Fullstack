package a0407;

import java.util.ArrayList;

public class ParkManager {
    private ArrayList<Car> cars; //차배열
    private int carcount;  //차량수
    
    public ParkManager(){
        cars = new ArrayList<>();
        carcount = 0;
    }

    // 입차메서드
    public void parkCar(String number, int inTime) {   
        if(carcount < 5){
            cars.add(new Car(number, inTime));
            carcount++;
            System.out.println(number + " 입차 완료");
        }else{
            System.out.println("주차공간이 부족합니다.");
        }
    }


    //출차메서드
    public void exitCar(String number, int outTime) {
        for(int i = 0; i <carcount; i++){
            if(cars.get(i).getCarNumber().equals(number)){
                int parktime = (outTime - cars.get(i).getInTime());

                int pay = calculatepay(parktime);

                System.out.println(number + " 출차 완료. 요금 : " + pay);

                cars.remove(i);
                carcount--;
                return;
            }
        }
        System.out.println("차량을 찾을 수 없습니다.");
    }


    private int calculatepay(int parktime) {
        int usedtime = (int)Math.ceil(parktime / 10);    //  math.ceil로  parktime을 10분단위로 반올림 // int값을주어 계산
        return usedtime * 1000;
    }




    //차량조회 메서드
    public void showCars() {
        if ( carcount == 0){
            System.out.println("주차된 차량이 없습니다.");
        }else{
            System.out.println("현재 주차된 차량 목록");
            for(int i =0; i < carcount; i++){
                System.out.println("차량 번호 : " + cars.get(i).getCarNumber() + ", 입차시간 : " + cars.get(i).getInTime());
            }
        }
    }

}
