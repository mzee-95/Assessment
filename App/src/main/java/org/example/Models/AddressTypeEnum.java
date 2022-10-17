package org.example.Models;

public enum AddressTypeEnum {
    PHYSICAL("1"), POSTAL("2"), BUSSINESS("3");
    private String type;

    private AddressTypeEnum(String _type){
        this.setCode(_type);
    }
    public String getType() {
        return type;
    }
    public void setCode(String type) {
        this.type = type;
    }
}
