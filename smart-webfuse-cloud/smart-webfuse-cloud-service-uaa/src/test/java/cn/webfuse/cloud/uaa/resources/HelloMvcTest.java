package cn.webfuse.cloud.uaa.resources;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import cn.webfuse.cloud.uaa.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TestConfig.class
)
@AutoConfigureMockMvc
public class HelloMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails("user1@test.com")
    public void shouldAllowUserWithNoAuthorities() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello?name=Seb")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greetings", is("Welcome Seb (user1@test.com)!")));
    }

    @Test
    @WithUserDetails("user2@test.com")
    public void shouldRejectUserWithNoAuthorities() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello?name=Seb")
                .accept(MediaType.ALL))
                .andExpect(status().isForbidden());
    }

    @Test
    public void shouldRejectIfNoAuthentication() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello?name=Seb")
                .accept(MediaType.ALL))
                .andExpect(status().isUnauthorized());
    }
}