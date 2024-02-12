package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);
    void setUserById(Integer id);

    List<User> getAllUsers();
}
