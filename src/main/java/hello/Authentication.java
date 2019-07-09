package hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.dto.AuthenticatorDto;
import org.javalite.http.Http;
import org.javalite.http.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Authentication {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private AppConfiguration configuration;

    public String token() throws IOException {
        Post post = Http.post(configuration.getAuthenticationUrl())
                .param("email", configuration.getEmail())
                .param("password", configuration.getPassword());

        return readToken(post.text());
    }

    private String readToken(String response) throws IOException {
        final AuthenticatorDto authenticator = MAPPER.readValue(response, AuthenticatorDto.class);

        return  authenticator.getToken();
    }
}
