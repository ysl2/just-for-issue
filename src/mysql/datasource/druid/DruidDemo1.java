package src.mysql.datasource.druid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        // test1();
        test2();
    }

    public static void test1() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("druid.properties"));
        Properties properties = new Properties();
        properties.load(reader);
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 0; i < 100; i++) {
            Connection conn = ds.getConnection();
            System.out.println(conn);
            conn.close();
        }
    }

    public static void test2 () throws Exception {
        Properties properties = new Properties();
        InputStream is = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 0; i < 100; i++) {
            Connection conn = ds.getConnection();
            System.out.println(conn);
            conn.close();
        }
    }
}
