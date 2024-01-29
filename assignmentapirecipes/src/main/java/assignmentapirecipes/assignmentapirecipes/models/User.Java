package assignmentapirecipes.assignmentapirecipes;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id; 
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    
}