package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class MyPersonalInfoPage extends AccountCreationPage{

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

    public MyPersonalInfoPage(WebDriver driver) {
        super(driver);
    }

    public void clickSave(){
        save.click();
    }

    public boolean verificationGender(AccountData accountData){
        return  (this.getGender().getAttribute("value")).contentEquals(accountData.getGender());
    }

    public boolean verificationName(AccountData accountData){
        return  (this.getFirstNameInAdressForm().getAttribute("value")).contentEquals(accountData.getFirstName());
    }

    public boolean verificationLastName(AccountData accountData){
        return  (this.getLastNameInAdressForm().getAttribute("value")).contentEquals(accountData.getLastName());
    }

    /*public boolean verificationEmail(AccountData accountData){
        return  (this.getEmailSecondPage().getAttribute("value")).contentEquals(accountData.getEmail());
    }*/

    public boolean verificationDate(AccountData accountData){
        return  (this.getDate().getAttribute("value")).contentEquals(accountData.getDate());
    }

    public boolean verificationMonth(AccountData accountData){
        return  (this.getMonth().getAttribute("value")).contentEquals(accountData.getMonth());
    }

    public boolean verificationYear(AccountData accountData){
        return  (this.getYear().getAttribute("value")).contentEquals(accountData.getYear());
    }

    /*public boolean editInfo(AccountData acc) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        AccountData account = objectMapper.readValue( new File(ConfigFileReader.readJson()), AccountData.class );

        this.getFirstNameInAdressForm().clear();
        this.getFirstNameInAdressForm().sendKeys(account.getFirstName());

        this.getLastNameInAdressForm().clear();
        this.getLastNameInAdressForm().sendKeys(account.getLastName());

        this.getEmailSecondPage().clear();
        this.getEmailSecondPage().sendKeys(account.getNewEmail());

        currentPassword.sendKeys(acc.getPassword());
        newPassword.sendKeys(account.getNewPassword());
        confirmation.sendKeys(account.getNewPassword());
        clickSave();
        return messageSuccessUpdate.isDisplayed();
    }*/
}
