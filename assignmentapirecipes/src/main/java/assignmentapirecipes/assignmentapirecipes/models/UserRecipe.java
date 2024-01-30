package assignmentapirecipes.assignmentapirecipes.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserRecipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private User user;
    
    private String username;
    
    @ElementCollection
    @Size(min = 1, max = 10)
    private List<String> ingredients;
    
    @NotNull
    private String recipeName;

    @Lob
    private byte[] recipeImage;

    public UserRecipe() {}
    
    public UserRecipe(String username, String recipeName, List<String> ingredients, byte[] recipeImage) {

        this.username = username;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.recipeImage = recipeImage;
    }
    
    
    public int getId() {
        return id;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public byte[] getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    

    



}   
