package com.example.demorulenode.node;

/**
 * INodeComponent
 * 各业务节点处理的数据是同一份，处理方法是一个，只是处理的业务不同
 * 所以我们定义一个业务处理点的接口，让各业务节点去实现业务处理接口
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
public interface INodeComponent {
    /**
     * 定义所有数据处理节点的接口
     * @param orderContext 数据上下文
     * @param orderParam 数据处理入参参数
     */
    void handData(OrderContext orderContext,OrderParam orderParam);
}
