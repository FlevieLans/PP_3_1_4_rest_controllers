package application.pp_3_1_4_rest_controllers.service;

import application.pp_3_1_4_rest_controllers.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User getUser(int id);

    boolean saveUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(int id);

}