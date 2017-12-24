package generalPackage.web.controller;

import generalPackage.data.entity.User;
import generalPackage.exception.ApplicationRuntimeException;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.UserWebModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ValidationException;

@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<String> getRegister() {
        return new ResponseEntity<>("Hello from login", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ModelAndView addUser(@RequestBody UserWebModel userWebModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(String.format(
                    "UserDataModel has %s validation counts",
                    bindingResult.getFieldErrorCount()));
        }

        User expectedUser = userService.readUserByLogin(userWebModel.getLogin());
        if (expectedUser == null)
            throw new ApplicationRuntimeException("Wrong login");

        if (!authService.check(expectedUser, userWebModel.getPassword()))
            throw new ApplicationRuntimeException("Wrong password");

        authService.setCurrentUserId(expectedUser.getId());

        return new ModelAndView("notebooks");
//        return new ModelAndView("redirect:/notebooks");
    }
}
