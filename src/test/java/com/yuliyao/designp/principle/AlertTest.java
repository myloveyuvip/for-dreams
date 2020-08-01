package com.yuliyao.designp.principle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
public class AlertTest {

    @Test
    public void check() {
        ApiMonitorInfo apiMonitorInfo = new ApiMonitorInfo();
        apiMonitorInfo.setTps(5086);
        apiMonitorInfo.setErrorCount(1000);
        Alert.getInstance().check(apiMonitorInfo);

    }
}