package com.revature.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.SocialHubApiApplication;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repo.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Tell Spring boot to spin up a fake server/test server, and load all the normal application context for our app
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes= SocialHubApiApplication.class)
//Setsup out internal API routes with the mocked server
@AutoConfigureMockMvc
//Setsup the H2 database for use before the test
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class UserControllerIntegrationTest {

    //Setup our mock mvc to allows to generate api calls like a user would
    @Autowired
    private MockMvc mockMvc;

    //Want to gain access to the Repo, so we can setup/tear before and after tests
    @Autowired
    private UserRepo ur;

    @BeforeEach
    public void resetDatabase(){
        ur.deleteAll();
    }

    private ObjectMapper om = new ObjectMapper();

    @Test
    @Transactional
    public void successfulRegistrationTest() throws Exception {

        //Setup the data to be sent in the request
        LinkedHashMap<String, String> registerBody = new LinkedHashMap<>();

        registerBody.put("firstName", "testFirst");
        registerBody.put("lastName", "testLast");
        registerBody.put("username", "test");
        registerBody.put("email", "test@email.com");
        registerBody.put("password", "password");

        //We will use mockMvc to make a post request to our fake testing server
        mockMvc.perform(post("/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(registerBody))
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("testFirst"))
                .andExpect(jsonPath("$.lastName").value("testLast"))
                .andExpect(jsonPath("$.username").value("test"))
                .andExpect(jsonPath("$.email").value("test@email.com"))
                .andExpect(jsonPath("$.password").value("password"))
                .andExpect(jsonPath("$.posts").value(new ArrayList<Post>()));

        //Lets check to see if the user was stored correctly
        User registered = ur.findUserByUsername("test");

        assertEquals("testFirst", registered.getFirstName());
        assertEquals("testLast", registered.getLastName());
        assertEquals("test", registered.getUsername());
        assertEquals("test@email.com", registered.getEmail());
        assertEquals("password", registered.getPassword());
    }

    @Test
    @Transactional
    public void unsuccessfulRegistrationTest() throws Exception {

        LinkedHashMap<String, String> registerBody = new LinkedHashMap<>();

        registerBody.put("firstName", "testFirst");
        registerBody.put("lastName", "testLast");
        registerBody.put("username", "test");
        registerBody.put("email", "test@email.com");
        registerBody.put("password", "testPass");

        //Store a user in the database
        ur.save(new User(registerBody.get("firstName"), registerBody.get("lastName"), registerBody.get("username"), registerBody.get("email"), registerBody.get("password")));

        //Make a post request with a user with the same info thats already stored in the database
        mockMvc.perform(post("/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(registerBody))
                )
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    @Transactional
    public void getUserInfo() throws Exception {

        User u = ur.save(new User("first", "last", "test", "test@email.com", "password"));

        mockMvc.perform(get("/user?id="+u.getUserId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("first"))
                .andExpect(jsonPath("$.lastName").value("last"))
                .andExpect(jsonPath("$.username").value("test"))
                .andExpect(jsonPath("$.email").value("test@email.com"))
                .andExpect(jsonPath("$.password").value("password"))
                .andExpect(jsonPath("$.posts").value(new ArrayList<Post>()));

    }

}
