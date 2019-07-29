package data_model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class AccountData {

    Date dat = new Date();
    long now = dat.getTime();

    private String email;
    private String password;

    private UserInfo userInfo;
    private ArrayList<UserAddress> addressMap = new ArrayList<>();

    public AccountData() {
        this.email = "koko" + now + "@gmail.com";
    }
}
