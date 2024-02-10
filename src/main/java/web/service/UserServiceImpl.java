package web.service;

import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> getUser(Integer id) {
        return userDao.getUser(id);
    }
}
