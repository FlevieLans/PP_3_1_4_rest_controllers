package application.pp_3_1_4_rest_controllers.repository;

import application.pp_3_1_4_rest_controllers.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> { }
