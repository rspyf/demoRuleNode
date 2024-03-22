package com.example.demorulenode;

import com.example.demorulenode.node.OrderDo;
import com.example.demorulenode.node.OrderFactory;
import com.example.demorulenode.node.OrderRequestVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRuleNodeApplicationTests {

    @Autowired
    public OrderFactory orderFactory;

    @Test
    public void testCreatOrder() {
        OrderRequestVo orderRequestVo = new OrderRequestVo();
        orderRequestVo.setOrderType(1);
        orderRequestVo.setOrderNo("123");
        orderRequestVo.setUserId("aaa");
        orderRequestVo.setUserName("小明");
        OrderDo order = orderFactory.createOrder(orderRequestVo);
        System.out.println(order.getOrderId());
    }


}
