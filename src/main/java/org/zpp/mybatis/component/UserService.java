package org.zpp.mybatis.component;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        System.out.println("执行 orderService 的自动装配");
        this.orderService = orderService;
    }
}
