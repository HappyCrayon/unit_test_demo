package tdd.shoppingcart;

import org.junit.Test;

import static org.junit.Assert.*;

public class CartItemTest {

    @Test
    public void should_get_item_price_when_5_mate10() throws Exception {
        final Product mate10 = new Product(1, "mate10", 5000);
        final CartItem cartItem = new CartItem(mate10);
        cartItem.setQuantity(5);

        final float price = cartItem.getPrice();

        assertEquals(25000f,price,0.00001);
    }

    @Test
    public void shoud_be_able_to_change_the_quantity() throws Exception {
        final Product mate10 = new Product(1, "mate10", 5000);
        final CartItem cartItem = new CartItem(mate10);
        cartItem.setQuantity(5);
    }
}