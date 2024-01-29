package assignmentapirecipes.assignmentapirecipes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import assignmentapirecipes.assignmentapirecipes.services.JpaUserDetailsService;

@Configuration
public class SecurityConfig {
    
    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth
        .requestMatchers("/start", "/").permitAll())
        .userDetailsService(jpaUserDetailsService)
        .formLogin(Customizer.withDefaults());
        
        return http.build();
    }
}
