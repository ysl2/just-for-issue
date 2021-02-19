package src.mysql.jdbctemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import src.mysql.datasource.utils.JDBCUtils;


public class JdbcTemplateDemo2 {
    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    // @Test
    // public void test1() {
    // String sql = "UPDATE emp SET salary = 10101 WHERE id = ?";
    // int count = jdbcTemplate.update(sql, 1001);
    // System.out.println(count);
    // }

    // @Test
    // public void test2() {
    // String sql = "INSERT INTO emp(id, ename, dept_id) VALUES (?,?,?)";
    // int count = jdbcTemplate.update(sql,1015,"郭靖",10);
    // System.out.println(count);
    // }

    // @Test
    // public void test3() {
    // String sql = "DELETE FROM emp WHERE id = ?";
    // int count = jdbcTemplate.update(sql, 1015);
    // System.out.println(count);
    // }

    // @Test
    // public void test4() {
    // String sql = "SELECT * FROM emp WHERE id = ?";
    // Map<String, Object>map = jdbcTemplate.queryForMap(sql, 1001);
    // System.out.println(map);
    // }

    // @Test
    // public void test5() {
    // String sql = "SELECT * FROM emp";
    // List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
    // for (Map<String , Object> map : list) {
    // System.out.println(map);
    // }
    // }

    // @Test
    // public void test6() {
    //     String sql = "SELECT * FROM emp";
    //     List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
    //     for (Emp e : list) {
    //         System.out.println(e);
    //     }

    // }

    @Test
    public void test7() {
        String sql = "SELECT count(id) FROM emp";
        Long total = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
