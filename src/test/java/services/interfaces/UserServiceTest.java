//package services.interfaces;
//
//import model.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import repositories.UserRepository;
//import services.impl.UserServiceImpl;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    @InjectMocks
//    private UserServiceImpl userServiceImplMock;
//
//    @Mock
//    private UserRepository userRepositoryMock;
//
//    @Mock
//    private User userMock;
//
//    @Test
//    public void createUser() throws Exception {
//        userServiceImplMock.createUser(userMock);
//        verify(userRepositoryMock).save(userMock);
//    }
//
//    @Test
//    public void updateUser() throws Exception {
//        userServiceImplMock.updateUser(userMock);
//        verify(userRepositoryMock).save(userMock);
//    }
//
//    @Test
//    public void readUserById() throws Exception {
//        when(userRepositoryMock.exists(13L)).thenReturn(true);
//        userServiceImplMock.readUserById(13L);
//        verify(userRepositoryMock).findOne(13L);
//    }
//
//    @Test
//    public void deleteUser() throws Exception {
//        userServiceImplMock.deleteUser(15L);
//        verify(userRepositoryMock).delete(15L);
//    }
//}
