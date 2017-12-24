package generalPackage.service.interfaces;

import generalPackage.data.entity.User;

public interface AuthService {

    Integer getCurrentUserId();

    void setCurrentUserId(Integer currentUserId);

    boolean check(User user, String password);

    void saveUserPassword(User user, String password);
}
