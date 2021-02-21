package src.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import src.mysql.datasource.utils.JDBCUtils;

/**
 * JDBCTemplateDemo1
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        // DataSource ds = DruidDataSourceFactory.createDataSource(JDBCUtils.class.getClassLoader().getResource("druid.properties"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "UPDATE account SET balance = 5000 WHERE id = ?";
        int count = jdbcTemplate.update(sql, 3);
        System.out.println(count);
    }
}
