package a0327.package2;

public class Main1 {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();   //가능 . 상속받는 클래스 내부에서 접근 가능.

        // Parent parent = new Parent();
        // System.out.println(parent.message); 오류 (다른 캐피지에서 직접접근 불가능)
        // parent.showMessage(); //오류 ( 상속 없이 직접 호출 불가능)
    }
}

// 1. public (공개)
// 어디서든 접근가능(제한없음)
// ex) 라이브러리 api, 유틸리티 클래스의 메서드등

// 2. protected (상속관계에서만 접근 가능)
// 같은 패키지 내에서 자유롭게 접근 가능
// 다른 패키지에 있더라도 상속받은 경우 접근 가능

// 3. default (아무것도 안씀(패키지전용))
// 같은 패키지 내에서만 접근 가능
// 다른 패키지에서는 접근 불가능

// 4. private (비공개)
// 같은 클래스 내부에서만 접근 가능
// 외부에서 접근 할 수없음
// 보통 클래스 내부의 필드(멤버 변수)를 보호하는 데 사용