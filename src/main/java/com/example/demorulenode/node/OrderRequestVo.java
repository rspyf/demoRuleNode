package com.example.demorulenode.node;

import lombok.Data;

/**
 * OrderRequestVo
 * requestVO 订单创建入参
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Data
public class OrderRequestVo {
   private Integer orderType;
   private String orderNo;
   private String userId;
   private String userName;
}
