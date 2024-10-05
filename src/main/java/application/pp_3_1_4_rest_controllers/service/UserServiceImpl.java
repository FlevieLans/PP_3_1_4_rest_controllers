package application.pp_3_1_4_rest_controllers.service;

import application.pp_3_1_4_rest_controllers.entity.Role;
import application.pp_3_1_4_rest_controllers.entity.User;
import application.pp_3_1_4_rest_controllers.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<User> getAllUsers() { return userRepository.findAll(); }

    public User getUser(int id) {
        Optional<User> userFromDB = userRepository.findById(id);
        return userFromDB.orElse(new User());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) { throw new UsernameNotFoundException("User not found"); }
        return user;
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) { return false; }
        user.setRoles(Collections.singleton(new Role(1, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(int id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}