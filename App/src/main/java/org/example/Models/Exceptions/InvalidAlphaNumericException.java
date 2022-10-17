package org.example.Models.Exceptions;

public class InvalidAlphaNumericException extends Exception{
    @Override
    public String getMessage() {
        return "The current address is invalid, a valid address must consist of a numeric postal code";
    }
}
