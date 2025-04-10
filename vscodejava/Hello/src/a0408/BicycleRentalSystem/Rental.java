package a0408.BicycleRentalSystem;

public class Rental {
    private String userId;  //대여유저ID
    private String bicycleId;  //대여자전거ID
    private int rentalTimes;  //대여시간
    private int payment; //결제 금액




    public Rental(String userId, String bicycleId, int rentalTimes, int payment) {
        this.userId = userId;
        this.bicycleId = bicycleId;
        this.rentalTimes = rentalTimes;
        this.payment = rentPayment(rentalTimes);
    }



    //요금 계산 메서드
    private int rentPayment(int hours){
        return hours * 1000;  //시간당 천원
    }




    public String getUserId() {
        return userId;
    }




    public void setUserId(String userId) {
        this.userId = userId;
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
        return "대여ID: " + userId + ", 대여자전거ID: " + bicycleId + ", 대여시간: " + rentalTimes + ", 요금: "
                + payment + "]";
    }
}
