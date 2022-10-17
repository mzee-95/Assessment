package org.example.Models.Exceptions;

public class InvalidZACodeException extends Exception{
    @Override
    public String getMessage() {
        return "The current address is invalid, an address with code ZA must contain a province";
    }
}
