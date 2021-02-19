package src.mysql.jdbc.myjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import src.mysql.datasource.utils.JDBCUtils;

public class JDBCDemo5 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            String sql1 = "UPDATE account SET balance = balance - ? WHERE id = ?";
            String sql2 = "UPDATE account SET balance = balance + ? WHERE id = ?";
            preparedStatement1 = conn.prepareStatement(sql1);
            preparedStatement2 = conn.prepareStatement(sql2);
            preparedStatement1.setDouble(1, 500);
            preparedStatement1.setInt(2, 1);
            preparedStatement2.setDouble(1, 500);
            preparedStatement2.setInt(2, 2);
            preparedStatement1.executeUpdate();
            // int i = 3/0;
            preparedStatement2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtils.close(null,preparedStatement1, conn);
            JDBCUtils.close(null,preparedStatement2, null);
        }
    }
}
