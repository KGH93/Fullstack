package a0402.movie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;



public class FileS {
    private CinemaManager fm = new CinemaManager();


    public void ticketSaveFile(Map<String,Cinema> reservationMap, String phone) {  
        try {
            File directory = new File("d:\\ticket");

                if(!directory.exists()){
                    if(directory.mkdirs()){
                        System.out.println("디렉토리를 새로 생성했습니다.");
                    }else{
                        System.out.println("디렉토리 생성을했습니다.");
                        return;
                    }
            }

            File file = new File("d:\\ticket\\reserveData.txt");
                if(!file.exists()){
                        file.createNewFile();
                        System.out.println("파일을 새로 생성했습니다.");
                }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true)); //bufferwriter 데이터추가기능 //append true로 저장유지
                if(file.isFile() && file.canWrite()){
                    bufferedWriter.write(fm.ticketPrint(reservationMap, phone));
                    bufferedWriter.newLine(); //새줄 추가
                    bufferedWriter.flush();  //데이터 바로저장
                    System.out.println("파일저장을 완료했습니다.");
                }else{
                    System.out.println("저장할 예매 정보가 없습니다.");
                }
                bufferedWriter.close();
        }catch(IOException e){
            System.out.println("파일저장을 실패했습니다.");
            e.printStackTrace();
        }
    }


    public void movieUpload() {
        try {
            // 디렉토리 확인 및 생성
            File directory = new File("d:\\ticket");
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("디렉토리를 새로 생성했습니다.");
                } else {
                    System.out.println("디렉토리 생성을 실패했습니다.");
                    return;
                }
            }
    
            // movieData.txt 파일 확인 및 생성
            File file = new File("d:\\ticket\\movieData.txt");
            if (!file.exists()) {
                System.out.println("파일이 존재하지 않습니다.");
                return;
            }
            // bufferedreader utf-8 읽기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8")); 
            String line;
            boolean HasData = false;
            System.out.println("=======================================================");
            
            // 파일 내용 처리
            while ((line = bufferedReader.readLine()) != null) {
                // 파일에 데이터가 하나라도 있으면 true로 설정
                HasData = true; 
                
                // 데이터가 '/' 구분자로 나누어졌는지 확인
                String[] cinema = line.split("/");
    
                // 데이터 4개 각각 나눠서 정확하게 확인
                if (cinema.length == 4) {
                    try {
                        String title = cinema[0].trim();  // 영화 제목
                        String time = cinema[1].trim();   // 상영 시간
                        int price = Integer.parseInt(cinema[2].trim()); // 가격
                        boolean isAdult = Boolean.parseBoolean(cinema[3].trim()); // 성인 여부
    
                        Cinema newCinema = new Cinema(title, time, price, isAdult);
                        CinemaManager.getcinemas().add(newCinema);  // cinemas 리스트에 추가
                        System.out.println("영화 업로드 성공: " + newCinema);
                    } catch (NumberFormatException e) {
                        System.out.println("데이터 오류: ");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("잘못된 형식의 데이터 발견: ");
                }
            }
    
            if (!HasData) {
                System.out.println("파일에 데이터가 없습니다.");
            }
    
            bufferedReader.close();
    
        } catch (FileNotFoundException e) {  //파일못찾을때
            System.out.println("movieData.txt 파일을 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {  //파일읽는중 오류
            System.out.println("파일 읽기 실패");
            e.printStackTrace();
        }
    }
}



