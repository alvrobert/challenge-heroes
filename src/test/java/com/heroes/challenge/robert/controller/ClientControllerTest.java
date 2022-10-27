package com.heroes.challenge.robert.controller;

import com.heroes.challenge.robert.controller.fixture.ClientResponseDTOFixture;
import com.heroes.challenge.robert.dtos.ClientResponseDTO;
import com.heroes.challenge.robert.service.ClientService;
import com.heroes.challenge.robert.util.ClientResponse;
import com.heroes.challenge.robert.util.exceptions.ClientException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {

    private static final String SUCCESS_STATUS = "Success";

    @Autowired
    private MockMvc mvc;

    @MockBean
    ClientService clientService;

    @Test
    private void getClientByDocument() throws Exception {
        when(clientService.getClientByDocument(any())).thenReturn(ClientResponseDTOFixture.withDefaults());
        mvc.perform(get("/client/client/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}