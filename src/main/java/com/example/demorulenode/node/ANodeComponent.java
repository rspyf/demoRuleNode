package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ANodeComponent
 * A流程实现业务处理
 * 实现业务处理接口
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
@Component
@RuleA
@Order(1)
public class ANodeComponent implements INodeComponent{
    @Override
    public void handData(OrderContext orderContext, OrderParam orderParam) {
        log.info("RuleA流程执行处理A业务节点");
        final List<String> executeRuleList  = Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>());
        executeRuleList.add("ANodeComponent");
        orderContext.setExecuteRuleList(executeRuleList);
        orderContext.setOrderId("TOA_11111");

    }
}
