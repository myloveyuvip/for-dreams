package com.yuliyao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author YuLiyao
 * @date 2020/8/3
 */
@Data
@AllArgsConstructor
@ToString
public class User {

    private String name;

    private Integer age;
}
