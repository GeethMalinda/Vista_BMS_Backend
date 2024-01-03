package lk.vista.book.controller;


import lk.vista.book.dto.JwtRequestDTO;
import lk.vista.book.dto.JwtResponseDTO;
import lk.vista.book.dto.UserRegistrationDTO;
import lk.vista.book.entity.User;
import lk.vista.book.service.AuthenticationService;
import lk.vista.book.service.UserService;
import lk.vista.book.util.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final JWTTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(AuthenticationService authenticationService, UserService userService, JWTTokenUtil jwtTokenUtil) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO authenticationRequest) {
        try {
            Authentication authentication = authenticationService.authenticate(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword());

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponseDTO(token));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDto) {
        try {
            User newUser = userService.registerUser(registrationDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration");
        }
    }

}
