package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);
    void setUserById(Integer id);
    List<User> getAllUsers();
}
