package best;

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

    public boolean verificationName(AccountData accountData){
        return  (this.firstNameInAdressForm.getAttribute("value")).contentEquals(accountData.getFirstName());
    }

    public boolean verificationLastName(AccountData accountData){
        return  (this.lastNameInAdressForm.getAttribute("value")).contentEquals(accountData.getLastName());
    }

    public boolean verificationEmail(AccountData accountData){
        return  (this.emailSecondPage.getAttribute("value")).contentEquals(accountData.getEmail());
    }

    public boolean editNameInAdress(AccountData acc) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        AccountData account = objectMapper.readValue( new File( "C:\\Users\\User\\IdeaProjects\\qa_automation585\\src\\test\\data\\new_data.json" ), AccountData.class );

        this.firstNameInAdressForm.clear();
        this.firstNameInAdressForm.sendKeys(account.getFirstName());

        this.lastNameInAdressForm.clear();
        this.lastNameInAdressForm.sendKeys(account.getLastName());

        this.emailSecondPage.clear();
        this.emailSecondPage.sendKeys(account.getNewEmail());

        currentPassword.sendKeys(acc.getPassword());
        newPassword.sendKeys(account.getNewPassword());
        confirmation.sendKeys(account.getNewPassword());
        clickSave();
        return messageSuccessUpdate.isDisplayed();
    }


}
