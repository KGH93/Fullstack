package a0327;

    import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        phoneBook.put("영이", "010-1234-5678");
        phoneBook.put("민지", "010-2222-3333");

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        if (phoneBook.containsKey(name)) {
            System.out.println(name + "의 전화번호: " + phoneBook.get(name));
        } else {
            System.out.println("등록되지 않은 이름입니다.");
        }

        sc.close();
    }
}


