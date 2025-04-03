package a0402.movie;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cinema {
    private String title;
    private String time;
    private int price;
    private DecimalFormat priceFormat = new DecimalFormat("#,###원");
    private Boolean adultGrade;
    private ArrayList<String> seats;

    
    public Cinema(String title, String time, int price, Boolean adultGrade) {
        this.title = title;
        this.time = time;
        this.price = price;
        this.adultGrade = adultGrade;
        seats = new ArrayList<>();
        for(int i = 1; i<=48; i++){
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
    public String toString() {
        String priceCom = priceFormat.format(price);
        return ". " + "타이틀 : " + title + ", 상영시간 : " + time + ", 가격 : " + priceCom + "]";
    }


    public void seatToString(){
        for(int i = 0; i <seats.size(); i +=6){
            System.out.printf("|    [%2s][%2s]\t\t[%2s][%2s]\t[%2s][%2s]    |\n",seats.get(i),seats.get(i+1),seats.get(i+2),seats.get(i+3),seats.get(i+4),seats.get(i+5));
        }
    }
    
}
