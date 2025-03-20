package a0320;

public class Class5_1 {
    public static void main(String[] args) {
        // person1이라는 객체를 만들고 생성자에 "홍길동" 31 넣어 출력하시오/

        Person1 p1 = new Person1("홍길동", 31);   //기본생성자없어도 되는방법
        Person1 p2 = new Person1();                       //기본생성자가 무조건 필요한 방법


        p2.name = "이순신";
        p2.age = 25;

        
        System.out.printf(" 이름: %s 나이: %d%n", p1.name, p1.age);   //  메서드없으면 기본생성자가 있어 null , 0 출력됌
        System.out.printf(" 이름: %s 나이: %d%n", p2.name, p2.age);
    }
}

class Person1 {
    String name;
    int age;


    public Person1(String n, int a) {
        this.name = n;  //this는 구별을 위해 genelate contract시 자동생성
        this.age = a;
    }

    public Person1(){    //p2를 위한 기본생성자

    }






    //자바프로그램이 알아서 기본생성자를 만들어준다.
    //public Person1(){

    //}

 }
