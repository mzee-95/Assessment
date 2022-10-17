package org.example.Models.Exceptions;

public class InvalidAddressLineException extends Exception{
    @Override
    public String getMessage() {
        return "The current address is invalid, a valid address must consist of at least one address line that is not blank or null.";
    }
}
