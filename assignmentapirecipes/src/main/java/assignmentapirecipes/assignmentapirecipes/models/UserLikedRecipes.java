package assignmentapirecipes.assignmentapirecipes.models;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@CrossOrigin(origins = "*")
public class UserLikedRecipes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    private String userId;
    private String recipeNumber;

    public UserLikedRecipes() {}

    public UserLikedRecipes(User user, String recipeNumber) {
        this.user = user;
        this.recipeNumber = recipeNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRecipeNumber() {
        return recipeNumber;
    }

    public void setRecipeNumber(String recipeNumber) {
        this.recipeNumber = recipeNumber;
    }


    
    
    
}
