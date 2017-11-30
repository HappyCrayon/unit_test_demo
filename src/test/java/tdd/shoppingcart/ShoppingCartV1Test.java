package tdd.shoppingcart;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartV1Test {

    private ShoppingCart shoppingCart;
    private Product iphonex;
    private Product mate10;
    private Product iphone8;

    @Before
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCartV2();
        iphonex = new Product(1, "iphonex", 8499);
        mate10 = new Product(2, "mate10", 3899);
        iphone8 = new Product(3, "iphone8", 6000);
    }

    @Test
    public void should_get_3_items_after_add_3_product() throws Exception {
        shoppingCart.addProduct(iphonex);
        shoppingCart.addProduct(mate10);
        shoppingCart.addProduct(iphone8);

        assertThat(shoppingCart.getList()).hasSize(3);
        final float expected = iphone8.getPrice() + mate10.getPrice() + iphonex.getPrice();
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(expected);
    }

    @Test
    public void should_has_1_item_when_add_same_product_3_times() throws Exception {
        shoppingCart.addProduct(iphonex);
        shoppingCart.addProduct(iphonex);
        shoppingCart.addProduct(iphonex);
        assertThat(shoppingCart.getList()).hasSize(1);
        assertThat(shoppingCart.getList().get(0).getQuantity()).isEqualTo(3);
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(8499*3);
    }


    @Test
    public void item_should_be_merged_when_add_several_same_product() throws Exception {
        shoppingCart.addProduct(iphone8);
        shoppingCart.addProduct(iphonex);
        shoppingCart.addProduct(mate10);

        shoppingCart.addProduct(mate10,5);

        final int lines = shoppingCart.getList().size();

        final float expectedTotalPrice = mate10.getPrice() * 5 + mate10.getPrice() + iphone8.getPrice() + iphonex.getPrice();

        assertThat(lines).isEqualTo(3);
        assertThat(shoppingCart.getTotalPrice()).isEqualTo(expectedTotalPrice);
    }
}