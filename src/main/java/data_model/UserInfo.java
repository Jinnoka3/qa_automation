package data_model;

import best.MyPersonalInfoPage;
import lombok.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Comparable <UserInfo>{

    static final Logger LOGGER = Logger.getLogger(MyPersonalInfoPage.class);

    private String gender;
    private String firstName;
    private String lastName;

    private String day;
    private String month;
    private String year;

    private boolean newsletter;
    private boolean specialOffers;

    @Override
    public String toString(){
        return firstName + " " + lastName + "\n";
    }

    @Override
    public int compareTo(UserInfo o) {

        int i = gender.compareTo(o.gender);
        if (i != 0) {
            LOGGER.error("Genders aren't equal");
            return i;
        }

        i = firstName.compareTo(o.firstName);
        if (i != 0) {
            LOGGER.error("First names aren't equal");
            return i;
        }

        i = lastName.compareTo(o.lastName);
        if (i != 0) {
            LOGGER.error("Last names aren't equal");
            return i;
        }

        i = day.compareTo(o.day);
        if (i != 0) {
            LOGGER.error("Days aren't equal");
            return i;
        }

        i = month.compareTo(o.month);
        if (i != 0) {
            LOGGER.error("Months aren't equal");
            return i;
        }

        i = year.compareTo(o.year);
        if (i != 0) {
            LOGGER.error("Years aren't equal");
            return i;
        }

        return 0;
    }
}
