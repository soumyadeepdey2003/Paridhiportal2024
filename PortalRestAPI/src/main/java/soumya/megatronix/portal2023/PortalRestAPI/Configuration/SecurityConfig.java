package soumya.megatronix.portal2023.PortalRestAPI.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.service.AdminService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AdminService service;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").permitAll();
                    auth.requestMatchers("/megatronix/paridhi/user/**", "/megatronix/paridhi/admin/registration", "/megatronix" +
                            "/paridhi/admin/validate").permitAll();
                    auth.requestMatchers("/megatronix/paridhi/admin/**").hasRole("ADMIN");
                    auth.anyRequest().authenticated();
                });

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return service;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
