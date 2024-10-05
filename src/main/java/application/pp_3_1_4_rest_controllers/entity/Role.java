package application.pp_3_1_4_rest_controllers.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

// import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

//    Убрано из-за ошибки LazyInitializationException, без этого все ок работает
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;

    public Role() { }

    public Role(int id) { this.id = id; }

    public Role(int id, String role) { this.id = id; this.role = role; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

//    Убрано поле выше, соотвественно и это не нужно
//    public Set<User> getUsers() { return users; }
//    public void setUsers(Set<User> users) { this.users = users; }

    @Override
    public String getAuthority() { return getRole(); }


    @Override
    public String toString() {
        if(role.contains("ADMIN")) {
            return "Admin";
        } else {
            return "User";
        }
    }

}