package com.yuliyao.designp.principle;

import lombok.Data;

/**
 * @author YuLiyao
 * @date 2020/7/31
 */
@Data
public class ApiMonitorInfo {

    private int tps;

    private int errorCount;

    private int timeoutCount;
}
