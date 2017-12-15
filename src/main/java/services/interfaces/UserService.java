package services.interfaces;

import model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User readUserById(Long id);
    void deleteUser(Long id);
    List<User> list();
}
