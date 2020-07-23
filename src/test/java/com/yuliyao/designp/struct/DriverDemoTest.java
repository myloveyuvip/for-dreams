package com.yuliyao.designp.struct;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class DriverDemoTest {

    @Test
    public void connect() throws SQLException, ClassNotFoundException {
        DriverDemo driverDemo = new DriverDemo();
        driverDemo.connect();
    }
}