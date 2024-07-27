package com.api.employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.ContentSecurityPolicyHeaderWriter;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection if using stateless APIs
                .headers(headers -> headers
                        .addHeaderWriter(new ContentSecurityPolicyHeaderWriter(
                                "frame-ancestors 'self' http://localhost:8080/h2-console"  // This disables embedding of your site in any frame
                        ))
                )

                .authorizeRequests()

                // Allow access to public endpoints
                        .requestMatchers("/api/employee/**").permitAll()

                // Allow access to H2 console
               // .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers(toH2Console()).permitAll()

                // Require authentication for other endpoints
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/user/**").hasRole("USER")
                        .and()
                        .formLogin(withDefaults()) // Enable form-based login
                        .httpBasic(withDefaults()); // Use only if needed

        return http.build();
    }

    // In-Memory Authentication  for simple applications and development purposes.
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder().encode("adminpass")).roles("ADMIN").build(),
                User.withUsername("user").password(passwordEncoder().encode("userpass")).roles("USER").build()
        );

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
