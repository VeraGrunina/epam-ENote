package generalPackage.web.controller;

import generalPackage.data.entity.User;
import generalPackage.exception.UnprocessableEntityException;
import generalPackage.service.interfaces.AuthService;
import generalPackage.service.interfaces.UserService;
import generalPackage.web.model.UserWebModel;
import generalPackage.web.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
public class RegistrationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTransformer userTransformer;

    @GetMapping("/reg")
    public String getRegister() {
        return "Hello from reg";
    }

    @PostMapping(value = "/reg", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView addUser(@RequestBody @Valid UserWebModel userWebModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException(String.format(
                    "UserWebModel has %s validation counts",
                    bindingResult.getFieldErrorCount()));
        }

        if (userService.existsUser(userWebModel.getLogin()))
            throw new UnprocessableEntityException(String.format(
                    "User with login '%s' already exists",
                    userWebModel.getLogin())
            );

        User user = userTransformer.bind(userWebModel);
        userService.createUser(user);

        authService.saveUserPassword(user, userWebModel.getPassword());
        authService.setCurrentUserId(user.getId());

        return new ModelAndView("notebooks");
//        return new ModelAndView("redirect:/notebooks");
    }
}
