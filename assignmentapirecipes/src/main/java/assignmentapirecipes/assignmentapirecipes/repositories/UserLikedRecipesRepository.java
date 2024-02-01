package assignmentapirecipes.assignmentapirecipes.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import assignmentapirecipes.assignmentapirecipes.models.UserLikedRecipes;
import jakarta.transaction.Transactional;

public interface UserLikedRecipesRepository extends CrudRepository<UserLikedRecipes, Integer>{

    @Transactional
    @Modifying
    @Query("DELETE FROM UserLikedRecipes ulr WHERE ulr.userId =?1 AND ulr.recipeNumber=?2")
    void removeRecipe(String userId, String recipeId);

    
}
