package a0327.접근제어자;

public class DefaultExample {
    public static void main(String[] args) {
        DefaultClass obj = new DefaultClass();
        obj.display(); // 정상 실행 (같은 패키지안에서)
    }
}



class DefaultClass{
    void display(){    //앞에 아무것도 안붙이면 접근제어자는 default가 생략되있음
        System.out.println("패키지(폴더) 내부에서만 접근 가능");
    }
}