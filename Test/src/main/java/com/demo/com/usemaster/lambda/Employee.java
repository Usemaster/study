package com.demo.com.usemaster.lambda;/**
 * @author gongwj
 * @Date 2022/1/10
 */

import lombok.*;

/**
 * @author gongwj
 * @Date 2022/1/10
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private static final long serialVersionID = -9079722457749166858L;

    private String name;

    private Integer age;

    private Double salary;

    private Status status;

    public enum Status{
        WORKING,
        SLEEPING,
        VOCATION
    }

}
