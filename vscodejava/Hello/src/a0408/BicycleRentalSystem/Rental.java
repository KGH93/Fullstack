package a0408.BicycleRentalSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rental {
    private String phone;  //대여유저ID// 전화번호4자리로
    private String bicycleId;  //대여자전거ID
    private int rentalTimes;  //대여시간
    private int payment; //결제 금액



    private static final File file = new File("d:\\\\KGH\\\\vscodejava\\\\hello\\\\src\\\\a0408\\\\BicycleRentalSystem\\rentals.txt");   //대여정보 파일저장 경로


    public Rental(String phone, String bicycleId, int rentalTimes, int payment) {
        this.phone = phone;
        this.bicycleId = bicycleId;
        this.rentalTimes = rentalTimes;
        this.payment = payment;
    }

    public Rental(String phone, String bicycleId, int rentalTimes) {  //계산용 생성자
        this.phone = phone;
        this.bicycleId = bicycleId;
        this.rentalTimes = rentalTimes;
        this.payment = rentPayment(rentalTimes);
    }



    //요금 계산 메서드
    private int rentPayment(int hours){
        return hours * 1000;  //시간당 천원
    }


    public String getPhone() {
        return phone;
    }




    public void setPhone(String phone) {
        this.phone = phone;
    }




    public String getBicycleId() {
        return bicycleId;
    }




    public void setBicycleId(String bicycleId) {
        this.bicycleId = bicycleId;
    }




    public int getRentalTimes() {
        return rentalTimes;
    }




    public void setRentalTimes(int rentalTimes) {
        this.rentalTimes = rentalTimes;
    }




    public int getPayment() {
        return payment;
    }




    public void setPayment(int payment) {
        this.payment = payment;
    }




    @Override
    public String toString() {
        return "대여전화번호: " + phone + ", 대여자전거ID: " + bicycleId + ", 대여시간: " + rentalTimes + ", 요금: "
                + payment + "]";
    }


    //대여 정보를 파일에서 읽어오는 메서드
    public static List<Rental> findAll() throws IOException {
        List<Rental> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue; //빈 줄 건너뜀
            String[] temp = line.split(",");
            if (temp.length != 4) continue;
            try {
                Rental r = new Rental(temp[0].trim(),  //전화번호
                temp[1].trim(),                        //자전거id
                Integer.parseInt(temp[2].trim()),      //대여시간
                Integer.parseInt(temp[3].trim()));     //대여금액
                list.add(r);
            } catch (NumberFormatException e) {
                System.out.println("잘못된 렌탈 정보");
            }
        }
        br.close();
        return list;
    }


    //대여 정보 파일에 저장하는 메서드
    public static void saveAll(List<Rental> rentals) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Rental r : rentals) {
            bw.write(r.toDataString());
            bw.newLine();
        }
        bw.close();
    }



    public String toDataString() {
        return phone + "," + bicycleId + "," + rentalTimes + "," + payment;
    }

}