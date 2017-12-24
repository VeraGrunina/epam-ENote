package generalPackage.service.interfaces;

import generalPackage.data.entity.Credit;
import generalPackage.data.entity.User;

public interface CreditService {

    Credit createCredit(Credit credit);

    Credit updateCredit(Credit credit);

    Credit readCreditByUser(User user);
}
