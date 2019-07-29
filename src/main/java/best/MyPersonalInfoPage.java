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

    private ArrayList<String> elementAttributes;

    public ArrayList<String> getAllAttribute(){
        for (WebElement webElement : getPageElements()) {
            elementAttributes = new ArrayList<>();
            elementAttributes.add(getAttribute(webElement));
        }
        System.out.println(elementAttributes);
        return elementAttributes;
    }

    public String getMaleAttribute(){
        return getAttribute(getMale());
    }

    public String getFemaleAttribute(){
        return getAttribute(getFemale());
    }

    public String getFirstNameAttribute(){
        return getAttribute(getFirstNameInAdressForm());
    }

    public String getLastNameAttribute(){
        return getAttribute(getLastNameInAdressForm());
    }

    public String getEmailAttribute(){
        return getAttribute(getEmail());
    }

    public String  getDayAttribute(){
        return getAttribute(getDay());
    }

    public String  getMonthAttribute(){
        return getAttribute(getMonth());
    }

    public String getYearAttribute(){
        return getAttribute(getYear());
    }

    public UserInfo getUserInfoFromPage(){

        return new UserInfo(
                verificationUserGender(),
                getFirstNameAttribute(),
                getLastNameAttribute(),
                getDayAttribute(),
                getMonthAttribute(),
                getYearAttribute(),
                getNewsletter().isSelected(),
                getSpecialOffers().isSelected()
        );
    }

    public boolean verificationAllFields(AccountData accountData){
        if(!accountData.getUserInfo().equals(getUserInfoFromPage())){
            LOGGER.error("Page element \"" + "Something isn't equals" + "\" isn't shown");
            return false;
        }
       return true;
    }

    public String verificationUserGender(){
        if(getMale().isSelected()){
            return getMaleAttribute();
        }
        else
            return getFemaleAttribute();
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
