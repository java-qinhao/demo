package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class mysql {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接MySQL服务器
             String username= "root";
            String password = "12345";
            String connectionUrl =
                    "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            return conn;
        }catch (Exception e){
        }
        return null;
    }
}
