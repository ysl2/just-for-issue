package src.mysql.datasource.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
    private static DataSource ds;

    private JDBCUtils() {

    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (Exception e) {
            System.out.println("JDBCUtils.getConnection() ERROR");
        }
        return null;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                System.out.println("JDBCUtils.close() resultSet ERROR");
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.println("JDBCUtils.close() statement ERROR");
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("JDBCUtils.close() connection ERROR");
            }
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

}
