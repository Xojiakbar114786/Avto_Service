package brr.uz.avto_service.config;

import brr.uz.avto_service.entity.Role;
import brr.uz.avto_service.entity.Users;
import brr.uz.avto_service.entity.enums.RoleName;
import brr.uz.avto_service.repository.RoleRepository;
import brr.uz.avto_service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.*;


@Component
public class DataLoader implements CommandLineRunner {

    private final
    UsersRepository usersRepository;

    private final
    PasswordEncoder passwordEncoder;

    private final
    RoleRepository roleRepository;


    @Value("${spring.sql.init.enabled}")
    private boolean addSuperAdmin;

    public DataLoader(UsersRepository usersRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (addSuperAdmin) {
            Role byRoleName = roleRepository.findByRoleName(RoleName.ROLE_SUPER_ADMIN);
            Set<Role> role = new HashSet<>(Arrays.asList(byRoleName));
            Users user = new Users(
                    "Xojiakbar",
                    "Raxmatov",
                    "++998999999999",
                    passwordEncoder.encode("1234"),
                    41.27353496221772F,
                    69.22578938864957F,
                    role
            );
            usersRepository.save(user);
        }
    }
}