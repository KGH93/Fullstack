package a0326.coffee1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class coffeeOrder {
    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();

        menu.put("Americano", 3000);
        menu.put("Latte", 4000);
        menu.put("Mocha", 4500);
        menu.put("Espresso", 2500);

        Map<String, Integer> order = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            // System.out.println("\n메뉴: ");
            // for(Map.Entry<String, Integer> entry: menu.entrySet()){
            // System.out.println(entry.getKey() + " - " + entry.getValue() + "원"  );
            // }
            // menu.entrySet(); - 커피이름과 가격을 저장
            // entry. getkey9*() =커피이름(Americano) entry.getValue (3000)

            for (String coffee : menu.keySet()) {
                System.out.println(coffee + " - " + menu.get(coffee) + "원");
            }
            // menu.keyset() -> menu의 모든키(커피이름
            // menu.get(coffee)랄 사용하여 해당 키(커피으름)에 대한 값을 가져옵니다.

            System.out.println("몇명의 주문을 하시겠습니까?");
            int orderP = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < orderP; i++) {
                System.out.printf("%d번째 고객님 주문을 시작합니다.", i + 1);

                System.out.println("주문할 커피 이름(종료:exit)");
                String coffee = scan.nextLine();
                if (coffee.equalsIgnoreCase("exit")) {
                    break;
                }
                if (!menu.containsKey(coffee)) {// 입력한 커피이름이 menu앱에 키에 포함되지않으면
                    System.out.println("해당커피는 메뉴에 없습니다. 다시 입력 바랍니다.");
                    continue;
                }

                System.out.println("수량: ");
                int quantity;

                // 예외 처리 // try catch 문
                while (true) {
                    try {
                        quantity = Integer.parseInt(scan.nextLine());
                        if (quantity <= 0) {
                            System.out.println("1이상의 숫자를 입력하세요");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해주세요");
                    }

                }

                // order.put(coffee, quantity);
                order.put(coffee, order.getOrDefault(coffee, 0) + quantity);
                // getOrDefault()는 Map에서 키가 존재하지 않을 경우 기본값을 반환하는 메서드
                // null 값을 방지하고 , 기본값을 처리

                // if(menu.containsKey(coffee)){
                // order.put(coffee, quantity);
                // }
                // containsKey 를 사용 할 필요 없이 코드가 간결
                System.out.println(coffee + " " + quantity + "개 추가 되었습니다.");

            }

            // 주문내역 출력
            System.out.println("\n 주문내역");
            int total = 0;
            for (Map.Entry<String, Integer> entry : order.entrySet()) {
                int price = menu.get(entry.getKey()) * entry.getValue();
                System.out.println(entry.getKey() + " X " + entry.getValue() + " = " + price + "원");
                total += price;
            }


            double discount = 0;
            double distotal = total;
                if ( total>= 20000){
                    discount = total * 0.1;
                    distotal = total - discount;
                    System.out.printf("총 금액: %d원\n 할인 적용: 10%% 할인 - %.0f원\n 총 금액: %.0f원\n",total,discount,distotal);
                    break;
                }else{
                    System.out.println("총 금액: " + total + "원");
                    break;
                }
            
            // order("Americano",3)
            // menu.get("Americano") = 3000
            // entry.getValue() = 3
            // price = 9000;
        }
        scan.close();
    }

}