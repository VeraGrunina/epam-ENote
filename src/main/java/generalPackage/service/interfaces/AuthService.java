package generalPackage.service.interfaces;

public interface AuthService {

    Long getCurrentUserId();

    void setCurrentUserId(Long currentUserId);

    boolean login(Long userId, String password);
    boolean register(Long userId, String password);
}
