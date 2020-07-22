package com.yuliyao.designp.create;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/21
 */
public class ResourcePoolConfigTest {

    @Test
    public void createPool() {
        ResourcePoolConfig threadPool = new ResourcePoolConfig.Builder().name("threadPool").maxIdle(10).build();
        System.out.println(JSON.toJSONString(threadPool));
    }

}