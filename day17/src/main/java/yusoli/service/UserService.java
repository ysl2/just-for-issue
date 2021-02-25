package yusoli.service;

import java.util.List;

import yusoli.domain.User;

public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
}
