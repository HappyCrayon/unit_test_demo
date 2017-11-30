package tdd.shoppingcart;

import java.util.List;

interface ShoppingCart {

    List<CartItem> addProduct(Product product);

    List<CartItem> getList();

    float getTotalPrice();

    List<CartItem> addProduct(Product product, int quantity);
}
