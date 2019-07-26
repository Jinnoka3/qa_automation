package data_model;

import lombok.Data;

@Data

public class UserAddress {
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;

    private String wrongZip;


    private String country;
    private String info;
    private String phone;
    private String mobile;
    private String alias;
}
