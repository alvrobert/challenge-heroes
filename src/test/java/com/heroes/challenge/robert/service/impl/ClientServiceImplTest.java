package com.heroes.challenge.robert.service.impl;

import com.heroes.challenge.robert.entity.Client;
import com.heroes.challenge.robert.repositoy.ClientRepository;
import com.heroes.challenge.robert.service.ClientService;
import com.heroes.challenge.robert.util.exceptions.ClientException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClientServiceImplTest {

    ClientRepository clientRepository;
    ClientService clientService;

    @BeforeEach
    void setUp() {
        clientRepository = mock(ClientRepository.class);
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    void getClientByDocumentTest() throws ClientException {
        Client client = Client.builder()
                .document(BigInteger.valueOf(123))
                .lastName("Last Name")
                .name("name")
                .email("email").build();
        when(clientRepository.findByDocument(any())).thenReturn(Optional.ofNullable(client));
        String name = clientService.getClientByDocument(any()).getName();
        assertEquals("name", name);
    }
}