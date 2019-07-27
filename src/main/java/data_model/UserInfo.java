package data_model;

import lombok.Data;

@Data
public class UserInfo {

    private String gender;
    private String firstName;
    private String lastName;

    private String day;
    private String month;
    private String year;

    private boolean newsletter;
    private boolean specialOffers;
}
