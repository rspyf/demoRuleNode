package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * HNodeComponent
 *
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
@RuleA
@RuleB
@Order(40)
@Component
public class HNodeComponent implements INodeComponent{
    @Override
    public void handData(OrderContext orderContext, OrderParam orderParam) {
        log.info("RuleA&RuleB流程执行处理H业务节点");
        final List<String> executeRuleList  = Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>());
        executeRuleList.add("HNodeComponent");
        orderContext.setExecuteRuleList(executeRuleList);
    }
}
