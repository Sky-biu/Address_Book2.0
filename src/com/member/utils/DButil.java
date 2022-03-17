package com.member.utils;

import java.sql.*;

public class DButil {
    private static String url = "jdbc:mysql://localhost:3306/address_book_data?serverTimezone=GMT%2B8";
    private static String user = "root";
    private static String password = "00000000";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        // 关闭资源，避免出现异常
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        try {
            DButil.getConnection();
            System.out.println("---测试数据库链接成功---");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
