package com.nisum.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.demo.dto.PhoneRequest;
import com.nisum.demo.dto.UserRequest;
import com.nisum.demo.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@WithMockUser(username = "gustavo@gmail.com", password = "gustavo", roles = "")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void create() throws Exception {
        UserRequest request = new UserRequest(
                "Gustavo Martinez",
                "gustavo@hotmail.com.ar",
                "Gustavo!234123123",
                List.of(new PhoneRequest("21123213213", "122", "+54"))
        );
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(request);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Gustavo Martinez"))
                .andExpect(jsonPath("$.email").value("gustavo@hotmail.com.ar"));
    }

    @Test
    void update() {
    }

    @Test
    void getUsers() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void delete() {
    }
}