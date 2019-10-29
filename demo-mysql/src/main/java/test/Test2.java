package test;

import util.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {
    public static void main(String[] args) throws SQLException, InterruptedException {
        final Test2 tests = new Test2();
        Thread[] threads = new Thread[1];
        for (int i=0;i<1;i++){
            threads[i] = new Thread(){
                @Override
                public void run() {
                    try {
                        tests.service();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            };
        }
        for (int i=0;i<1;i++){
            threads[i].start();
        }
    }
    public void service() throws Exception {
        Connection connection = mysql.getConnection();
        String selectSql = "select count from stock where id = 1";
        PreparedStatement statement1 = connection.prepareStatement(selectSql);
        ResultSet resultSet = statement1.executeQuery();
        resultSet.next();
        String count = resultSet.getString("count");
        System.out.println(count);
        int c = Integer.parseInt(count);
        Thread.sleep(10);
        if (c<1)
            throw new Exception();
        String updateSql = "update stock set count = count - 1 where count > 0";
        PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
        int update = preparedStatement.executeUpdate();
        String insertSql = "insert into stock_order(sid,name) VALUES (1,'aaa')";
        PreparedStatement statement = connection.prepareStatement(insertSql);
        int insert = statement.executeUpdate();
    }
}