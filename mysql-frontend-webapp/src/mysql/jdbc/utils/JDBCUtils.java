package src.mysql.jdbc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBCUtils
 */
public class JDBCUtils {
    private static String url;
    private static String username;
    private static String password;
    private static String driver;

    private JDBCUtils() {
    }

    static {
        Properties properties = null;
        ClassLoader classLoader = null;
        URL resource = null;
        String path = null;
        try {
            properties = new Properties();
            classLoader = JDBCUtils.class.getClassLoader();
            resource = classLoader.getResource("jdbc.properties");
            path = resource.getPath();
            properties.load(new BufferedReader(new FileReader(path)));
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            // driver = properties.getProperty(driver);
        } catch (Exception e) {
            System.out.println("init error");
            System.out.println("classLoader: " + classLoader);
            System.out.println("resource: " + resource);
            System.out.println("path: " + path);
            System.out.println("properties: " + properties);
            System.out.println("url: " + url);
            System.out.println("username: " + username);
            System.out.println("password: " + password);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("JDBCUtils.getConnection() return null");
            System.exit(1);
        }
        return null;
    }

    /**
     * 释放资源
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
