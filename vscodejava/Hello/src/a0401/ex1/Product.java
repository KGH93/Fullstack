package a0401.ex1;

class Product {
    private String name;
    private String category;
    private String brand;
    private int price;
    private int stock;

    public Product(String name, String category, String brand, int price, int stock) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - Price: " + price + " Stock: " + stock;
    }
}
