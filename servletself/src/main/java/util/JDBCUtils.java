package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * Use durid pool
 */
public class JDBCUtils {
    private static DataSource ds;

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
