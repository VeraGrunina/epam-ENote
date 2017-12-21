package generalPackage.config.web.utils;

import lombok.Data;
import generalPackage.config.model.Hash;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import generalPackage.config.services.interfaces.HashService;
import generalPackage.config.services.interfaces.UserService;

@Data
public class AuthService {

    private static int workload = 12;

    @Autowired
    private UserService userService;

    @Autowired
    private HashService hashService;

    private Long currentUserId;

    public static int getWorkload() {
        return workload;
    }

    public static void setWorkload(int workload) {
        AuthService.workload = workload;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public HashService getHashService() {
        return hashService;
    }

    public void setHashService(HashService hashService) {
        this.hashService = hashService;
    }

    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(password_plaintext, salt);

        return (hashed_password);
    }

    public boolean check(Long userId, String plainPassword) {
        Hash hash = hashService.readHashByUserId(userId);
        String storedHash = hash.getHash();

        if (null == storedHash || !storedHash.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        if (!BCrypt.checkpw(plainPassword, storedHash))
            return false;

        setCurrentUserId(userId);
        return true;
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
