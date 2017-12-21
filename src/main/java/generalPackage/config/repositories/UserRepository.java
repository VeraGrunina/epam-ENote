package generalPackage.config.repositories;

import generalPackage.config.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

    boolean exists(String login);

    User findOne(String login);
}
