package a0321.Account1;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee c = new Coffee("아메리카노",3000);
        System.out.printf("%s(%d) ->", c.getName(), c.getPrice());
        c.setPrice(c.getPrice()+ 500);  //500원 가격인상
        System.out.printf("%s(%d) ->", c.getName(), c.getPrice());
    }
}

class Coffee{
    private String name;
    private int price;


    public Coffee(String n, int p){
        name = n;
        price = p;
    }

    public void setName(String n){
        name = n;
    }
    public void setPrice(int p){
        price = p;
    }

    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}
