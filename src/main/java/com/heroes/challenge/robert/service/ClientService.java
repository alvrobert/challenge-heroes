package com.heroes.challenge.robert.service;

import com.heroes.challenge.robert.dtos.ClientRequestDTO;
import com.heroes.challenge.robert.dtos.ClientResponseDTO;
import com.heroes.challenge.robert.util.exceptions.ClientException;

import java.math.BigInteger;

public interface ClientService {

    ClientResponseDTO getClientByDocument(BigInteger document) throws ClientException;
    Iterable getClients() throws ClientException;
    ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) throws ClientException;
    void deleteClient(BigInteger document) throws ClientException;
}
