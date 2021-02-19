package src.mysql.datasource.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;

import src.mysql.datasource.utils.JDBCUtils;

public class DruidDemo2 {
    public static void main(String[] args) {
        String sql = "INSERT INTO account VALUES (null,?,?)";
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "王五");
            preparedStatement.setDouble(2, 3000);
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println("connection: " + connection);
            System.out.println("preparedStatement: " + preparedStatement);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
