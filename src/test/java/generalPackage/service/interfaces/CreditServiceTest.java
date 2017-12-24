package generalPackage.service.interfaces;

import generalPackage.data.dao.CreditDAO;
import generalPackage.data.entity.Credit;
import generalPackage.data.entity.User;
import generalPackage.service.impl.CreditServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreditServiceTest {

    @InjectMocks
    private CreditServiceImpl creditServiceImplMock;

    @Mock
    private CreditDAO creditDAOMock;

    @Mock
    private Credit creditMock;

    @Mock
    private User userMock;

    @Test
    public void createCredit() throws Exception {
        creditServiceImplMock.createCredit(creditMock);
        verify(creditDAOMock).save(creditMock);
    }

    @Test
    public void updateCredit() throws Exception {
        creditServiceImplMock.updateCredit(creditMock);
        verify(creditDAOMock).save(creditMock);
    }

    @Test
    public void readCreditByUser() throws Exception {
        creditServiceImplMock.readCreditByUser(userMock);
        verify(creditDAOMock).findOne(userMock.getId());
    }

}