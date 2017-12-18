package services.interfaces;

import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import repositories.UserRepository;
import services.impl.UserServiceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userServiceImplMock;

    @Mock
    UserRepository userRepositoryMock;

    @Mock
    User userMock;

    @Test
    public void createUser() throws Exception {
        userServiceImplMock.createUser(userMock);
        // проверяем вызвался ли метод у userRepository
        verify(userRepositoryMock).save(userMock);
    }

    @Test
    public void updateUser() throws Exception {
        userServiceImplMock.updateUser(userMock);
        verify(userRepositoryMock).save(userMock);
    }

    @Test
    public void readUserById() throws Exception {
        userServiceImplMock.readUserById(13L);
        verify(userRepositoryMock).findOne(13L);
    }

    @Test
    public void deleteUser() throws Exception {
        userServiceImplMock.deleteUser(15L);
        verify(userRepositoryMock).delete(15L);
    }

    @Test
    public void list() throws Exception {
        userServiceImplMock.list();
        verify(userRepositoryMock).findAll();
    }

}