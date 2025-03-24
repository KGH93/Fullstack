package a0324;

public class Car2 {
    //필드
    String color;
    String company;
    String type;

    

   
    Car2(){
        this("white","기아","경차");
    }

    Car2(String color, String company, String type) {
        this.color = color;
        this.company = company;
        this.type = type;
    }

    Car2(String com, String t){
        this("white",com,t);
    }

    Car2(String t){
        this("white","기아",t);
    }

    // public String toString(){
    //     return color + "-" + company + "-" + type;
    // }


    // 원하는 필드 캡처후 마우스우클릭 sourceaction - tostring
    // tostring 은 생성자 출력이 매우 편리해진다.
    // toString() -기본동작 -> 클래스 이름 +@+ 16진수 해시코드 반환
    // toString() -오버라이딩(재정의) -> 객체의 정보를 의미 있게 출력
    // System.out.println("c3 = " +c3); toString() 자동 호출됨

    // ArrayList, HashMap toString()이미 오버 라이딩 되어 있음

    @Override
    public String toString() {
        return "Car2 [color=" + color + ", company=" + company + ", type=" + type + "]";
    }




    //생성자    
    // 생성저란 객체를 만드는 특별한 메소드, 객체의 상태를 초기화 할 수있다.
    // 생성자는 호출부와 정의부로 나뉜다.
    // 생성자 호출시 new 키워드 사용
    // 생성자 이름과 클래스 명이 같다.
    // 생성자는 생성 객체의 주소를 반환한다.
    // 생성자는 반환 타입을 적지 않는다.
    // 클래스 내부에 생섲아가 없는 경우, 디폴트 생성자가 추가 된다.

    
}
