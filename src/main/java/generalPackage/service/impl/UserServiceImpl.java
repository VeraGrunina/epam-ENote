package generalPackage.service.impl;

import generalPackage.data.dao.UserDAO;
import generalPackage.data.entity.User;
import generalPackage.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User readUserById(Integer id) {
        return userDAO.findOne(id);
    }

    @Override
    public User readUserByLogin(String login) {
        return userDAO.findOne(login);
    }

    @Override
    public void deleteUser(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public boolean existsUser(Integer id) {
        return userDAO.exists(id);
    }

    @Override
    public boolean existsUser(String login) {
        return userDAO.exists(login);
    }
}
