package generalPackage.service.impl;

import generalPackage.data.dao.CreditDAO;
import generalPackage.data.entity.Credit;
import generalPackage.data.entity.User;
import generalPackage.service.interfaces.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditDAO creditDAO;

    @Override
    public Credit createCredit(Credit credit) {
        return creditDAO.save(credit);
    }

    @Override
    public Credit updateCredit(Credit credit) {
        return creditDAO.save(credit);
    }

    @Override
    public Credit readCreditByUser(User user) {
        return creditDAO.findOne(user.getId());
    }
}
