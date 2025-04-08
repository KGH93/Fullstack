package a0407;

public class Car {
    private String carNumber;  //차넘버
    private int inTime;   //이용시간
    

    public Car(String carNumber, int inTime) {
        this.carNumber = carNumber;
        this.inTime = inTime;
    }

    public String getCarNumber() {
        return carNumber;
    }
    
    public int getInTime() {
        return inTime;
    }
}