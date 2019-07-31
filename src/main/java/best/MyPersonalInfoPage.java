package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import data_model.UserAddress;
import data_model.UserInfo;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Getter
public class MyPersonalInfoPage extends AccountCreationPage{

    static final Logger LOGGER = Logger.getLogger(MyPersonalInfoPage.class);
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

    public String getMessageSuccessUpdate(){
        return messageSuccessUpdate.getText();
    }

    public UserInfo getUserInfoFromPage(){

        return new UserInfo(
                verificationUserGender(),
                getAttribute(getFirstNameInAdressForm()),
                getAttribute(getLastNameInAdressForm()),
                getAttribute(getDay()),
                getAttribute(getMonth()),
                getAttribute(getYear()),
                getNewsletter().isSelected(),
                getSpecialOffers().isSelected()
        );
    }

    public AccountData getUserEmailFromPage(){

        return AccountData.builder(getAttribute(getEmail())).password("").userInfo(getUserInfoFromPage()).addressMap(new ArrayList<UserAddress>()).build();
    }

    public boolean verificationAllFields(AccountData accountData){
        return accountData.getUserInfo().compareTo(getUserInfoFromPage()) == 0;
    }

    public boolean verificationEmail(AccountData accountData){
        return accountData.compareTo(getUserEmailFromPage()) == 0;
    }

    public boolean verificationNewsletter(AccountData accountData){
        if(!accountData.getUserInfo().isNewsletter() == getUserInfoFromPage().isNewsletter())
        {
            LOGGER.error("Newsletters aren't equal");
            return false;
        }
        return true;
    }

    public boolean verificationSpecialOffers(AccountData accountData){
        if(!accountData.getUserInfo().isSpecialOffers() == getUserInfoFromPage().isSpecialOffers()){
            LOGGER.error("Special Offers aren't equal");
            return false;
        }
        return true;
    }

    public String verificationUserGender(){
        if(getMale().isSelected()){
            return getAttribute(getMale());
        }
        else
            return getAttribute(getFemale());
    }

    public void editUserInformation(AccountData oldData, AccountData accountData) {

       selectGender(accountData.getUserInfo().getGender());
       sendToForm(getFirstNameInAdressForm(), accountData.getUserInfo().getFirstName());
       sendToForm(getLastNameInAdressForm(), accountData.getUserInfo().getLastName());
       sendToForm(getEmail(), accountData.getEmail());

        selectByValue(getDay(), accountData.getUserInfo().getDay());
        selectByValue(getMonth(), accountData.getUserInfo().getMonth());
        selectByValue(getYear(), accountData.getUserInfo().getYear());

        sendToForm(currentPassword, oldData.getPassword());

        sendToForm(newPassword, accountData.getPassword());
        sendToForm(confirmation, accountData.getPassword());

        selectOption(getNewsletter(), accountData.getUserInfo().isNewsletter());
        selectOption(getSpecialOffers(), accountData.getUserInfo().isSpecialOffers());
    }

    public void saveUpdate(){
        click(save);
    }
}
