package mock.start;

import java.util.List;

/*
* 1.通过 mock 解决依赖，隔离外部系统
* 2.考虑 mock 是否有必要，切面上的依赖可以把业务逻辑抽出来，而无需mock 即可测试
*
* */

public class OrderService {

    private OrderDao orderDao;

    public float totalPrice(){
        final List<Order> orderList = orderDao.getOrderList();
        float total = 0 ;

        for (Order order:orderList){
            total+=order.getPrice();
        }

        return total;
    }

}
