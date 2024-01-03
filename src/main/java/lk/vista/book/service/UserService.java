package lk.vista.book.service;


import lk.vista.book.dto.UserRegistrationDTO;
import lk.vista.book.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerUser(UserRegistrationDTO registrationDto);
}
