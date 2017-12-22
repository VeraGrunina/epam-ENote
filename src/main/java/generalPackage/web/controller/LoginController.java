package generalPackage.web.controller;

import generalPackage.data.entity.User;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ModelAndView login(@PathVariable String login, @PathVariable String password) {

        User user = userService.readUserByLogin(login);
        if (!authService.login(user.getId(), password))
            return new ModelAndView("redirect:/login");

        return new ModelAndView(String.format("redirect:/userWebModel/%d/notebooks", user.getId()));
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("Hello from login");
    }
}
