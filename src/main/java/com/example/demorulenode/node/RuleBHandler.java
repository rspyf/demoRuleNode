package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * RuleBHandler
 *
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
@Component("ruleB")
public class RuleBHandler extends NodeHandler{

    @RuleB
    @Autowired
    private List<? extends INodeComponent> nodeComponents;

    @Override
    public OrderDo handleOrder(OrderRequestVo orderRequestVo) {
        return super.executeChain(orderRequestVo,nodeComponents);
    }
}
