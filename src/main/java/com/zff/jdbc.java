package com.zff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc {
    public static void main(String[] args) throws Exception{
//        注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
//        获取连接
        Connection connection=DriverManager.getConnection("jdbc:mysql://10.100.16.79:3306/db");
//        获取操作数据库的预处理对象
        PreparedStatement pstm = connection.prepareStatement("select * from account");
//执行sql
        ResultSet rs=pstm.executeQuery();
        //        遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("id"));
        }
//        释放资源
        rs.close();
        pstm.close();
        connection.close();
    }
}
