//package services.impl;
//
//import exception.ApplicationRuntimeException;
//import model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import repositories.UserRepository;
//import services.interfaces.UserService;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public User createUser(User user) {
//        if (user == null)
//            throw new ApplicationRuntimeException("create null User");
//
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User updateUser(User user) {
//        if (!userRepository.exists(user.getId())) {
//            throw new ApplicationRuntimeException(
//                    String.format("There is no user with id %s",
//                            user.getId()));
//        }
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User readUserById(Long id) {
//        if (!userRepository.exists(id)) {
//            throw new ApplicationRuntimeException(
//                    String.format("There is no user with id %s",
//                            id));
//        }
//        return userRepository.findOne(id);
//    }
//
//    @Override
//    public User readUserByLogin(String login) {
//        if (!userRepository.exists(login)) {
//            throw new ApplicationRuntimeException(
//                    String.format("There is no user with login '%s'",
//                            login));
//        }
//        return userRepository.findOne(login);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        if (!userRepository.exists(id)) {
//            throw new ApplicationRuntimeException(
//                    String.format("There is no user with id %s",
//                            id));
//        }
//        userRepository.delete(id);
//    }
//}
