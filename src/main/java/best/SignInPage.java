package best;

import data_model.AccountData;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailForCreateAnAccount;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement buttonCreateAnAccount;

    ////////////////////////////
    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement invalidEmail;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement titleCreateAnAccount;
    /////////////////////////////

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailAlreadyRegistered;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordAlreadyRegistered;

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    private WebElement buttonSignIn;

    public void sendEmailForCreateAnAccount(String email) {
        sendToForm(emailForCreateAnAccount, email);
    }

    public void clickCreateAnAccount(){
        click(buttonCreateAnAccount);
    }

    public void alreadyRegistered(String email, String password){
        sendToForm(emailAlreadyRegistered, email);
        sendToForm(passwordAlreadyRegistered, password);
    }

    public void clickSignInAlreadyRegistered(){
        click(buttonSignIn);
    }


















    /*public void sendPassword(String password) {
        passwordAlreadyRegistered.sendKeys(password);
    }

    public void clickSignIn(){
        buttonSignIn.click();
    }

    public boolean getInvalidEmail(){
        return invalidEmail.isDisplayed();
    }

    public void signIn(AccountData accountData){

        super.clickSignIn();
        sendEmailFirstPage(accountData.getEmail());
        clickCreateAnAccount();
        getTitle();
    }

    public void alreadyRegistered(String email, String password){

        super.clickSignIn();
        sendEmail(email);
        sendPassword(password);
        clickSignIn();
        getTitle();
    }

    @Override
    public String getTitle(){
        return titleCreateAnAccount.getText();
    }*/
}
