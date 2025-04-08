package a0408.project;

public class Rental {
    private int rentalId;
    private int userId;
    private int bicycleId;
    private int rentalTime;
    private int returnTime;
    private int usedTime;


    
    public int getRentalId() {
        return rentalId;
    }
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getBicycleId() {
        return bicycleId;
    }
    public void setBicycleId(int bicycleId) {
        this.bicycleId = bicycleId;
    }
    public int getRentalTime() {
        return rentalTime;
    }
    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }
    public int getReturnTime() {
        return returnTime;
    }
    public void setReturnTime(int returnTime) {
        this.returnTime = returnTime;
    }
    public int getUsedTime() {
        return usedTime;
    }
    public void setUsedTime(int usedTime) {
        this.usedTime = usedTime;
    }
}
