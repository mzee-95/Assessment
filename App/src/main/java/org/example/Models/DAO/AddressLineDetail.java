package org.example.Models.DAO;

public class AddressLineDetail {
    private String line1;
    private String line2;

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    @Override
    public String toString() {
        return line1 + " " + line2 + " ";
    }

    public boolean isValid() {
        if((line1 == null || line1.equals("")) && (line2 == null || line2.equals("")) ) {
            return false;
        }
        else {
            return true;
        }
    }
}
