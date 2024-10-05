package application.pp_3_1_4_rest_controllers.repository;

import application.pp_3_1_4_rest_controllers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
