package com.Springconcept.Learning.Confiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Validation {
private static final String[] AUTH_WHITELIST = {
        "/login",
        "/css/**","/images/**",
        "/js/**",
        "/dashboard",
        "/error"
};
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->auth.requestMatchers(AUTH_WHITELIST)
                .permitAll().anyRequest().authenticated())
                .formLogin(form->form.loginPage("/login").loginProcessingUrl("/login")
                        .defaultSuccessUrl("/dashboard",true)
                        .permitAll()).logout(logout->logout.logoutSuccessUrl("/login?logout"));
        return http.build();
    };
    @Bean
   public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
