package com.example.demorulenode.node;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RuleA
 *
 * @Qualifier注解用于指定要注入的具体bean的名称
 * @Qualifier
 * @Target它也是元注解（修饰注解的注解），用于描述注解的适用场景（即注解的使用地方），通过定义ElementType的取值类型实
 * @Retention
 * 1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 * 2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 * 3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在
 * @author pyf
 * @version V1.0.0
 * @date 2024/3/21
 */
@Qualifier
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RuleA {
}
