package src.mysql.jdbc.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JdbcDemo1
 */
public class JdbcDemo1 {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://192.168.3.74:3306/db3", "yusoli", "123456");
            // Connection conn = DriverManager.getConnection("jdbc:mysql:///db3", "root",
            // "root");
            // String sql = "update account set balance = 2000 where id = 1";
            String sql = "UPDATE account SET balance = 2000";
            stmt = con.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
