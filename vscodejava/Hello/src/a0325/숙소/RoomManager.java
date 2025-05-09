package a0325.숙소;

import java.util.ArrayList;
import java.util.Scanner;

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




    public void delRoom(String dname) {
        boolean result = false;
        for(Room r: rooms){
            if(r.getName().equalsIgnoreCase(dname)){
                if(r.isAvailable()){
                    rooms.remove(r);
                    result = true;
                    break;
                }else{
                    System.out.println("해당 숙소는 이미 예약되었습니다.");
                    result = false;
                    break;
                }
            }
        }
        if(result){ 
            System.out.println("삭제했습니다.");
        }else{
            System.out.println("삭제실패했습니다.");
        }
    }




    public void updateRoom(String uname) {
        int i = 0;
        int index = -1;
        int menu = -1;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Room newR = new Room();
        System.out.println(uname);
        for(Room a : rooms){
            i++;
            if(a.getName().equalsIgnoreCase(uname)){
                index = i - 1;
                newR = a;
            }
            System.out.println(a.getName().equals(uname) + " " + a.getName() + " " + uname);
        }
        if(index != -1){
            System.out.println("수정이 필요한 번호를 누르세요.\n 1. 숙소이름 \n2. 숙소 장소 \n3. 숙소 가격 \n>>");
            menu = scan.nextInt();
            scan.nextLine();
            while (flag) {
                switch (menu) {
                    case 1:
                        System.out.println("수정할 이름을 입력하세요 ");
                        newR.setName(scan.nextLine());
                        rooms.set(index,newR);
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 장소를 입력하세요 ");
                        newR.setLocation(scan.nextLine());
                        rooms.set(index,newR);
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 가격을 입력하세요 ");
                        newR.setPrice(scan.nextDouble());
                        rooms.set(index,newR);
                        flag = false;
                        break;
                    default:
                        System.out.println("1~3번 중에 번호를 입력하세요");
                        return;
                }
            }
        }else{
            System.out.println("찾는 숙소가 없어 업데이트가 불가능합니다.");
        }

    }




    public void searchRoom(String sname) {
        for(Room r:rooms){
            if (r.getName().equalsIgnoreCase(sname)) {
                System.out.println(r.toString());                
            }
        }
    }




}
