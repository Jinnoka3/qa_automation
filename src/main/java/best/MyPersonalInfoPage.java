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


    public boolean verificationUserGender(AccountData accountData){
        if(getMale().isSelected()){
            if(getMaleAttribute().contentEquals(accountData.getUserInfo().getGender())){
                LOGGER.info("Gender verification is successful");
                return true;
            }
            else{
                LOGGER.error("Gender verification isn't successful");
                return false;
            }
        }
        else if(getFemale().isSelected()){
            if(getFemaleAttribute().contentEquals(accountData.getUserInfo().getGender())){
                LOGGER.info("Gender verification is successful");
                return true;
            }
            else{
                LOGGER.error("Gender verification isn't successful");
                return false;
            }
        }
        else {
            LOGGER.error("Gender verification isn't successful");
            return false;
        }
    }

    public boolean verificationNewsletterOption(AccountData accountData){
        if(getNewsletter().isSelected() == accountData.getUserInfo().isNewsletter()){
                LOGGER.info("Newsletter option verification is successful");
                return true;
            }
            else{
                LOGGER.error("Newsletter option verification isn't successful");
                return false;
            }
    }

    public boolean verificationSpecialOffersOption(AccountData accountData){
        if(getSpecialOffers().isSelected() == accountData.getUserInfo().isSpecialOffers()){
            LOGGER.info("Special Offers Option verification is successful");
            return true;
        }
        else{
            LOGGER.error("Special Offers Option verification isn't successful");
            return false;
        }
    }

    public boolean verificationUserFirstName(AccountData accountData){
        if(getFirstNameAttribute().contentEquals(accountData.getUserInfo().getFirstName())){
            LOGGER.info("First name verification is successful");
            return true;
        }
        else {
            LOGGER.error("First name verification isn't successful");
            return false;
        }
    }

    public boolean verificationUserLastName(AccountData accountData){
        if(getLastNameAttribute().contentEquals(accountData.getUserInfo().getLastName())){
            LOGGER.info("Last name verification is successful");
            return true;
        }
        else {
            LOGGER.error("Last name verification isn't successful");
            return false;
        }
    }

    public boolean verificationUserEmail(AccountData accountData){
        if(getEmailAttribute().contentEquals(accountData.getEmail())){
            LOGGER.info("Email verification is successful");
            return true;
        }
        else {
            LOGGER.error("Email verification isn't successful");
            return false;
        }
    }

    public boolean verificationUserDayOfBirth(AccountData accountData){
        if(getDayAttribute().contentEquals(accountData.getUserInfo().getDay())){
            LOGGER.info("Day verification is successful");
            return true;
        }
        else {
            LOGGER.error("Day verification isn't successful");
            return false;
        }
    }

    public boolean verificationUserMonthOfBirth(AccountData accountData){
        if(getMonthAttribute().contentEquals(accountData.getUserInfo().getMonth())){
            LOGGER.info("Month verification is successful");
            return true;
        }
        else {
            LOGGER.error("Month verification isn't successful");
            return false;
        }
    }

    public boolean verificationUserYearOfBirth(AccountData accountData){
        if(getYearAttribute().contentEquals(accountData.getUserInfo().getYear())){
            LOGGER.info("Year verification is successful");
            return true;
        }
        else {
            LOGGER.error("Year verification isn't successful");
            return false;
        }
    }

    public boolean verificationAllUserInfo(AccountData accountData){
        if(verificationUserFirstName(accountData) && verificationUserLastName(accountData)
        && verificationUserEmail(accountData) && verificationUserDayOfBirth(accountData)
        && verificationUserMonthOfBirth(accountData) && verificationUserYearOfBirth(accountData)
        && verificationUserGender(accountData) && verificationNewsletterOption(accountData)
        && verificationSpecialOffersOption(accountData)){
            return true;
        }
        else {
            return false;
        }
    }

    public void editUserInformation(AccountData oldData, AccountData accountData) {

       /* ObjectMapper objectMapper = new ObjectMapper();
        AccountData account = objectMapper.readValue( new File(ConfigFileReader.readJson()), AccountData.class );*/
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
}
