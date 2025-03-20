package a0320;

public class Class3 {
    public static void main(String[] args) {
        // System.out.println(Card.width);

        //Card.width, Card.height 클래스변수 // 객체 생성없이 사용가능
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        // 객체 생성후 참조변수 c1을 사용
        Card c1 = new Card();    // c1 주소 할당
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 5;

        System.out.println("c1은 : " + c1.kind + ", " + c1.number + "이며, 크기는 " + c1.width + ", " + c1.height);
        System.out.println("c2는 : " + c2.kind + ", " + c2.number + "이며, 크기는 " + c2.width + ", " + c2.height);

        System.out.println("c1의 width와 height 50 , 50으로 변경합니다.");
        // c1.width = 50;   
        // c1.height = 50; 
        // 이 방식도 공용변수 변환은 되지만 아래 방식이 더좋은 방식
        Card.width = 50;
        Card.height = 50;

        // 공용변수라 싹다 50으로 변환됌
        System.out.println("c1은 : " + c1.kind + ", " + c1.number + "이며, 크기는 " + c1.width + ", " + c1.height);
        System.out.println("c2는 : " + c2.kind + ", " + c2.number + "이며, 크기는 " + c2.width + ", " + c2.height);
    }
}




class Card{
    String kind;   //인스턴스변수 // 객체변수
    int number;    //인스턴스변수 // 객체변수
    static int width = 100;
    static int height = 80;
    // 공용변수  공통되는 부분을 변수로 지정해서 사용// 변환시 모든 변수가 변화하니 주의해야함
}