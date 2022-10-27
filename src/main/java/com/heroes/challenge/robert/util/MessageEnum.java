package com.heroes.challenge.robert.util;

public enum MessageEnum {

    CLIENT_NOT_FOUND("CLI-01", "Document number not exist."),
    ERROR_SAVE_CLIENT("CLI-02", "The client could not be saved");

    private final String code;
    private final String message;

    private MessageEnum(String code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }
}
