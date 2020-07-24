package com.yuliyao.designp.create;

import lombok.Builder;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * lombok @Builder在编译时会自动生成builder代码，代码与ResourcePoolConfig基本类似
 * @author YuLiyao
 * @date 2020/7/22
 */
@Builder
@ToString
@Slf4j
public class LombokBuilderDemo {

    private String name;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;

}
