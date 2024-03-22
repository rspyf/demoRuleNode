package com.example.demorulenode.node;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
public enum OrderHandlerEnum {
    TO_A(1,"ruleA"),
    TO_B(2,"ruleB"),
    TO_C(3,"ruleC");
    public final Integer orderType;
    public final String ruleHandle;

    public static String getRuleHandle(Integer orderType){
        return Arrays.stream(OrderHandlerEnum.values())
                .filter(e-> Objects.equals(e.orderType,orderType))
                .findFirst()
                .orElse(OrderHandlerEnum.TO_A)
                .ruleHandle;
    }
}
