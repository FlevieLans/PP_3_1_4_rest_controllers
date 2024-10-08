package application.pp_3_1_4_rest_controllers.controller;

import application.pp_3_1_4_rest_controllers.entity.User;
import application.pp_3_1_4_rest_controllers.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) { this.userService = userService; }

    @GetMapping("/userInfo")
    public User getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        return (User) userService.loadUserByUsername(currentUsername);
    }

}
