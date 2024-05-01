package soumya.megatronix.portal2023.PortalRestAPI.Configuration;

import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOriginPatterns(List.of("https://msitparidhi.in")); // Allow requests only from https://msitparidhi.in
        config.setAllowedMethods(List.of("GET", "POST", "PUT")); // Allow only GET, POST, and PUT methods
        config.addAllowedHeader("*"); // Allow all headers
        config.setAllowCredentials(false); // Allow credentials (if needed)
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);


        return new CorsFilter(source);
    }
}

