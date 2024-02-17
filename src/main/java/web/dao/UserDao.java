package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(Long id);
    void addUser(User user);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUserById(Long id);
}
