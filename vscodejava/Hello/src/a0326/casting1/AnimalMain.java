package a0326.casting1;

public class AnimalMain {
    public static void main(String[] args) {
        Animal eagle = new Eagle();

        eagle.sleep();
        // eagle.eat(); //에러

        Eagle eagle1 = (Eagle)eagle;  //강제 형변환
        eagle1.eat();  //Eagle 클래스의 eat() 메서드

        System.out.println(eagle instanceof Animal);  
        // instanceof 연산자는 객체의 타입을 확인하는 데 사용
    }
}
