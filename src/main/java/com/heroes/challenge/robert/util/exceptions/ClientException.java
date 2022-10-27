package com.heroes.challenge.robert.util.exceptions;

import com.heroes.challenge.robert.dtos.ErrorDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClientException extends Exception {

    private final String code;
    private final int responseCode;
    private final List<ErrorDTO> errorList = new ArrayList<>();

    public ClientException(String code, int responseCode, String message) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public ClientException(
            String message, String code, int responseCode, List<ErrorDTO> errorList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }
}
