package a0324;

public class Car2Main {

    public static void main(String[] args) {
        Car2 c1 = new Car2();   // white ,기아 ,경차 출력
        Car2 c2 = new Car2("중형차");   // white ,기아 ,중형차 출력
        Car2 c3 = new Car2("현대","대형차");   // white ,현대 ,대형차 출력
        Car2 c4 = new Car2("black","기아","화물차");   // black ,기아 ,화물차 출력


        System.out.println("c1 = " + c1.color + " " + c1.company + " " + c1.type);

        System.out.println("c1 = "+c1);  // tostring이 생략되있음. tostring 설정을 안하면 주소그대로 반환됨
        System.out.println("c1 = "+c1.toString());  

        System.out.println("c2 = "+c2);
        System.out.println("c3 = "+c3);
        System.out.println("c4 = "+c4);
    }
    
    
}
