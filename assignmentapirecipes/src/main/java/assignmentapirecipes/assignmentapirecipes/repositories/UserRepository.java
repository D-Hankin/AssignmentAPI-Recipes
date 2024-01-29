package assignmentapirecipes.assignmentapirecipes.repositories;

import assignmentapirecipes.assignmentapirecipes.models.User;
import java.util.UUID;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByUsername(String username);
    
} 
