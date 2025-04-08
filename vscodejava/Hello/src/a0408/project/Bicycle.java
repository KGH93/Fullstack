package a0408.project;

public class Bicycle {
    private int BicycleId;
    private String type;
    private String status;  // available , rented, under_repair
   
   
   
   
    public Bicycle(int bicycleId, String type, String status) {
        BicycleId = bicycleId;
        this.type = type;
        this.status = status;
    }


    
    public int getBicycleId() {
        return BicycleId;
    }
    public void setBicycleId(int bicycleId) {
        BicycleId = bicycleId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "[ 자전거등록번호 : " + BicycleId + " , 종류 : " + type + " , 상태 : " + status + " ]";
    }
}
