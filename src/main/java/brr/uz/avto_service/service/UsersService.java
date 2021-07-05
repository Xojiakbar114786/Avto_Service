package brr.uz.avto_service.service;

import brr.uz.avto_service.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usersRepository.findByPhoneNumber(s).orElseThrow(() -> new UsernameNotFoundException(s));

//
//    public ApiResponse createUser(UserDto userDto){
//        UserDto userDto1 = new UserDto();
//        if (userDto.getPhoneNumber().isEmpty() || userDto.getPhoneNumber().length()!=13){
//            return new ApiResponse("There is an error in the phone number",false);
//
//            userDto1.setPhoneNumber(userDto.getPhoneNumber()==null ? userDto1);
//        }
//    }

    }
}
