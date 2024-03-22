package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * OrderFactory
 * 订单工厂决定调用那个规则处理器去执行规则，最终生成订单
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
@Component
public class OrderFactory {

    /**
     * 注入所有规则下的节点
     */
    @Autowired
    private Map<String,NodeHandler> nodeHandlerMap;

    /**
     * 创建订单
     * 匹配规则创建订单
     * @param orderRequestVo 订单参数
     * @return 订单实体
     */
    public OrderDo createOrder(OrderRequestVo orderRequestVo){
        Integer orderType = orderRequestVo.getOrderType();
        String ruleHandle = OrderHandlerEnum.getRuleHandle(orderType);
        NodeHandler nodeHandler = nodeHandlerMap.get(ruleHandle);
        if(nodeHandler==null){
            throw new RuntimeException("没有匹配到相应规则");
        }
        return nodeHandler.handleOrder(orderRequestVo);
    }
}
