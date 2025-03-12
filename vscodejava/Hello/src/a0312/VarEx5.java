package a0312;

public class VarEx5 {
    public static void main(String[] args) {
        String item = "라면";
        int price = 800;
        double weight = 0.12;
        boolean discounted =false;
        System.out.printf("상품-%s 가격-%d원 무게-%.2fkg 할인여부-%b",
        item, price, weight, discounted);
    }
}
