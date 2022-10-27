package com.heroes.challenge.robert.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heroes.challenge.robert.controller.fixture.ClientResponseDTOFixture;
import com.heroes.challenge.robert.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    private static final String SUCCESS_STATUS = "Success";
    @MockBean
    ClientService clientService;
    @Autowired
    private MockMvc mvc;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetClientByDocumentTest() throws Exception {
        when(clientService.getClientByDocument(any())).thenReturn(ClientResponseDTOFixture.withDefaults());
        mvc.perform(get("/client/client/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data.document").value("123477"));
    }
}