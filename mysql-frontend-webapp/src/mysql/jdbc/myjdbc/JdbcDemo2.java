package src.mysql.jdbc.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JdbcDemo2
 */
public class JdbcDemo2 {

    public static void main(String[] args) {
        // Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://192.168.3.74:3306/db3", "yusoli", "123456");
                Statement stmt = con.createStatement();) {
            String sql = "INSERT INTO account VALUES(NULL,'王五',3000)";
            int count = stmt.executeUpdate(sql);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
