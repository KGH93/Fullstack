package a0325.숙소;

public class Room {
    private String name;
    private String location;
    private double price;
    private boolean available;



    public Room(){}

    public Room(String name, String location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.available = true;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLocation() {
        return location;
    }



    public void setLocation(String location) {
        this.location = location;
    }



    public double getPrice() {
        return price;
    }



    public void setPrice(double price) {
        this.price = price;
    }



    public boolean isAvailable() {
        return available;
    }



    public void setAvailable(boolean available) {
        this.available = available;
    }




    @Override
    public String toString() {
        return "숙소 이름: " + name + ",숙소 장소: " + location + ", 숙소 가격: " + price + ", 예약여부 " + (available ? "예약가능" : "예약 불가능");
    }


    public void rent(){
        this.available = false;
    }


}

