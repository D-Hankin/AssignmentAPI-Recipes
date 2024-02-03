package assignmentapirecipes.assignmentapirecipes.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assignmentapirecipes.assignmentapirecipes.models.User;
import assignmentapirecipes.assignmentapirecipes.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
public class UserController {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        
        String encryptedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);

        return user;
    }

    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable("id") @NonNull UUID id) {
        Optional<User> user = userRepository.findById(id);

        return user;
    }

    @PostMapping("/custom-login")
    public Optional<User> customLogIn(@RequestBody Map<String, String> loginRequest, HttpServletRequest request) {
    
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.get("username"), loginRequest.get("password"));
        Authentication auth3 = authenticationManager.authenticate(token);

        if (auth3.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(auth3);
            Authentication successfullAuthentication = SecurityContextHolder.getContext().getAuthentication();
            Optional<User> user = userRepository.findByUsername(successfullAuthentication.getName());

            return user;
        } else {
            return null;
        }
    }

    @PostMapping("/custom-logout")
    public ResponseEntity<String> customLogout(HttpServletRequest request, HttpServletResponse response) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();      
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
        auth.setAuthenticated(false);
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, response, auth);
        SecurityContextHolder.clearContext();
        request.getSession().invalidate();
        return ResponseEntity.ok("You have successfully logged out");

    }

    @GetMapping("/users") 
    public Iterable<User> compareUsernames() {
        Iterable<User> users = userRepository.findAll();

        return users;
    }

}
