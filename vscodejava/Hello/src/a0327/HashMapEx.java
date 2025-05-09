package a0327;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {
    public static void main(String[] args) {
        // HashMap 생성: 이름을 키로, 전화번호를 값으로 저장
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String name, phoneNumber;

        while (true) {
            System.out.println("전화번호부 메뉴:");
            System.out.println("1. 전화번호 추가");
            System.out.println("2. 전화번호 조회");
            System.out.println("3. 전화번호 삭제");
            System.out.println("4. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            switch (choice) {
                case 1: // 전화번호 추가
                    System.out.print("이름을 입력하세요: ");
                    name = scanner.nextLine();
                    System.out.print("전화번호를 입력하세요: ");
                    phoneNumber = scanner.nextLine();
                    phoneBook.put(name, phoneNumber);
                    System.out.println("전화번호가 추가되었습니다.");
                    break;

                case 2: // 전화번호 조회
                    System.out.print("조회할 이름을 입력하세요: ");
                    name = scanner.nextLine();
                    if (phoneBook.containsKey(name)) {
                        System.out.println(name + "의 전화번호: " + phoneBook.get(name));
                    } else {
                        System.out.println("등록되지 않은 이름입니다.");
                    }
                    break;

                case 3: // 전화번호 삭제
                    System.out.print("삭제할 이름을 입력하세요: ");
                    name = scanner.nextLine();
                    if (phoneBook.containsKey(name)) {
                        phoneBook.remove(name);
                        System.out.println(name + "의 전화번호가 삭제되었습니다.");
                    } else {
                        System.out.println("등록되지 않은 이름입니다.");
                    }
                    break;

                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
}
