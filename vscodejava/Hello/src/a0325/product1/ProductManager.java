package a0325.product1;

import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products = new ArrayList<>();
    // 프로덕트 객체 모음을 관리하는 리스트 





    private int nextId = 1; //제품 id 자동증가

    public void addProduct(String name, double price) {
        products.add(new Product(nextId++, name, price));
        System.out.println("제품이 추가 되었습니다.");
    }




    //생성자에서 더미데이터 추가
    public ProductManager(){
        products.add(new Product(nextId++, "laptop", 1200.0));
        products.add(new Product(nextId++, "mouse", 50.0));
        products.add(new Product(nextId++, "keyboard", 100.0));
    }





    public void listProducts() {
        if(products.isEmpty()){ //products 비어있으면 
            System.out.println("제품이 없습니다.");
        }else{
            for(Product p : products){
                System.out.println(p);
            }
        }
    }




    public boolean updateProduct(int id, String newName, double newPrice) {
        for(Product p:products){
            if(p.getId() == id){
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("제품이 수정되었습니다.");
                return true;
            }
        }
        System.out.println("해당 id의 제품이 없습니다.");
        return false;
    }




    public boolean deleteProduct(int id) {
        for(Product d:products){
            if(d.getId() == id){
                products.remove(d);
                System.out.println("제품이 삭제되었습니다.");
                return true;
            }
        }
        System.out.println("해당 id의 제품이 없습니다.");
        return false;
        // return products.removeIf(p -> p.getId() == id);  //람다식 removeIf
    }
}
