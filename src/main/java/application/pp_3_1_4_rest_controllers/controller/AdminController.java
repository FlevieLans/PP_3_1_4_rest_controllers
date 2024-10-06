package application.pp_3_1_4_rest_controllers.controller;

import application.pp_3_1_4_rest_controllers.entity.User;
import application.pp_3_1_4_rest_controllers.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
//  import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
//    private final PasswordEncoder passwordEncoder; <- в новых методах не используется

//    Это нам пока что тоже не надо, т. к. passwordEncoder не используется
//    public AdminController(UserService userService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//    }

//    Пока что вот такой конструктор
    public AdminController(UserService userService) { this.userService = userService; }


//    Старый метод получения всех пользователей
//    @GetMapping("/admin")
//    public String showAllUsers(Model model){
//        model.addAttribute("allUsers", userService.getAllUsers());
//        return "admin";
//    }

    //    Новый метод получения всех пользователей
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users == null && users.isEmpty() ?
                new ResponseEntity<>(users, HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ModelAttribute("newUser")
    public User getNewUser() {
        return new User();
    }

    //    Новый метод получения пользователя по ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Старый метод добавления пользователя
//    @PostMapping
//    public String addNewUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("allUsers", userService.getAllUsers());
//            return "admin";
//        }
//        userService.saveUser(user);
//        return "redirect:/admin";
//    }

    //    Новый метод добавления пользователя
    @PostMapping
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/{id}/edit")
    public String editUser(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin";
    }

//    Старый метод обновления пользователя
//    @PostMapping("/{id}")
//    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) { return "admin"; }
//        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//        } else {
//            User existingUser = userService.getUser(id);
//            user.setPassword(existingUser.getPassword());
//        }
//        userService.updateUser(user);
//        return "redirect:/admin";
//    }

//    Новый метод обновления пользователя
    @PatchMapping
    public ResponseEntity<HttpStatus> updateUser(@RequestBody @Valid User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    Старый метод удаления пользователя
//    @PostMapping("/{id}/delete")
//    public String deleteUser(@ModelAttribute("id") int id) {
//        userService.deleteUser(id);
//        return "redirect:/admin";
//    }

//    Новый метод удаления пользователя
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}