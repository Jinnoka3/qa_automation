package best;

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

    private String wrongEmail;

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
        this.firstName = "Daria";
        this.lastName = "Kalinina";
        this.email = "koko@gmail.com" + now;
        this.wrongEmail = "kokogmailcgfnhfdh";
        this.password = "12345";
        this.address1 = "Bulvar 30-letiya Pobedi";
        this.city = "Volgograd";
        this.state = "3";
        this.zip = "00000";
        this.wrongZip = "001000";
        this.country = "21";
        this.mobile = "98093243";
        this.alias = "Unknown Address";
    }


    /*public String getFirstName() {
        return "Daria";
    }

    public String getLastName() {
        return "Kalinina";
    }

    public String getEmail() {
        return "koko@gmail.com" + now;
    }

    public String getWrongEmail() {
        return "kokogmailcgfnhfdh";
    }

    public String getPassword() {
        return "12345";
    }


    public String getAddress1() {
        return "Bulvar 30-letiya Pobedi";
    }


    public String getCity() {
        return "Volgograd";
    }

    public String getState() {
        return "3";
    }

    public String getZip() {
        return "00000";
    }

    public String getWrongZip() {
        return "111111";
    }

    public String getCountry() {
        return "21";
    }

    public String getMobile() {
        return "98093243";
    }

    public String getAlias() {
        return "Unknown Address";
    }*/


    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return new Object[][]{
                {new AccountData()}
        };
    }
}
