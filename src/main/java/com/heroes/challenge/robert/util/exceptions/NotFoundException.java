package com.heroes.challenge.robert.util.exceptions;

import com.heroes.challenge.robert.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundException extends ClientException {

    public NotFoundException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String code, String message, ErrorDTO data) {
        super(message, code, HttpStatus.NOT_FOUND.value(), Arrays.asList(data));
    }
}
