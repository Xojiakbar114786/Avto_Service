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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;


    @Value("${spring.datasource.initialization-mode}")
    private String addSuperAdmin;

    @Override
    public void run(String... args) throws Exception{
        if (addSuperAdmin.equals("always")) {
            Role byRoleName = roleRepository.findByRoleName(RoleName.ROLE_SUPER_ADMIN);
            Set<Role> role = new HashSet<>(Arrays.asList(byRoleName));
            Users users = new Users(
                   "Xojiakbar",
                    "Raxmatov",
                    "+998994503114",
                    passwordEncoder.encode("qwert456"),
                    22.139021330134582,
                    39.96507856579298,
                    null,
                    null,
                    0,
                    false,
                    role,
                    true,
                    true,
                    true,
                    true
            );
            usersRepository.save(users);
        }
    }
}