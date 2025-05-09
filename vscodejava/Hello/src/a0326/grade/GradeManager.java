package a0326.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    private static int Idcounter = 1;


    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 성적 관리 프로그램 ===");
            System.out.println("1. 성적 추가");
            System.out.println("2. 성적 조회");
            System.out.println("3. 성적 수정");
            System.out.println("4. 성적 삭제");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudent();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("종료");
                    System.exit(0);
                    // return;
                                
                default:
                    System.out.println("잘못된 연릭입니다. 다시 선택하세요");
                }
        }
    }
                    


            
                    
                    
            //성적추가 
            private static void addStudent() {
                System.out.println("학생 이름: ");
                String name = scan.nextLine();
                System.out.println("점수 입력: ");
                int score = scan.nextInt();
                scan.nextLine();  //개행문자 처리

                // 차선책
                // Student student = new Student();  
                // student.setId(Idcounter++);
                // student.setName(name);
                // student.setScore(score);

                Student student = new Student(Idcounter++, name, score);  //arraylist에 저장됨. 삭제,수정이 arraylist가 용이함 추가-add/
                students.add(student);
                System.out.println("성적이 추가되었습니다.");

            }


            //성적조회
            private static void viewStudent() {
                if(students.isEmpty()){  //isEmpty 비어있는 객체 확인용
                    System.out.println("등록된 성적이 없습니다.");
                }else{
                    System.out.println("\n-----성적목록-----");
                    for(Student s : students){
                        // s.display();   //직접만든 출력메서드를 사용
                        System.out.println(s.toString());  //toString을 이용
                    }
                }
            }



            //성적수정
            private static void updateStudent() {
                System.out.println("수정할 학생 ID 입력: ");
                int id = scan.nextInt();
                scan.nextLine();

                for(Student u:students){//students리스트를 순회하며 
                    if(u.getId() == id){
                        System.out.println("새로운 점수 입력 : ");
                        int newScore = scan.nextInt();
                        scan.nextLine();
                        u.setScore(newScore);
                        System.out.println("성적이 수정되었습니다.");
                        return;  //return을 써주지 않으면 학생을 찾아 수정후에도 끝까지 루프를 실행
                    }
                }
                System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
            }




            //성적삭제
            private static void deleteStudent() {
                System.out.println("삭제할 학생 ID 입력: ");
                int id = scan.nextInt();
                scan.nextLine();

                for(Student d:students){//students리스트를 순회하며 
                    if(d.getId() == id){
                        students.remove(d);
                        System.out.println("학생ID가 삭제되었습니다.");
                        return;  //return을 써주지 않으면 학생을 찾아 수정후에도 끝까지 루프를 실행
                    }
                }
                System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
            }


}
