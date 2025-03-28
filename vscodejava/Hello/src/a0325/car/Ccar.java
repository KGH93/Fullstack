package a0325.car;

public class Ccar {
    public static void main(String[] args) {
        
        Car car = new Car("베누스");
        Bicycle bicycle = new Bicycle("에피드");
        car.displayInfo();
        car.move();
        System.out.println();
        bicycle.displayInfo();
        bicycle.move();


    }
}


abstract class Vehicle{
    String name;

    public Vehicle(String name) {
        this.name = name;
    }


    abstract void move();   //추상메서드

    void displayInfo(){    //일반메서드
        System.out.println("이 차량은 " + name + " 입니다.");
    }

}


class Car extends Vehicle{

    public Car(String name) {
            super(name);
        }

    @Override
    void move() {
        System.out.println("자동차 ["+ name + "]이(가) 도로를 달립니다.");
    }    
}



class Bicycle extends Vehicle{

    public Bicycle(String name) {
        super(name);
    }

    @Override
    void move() {   
        System.out.println("자동차 ["+ name + "]이(가) 페달을 밟으며 이동합니다.");
    }

}