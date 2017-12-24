package generalPackage.service.impl;

import generalPackage.data.entity.Credit;
import generalPackage.data.entity.User;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.CreditService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private CreditService creditService;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final int WORKLOAD = 12;

    private Integer currentUserId;

    private String hashPassword(String password) {

        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(password, salt);
    }

    @Override
    public boolean check(User user, String password) {

        Credit credit = creditService.readCreditByUser(user);
        String hash = credit.getHash();

        if (!BCrypt.checkpw(password, hash))
            return false;

        setCurrentUserId(user.getId());
        return true;
    }

    @Override
    public void saveUserPassword(User user, String password) {

        Credit credit = new Credit();
        credit.setUser(user);
        credit.setHash(hashPassword(password));

        creditService.createCredit(credit);
    }
}


//CREATE TABLE user_credit (
//    user_id      INT          NOT NULL,
//    hash         VARCHAR(60)  NOT NULL,
//
//    CONSTRAINT user_credit__user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
//);
//
// jBCrypt: http://www.mindrot.org/projects/jBCrypt/
