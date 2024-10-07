package application.pp_3_1_4_rest_controllers.controller;

import application.pp_3_1_4_rest_controllers.entity.User;
import application.pp_3_1_4_rest_controllers.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

 @Controller
//@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }


    @GetMapping
    public String getUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        User currentUser = (User) userService.loadUserByUsername(currentUsername);
        model.addAttribute("user", currentUser);
        return "user";
    }

}