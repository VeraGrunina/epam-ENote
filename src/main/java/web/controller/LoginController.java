//package web.controller;
//
//import model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//import services.interfaces.UserService;
//import web.utils.AuthService;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private AuthService authService;
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ModelAndView login(@PathVariable String login, @PathVariable String password) {
//
//        User user = userService.readUserByLogin(login);
//        if (!authService.check(user.getId(), password))
//            return new ModelAndView("redirect:/login");
//
//        return new ModelAndView(String.format("redirect:/user/%d/notebooks", user.getId()));
//    }
//}
