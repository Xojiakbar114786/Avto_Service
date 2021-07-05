package brr.uz.avto_service.config;

import brr.uz.avto_service.entity.Company;
import brr.uz.avto_service.entity.Users;
import brr.uz.avto_service.entity.enums.RoleName;
import brr.uz.avto_service.repository.CompanyRepository;
import brr.uz.avto_service.repository.RoleRepository;
import brr.uz.avto_service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements CommandLineRunner {


    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CompanyRepository companyRepository;


    @Value("${spring.sql.init.enabled}")
    private boolean addSuperAdmin;



//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(new MyCustomAuthProvider());
//    }

    @Override
    public void run(String... args)  {
        if (addSuperAdmin) {
            usersRepository.save(new Users(
                    "Xojiakbar",
                    "Raxmatov",
                    "+998999999999",
                    passwordEncoder.encode("1234"),
                    41.27353496221772,
                    69.22578938864957,
                    roleRepository.findByRoleName(RoleName.ROLE_SUPER_ADMIN)
            ));
            Users user = usersRepository.save(new Users(
                    "Xojiakbar",
                    "Raxmatov",
                    "+998999999999",
                    passwordEncoder.encode("1234"),
                    69.22578938864957,
                    41.27353496221772,
                    roleRepository.findByRoleName(RoleName.ROLE_USER)
            ));
            for (double i = 0; i < 10; i=i+0.009) {
                companyRepository.save(new Company(
                        "BMW service",
                        user,
                        41.27353496221772+i,
                        69.22578938864957+i,
                        "+9989999999"+i,
                        true
                ));
            }
        }
    }
}