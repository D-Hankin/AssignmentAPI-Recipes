package assignmentapirecipes.assignmentapirecipes.repositories;

import assignmentapirecipes.assignmentapirecipes.models.User;

import java.util.UUID;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByUsername(String username);
    
} 
