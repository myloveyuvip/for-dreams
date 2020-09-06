package com.yuliyao.ringcentral;

/**
 * @author yuliyao
 * @date 2020/9/5
 */
public enum ExtTypeEnum {

    User, Dept, AO, TMO, Other;


    /**
     * when name is null or doesn't exist in ExtTypeEnum， return ExtTypeEnum.Other to order by last
     * @param name
     * @return
     */
    public static ExtTypeEnum sortValueOf(String name) {

        if (name == null || !isExists(name)) {
            return ExtTypeEnum.Other;
        }
        
        return ExtTypeEnum.valueOf(name);

    }

    /**
     * return whether name is exist in ExtTypeEnum or not
     * @param name
     * @return
     */
    private static boolean isExists(String name) {
        for (ExtTypeEnum extTypeEnum : ExtTypeEnum.values()) {
            if (extTypeEnum.name().equals(name)) {
                return true;
            }
        }
        return false;

    }

}
