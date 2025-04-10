package a0408.BicycleRentalSystem;


import java.io.*;
import java.util.*;

class Bicycle {
    private String id;  // 자전거 ID
    private BicycleStatus status;  // 자전거 상태 (대여 가능, 대여 중, 고장)

    // 생성자
    public Bicycle(String id, BicycleStatus status) {
        this.id = id;
        this.status = status;
    }

    // Getter 메서드
    public String getId() {
        return id;
    }

    public BicycleStatus getStatus() {
        return status;
    }

    public void setStatus(BicycleStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Bicycle[ID=%s, Status=%s]", id, status);
    }

    // 모든 자전거 데이터를 파일에서 읽어오는 메서드
    public static List<Bicycle> findAll() throws IOException {
        List<Bicycle> bicycles = new ArrayList<>();
        File file = new File("bicycles.txt"); // 자전거 데이터를 저장한 파일

        // 파일이 존재하지 않으면 빈 리스트 반환
        if (!file.exists()) {
            return bicycles;
        }

        // 파일 읽기
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // 파일 내용은 "ID,STATUS" 형식
                String id = parts[0];
                BicycleStatus status = BicycleStatus.valueOf(parts[1]); // 문자열을 enum으로 변환
                bicycles.add(new Bicycle(id, status));
            }
        }

        return bicycles;
    }

    // 자전거 데이터를 파일에 추가하는 메서드
    public static void add(Bicycle bicycle) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bicycles.txt", true))) {
            writer.write(bicycle.getId() + "," + bicycle.getStatus());
            writer.newLine();
        }
    }

    // 특정 자전거 데이터를 파일에서 삭제하는 메서드
    public static void delete(String id) throws IOException {
        File file = new File("bicycles.txt");
        List<Bicycle> bicycles = findAll();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Bicycle bicycle : bicycles) {
                if (!bicycle.getId().equals(id)) {
                    writer.write(bicycle.getId() + "," + bicycle.getStatus());
                    writer.newLine();
                }
            }
        }
    }
}






private void rentBicycle() {
    try {
        List<Bicycle> bicycles = Bicycle.findAll();
        System.out.println("대여 가능한 자전거 목록: ");
        boolean hasAvailable = false;

        // 대여 가능한 자전거 출력
        for (int i = 0; i < bicycles.size(); i++) {
            if (bicycles.get(i).getStatus() == BicycleStatus.AVAILABLE) {
                hasAvailable = true;
                System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
            }
        }

        if (!hasAvailable) {
            System.out.println("대여 가능한 자전거가 없습니다.");
            return; // 대여 가능한 자전거가 없으면 종료
        }

        // 사용자 입력
        System.out.println("대여할 자전거 번호를 입력하세요:");
        int index = Integer.parseInt(scan.nextLine()) - 1;

        // 대여 시간 입력
        System.out.println("몇 시간 동안 대여하시겠습니까?");
        int rentalHours = Integer.parseInt(scan.nextLine());

        // 요금 계산 및 대여 처리
        Bicycle selectedBicycle = bicycles.get(index);
        double payment = rentalHours * 1000.0; // 시간당 1000원
        System.out.printf("결제 금액: %.2f원\n", payment);

        // 대여 정보 생성 및 출력
        Rental rental = new Rental("User123", selectedBicycle.getId(), rentalHours);
        selectedBicycle.rent();
        System.out.println(rental);
        System.out.println("대여 완료!");

    } catch (NumberFormatException e) {
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
    } catch (IndexOutOfBoundsException e) {
        System.out.println("유효하지 않은 번호입니다.");
    } catch (Exception e) {
        System.out.println("대여 실패: " + e.getMessage());
    }
}




private void returnBicycle() {
    try {
        List<Bicycle> bicycles = Bicycle.findAll();
        System.out.println("반납할 자전거 번호를 입력하세요:");
        boolean hasRented = false;

        // 대여 중인 자전거 목록 출력
        for (int i = 0; i < bicycles.size(); i++) {
            if (bicycles.get(i).getStatus() == BicycleStatus.RENTED) {
                hasRented = true;
                System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
            }
        }

        if (!hasRented) {
            System.out.println("반납할 대여 중인 자전거가 없습니다.");
            return; // 대여 중인 자전거가 없으면 종료
        }

        // 사용자 입력
        int index = Integer.parseInt(scan.nextLine()) - 1;

        // 선택한 자전거 반납 처리
        Bicycle bicycle = bicycles.get(index);
        if (bicycle.getStatus() != BicycleStatus.RENTED) {
            System.out.println("선택한 자전거는 대여 중이 아닙니다.");
            return;
        }

        // 요금 계산
        double cost = Rental.calculateCost(bicycle.getId());
        bicycle.returnBicycle(); // 자전거 상태를 '대여 가능'으로 변경
        System.out.printf("반납 완료! 이용료: %.2f원\n", cost);
    } catch (NumberFormatException e) {
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
    } catch (IndexOutOfBoundsException e) {
        System.out.println("유효하지 않은 번호입니다.");
    } catch (Exception e) {
        System.out.println("반납 실패: " + e.getMessage());
    }
}




// 자전거 고장 신고 메서드
private void reportBicycle() {
    try {
        List<Bicycle> bicycles = Bicycle.findAll();
        System.out.println("고장 신고할 자전거 번호를 입력하세요:");
        for (int i = 0; i < bicycles.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
        }
        int index = Integer.parseInt(scan.nextLine()) - 1;
        bicycles.get(index).setStatus(BicycleStatus.BROKEN); // 자전거 상태를 '고장'으로 변경
        System.out.println("고장 신고 완료!");
    } catch (Exception e) {
        System.out.println("고장 신고 실패: " + e.getMessage());
    }
}













// 자전거 목록 보기
private void ListupBicycle() {
    try {
        List<Bicycle> bicycles = Bicycle.findAll();
        System.out.println("자전거 목록:");
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle);
        }
    } catch (Exception e) {
        System.out.println("목록 조회 실패: " + e.getMessage());
    }
}

// 자전거 등록
private void addBicycle() {
    try {
        System.out.println("등록할 자전거 ID를 입력하세요:");
        String id = scan.nextLine();
        Bicycle newBicycle = new Bicycle(id, BicycleStatus.AVAILABLE); // 새 자전거 생성
        Bicycle.add(newBicycle); // 데이터베이스에 추가
        System.out.println("자전거 등록 완료!");
    } catch (Exception e) {
        System.out.println("등록 실패: " + e.getMessage());
    }
}

// 자전거 삭제
private void dropBicycle() {
    try {
        List<Bicycle> bicycles = Bicycle.findAll();
        System.out.println("삭제할 자전거 번호를 입력하세요:");
        for (int i = 0; i < bicycles.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, bicycles.get(i));
        }
        int index = Integer.parseInt(scan.nextLine()) - 1;
        Bicycle.delete(bicycles.get(index).getId()); // 자전거 삭제
        System.out.println("자전거 삭제 완료!");
    } catch (Exception e) {
        System.out.println("삭제 실패: " + e.getMessage());
    }
}














