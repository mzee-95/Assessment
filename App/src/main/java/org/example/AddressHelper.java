package org.example;

import org.example.Models.Address;
import org.example.Models.AddressTypeEnum;

import java.util.List;

public class AddressHelper {
    //Question 2a
    //The understanding is that the print-out must looks as:
    //Type: LineDetails - City - Province - PostalCode – Country
    //I have not included the code as part of the return
    public static String prettyPrintAddress(Address a) {
        StringBuilder sb = new StringBuilder();
        if(a.getType()!=null) sb.append(a.getType().toString() + ": ");
        if(a.getAddressLineDetail()!=null) sb.append(a.getAddressLineDetail().toString() + ": ");
        if(a.getCity()!=null) sb.append(a.getCity() + ": ");
        if(a.getProvince()!=null) sb.append(a.getProvince().toString() + ": ");
        if(a.getPostalCode()!=null) sb.append(a.getPostalCode() + ": ");
        if(a.getCountry()!=null) sb.append(a.getCountry().toString() + ": ");

        return  sb.toString() ;
    }
    //Question 2b
    public static void printAddress(List<Address> addresses){
        for (Address address: addresses) {
            System.out.println(prettyPrintAddress(address));
        }
    }
    //Question 2c
    public static String printAddressByType(AddressTypeEnum type, Address address){
            if(address.getType().getCode().equals(type.getType())) {
                return prettyPrintAddress(address);
        }
            return "";
    }
    //Question 2d & 2e
    //this will validate and throw an exception specific
    //to the invalidity found on the address
    //via an extension of the Exception class
    public static boolean isValidAddress(Address address){
        try {
            return address.isSouthAfricanValid() && address.isAlphaNumeric(address);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
