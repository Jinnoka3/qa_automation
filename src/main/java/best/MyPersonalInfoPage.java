package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInfoPage extends AccountCreationPage{

    @FindBy(xpath = "//input[@id='old_passwd']")
    private WebElement currentPassword;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement newPassword;

    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmation;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

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

    public void editNameInAdress(AccountData acc) {
        this.lastNameInAdressForm.clear();
        this.lastNameInAdressForm.sendKeys(acc.getFirstName());
    }


}
