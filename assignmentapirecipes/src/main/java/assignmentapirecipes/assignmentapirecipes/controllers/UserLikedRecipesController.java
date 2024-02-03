package assignmentapirecipes.assignmentapirecipes.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignmentapirecipes.assignmentapirecipes.models.UserLikedRecipes;
import assignmentapirecipes.assignmentapirecipes.repositories.UserLikedRecipesRepository;

@RestController
@RequestMapping("/user/{id}/my-recipes")
@CrossOrigin(origins = "*")
public class UserLikedRecipesController {
    
    @Autowired
    private UserLikedRecipesRepository userLikedRecipesRepository;

    UserLikedRecipes userLikedRecipes;

    public UserLikedRecipesController(UserLikedRecipesRepository userLikedRecipesRepository) {
        this.userLikedRecipesRepository = userLikedRecipesRepository;
    }

    @GetMapping("/liked-recipes")
    public Iterable<UserLikedRecipes> getLikedRecipes(@PathVariable("id") String userId) {
            
            return userLikedRecipesRepository.findByUserId(userId);
        
    }

    @PostMapping("/add-liked-recipe/{recipeId}")
    public String likeARecipe(@RequestBody Map<String, String> incomingRecipe) {

        userLikedRecipes = new UserLikedRecipes(null, null);
        userLikedRecipes.setRecipeNumber(incomingRecipe.get("recipeId"));
        userLikedRecipes.setUserId(incomingRecipe.get("userId"));

        if (userLikedRecipes != null) {
            userLikedRecipesRepository.save(userLikedRecipes);
        }

        return "Recipe added to your list!";
    }

    @DeleteMapping("/remove-liked-recipe/{recipeId}")
    public String unliLikeARecipe(@PathVariable("id") String userId, @PathVariable String recipeId) {

        userLikedRecipesRepository.removeRecipe(userId, recipeId);
        return "Recipe removed from your list!";
    }
}
