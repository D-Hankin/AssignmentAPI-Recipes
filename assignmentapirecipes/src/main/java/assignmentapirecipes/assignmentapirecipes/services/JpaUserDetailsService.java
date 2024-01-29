package assignmentapirecipes.assignmentapirecipes.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import assignmentapirecipes.assignmentapirecipes.models.UserDto;
import assignmentapirecipes.assignmentapirecipes.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return userRepository.findByUsername(username)
        .map(UserDto::new)
        .orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
    }
    
}
