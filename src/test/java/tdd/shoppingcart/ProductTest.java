package tdd.shoppingcart;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    private Product mate10;

    @Before
    public void setUp() throws Exception {
        mate10 = new Product(1, "mate10", 4899);
    }

    @Test
    public void product_id_name_price_should_be_gettable() throws Exception {
        assertThat(mate10).hasFieldOrPropertyWithValue("id",1)
                .hasFieldOrPropertyWithValue("productName","mate10")
                .hasFieldOrPropertyWithValue("price",4899f);
    }


}