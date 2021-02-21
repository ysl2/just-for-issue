package src.mysql.jdbc.myjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import src.mysql.datasource.utils.JDBCUtils;

public class JDBCDemo4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your username");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        if (new JDBCDemo4().login(username, password)) {
            System.out.println("login successful");
        } else {
            System.out.println("login failed");
        }
        scanner.close();
    }

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM user WHERE username = ? AND PASSWORD = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println(conn);
            System.out.println(preparedStatement);
            System.out.println(rs);
            System.out.println("Exception: login error");
            System.exit(1);
        } finally {
            JDBCUtils.close(rs, preparedStatement, conn);
        }
        return false;
    }
}
