package data_model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.testng.annotations.DataProvider;

import java.util.Date;

@Data

public class AccountData {

    Date dat = new Date();
    long now = dat.getTime();


    private String gender;
    private String firstName;
    private String lastName;
    private String email;


    //private String wrongEmail;

    private String password;

    private String date;
    private String month;
    private String year;

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


    public AccountData() {
        this.email = now + "koko@gmail.com";

    }
}
