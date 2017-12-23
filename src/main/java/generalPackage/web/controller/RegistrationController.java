package generalPackage.web.controller;

import generalPackage.data.entity.Hash;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.UserWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView getRegister() {
        return new ModelAndView("Hello from reg");
    }

//    @PostMapping("/register")
//    public ModelAndView postRegister(
//            @PathVariable String login,
//            @PathVariable String password) {
//
//        if (userService.exists(login)) {
//            return new ModelAndView("redirect:/register");
//            //TODO login taked
//        }
//
//
//        authService.saveUserPassword(user.getId());
//
//
//        Hash hash = Hash.builder().hash(AuthService.hashPassword(password)).build();
//        UserWebModel newUser = UserWebModel.builder()
//                .login(login)
//                .name(name)
//                .hash(hash)
//                .build();
//        userService.createUser(newUser);
//        return new ModelAndView("redirect:/login");
//        //TODO say success
//    }


}
