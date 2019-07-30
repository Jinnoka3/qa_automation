package data_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {

    private String addressFirstName;
    private String addressLastName;

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

    @Override
    public String toString(){
        return alias.toUpperCase() + "\n"
                + addressFirstName + " " + addressLastName + "\n"
                + company + "\n"
                + address1 + " " + address2 + "\n"
                + city + ", " + state + " " + zip + "\n"
                + country + "\n"
                + phone + "\n"
                + mobile + "\n"
                + "Update" + "\n"
                + "Delete";
    }

    public int compareTo(UserAddress comparedWith){
        return this.toString().compareTo(comparedWith.toString());
    }

}
