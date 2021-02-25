package yusoli.service.impl;

import java.util.List;

import yusoli.dao.UserDao;
import yusoli.dao.impl.UserDaoImpl;
import yusoli.domain.User;
import yusoli.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

}
