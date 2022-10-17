package org.example.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.Models.DAO.AddressLineDetail;
import org.example.Models.DAO.AddressType;
import org.example.Models.DAO.Country;
import org.example.Models.DAO.Province;
import org.example.Models.Exceptions.InvalidZACodeException;
import org.example.Models.Exceptions.InvalidAddressLineException;
import org.example.Models.Exceptions.InvalidAlphaNumericException;
import org.example.Models.Exceptions.InvalidCountryAddress;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private AddressType type;
    @JsonProperty("addressLineDetail")
    private AddressLineDetail addressLineDetail;

    @JsonProperty("provinceOrState")
    private Province province;

    @JsonProperty("cityOrTown")
    private String city;

    @JsonProperty("country")
    private Country country;

    @JsonProperty("postalCode")
    private String postalCode;

    private Date lastUpdated;
    public String getCity() {
        return city;
    }
    public AddressLineDetail getAddressLineDetail() {
        return addressLineDetail;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public AddressType getType() {
        return type;
    }

    public Province getProvince() {
        return province;
    }

    public Country getCountry() {
        return country;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
        this.addressLineDetail = addressLineDetail;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isSouthAfricanValid() throws InvalidZACodeException {
        if(this.country.getCode().equals("ZA")){
            if(province == null || province.getName().equals("")){
                throw new InvalidZACodeException();
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(Address address) throws Exception{
        try{
            Integer a = Integer.parseInt(address.getPostalCode());
        }catch (NumberFormatException n){
            throw new InvalidAlphaNumericException();
        }
        if(address.getCountry()==null){
            throw new InvalidCountryAddress();
        }
        AddressLineDetail line = address.getAddressLineDetail();
        if(line == null || !line.isValid()){
            throw new InvalidAddressLineException();
        }
        return true;
    }
}
