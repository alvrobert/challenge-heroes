package com.heroes.challenge.robert.controller;

import com.heroes.challenge.robert.dtos.ClientRequestDTO;
import com.heroes.challenge.robert.dtos.ClientResponseDTO;
import com.heroes.challenge.robert.service.ClientService;
import com.heroes.challenge.robert.util.ClientResponse;
import com.heroes.challenge.robert.util.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigInteger;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/clients")
    public ClientResponse<?> getAllClients() throws ClientException {
        return new ClientResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", clientService.getClients());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/client/{document}")
    public ClientResponse<ClientResponseDTO> getClientByDocument(@PathVariable BigInteger document) throws ClientException {
        return new ClientResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", clientService.getClientByDocument(document));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/create-client")
    public ClientResponse<?> createClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) throws ClientException {
        return new ClientResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", clientService.createClient(clientRequestDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update-client")
    public ClientResponse<?> updateClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) throws ClientException {
        return new ClientResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", clientService.createClient(clientRequestDTO));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete-client/{document}")
    public ClientResponse<?> deleteClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO, @PathVariable BigInteger document) throws ClientException {
        clientService.deleteClient(document);
        return new ClientResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK");
    }
}
