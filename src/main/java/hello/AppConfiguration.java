package hello;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
@Getter
@Setter
@ComponentScan("hello")
public class AppConfiguration {

    private String host;
    private String authenticationUrl;
    private String email;
    private String password;
    private String postsUrl;

}

