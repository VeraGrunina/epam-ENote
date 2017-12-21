package web.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import services.interfaces.UserService;
import web.utils.AuthService;

@Controller
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.readUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public User updateUser(@PathVariable User user) {
        //user.setId(authService.getCurrentUserId());
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser() {
        userService.deleteUser(authService.getCurrentUserId());
    }
}
