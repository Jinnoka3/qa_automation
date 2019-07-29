package data_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {

    private String company;
    private String address1;
    private String address2;

    private String city;
    private String state;
    private String zip;
    private String country;

    private String info;
    private String phone;
    private String mobile;
    private String alias;

    public int compareTo(UserAddress comparedWith){
        return this.toString().compareTo(comparedWith.toString());
    }

}
