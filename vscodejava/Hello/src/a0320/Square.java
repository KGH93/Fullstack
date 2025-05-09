package a0320;

public class Square {

    int length;

    int area(){  //위로 리턴하려면 void가 아니라 int
        return length * length;
    }

    public static void main(String[] args) {
        Square s1 = new Square();
        s1.length = 4;


        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이:%d", s1.length, s1.area());
    }
}
//객체 지향 프로그램(Object-Oriented-Programming) -OOP
//객체 지향 프로그램 장점
// 1. 프로그램 유지 보수가 좋다.
// 2. 코드 재사용이 수월.

// 클래스 -> 객체의 설계도 ***************
// 클래스를 토대로 만들어진 프로그램의 구성요소를 객체
// 클래스 설계 - 필드와 메소드로 이루어짐
//  Dog d1 = new Dog(); - Dog객체만들어서 d1 연결


