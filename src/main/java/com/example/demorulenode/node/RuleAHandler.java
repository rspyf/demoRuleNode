package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RuleAHandler
 * 规则A的处理器
 * 注入spring容器
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
@Component("ruleA")
public class RuleAHandler extends NodeHandler{

    /**
     * 注入规则A的所有节点
     */
    @RuleA
    @Autowired
    private List<? extends INodeComponent> nodeComponents;

    /**
     * 处理校验订单以及创建订单信息
     * @param orderRequestVo 订单创建入参
     * @return 订单DO实体类
     */
    @Override
    public OrderDo handleOrder(OrderRequestVo orderRequestVo) {
        return super.executeChain(orderRequestVo,nodeComponents);
    }
}
