package a0328.file2;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentDAO {
    private ArrayList<StudentDTO> slist;
    Scanner scan = new Scanner(System.in);
    FileClass file = new FileClass("student", "student_Grade");
    public StudentDAO () {
        slist = new ArrayList<>();
        // 기본데이터 - 4명의 더미데이터 생성
        StudentDTO s1 = new StudentDTO(0, "테스트1", 11, 100, 100, 100);
        StudentDTO s2 = new StudentDTO(1,"테스트2",22,90,89,91);
        StudentDTO s3 = new StudentDTO(2,"테스트3",33,85,77,55);
        StudentDTO s4 = new StudentDTO(3,"테스트4",44,77,68,85);
        slist.add(s1);
        slist.add(s2);
        slist.add(s3);
        slist.add(s4);
    }


    private void insert(StudentDTO s) {
        slist.add(s);
    }

    
    private void delete(int index) {
        slist.remove(index);
    }


    private StudentDTO select(int index) {
        return slist.get(index);   // slist에서 인덱스 번호에 해당되는 StudentDTO 객체 반환
    }


    private void update(int index, StudentDTO s) {
        slist.set(index,s); //set은 ArrayList에서 수정할때 쓰는 메서드
    }




    public void userInsert() {
        StudentDTO s = new StudentDTO();
        s.setId(slist.size());
        System.out.println("<학생 추가하기>");
        System.out.print("이름: ");
        s.setName(scan.next()); //문자로 입력받은것은 setter로 객체s에 이름에 추가
        System.out.print("나이: ");
        s.setAge(scan.nextInt());
        System.out.print("국어점수: ");
        s.setKor(scan.nextInt());
        System.out.print("영어점수: ");
        s.setEng(scan.nextInt());
        System.out.print("수학점수: ");
        s.setMath(scan.nextInt());
        //slist.add(s);
        insert(s);
        System.out.println("학생이 추가 되었습니다.");
    }

    

    public void userDelete(){
        System.out.println("<학생정보삭제>");
        int index = searchIndex();
        if(index == -1){
            System.out.println("찾는 학생이 없습니다.");
        }else{
            String name = slist.get(index).getName();
            delete(index);
            System.out.println(name + "학생정보를 삭제했습니다.");
            // slist.remove(index);
        }
    }



    private int searchIndex() {
        int index = -1;
        System.out.println("학생이름을 입력해주세요.");
        System.out.print(">>");
        String name = scan.next();
        for(int i = 0; i < slist.size(); i++){
            if(slist.get(i).getName().equals(name)){
                index = i;
                break;
        }
    }
    return index;
    }



    //  \t 탭반큼 띄기
    public void userSelect() {
        System.out.println("<학생정보보기>");
        int index = searchIndex();
        if(index == -1){
            System.out.println("찾는 학생이 없습니다.");
        }else{
            System.out.println("이름\t 나이\t 국어\t 영어\t 수학\n" + "---------------------------------------");
            StudentDTO s = select(index);
            System.out.println(s);
        }
    }


    public void userUpdate() {
        System.out.println("<학생정보수정>");
        int index = searchIndex();
        if(index==-1){
            System.out.println("찾는 학생이 없습니다.");
        }else{
            StudentDTO s = new StudentDTO();  //빈 객체를 하나 만듬
            s.setId(slist.get(index).getId());
            s.setName(slist.get(index).getName());
            s.setAge(slist.get(index).getAge());
            System.out.println(slist.get(index).getId() + "학생 점수정보수정");
            System.out.println("국어점수: ");
            s.setKor(scan.nextInt());
            System.out.println("영어점수: ");
            s.setEng(scan.nextInt());
            System.out.println("수학점수: ");
            s.setMath(scan.nextInt());
            // slist.set(index,s); 업데이트
            update(index, s);

        }
    }


    public void printAll() {
        System.out.println("   이름\t      나이\t      국어\t     영어\t     수학\n" + "---------------------------------------");
        for(int i =0 ; i < slist.size(); i ++){
           System.out.println(slist.get(i).toString());
        }
    }


    public void dataSave() throws Exception{
        file.create();
        String str = "이름\t 나이\t 국어\t 영어\t 수학\n" + "----------------------------------------\n";
        for(int i = 0; i < slist.size(); i++){
            str += slist.get(i).toString() + "\n";
        }
        file.write(str);
    }


    public void dataLoad() {
        try {
            file.read();
        } catch (Exception e) {
            System.out.println("읽을 파일이 없습니다.");
        }
    }
}
