package com.heroes.challenge.robert.service.impl;

import com.heroes.challenge.robert.dtos.ClientRequestDTO;
import com.heroes.challenge.robert.dtos.ClientResponseDTO;
import com.heroes.challenge.robert.entity.Client;
import com.heroes.challenge.robert.repositoy.ClientRepository;
import com.heroes.challenge.robert.service.ClientService;
import com.heroes.challenge.robert.util.exceptions.ClientException;
import com.heroes.challenge.robert.util.exceptions.InternalServerErrorException;
import com.heroes.challenge.robert.util.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static com.heroes.challenge.robert.util.MessageEnum.CLIENT_NOT_FOUND;
import static com.heroes.challenge.robert.util.MessageEnum.ERROR_SAVE_CLIENT;

@Service
public class ClientServiceImpl implements ClientService {

    public static final ModelMapper modelMapper = new ModelMapper();
    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(final ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponseDTO getClientByDocument(final BigInteger document) throws ClientException {
        return modelMapper.map(clientRepository.findByDocument(document)
                .orElseThrow(() -> new NotFoundException(CLIENT_NOT_FOUND.getCode(), CLIENT_NOT_FOUND.getMessage())), ClientResponseDTO.class);
    }

    @Override
    public Iterable<ClientResponseDTO> getClients() throws ClientException {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) throws ClientException {

        Client client = Client.builder()
                .document(clientRequestDTO.getDocument())
                .email(clientRequestDTO.getEmail())
                .name(clientRequestDTO.getName())
                .lastName(clientRequestDTO.getLastName())
                .build();
        try {
            return modelMapper.map(clientRepository.save(client), ClientResponseDTO.class);
        } catch(Exception e) {
            throw new InternalServerErrorException(ERROR_SAVE_CLIENT.getCode(), ERROR_SAVE_CLIENT.getMessage());
        }
    }

    @Override
    public void deleteClient(final BigInteger document) throws ClientException {

        Client client = clientRepository.findByDocument(document)
                .orElseThrow(() -> new NotFoundException(CLIENT_NOT_FOUND.getCode(), CLIENT_NOT_FOUND.getMessage()));

        if (client.getDocument() != null) {
            clientRepository.delete(client);
        }
    }

}
