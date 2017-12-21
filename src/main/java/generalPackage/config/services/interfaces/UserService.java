package generalPackage.config.services.interfaces;

import generalPackage.config.model.User;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    User readUserById(Long id);

    User readUserByLogin(String login);

    void deleteUser(Long id);
}
