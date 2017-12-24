package generalPackage.data.dao;

import generalPackage.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User getUserByLogin(String login);

    boolean exists(String login);

    User findOne(String login);
}
