package com.heroes.challenge.robert.util.exceptions;

import com.heroes.challenge.robert.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class InternalServerErrorException extends ClientException {

    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code, String message, ErrorDTO data) {
        super(message, code, HttpStatus.INTERNAL_SERVER_ERROR.value(), Arrays.asList(data));
    }
}
