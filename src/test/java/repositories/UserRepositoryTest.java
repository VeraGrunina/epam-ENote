//package repositories;
//
//import model.UserWebModel;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = TestConfig.class)
//@Transactional
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void readTest() throws Exception {
//        UserWebModel userRead = userRepository.getOne(1L);
//
//        UserWebModel user = new UserWebModel();
//        user.setId(1L);
//        user.setName("Vera");
//        user.setLogin("vera76532");
//        user.setPassword("testPassword");
//
//        assertEquals(userRead, user);
//    }
//
//    @Test
//    public void updateTest() throws Exception {
//        UserWebModel user = userRepository.getOne(2L);
//
//        user.setName("name2_changed");
//        user.setLogin("login2_changed");
//        user.setPassword("password2_changed");
//        userRepository.saveAndFlush(user);
//
//        UserWebModel actual = userRepository.getOne(2L);
//
//
//        UserWebModel expected = new UserWebModel();
//        expected.setId(2L);
//        expected.setName("name2_changed");
//        expected.setLogin("login2_changed");
//        expected.setPassword("password2_changed");
//
//        assertEquals(expected, actual);
//    }
//}
