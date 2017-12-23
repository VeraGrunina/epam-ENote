package generalPackage.service.impl;

import generalPackage.data.entity.Hash;
import generalPackage.service.interfaces.HashService;
import generalPackage.service.interfaces.UserService;
import generalPackage.service.interfaces.AuthService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private static int workload = 12;

    @Autowired
    private UserService userService;

    @Autowired
    private HashService hashService;

    private Long currentUserId;

    private String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    @Override
    public Long getCurrentUserId() {
        return currentUserId;
    }

    @Override
    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    @Override
    public boolean login(Long userId, String password) {
        Hash hash = hashService.readHashByUserId(userId);
        String storedHash = hash.getHash();

        if (null == storedHash || !storedHash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        if (!BCrypt.checkpw(password, storedHash))
            return false;

        setCurrentUserId(userId);
        return true;
    }

    @Override
    public boolean register(Long userId, String password) {
        return false;
    }
}


//CREATE TABLE user_hash (
//    user_id      BIGINT       NOT NULL,
//    hash         VARCHAR(60)  NOT NULL,
//
//    CONSTRAINT user_hash__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
//
// jBCrypt: http://www.mindrot.org/projects/jBCrypt/
