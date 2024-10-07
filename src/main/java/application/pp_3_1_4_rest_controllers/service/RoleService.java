package application.pp_3_1_4_rest_controllers.service;

import application.pp_3_1_4_rest_controllers.entity.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getAllRoles();

    Role findRoleById(int id);

}