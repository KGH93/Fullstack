package a0402.movie;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cinema {
    private String title;   //영화제목
    private String time;    //상영시간
    private int price;      //가격
    private DecimalFormat priceFormat = new DecimalFormat("#,###원");    //가격에 포맷 0,000원
    private Boolean adultGrade;    //성인구별유무 
    private ArrayList<String> seats;    //좌석

    
    public Cinema(String title, String time, int price, Boolean adultGrade) {
        this.title = title;
        this.time = time;
        this.price = price;
        this.adultGrade = adultGrade;
        seats = new ArrayList<>();   //좌석 1~64까지
        for(int i = 1; i<=64; i++){
            seats.add(i+"");
        }
    }



    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public DecimalFormat getPriceFormat() {
        return priceFormat;
    }
    public void setPriceFormat(DecimalFormat priceFormat) {
        this.priceFormat = priceFormat;
    }
    public Boolean getAdultGrade() {
        return adultGrade;
    }
    public void setAdultGrade(Boolean adultGrade) {
        this.adultGrade = adultGrade;
    }
    public ArrayList<String> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }



    @Override
    public String toString() {  //영화출력포맷
        String priceCom = priceFormat.format(price);   //가격에 ,000원 포맷
        return "[ 타이틀 : " + title + " | 상영시간 : " + time + " | 가격 : " + priceCom + "]";
    }


    public void seatToString(){
        for(int i = 0; i <seats.size(); i +=8){   //좌석 표시 메서드
            System.out.println("|________________________________________________|");
            System.out.println("|*                                              *|");
            System.out.println("|________________________________________________|");
            System.out.printf("|   [%2s][%2s]     [%2s][%2s][%2s][%2s]     [%2s][%2s]   |\n",seats.get(i),seats.get(i+1),seats.get(i+2),seats.get(i+3),seats.get(i+4),seats.get(i+5),seats.get(i+6),seats.get(i+7));
        }
    }
    
}
