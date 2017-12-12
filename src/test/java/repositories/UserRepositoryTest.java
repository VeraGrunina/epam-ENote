package repositories;


import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getByNotebook() throws Exception {

    }
    @Test
    public void readTest() throws Exception {
        User userRead = userRepository.getOne(13L);

        User user = new User();
        user.setId(13L);
        user.setName("Vera");
        user.setEmail("vera76532");
        user.setPassword("testPassword");


        assertEquals(userRead, user);
    }



}
