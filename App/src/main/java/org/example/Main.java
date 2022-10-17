package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Models.Address;
import org.example.Models.AddressTypeEnum;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int result =1;
        int [] numbers = new int[]{
                6,8,10,14
        };
        try{
            result = HighestCommonFactor.getCommonFactor(numbers);
        }catch (Exception e){
            System.out.println(String.format("Error getting common factor %s", e.getMessage()));
        }
        System.out.println(String.format("The greatest common factor is %d", result));

        //Q2
        //Replace <path to file> with a json file
        //It is unclear if you will be using more files to calculate
        String path_to_file = "";
        ObjectMapper mapper = new ObjectMapper();
        List<Address> addresses = mapper.readValue(new File(path_to_file), new TypeReference<List<Address>>() { });

        //2b
        AddressHelper.printAddress(addresses);

        //2c
        addresses.forEach(a->System.out.println(AddressHelper.printAddressByType(AddressTypeEnum.PHYSICAL, a)));
        //2d&2e
        addresses.forEach(a->System.out.println("is valid address:" + AddressHelper.isValidAddress(a)));


    }
}