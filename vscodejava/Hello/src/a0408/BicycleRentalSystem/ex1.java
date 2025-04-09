package a0408.BicycleRentalSystem;

import java.io.*;
import java.util.*;

// Interface for Menu - 메뉴 출력 및 전환을 위한 인터페이스
interface Menu {
    void print(); // 메뉴 출력
    Menu next(); // 다음 메뉴로 이동
}

// Main Application - 프로그램 실행 진입점
public class ex1 {
    public static void main(String[] args) {
        System.out.println("자전거 대여 시스템을 시작합니다.");
        Menu menu = MainMenu.getInstance(); // 메인 메뉴 객체 가져오기
        while (menu != null) {
            menu.print(); // 현재 메뉴 출력
            menu = menu.next(); // 다음 메뉴로 이동
        }
        System.out.println("프로그램이 종료됩니다.");
    }
}

// Abstract Menu Class - 메뉴 기본 동작 정의
abstract class AbstractMenu implements Menu {
    protected static final Scanner scanner = new Scanner(System.in); // 사용자 입력 스캐너
    private final String menuText; // 메뉴 텍스트
    protected Menu prevMenu; // 이전 메뉴 객체

    public AbstractMenu(String menuText, Menu prevMenu) {
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    @Override
    public void print() {
        System.out.println(menuText); // 메뉴 텍스트 출력
    }

    public void setPrevMenu(Menu prevMenu) {
        this.prevMenu = prevMenu; // 이전 메뉴 설정
    }
}

// Main Menu for Users - 사용자용 메인 메뉴
class MainMenu extends AbstractMenu {
    private static final MainMenu instance = new MainMenu(null); // 싱글톤 인스턴스
    private static final String MENU_TEXT =
            "1: 자전거 대여\n" +
            "2: 대여 상태 확인\n" +
            "3: 대여 반납\n" +
            "4: 관리자 메뉴로 이동\n" +
            "q: 종료\n" +
            "메뉴를 선택하세요: ";

    private MainMenu(Menu prevMenu) {
        super(MENU_TEXT, prevMenu);
    }

    public static MainMenu getInstance() {
        return instance; // 메인 메뉴 싱글톤 인스턴스 반환
    }

    @Override
    public Menu next() {
        switch (scanner.nextLine()) {
            case "1":
                rentBicycle(); // 자전거 대여
                return this;
            case "2":
                checkRentalStatus(); // 대여 상태 확인
                return this;
            case "3":
                returnBicycle(); // 자전거 반납
                return this;
            case "4":
                if (!checkAdminPassword()) {
                    System.out.println(">> 비밀번호가 틀렸습니다.");
                    return this;
                }
                AdminMenu adminMenu = AdminMenu.getInstance();
                adminMenu.setPrevMenu(this);
                return adminMenu; // 관리자 메뉴로 이동
            case "q":
                return null; // 종료
            default:
                System.out.println("올바르지 않은 입력입니다.");
                return this;
        }
    }

    // 자전거 대여 기능
    private void rentBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll(); // 모든 자전거 가져오기
            System.out.println("대여 가능한 자전거 목록:");
            for (int i = 0; i < bicycles.size(); i++) {
                if (!bicycles.get(i).isRented()) {
                    System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
                }
            }
            System.out.println("대여할 자전거 번호를 입력하세요:");
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            bicycles.get(index).rent(); // 자전거 대여
            System.out.println("대여 완료.");
        } catch (Exception e) {
            System.out.println("대여 실패: " + e.getMessage());
        }
    }

    // 대여 상태 확인 기능
    private void checkRentalStatus() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("대여 상태 확인:");
            for (Bicycle bicycle : bicycles) {
                System.out.printf("%s - %s\n", bicycle, bicycle.isRented() ? "대여 중" : "대여 가능");
            }
        } catch (IOException e) {
            System.out.println("데이터를 불러오지 못했습니다.");
        }
    }

    // 자전거 반납 기능
    private void returnBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("반납할 자전거 번호를 입력하세요:");
            for (int i = 0; i < bicycles.size(); i++) {
                if (bicycles.get(i).isRented()) {
                    System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
                }
            }
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            bicycles.get(index).returnBicycle(); // 자전거 반납
            System.out.println("반납 완료.");
        } catch (Exception e) {
            System.out.println("반납 실패: " + e.getMessage());
        }
    }

    // 관리자 비밀번호 확인 기능
    private boolean checkAdminPassword() {
        System.out.println("관리자 비밀번호를 입력하세요:");
        return "admin1234".equals(scanner.nextLine()); // 비밀번호 검증
    }
}

// Admin Menu for Managing Bicycles - 관리자용 메뉴
class AdminMenu extends AbstractMenu {
    private static final AdminMenu instance = new AdminMenu(null); // 싱글톤 인스턴스
    private static final String MENU_TEXT =
            "1: 자전거 등록\n" +
            "2: 자전거 목록 보기\n" +
            "3: 자전거 삭제\n" +
            "b: 메인 메뉴로 이동\n" +
            "메뉴를 선택하세요: ";

    private AdminMenu(Menu prevMenu) {
        super(MENU_TEXT, prevMenu);
    }

    public static AdminMenu getInstance() {
        return instance; // 관리자 메뉴 싱글톤 인스턴스 반환
    }

    @Override
    public Menu next() {
        switch (scanner.nextLine()) {
            case "1":
                createBicycle(); // 자전거 등록
                return this;
            case "2":
                printAllBicycles(); // 자전거 목록 출력
                return this;
            case "3":
                deleteBicycle(); // 자전거 삭제
                return this;
            case "b":
                return prevMenu; // 이전 메뉴로 이동
            default:
                System.out.println("올바르지 않은 입력입니다.");
                return this;
        }
    }

    // 자전거 등록 기능
    private void createBicycle() {
        System.out.println("자전거 이름을 입력하세요:");
        String name = scanner.nextLine();
        try {
            Bicycle.create(name);
            System.out.println("자전거 등록 완료.");
        } catch (IOException e) {
            System.out.println("등록 실패: " + e.getMessage());
        }
    }

    // 자전거 목록 출력 기능
    private void printAllBicycles() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("자전거 목록:");
            for (Bicycle bicycle : bicycles) {
                System.out.println(bicycle);
            }
        } catch (IOException e) {
            System.out.println("데이터를 불러오지 못했습니다.");
        }
    }

    // 자전거 삭제 기능
    private void deleteBicycle() {
        try {
            List<Bicycle> bicycles = Bicycle.findAll();
            System.out.println("삭제할 자전거 번호를 입력하세요:");
            for (int i = 0; i < bicycles.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
            }
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            Bicycle.delete(bicycles.get(index).getName()); // 자전거 삭제
            System.out.println("삭제 완료.");
        } catch (Exception e) {
            System.out.println("삭제 실패: " + e.getMessage());
        }
    }
}

// User Class - 사용자 정보 관리
class User {
    private final String id; // 사용자 ID
    private final String name; // 사용자 이름
    private final String phone; // 사용자 전화번호

    public User(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("User[ID=%s, Name=%s, Phone=%s]", id, name, phone);
    }
}

// Rental Class - 대여 정보 관리
class Rental {
    private final String userId; // 대여한 사용자 ID
    private final String bicycleId; // 대여된 자전거 ID
    private final Payment payment; // 결제 정보

    public Rental(String userId, String bicycleId) {
        this.userId = userId;
        this.bicycleId = bicycleId;
        this.payment = new Payment(new Date()); // 대여 시작 시각
    }

    public void returnBicycle() {
        payment.setReturnDate(new Date()); // 반납 시각 설정
    }

    public long getPrice() {
        return payment.calculatePrice(); // 대여 요금 계산
    }

    @Override
    public String toString() {
        return String.format("Rental[UserID=%s, BicycleID=%s, Payment=%s]",
                userId, bicycleId, payment);
    }
}

// Bicycle Class - 자전거 정보 관리
class Bicycle {
    private final String id; // 자전거 ID
    private BicycleStatus status; // 자전거 상태 (대여 가능, 대여 중, 고장)

    public Bicycle(String id, BicycleStatus status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public BicycleStatus getStatus() {
        return status;
    }

    public void rent() {
        if (status != BicycleStatus.AVAILABLE) {
            throw new IllegalStateException("자전거를 대여할 수 없습니다.");
        }
        status = BicycleStatus.RENTED; // 상태를 대여 중으로 변경
    }

    public void returnBicycle() {
        if (status != BicycleStatus.RENTED) {
            throw new IllegalStateException("자전거가 대여 중이 아닙니다.");
        }
        status = BicycleStatus.AVAILABLE; // 상태를 대여 가능으로 변경
    }

    @Override
    public String toString() {
        return String.format("Bicycle[ID=%s, Status=%s]", id, status);
    }

    // Data handling methods (mock implementation)
    public static void create(String id) throws IOException {
        // 자전거 생성 로직 (데이터베이스/파일에 저장하는 코드로 확장 가능)
        System.out.printf("Creating Bicycle: %s\n", id);
    }

    public static List<Bicycle> findAll() throws IOException {
        // 자전거 데이터 읽기 (데이터베이스/파일에서 읽는 코드로 확장 가능)
        return new ArrayList<>(); // 더미 데이터 반환
    }

    public static void delete(String name) throws IOException {
        // 자전거 삭제 로직 (데이터베이스/파일에서 삭제하는 코드로 확장 가능)
        System.out.printf("Deleting Bicycle: %s\n", name);
    }
}

// Payment Class - 결제 정보 및 요금 계산
class Payment {
    private final Date rentalDate; // 대여 시작 시각
    private Date returnDate; // 반납 시각

    public Payment(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public long calculatePrice() {
        if (returnDate == null) {
            returnDate = new Date(); // 반납되지 않았으면 현재 시각 사용
        }
        long duration = returnDate.getTime() - rentalDate.getTime();
        long hours = Math.max(1, duration / (1000 * 60 * 60)); // 최소 1시간 계산
        return hours * 1000; // 시간당 1000원 요금
    }

    @Override
    public String toString() {
        return String.format("Payment[RentalDate=%s, ReturnDate=%s, Price=%d원]",
                rentalDate, returnDate != null ? returnDate : "미반납", calculatePrice());
    }
}

// BicycleStatus Enum - 자전거 상태 정의
enum BicycleStatus {
    AVAILABLE, // 대여 가능
    RENTED,    // 대여 중
    BROKEN     // 고장
}
