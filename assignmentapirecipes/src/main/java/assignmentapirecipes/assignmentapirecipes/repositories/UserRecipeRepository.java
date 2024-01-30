package assignmentapirecipes.assignmentapirecipes.repositories;

import org.springframework.data.repository.CrudRepository;

import assignmentapirecipes.assignmentapirecipes.models.UserRecipe;


public interface UserRecipeRepository extends CrudRepository<UserRecipe, Integer> {

    Iterable<UserRecipe> findByUsername(String username);
    
}
