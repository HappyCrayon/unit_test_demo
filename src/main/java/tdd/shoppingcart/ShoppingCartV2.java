package tdd.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartV2 implements ShoppingCart {

    private Map<Integer, CartItem> cartItemMap = new HashMap<>();


    @Override
    public List<CartItem> addProduct(Product product) {
        final boolean alreadyIn = isProductAlreadyIn(product);
        if (alreadyIn)
            increaseOne(product);
        else {
            newItem(product);
        }
        return getList();
    }

    @Override
    public List<CartItem> getList() {

        return new ArrayList<>(cartItemMap.values());
    }

    @Override
    public float getTotalPrice() {
        float totalPrice = 0f;
        for (CartItem item : getList()) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public List<CartItem> addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addProduct(product);
        }
        return getList();
    }


    private void newItem(Product product) {
        final CartItem item = new CartItem(product);
        cartItemMap.put(product.getId(), item);
    }

    private void increaseOne(Product product) {
        cartItemMap.get(product.getId()).increase();
    }

    private boolean isProductAlreadyIn(Product product) {
        return cartItemMap.containsKey(product.getId());
    }

}
