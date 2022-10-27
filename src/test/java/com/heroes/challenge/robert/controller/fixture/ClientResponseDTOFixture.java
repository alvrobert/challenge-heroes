package com.heroes.challenge.robert.controller.fixture;

import com.heroes.challenge.robert.dtos.ClientResponseDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class ClientResponseDTOFixture
{
    public static final BigInteger DOCUMENT = BigInteger.valueOf(123477);
    public static final String EMAIL = "Email";
    public static final String LAST_NAME = "Last Name";
    public static final String NAME = "Name";

    public static ClientResponseDTO withDefaults(){
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        clientResponseDTO.setDocument(DOCUMENT);
        clientResponseDTO.setEmail(EMAIL);
        clientResponseDTO.setLastName(LAST_NAME);
        clientResponseDTO.setName(NAME);
      return clientResponseDTO;
    }

}
