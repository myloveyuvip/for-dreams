package com.yuliyao.designp.struct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author YuLiyao
 * @date 2020/7/22
 */
public class DriverDemo {

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");//加载及注册JDBC驱动程序
        String url = "jdbc:mysql://10.0.0.210:3306/onemt_game_test?user=www&password=ltzdwww";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        String query = "select * from gam_gameid_map";
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next()) {
            System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
        }
    }
}
