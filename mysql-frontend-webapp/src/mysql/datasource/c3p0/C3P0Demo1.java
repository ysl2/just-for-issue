package src.mysql.datasource.c3p0;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo1 {
    public static void main(String[] args) throws Exception {
        DataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
