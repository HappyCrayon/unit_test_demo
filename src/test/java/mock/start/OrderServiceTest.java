package mock.start;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Tested
    OrderService orderService;

    @Injectable
    OrderDao orderDao;


    @Test
    public void total_should_be_10_when_1_3_6() throws Exception {
        final Order order = new Order(1);
        final Order order1 = new Order(3);
        final Order order2 = new Order(6);

        final List<Order> orders = Arrays.asList(order, order1, order2);

        new Expectations(){{
            orderDao.getOrderList();result = orders;
        }};

        final float price = orderService.totalPrice();

        assertEquals(10,price,0.1);
    }
}