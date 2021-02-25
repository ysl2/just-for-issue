package yusoli.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import yusoli.dao.UserDao;
import yusoli.domain.User;
import yusoli.util.JDBCUtils;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

}
