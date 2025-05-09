package a0401.ex1;

import java.util.Arrays;
import java.util.List;

public class InventoryManager {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Smartphone", "Electronics", "Samsung", 500, 10),
            new Product("Laptop", "Electronics", "Apple", 1500, 3),
            new Product("T-shirt", "Clothing", "Nike", 30, 50),
            new Product("Jacket", "Clothing", "Adidas", 80, 20),
            new Product("Microwave", "Home Appliances", "LG", 200, 15),
            new Product("Washing Machine", "Home Appliances", "Samsung", 700, 5),
            new Product("Shoes", "Footwear", "Nike", 100, 10),
            new Product("Refrigerator", "Home Appliances", "Whirlpool", 1200, 8),
            new Product("Headphones", "Electronics", "Sony", 150, 30),
            new Product("Sofa", "Furniture", "Ikea", 400, 12)
        );

        // 문제 1 예시 호출 (Electronics 카테고리에서 재고가 5개 미만인 상품 찾기)
        problem1(products);

        // 문제 2 예시 호출 (모든 상품의 가격을 10% 인상한 새로운 가격 목록 출력)
        problem2(products);

        // 문제 3 예시 호출 (재고가 10개 이상인 상품을 가격 순으로 내림차순 정렬)
        problem3(products);

        // 문제 4 예시 호출 (Clothing 카테고리의 상품을 가격 순으로 오름차순 정렬)
        problem4(products);

        // 문제 5 예시 호출 (Home Appliances 카테고리의 상품 개수)
        problem5(products);

        // 문제 6 예시 호출 (가격이 5000 이상이고 재고가 5개 이상인 상품 이름만 출력)
        problem6(products);

        // 문제 7 예시 호출 (가격이 가장 비싼 상품 출력)
        problem7(products);

        // 문제 8 예시 호출 (가격이 1000 이상인 상품들의 가격 합계 계산)
        problem8(products);

        // 문제 9 예시 호출 (Nike 브랜드의 상품을 재고가 많은 순으로 출력)
        // problem9(products);

        // 문제 10 예시 호출 (가격이 2000 이하인 상품을 재고가 적은 순으로 출력)
        // problem10(products);
    }


    // 문제 1: "Electronics" 카테고리의 상품 중 재고가 5개 미만인 상품 출력
    private static void problem1(List<Product> products) {
        products.stream()
                .filter(product -> "Electronics".equals(product.getCategory()))
                .filter(product -> product.getStock() < 5)
                .forEach(System.out::println);
    }

    // 문제 2: 모든 상품의 가격을 10% 인상한 가격 출력
    private static void problem2(List<Product> products) {
        products.stream()
                .map(product -> new Product(product.getName(), product.getCategory(), product.getBrand(), 
                                            (int)(product.getPrice() * 1.1), product.getStock()))
                .forEach(System.out::println);
    }

    // 문제 3: 재고가 10개 이상인 상품을 가격 순으로 내림차순 정렬
    private static void problem3(List<Product> products) {
        products.stream()
                .filter(product -> product.getStock() >= 10)
                .sorted((p1, p2) -> Integer.compare(p2.getPrice(), p1.getPrice()))  // 가격 내림차순
                .forEach(System.out::println);
    }

    // 문제 4: "Clothing" 카테고리의 상품을 가격 순으로 오름차순 정렬
    private static void problem4(List<Product> products) {
        products.stream()
                .filter(product -> "Clothing".equals(product.getCategory()))
                .sorted((p1, p2) -> Integer.compare(p1.getPrice(), p2.getPrice()))  // 가격 오름차순
                .forEach(System.out::println);
    }

    // 문제 5: "Home Appliances" 카테고리의 상품 개수 출력
    private static void problem5(List<Product> products) {
        long count = products.stream()
                .filter(product -> "Home Appliances".equals(product.getCategory()))
                .count();
        System.out.println("Home Appliances 카테고리의 상품 개수: " + count);
    }

    // 문제 6: 가격이 5000 이상이고 재고가 5개 이상인 상품 이름만 출력
    private static void problem6(List<Product> products) {
        products.stream()
                .filter(product -> product.getPrice() >= 5000 && product.getStock() >= 5)
                .map(Product::getName)
                .forEach(System.out::println);
    }

    // 문제 7: 가격이 가장 높은 상품 출력
    private static void problem7(List<Product> products) {
        products.stream()
                .max((p1, p2) -> Integer.compare(p1.getPrice(), p2.getPrice()))
                .ifPresent(System.out::println);
    }

    // 문제 8: 가격이 1000 이상인 상품들의 가격 합계 출력
    private static void problem8(List<Product> products) {

    }

}