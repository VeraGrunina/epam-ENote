package services;

import generalPackage.data.entity.UserWebModel;
import generalPackage.data.dao.UserDAO;
import generalPackage.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userServiceImplMock;

    @Mock
    private UserDAO userDAOMock;

    @Mock
    private UserWebModel userMock;

    @Test
    public void createUser() throws Exception {
        userServiceImplMock.createUser(userMock);
        verify(userDAOMock).save(userMock);
    }

    @Test
    public void updateUser() throws Exception {
        userServiceImplMock.updateUser(userMock);
        verify(userDAOMock).save(userMock);
    }

    @Test
    public void readUserById() throws Exception {
        when(userDAOMock.exists(13L)).thenReturn(true);
        userServiceImplMock.readUserById(13L);
        verify(userDAOMock).findOne(13L);
    }

    @Test
    public void deleteUser() throws Exception {
        userServiceImplMock.deleteUser(15L);
        verify(userDAOMock).delete(15L);
    }
}
