package a0320;

public class Class5 {
    public static void main(String[] args) {
        // person1이라는 객체를 만들고 생성자에 "홍길동" 31 넣어 출력하시오/
        Person person1 = new Person("홍길동", 31);

        System.out.printf(" 이름: %s 나이: %d%n", person1.name, person1.age);
    }
}

class Person {
    String name;
    int age;

    public Person(String n, int a) {
        name = n;
        age = a;

    }

}