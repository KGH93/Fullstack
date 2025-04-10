package a0408.BicycleRentalSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import a0403.movieEx.Movie;

class Bicycle {
    private String id;  //자전거 id
    private BicycleStatus status;   // 자전거 상태 (대여가능, 불가능)



    
    public Bicycle(String id, BicycleStatus status) {
        this.id = id;
        this.status = status;
    }


    public String getId() {
        return id;
    }
    public BicycleStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "[자전거 ID: " + id + " 대여여부 : " + status  + "]";
    }



    //자전거 찾는 메서드 
    public static List<Bicycle> findAll() throws IOException{
        List<Bicycle> bicycles = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            String [] temp = line.split(",");
            Bicycle b = new Bicycle(
                temp[0],temp[1]
            );
            bicycles.add(b);
        };
        br.close();
        return bicycles;
    }

    public void rent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rent'");
    }

}

// 자전거상태
enum BicycleStatus { 
    AVAILABLE, //대여가능
    RENTED, //대여중
    BROKEN //고장
}
