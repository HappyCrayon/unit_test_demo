package tdd.shoppingcart;

public class Product {
    private final int id;
    private final String productName;
    private float price;

    public Product(int id, String productName, float price) {
        this.id=id;
        this.productName=productName;
        this.price=price;
    }


    public float getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }
}
