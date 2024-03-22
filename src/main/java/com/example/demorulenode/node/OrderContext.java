package com.example.demorulenode.node;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * OrderContext
 * 数据上下文
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderContext {

    private List<String> executeRuleList;
    private String orderId;
}
