package application.pp_3_1_4_rest_controllers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String showAdminPanel() { return "admin"; }

}
