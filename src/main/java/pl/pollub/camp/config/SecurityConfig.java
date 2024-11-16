package pl.pollub.camp.config;

import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pollub.camp.Models.Role;
import pl.pollub.camp.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private JwtAuthFilter authfilter;
    private static final String[] AUTH_WHITELIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/auth/**",
            "/reservation/find",
            "/vehicle/all",
            "/vehicle/id/**",
            "/prices/find"
    };// lista dozwolonych enpointów dla niezalogowanych

    private static final String[] ADMIN_ENDPOINTS = {
            "/vehicle/delete/**",
            "/vehicle/add",
            "/vehicle/update/**",
            "/vehicle-type/**",
            "/user/**",
            "/reservation/all",
            "/reservation/cancel/**",
            "/reservation/accept/**",
            "/prices/add",
            "/prices/update",
            "/prices/all",
            "/princes/delete",
            "/order/**",
            "/inspection/**"
    };//  lista endpointów dla admina

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(admin -> admin
                        .requestMatchers(ADMIN_ENDPOINTS).hasRole(Role.ADMIN.toString()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No sessions
                )
                .addFilterBefore(authfilter, UsernamePasswordAuthenticationFilter.class)// Add JWT filter
                .cors(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}