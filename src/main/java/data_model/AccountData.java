package data_model;

import best.MyPersonalInfoPage;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder(builderMethodName = "hiddenBuilder")
public class AccountData implements Comparable <AccountData>{

    static final Logger LOGGER = Logger.getLogger(MyPersonalInfoPage.class);

    Date dat = new Date();
    long now = dat.getTime();

    private String email;
    private String password;

    private UserInfo userInfo;
    private ArrayList<UserAddress> addressMap = new ArrayList<>();

    public AccountData() {
        this.email = "koko" + now + "@gmail.com";
    }

    public static AccountDataBuilder builder(String email) {
        return hiddenBuilder().email(email);
    }

    @Override
    public String toString(){
        return addressMap.toString();
    }
    @Override
    public int compareTo(AccountData comparedWith){
        int i = this.email.compareTo(comparedWith.email);
        if (i != 0) {
            LOGGER.error("Emails aren't equal");
            return i;
        }
        return 0;
    }
}
