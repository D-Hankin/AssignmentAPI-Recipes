package assignmentapirecipes.assignmentapirecipes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import assignmentapirecipes.assignmentapirecipes.models.UserRecipe;


public interface UserRecipeRepository extends CrudRepository<UserRecipe, Integer> {

    Iterable<UserRecipe> findByUsername(String username);

    @Query("SELECT ur FROM UserRecipe ur WHERE ur.username = ?1")
    List<UserRecipe> getUserRecipes(String currentUsername); 
    
}
