package src.mysql.datasource.c3p0;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo2 {
    public static void main(String[] args) throws Exception {
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 100; i++) {
            Connection conn = ds.getConnection();
            System.out.println(conn);
            conn.close();
        }
    }
}
