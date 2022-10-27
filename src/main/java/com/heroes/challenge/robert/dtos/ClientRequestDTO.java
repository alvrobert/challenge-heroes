package com.heroes.challenge.robert.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientRequestDTO {

    private BigInteger document;
    private String name;
    private String lastName;
    private String email;
}
