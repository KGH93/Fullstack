package a0408.BicycleRentalSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Bicycle {
    private String id;  //자전거 id
    private BicycleStatus status;   // 자전거 상태 (대여가능, 불가능, 고장)

    
    
    private static final File file = new File("d:\\KGH\\vscodejava\\hello\\src\\a0408\\BicycleRentalSystem\\bicycles.txt"); //자전거데이터 저장경로
    private static List<Bicycle> bicycles = new ArrayList<>();
    
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
    public void setStatus(BicycleStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "[자전거 ID: " + id + " 대여여부 : " + status  + "]";
    }


    //자전거 파일에서 읽어 bicycles에 보내는 메서드 
    public static List<Bicycle> findAll() throws IOException{
        bicycles.clear();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {  //파일의 각줄 읽음
            String [] temp = line.split(",");  //쉼표로 데이터 구분
            if(temp.length !=2){
                continue;
            }
            try {
                BicycleStatus status= BicycleStatus.valueOf(temp[1].toUpperCase()); // valueof로 열거형으로 바꾸고 toUpperCase로 대문자로 표시// 
                Bicycle b = new Bicycle(temp[0], status);
                bicycles.add(b);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 상태 값");
            }
           
        };
        br.close();
        return bicycles;
    }

    //수정된 데이터 업데이트하는 메서드    
    public void updateData() throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (Bicycle b : Bicycle.bicycles) {
                bw.write(b.getId() + "," + b.getStatus());
                bw.newLine();
            }
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.err.println("BufferedWriter 닫기 중 오류 발생");
            }
        }
    }
  
    //자전거 대여 메서드
    public void rent() {
        if(this.status != BicycleStatus.AVAILABLE){
            System.out.println("현재 선택한 자전거는 대여 불가능합니다: " + this.status);
            return;
        }
        this.status = BicycleStatus.RENTED;
        System.out.println(this.id +"자전거가 성공적으로 대여되었습니다. ");
        try {
            updateData();
        } catch (IOException e) {
            System.out.println("업데이트중 오류 발생했습니다.");
        }
    }   


    //자전거 파일에 추가 등록하는 메서드
    public static boolean add(Bicycle newbicycle) throws IOException {
        for (Bicycle b : bicycles) {
            if (b.getId().equals(newbicycle.getId())) {
                System.out.println("이미 등록된 자전거 ID입니다.");
                return false;
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); 
        bw.write(newbicycle.getId() + "," + newbicycle.getStatus());
        bw.newLine();
        bw.close();
        return true;
    }


    //자전거 파일에서 삭제하는 메서드
    public boolean delete(String deletebicycle) {
        for (Bicycle b : bicycles) {
            if (b.getId().equals(deletebicycle)) {
                bicycles.remove(b);
                try {
                    updateData();
                } catch (IOException e) {
                    System.out.println("업데이트중 오류 발생했습니다.");
                }
                return true; // 삭제 후 메서드 종료
            }
        }
        System.out.println("존재하지 않는 자전거입니다.");
        return false;
    }
}

// 자전거상태 열거
enum BicycleStatus { 
    AVAILABLE, //대여가능
    RENTED, //대여중
    BROKEN //고장
}
