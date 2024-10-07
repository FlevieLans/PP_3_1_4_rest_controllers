package application.pp_3_1_4_rest_controllers.service;

import application.pp_3_1_4_rest_controllers.entity.Role;
import application.pp_3_1_4_rest_controllers.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) { this.roleRepository = roleRepository; }


    @Override
    public Set<Role> getAllRoles() { return new HashSet<>(roleRepository.findAll()); }

    @Override
    public Role findRoleById(int id) { return roleRepository.getReferenceById(id); }

}
