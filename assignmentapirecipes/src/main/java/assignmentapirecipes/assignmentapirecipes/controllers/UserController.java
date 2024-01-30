package assignmentapirecipes.assignmentapirecipes.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assignmentapirecipes.assignmentapirecipes.models.User;
import assignmentapirecipes.assignmentapirecipes.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "localhost:8080")
public class UserController {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> findAll() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {

        String encryptedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        System.out.println(user);
        System.out.println("newUSer");

        return user;
    }

    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable("id") @NonNull UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }
    
}
