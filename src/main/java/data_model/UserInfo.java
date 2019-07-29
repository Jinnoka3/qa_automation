package data_model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
