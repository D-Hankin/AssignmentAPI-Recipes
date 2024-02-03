package assignmentapirecipes.assignmentapirecipes.models;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
@CrossOrigin(origins = "*")
public class UserRecipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userRecipeId;
    
    private String recipeMethod;

    private String recipeName;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
    
    private String userId;
    
    @ElementCollection
    @Size(min = 0, max = 10)
    private List<String> ingredients;
    
    public UserRecipe() {}
    
    public UserRecipe(String username, String recipeName, List<String> ingredients, byte[] recipeImage, String recipeMethod) {

        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.recipeMethod = recipeMethod;
    }
    
    public String getRecipeMethod() {
        return recipeMethod;
    }

    public void setRecipeMethod(String recipeMethod) {
        this.recipeMethod = recipeMethod;
    }

    public int getUserRecipeId() {
        return userRecipeId;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecipeName() {
        return recipeName;
    }
    
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(String ingredient) {
        this.ingredients.remove(ingredient);
    }
}   
