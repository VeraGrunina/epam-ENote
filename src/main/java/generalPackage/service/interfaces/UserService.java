
package generalPackage.service.interfaces;

import generalPackage.data.entity.User;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    User readUserById(Long id);

    User readUserByLogin(String login);

    void deleteUser(Long id);
}
