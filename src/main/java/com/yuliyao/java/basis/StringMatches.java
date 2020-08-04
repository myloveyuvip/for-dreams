package com.yuliyao.java.basis;

import org.apache.logging.log4j.util.Strings;

/**
 * @author YuLiyao
 * @date 2020/8/1
 */
public class StringMatches {

    public static void main(String[] args) {
        StringMatches stringMatches = new StringMatches();
        System.out.println(stringMatches.isValidIpAddressV1("192.168.1.1"));
    }

    public boolean isValidIpAddressV1(String ipAddress) {
        if (Strings.isBlank(ipAddress)) {
            return false;
        }
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        return ipAddress.matches(regex);
    }
}
