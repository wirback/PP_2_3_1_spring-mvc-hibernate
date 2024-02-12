package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

//@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    void setUser(User user);
    void updateUser(Long id, User user);
    void deleteUserById(Long id);
}
