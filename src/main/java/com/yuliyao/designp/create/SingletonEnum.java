package com.yuliyao.designp.create;

/**
 * @author YuLiyao
 * @date 2020/7/20
 */
public enum SingletonEnum {

    /**
     *
     */
    INSTANCE;

    private String ObjectName;

    public String getObjectName() {
        return ObjectName;
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }
}
