package a0401;

import java.util.ArrayList;
import java.util.List;

class Student1{
   
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Student1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "1 [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}



public class List3 {
    public static void main(String[] args) {
         //ArrayList 생성
        List<Student1> studentList = new ArrayList<>();

        //객체추가
        studentList.add(new Student1(101, "Alice", 20));
        studentList.add(new Student1(102, "Bob", 22));
        studentList.add(new Student1(103, "Charlie", 21));


        //ArrayList 내용 출력
        System.out.println("1 List 출력");
        // System.out.println(studentList);
        printList(studentList);
        System.out.println();
        // 1번 인덱스 가져온뒤 프린트하기
        Student1 st1 =studentList.get(1);
        System.out.println(st1);
        // 1번 이름만 출력하기
        String name1 = studentList.get(1).getName();
        System.out.println(name1);
        System.out.println();
        // 모든 student 이름만 출력
        System.out.println("\n모든 학생의 이름 출력");
        studentList.stream()
                   .map(Student1::getName)  //이름만 추출
                   .forEach(System.out::println); 
        
        //데이터 추가
        //104, "David", 23
        System.out.println("새로운 학생 추가");
        studentList.add(new Student1(104, "David", 23));
        System.out.println(studentList);

        // 데이터 변경 102,"Robert", 25 updateStudent
        System.out.println("\n 특정 학생 변경");
        updateStudent(studentList,102,"Robert",25);
        printList(studentList);

        //데이터 삭제
        System.out.println("\n특정 학생 삭제");
        deleteStudent(studentList, 103);
        printList(studentList);

        //특정 학생 검색
        System.out.println("\n 특정 학생 검색");
        Student1 searchedStudent = findStudentById(studentList, 104);
        System.out.println(searchedStudent != null ? searchedStudent:"학생을 찾을 수 없습니다." );
    }












    private static Student1 findStudentById(List<Student1> studentList, int id) {
        return studentList.stream()
                          .filter(student -> student.getId() == id)
                          .findFirst()  //학생이 여러명 있어도 첫번째 학생만 선택
                          .orElse(null);   //학생을 찾으면 해당 학생을 반환 , 찾지 못하면 null 반환
    }










    private static void deleteStudent(List<Student1> studentList, int id) {
        boolean removed = studentList.removeIf(student -> student.getId() == id);
                System.out.println(removed ? "학생 ID" + id + "정보가 삭제되었습니다." : "학생 ID" + id + "가 존재하지 않습니다.");
    }





    private static void updateStudent(List<Student1> studentList, int id, String newname, int newage) {
        boolean updated = studentList.stream()
                                     .filter(student -> student.getId() == id)
                                     .peek(student -> {
                                        student.setName(newname);
                                        student.setAge(newage);
                                     })
                                     .findFirst()   //
                                     .isPresent();
                System.out.println(updated ? "학생 ID" + id + "정보가 수정되었습니다." : "학생 ID" + id + "가 존재하지 않습니다.");
    }




    private static void printList(List<Student1> studentList) {
        studentList.forEach(System.out::println);
    }
}
