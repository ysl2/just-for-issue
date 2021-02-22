package test;

import org.junit.Test;

import dao.UserDao;
import domain.User;

public class UserDaoTest {

    @Test
    public void testLogin() throws Exception {
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        System.out.println(user);
    }

}
