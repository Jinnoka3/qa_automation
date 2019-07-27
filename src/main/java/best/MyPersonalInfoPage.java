package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import data_model.UserAddress;
import data_model.UserInfo;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

@Getter
public class MyPersonalInfoPage extends AccountCreationPage{

    public MyPersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='old_passwd']")
    private WebElement currentPassword;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement newPassword;

    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmation;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement messageSuccessUpdate;


  /*  public UserInfo getUserInformation(){

        return new UserInfo(

               //getAttribute(getMale().isSelected() ? getMale() : getFemale()),
                "2",
                        getFirstNameAttribute(),
                        getLastNameAttribute(),
                        getDayAttribute(),
                        getMonthAttribute(),
                        getYearAttribute(),
                        false,
                        true
        );
    }

    public boolean verificationUserInfo(AccountData accountData){
        if(accountData.getUserInfo().equals(getUserInformation()) && accountData.getEmail().contentEquals(getEmailAttribute())){
            return true;
        }
        else
            return false;
    }*/

    public void editUserInformation(AccountData accountData) {

       /* ObjectMapper objectMapper = new ObjectMapper();
        AccountData account = objectMapper.readValue( new File(ConfigFileReader.readJson()), AccountData.class );*/

       sendToForm(getFirstNameInAdressForm(), accountData.getUserInfo().getFirstName());


    }
}
