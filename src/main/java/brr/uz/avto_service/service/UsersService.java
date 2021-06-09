package brr.uz.avto_service.service;

import brr.uz.avto_service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public  UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersRepository.findByPhoneNumber(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }
}
