package javamilos.com.example.demo.service;

import javamilos.com.example.demo.dto.UserDto;
import javamilos.com.example.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User saveUser(UserDto userDto);
}
