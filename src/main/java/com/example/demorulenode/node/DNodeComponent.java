package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DNodeComponent
 *
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
@RuleA
@Order(20)
@Component
public class DNodeComponent implements INodeComponent{
    @Override
    public void handData(OrderContext orderContext, OrderParam orderParam) {
        log.info("RuleA流程执行处理D业务节点");
        final List<String> executeRuleList  = Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>());
        executeRuleList.add("DNodeComponent");
        orderContext.setExecuteRuleList(executeRuleList);
    }
}
