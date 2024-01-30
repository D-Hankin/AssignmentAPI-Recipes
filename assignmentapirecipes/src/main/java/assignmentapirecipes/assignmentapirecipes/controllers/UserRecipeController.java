package assignmentapirecipes.assignmentapirecipes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignmentapirecipes.assignmentapirecipes.models.UserRecipe;
import assignmentapirecipes.assignmentapirecipes.repositories.UserRecipeRepository;

@RestController
@RequestMapping("/user/{id}")
@CrossOrigin(origins = "localhost:5500")
public class UserRecipeController {

    @Autowired
    private final UserRecipeRepository userRecipeRepository;

    public UserRecipeController(UserRecipeRepository userRecipeRepository) {
        this.userRecipeRepository = userRecipeRepository;
    }

    @GetMapping("/my-recipes")
    public Iterable<UserRecipe> findUserRecipes(Authentication authentication) {

        String currentUsername = "Kat88"/*authentication.getName()*/;
        
        System.out.println("current user: " + currentUsername);
        
        return userRecipeRepository.findByUsername(currentUsername);
    }

    @PostMapping("/add-recipe")
    public UserRecipe addRecipe(@RequestBody UserRecipe recipe, Authentication authentication) {

        String currentUsername = "Kat88" /*authentication.getName()*/;
        recipe.setUsername(currentUsername);
        userRecipeRepository.save(recipe);

        return recipe;
    }

    @GetMapping("my-recipes/{userRecipeId}")
    public Optional<UserRecipe> findRecipe(@PathVariable("userRecipeId") @NonNull Integer userRecipeId) {
        return userRecipeRepository.findById(userRecipeId);
    }

    @DeleteMapping("/my-recipes/{userRecipeId}/delete-recipe")
    public Iterable<UserRecipe> deleteRecipe(@PathVariable("userRecipeId") @NonNull Integer userRecipeId, Authentication authentication) {

        userRecipeRepository.deleteById(userRecipeId);
        String currentUsername = "Kat88"/*authentication.getName()*/;
        
        return userRecipeRepository.findByUsername(currentUsername);
    }

    @PatchMapping("my-recipes/{userRecipeId}/edit-recipe")
    public Optional<UserRecipe> editRecipe(@PathVariable("userRecipeId") @NonNull Integer userRecipeId, @RequestBody UserRecipe updatedRecipe) {

        Optional<UserRecipe> currentRecipe = userRecipeRepository.findById(userRecipeId);
        UserRecipe userRecipe = currentRecipe.get();
        userRecipe.setRecipeName(updatedRecipe.getRecipeName());
        userRecipe.setIngredients(updatedRecipe.getIngredients());
        userRecipe.setRecipeImage(updatedRecipe.getRecipeImage());
        userRecipe.setRecipeMethod(updatedRecipe.getRecipeMethod());
        userRecipeRepository.save(userRecipe);
        

        System.out.println("edit");
        return userRecipeRepository.findById(userRecipeId);
    }

    
}
