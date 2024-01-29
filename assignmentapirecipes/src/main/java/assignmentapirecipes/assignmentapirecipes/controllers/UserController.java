package assignmentapirecipes.assignmentapirecipes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/start")
    public String test() {
        return "Test Successful";
    }
    
}
