package a0324.숙소;

import java.util.ArrayList;

public class RoomManager {
    private ArrayList<Room> rooms;
    private ArrayList<Room> roomrented;
    
    
    
    
    public RoomManager() {
        rooms = new ArrayList<>();
        roomrented = new ArrayList<>();
        rooms.add(new Room("Hotel A", "Seoul", 100.0));
        rooms.add(new Room("Hotel B", "Busan", 80.0));
        rooms.add(new Room("Hotel C", "Jeju", 120.0));
    }




    public void allRoom() {
        System.out.println("예약 가능한 숙소보기");

        for(Room room:rooms){
            if(room.isAvailable()){
                System.out.println(room);
            }
        }
    }




    public boolean roomrented(String roomName) {
        for(Room room:rooms){
            if(room.getName().equalsIgnoreCase(roomName) && room.isAvailable()){
                room.rent();
                roomrented.add(room);
                return true;
            }
        }
        return false;
    }




    public void roomrented() {
        System.out.println("예약된 숙소: ");
        for(Room rent : roomrented){
            System.out.println(rent.toString());
        }
    }




    public void addRoom(String newname, String newlocation, double newprice) {
        rooms.add(new Room(newname,newlocation,newprice));
    }




}
