package com.example.demorulenode;

import com.example.demorulenode.node.OrderHandlerEnum;

/**
 * Test
 *
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
public class Test {
    @org.junit.Test
    public void test1(){
        System.out.println(OrderHandlerEnum.getRuleHandle(1));
    }
}
