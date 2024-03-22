package com.example.demorulenode.node;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * NodeHandler
 * 规则处理器
 * 定义条件X节点对应的针对处理规则A和规则B的处理器
 * 因规则A以及规则B处理数据的数据是同一份，方法也是同一个，所以我们还是定义一个处理器超类
 * 超类对外提供统一的业务处理接口方法，同时对业务处理节点的调用进行处理的管理
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Slf4j
public abstract class NodeHandler {
    /**
     * 处理校验订单以及创建订单信息
     * @param orderRequestVo 订单创建入参
     * @return 订单DO实体类
     */
    public abstract OrderDo handleOrder(OrderRequestVo orderRequestVo);

    /**
     * 执行业务处理链路
     * @param orderRequestVo 订单创建入参
     * @param nodeComponents 业务处理节点
     * @return
     */
    protected OrderDo executeChain(OrderRequestVo orderRequestVo, List<? extends INodeComponent> nodeComponents){
        OrderParam orderParam= this.buildOrderParam(orderRequestVo);
        OrderContext orderContext = OrderContext.builder().build();
        for (INodeComponent nodeComponent : nodeComponents) {
            nodeComponent.handData(orderContext,orderParam);
        }
        log.info("执行的链路:{}",String.join(",", Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>())));
        return this.buildOrderDo(orderContext);
    }

    /**
     * 装配订单请求参数
     * @param orderRequestVo orderRequestVo
     * @return OrderParam
     */
    private OrderParam buildOrderParam(OrderRequestVo orderRequestVo) {
        return new OrderParam();
    }

    /**
     * 装配订单实体
     * @param orderContext 订单上下文
     * @return 订单DO实体类
     */
    private OrderDo buildOrderDo(OrderContext orderContext) {
        OrderDo orderDo = new OrderDo();
        orderDo.setOrderId(orderContext.getOrderId());
        return orderDo;
    }




}
