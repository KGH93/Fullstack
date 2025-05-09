package a0401.ex2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Customer {
    private final String name;
    private final String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Order {
    private final int id;   
    private final Customer customer;
    private final String product;  //제품
    private final int quantity;  //수량

    public Order(int id, Customer customer, String product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Kim", "Seoul");
        Customer customer2 = new Customer("Lee", "Busan");
        Customer customer3 = new Customer("Park", "Seoul");
        Customer customer4 = new Customer("Choi", "Seoul");

        List<Order> orders = Arrays.asList(
                new Order(1, customer1, "Laptop", 1),
                new Order(2, customer2, "Smartphone", 2),
                new Order(3, customer3, "Keyboard", 1),
                new Order(4, customer1, "Mouse", 3),
                new Order(5, customer4, "Monitor", 1),
                new Order(6, customer3, "USB Cable", 2)
        );

        // 여기에 답을 작성하세요.

        // 문제1 서울에사는 고객의 주문만 출력하시오
        practice1(orders);

        // 문제2 모든 주문의 총 수량을 구하시오 (mapToint사용)
        practice2(orders);

        // 문제3 각 고객의 이름과 그 고객이 주문한 제품명을 출력하시오.
        practice3(orders);

        // 문제4 특정고객(kim)의 주문만 필터링하여 출력하시오.
        practice4(orders);

        //문제 5: 주문 수량이 2개 이상인 주문만 출력하시오.
        practice5(orders);

        //문제 6: 고객이 주문한 제품의 종류를 중복 없이 출력하시오.
        practice6(orders);

        //문제 7. 모든 주문을 quantity 기준 내림차순으로 정렬하시오.
        practice7(orders);
    
        //문제 8.각 도시별로 고객 수를 출력하시오. (count이용)
        practice8(orders);
    }


    //문제 8.각 도시별로 고객 수를 출력하시오. (count이용/ count에는 long 사용해야함)
    private static void practice8(List<Order> orders) {
        long seoul = orders.stream()
            .map(Order::getCustomer)
            .filter(ord -> "Seoul".equals(ord.getCity()))
            .distinct()
            .count();
            System.out.println("\nSeoul에서 주문한 고객 수 :" + seoul + "명 입니다.");

        long busan = orders.stream()
            .map(Order::getCustomer)
            .filter(ord -> "Busan".equals(ord.getCity()))
            .distinct()
            .count();
            System.out.println("\nBusan에서 주문한 고객 수 :" + busan + "명 입니다.");
    }

    //문제 7. 모든 주문을 quantity 기준 내림차순으로 정렬하시오.
    private static void practice7(List<Order> orders) {
        List<Order> result = orders.stream()
            .sorted(Comparator.comparing(Order::getQuantity).reversed())
            .collect(Collectors.toList());
            System.out.println("\n모든 주문의 수량 기준 " + result + "순으로 정렬했습니다.");
    }

    //문제 6: 고객이 주문한 제품의 종류를 중복 없이 출력하시오.
    private static void practice6(List<Order> orders) {
        List<String> result = orders.stream()
            .map(Order::getProduct)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
            System.out.println("\n고객님들이 주문한 제품의 종류는 " +result+" 입니다.");
    }

    //문제 5: 주문 수량이 2개 이상인 주문만 출력하시오.
    private static void practice5(List<Order> orders) {
        List<Order> result = orders.stream()
            .filter(order->order.getQuantity() >=2)
            .collect(Collectors.toList());
            System.out.println("\n주문 수량이 2개이상인 주문은 " +result+ " 입니다.");
    }

    // 문제4 특정고객(kim)의 주문만 필터링하여 출력하시오.
    private static void practice4(List<Order> orders) {
        List<String> result = orders.stream()
            .filter(order->("Kim").equals(order.getCustomer().getName()))
            .map(Order::getProduct)  //스트림의 각 요소를 다른 형태로 변환할 때 사용,각 주문에서 제품 정보를 추출하는 역할
            .distinct()   //스트림에서 중복된 요소를 제거.여러 번 주문된 경우, 중복된 제품을 하나로 줄임
            .sorted()   //스트림의 요소를 정렬, 기본적으로 자연 순서로 정렬
            .collect(Collectors.toList());   //스트림의 요소를 리스트, 세트 등으로 수집
            System.out.println("\nKim 고객님의 주문은 " + result + " 입니다.");
    }

    // 문제3 각 고객의 이름과 그 고객이 주문한 제품명을 출력하시오.
    private static void practice3(List<Order> orders) {
        List<String> result = orders.stream()
            .map(order -> order.getCustomer().getName() + " 이고 주문한 제품명은 " + order.getProduct() + " 입니다.")
            .distinct()
            .sorted()
            .collect(Collectors.toList());
            System.out.println("\n고객의 이름은 " + result + " 입니다.");
    }

    // 문제2 모든 주문의 총 수량을 구하시오 (mapToint사용)
    private static void practice2(List<Order> orders) {
        long result = orders.stream()
            .mapToInt((Order::getQuantity))
            .sum();
            System.out.println("\n모든 주문의 총 수량은 " + result + "건 입니다.");
    }

    // 문제1 서울에사는 고객의 주문만 출력하시오
    private static void practice1(List<Order> orders) {
        List<Order> result = orders.stream()
            .filter(tran -> "Seoul".equals(tran.getCustomer().getCity()))
            .collect(Collectors.toList());
            System.out.println("서울에 사는 고객의 주문은 "+ result);
    }
}