package a0325.abstract1;

// 추상클래스
// abstract 키워드가 붙은 클래스
// 객체를 직접 생성할 수 없음
// 공통적인 기능을 정의 하고, 하위클래스에서 구현하도록 강제하는 역할
// "일반메서드 + 추상 메서드(선언만 있고 구현은 없는 메서드)를 가질 수 있음"
abstract class Animal {
    String name;
 
    public Animal(String name){
        this.name = name;
    }

    abstract void makeSound();  //추상메서드 - 구현x


    void eat(){   //일반메서드
        System.out.println(name + " is eating ");
    }

}


class Dog extends Animal{   //Animal을 상속

    public Dog(String name) {
            super(name);
        }
    
    @Override
    void makeSound() {
        System.out.println(name + " 월월월 ");
    }
}

class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + "미야옹");
    }

}

class Bird extends Animal{

   
    public Bird(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + "꿕꿕꿕");
    }

}   
    
