
package generalPackage.service.interfaces;

import generalPackage.data.entity.User;

public interface UserService {

    User createUser(User user);

    User updateUser(User user);

    User readUserById(Integer id);

    User readUserByLogin(String login);

    void deleteUser(Integer id);

    boolean existsUser(Integer id);

    boolean existsUser(String login);
}
