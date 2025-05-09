package a0325.abstract1;

public class Main3 {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");

        dog.makeSound();
        dog.eat();
        // Animal 클래스가 추상클래스 이므로 직접 인스턴스를 만들수 없고 
        // Dog와 같은 하위 클래스에서 인스턴스를 만들어야 합니다.

        Cat cat = new Cat("나비");

        cat.makeSound();;
        cat.eat();

        Bird bird = new Bird("ediot");

        bird.makeSound();
        bird.eat();

    }
}
