package yusoli.dao;

import java.util.List;

import yusoli.domain.User;

public interface UserDao {

    public List<User> findAll();
}
