package a0325;

public class ExThis {
    public static void main(String[] args) {
        player player1 = new player("suarez");
        player player2 = new player("messi",31);
        player1.display();
        player2.display();
    }
}




class player{
    private String name;
    private int age;

    public player(String name){   // 같은 클래스 다른생성자를 호출할때 사용, 생성자 안에서만 사용가능
        this(name,30);
    }
    public player(String name, int age){  //현재 객체를 호출하거나 인스턴스 변수와 매개변수 구분할때 this 사용
        this.name = name;  
        this.age = age;
    }

    public void display(){
        System.out.println("name : " + this.name + " age : " + this.age);
    }
}