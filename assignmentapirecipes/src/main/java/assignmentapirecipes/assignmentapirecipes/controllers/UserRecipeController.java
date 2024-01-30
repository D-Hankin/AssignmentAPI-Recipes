package assignmentapirecipes.assignmentapirecipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignmentapirecipes.assignmentapirecipes.models.UserRecipe;
import assignmentapirecipes.assignmentapirecipes.repositories.UserRecipeRepository;

@RestController
@RequestMapping("/user/{id}")
@CrossOrigin(origins = "localhost:8080")
public class UserRecipeController {

    @Autowired
    private final UserRecipeRepository userRecipeRepository;

    public UserRecipeController(UserRecipeRepository userRecipeRepository) {
        this.userRecipeRepository = userRecipeRepository;
    }

    @GetMapping("/my-recipes")
    public List<UserRecipe> findUserRecipes(Authentication authentication) {

        String currentUsername = "Kat88"/*authentication.getName()*/;
        
        System.out.println("current user: " + currentUsername);
        
        return userRecipeRepository.getUserRecipes(currentUsername);
    }

    @PostMapping("/add-recipe")
    public UserRecipe addRecipe(@RequestBody UserRecipe recipe, Authentication authentication) {

        String currentUsername = "Kat88" /*authentication.getName()*/;
        recipe.setUsername(currentUsername);
        userRecipeRepository.save(recipe);

        return recipe;
    }


    
}
