package generalPackage.service.impl;

import generalPackage.data.entity.User;
import generalPackage.exception.ApplicationRuntimeException;
import generalPackage.data.dao.UserDAO;
import generalPackage.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User createUser(User user) {
        if (user == null)
            throw new ApplicationRuntimeException("create null User");

        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (!userDAO.exists(user.getId())) {
            throw new ApplicationRuntimeException(
                    String.format("There is no user with id %s",
                            user.getId()));
        }
        return userDAO.save(user);
    }

    @Override
    public User readUserById(Long id) {
        if (!userDAO.exists(id)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no user with id %s",
                            id));
        }
        return userDAO.findOne(id);
    }

    @Override
    public User readUserByLogin(String login) {
        if (!userDAO.exists(login)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no user with login '%s'",
                            login));
        }
        return userDAO.findOne(login);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userDAO.exists(id)) {
            throw new ApplicationRuntimeException(
                    String.format("There is no user with id %s",
                            id));
        }
        userDAO.delete(id);
    }

    @Override
    public boolean exists(String login) {
        return userDAO.exists(login);
    }
}
