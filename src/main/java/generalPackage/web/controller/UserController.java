package generalPackage.web.controller;

import generalPackage.data.entity.User;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.UserWebModel;
import generalPackage.web.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Transactional
@Controller
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTransformer userTransformer;

    @GetMapping("/user}")

    public UserWebModel getUser() {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return null; // redirect:/check
        }

        User user = userService.readUserById(currentUserId);
        return userTransformer.unbind(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserWebModel userWebModel) {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId == null) {
            return; // redirect:/check
        }

        User user = userTransformer.bind(userWebModel);
        user.setId(currentUserId);
        userService.updateUser(user);
    }

    @DeleteMapping("/user}")
    public void deleteUser() {
        Integer currentUserId = authService.getCurrentUserId();

        if (currentUserId != null) {
            User user = userService.readUserById(currentUserId);
            userService.deleteUser(currentUserId);
        }

        return; // redirect:/400
    }
}
