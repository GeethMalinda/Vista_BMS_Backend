package lk.vista.book.service;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {

    Authentication authenticate(String username, String password);

}
