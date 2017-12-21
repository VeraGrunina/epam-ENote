package web.controller;


import model.Hash;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import services.interfaces.UserService;
import web.utils.AuthService;

@Controller
public class RegistrationController {

  @Autowired
  private AuthService authService;

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ModelAndView login(@PathVariable String login, @PathVariable String name,
      @PathVariable String password, @PathVariable String confirmPassword) {
    if(password != confirmPassword){
      return new ModelAndView("redirect:/register");
      //TODO say not passwords are not equal
    }

    User user = userService.readUserByLogin(login);
    if (user != null){
      return new ModelAndView("redirect:/register");
      //TODO say user already exists
    }
    Hash hash = Hash.builder().hash(AuthService.hashPassword(password)).build();
    User newUser = User.builder()
        .login(login)
        .name(name)
        .hash(hash)
        .build();
    userService.createUser(newUser);
    return new ModelAndView("redirect:/login");
    //TODO say success
  }


}
