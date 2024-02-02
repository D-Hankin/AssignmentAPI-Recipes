package assignmentapirecipes.assignmentapirecipes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import assignmentapirecipes.assignmentapirecipes.models.UserRecipe;

@CrossOrigin
public interface UserRecipeRepository extends CrudRepository<UserRecipe, Integer> {

    Iterable<UserRecipe> findByUserId(String userId);
    
}
