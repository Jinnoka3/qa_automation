package best;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    private WebDriver driver;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailFirstPage;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement createAnAccount;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement invalidEmail;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement titleCreateAnAccount;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailRegistered;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordRegistered;

    @FindBy(xpath = "//p[@class='submit']//span[1]")
    private WebElement signIn;

    public void sendEmailFirstPage(String emailFirst) {
        emailFirstPage.sendKeys(emailFirst);
    }

    public void sendEmail(String email) {
        emailRegistered.sendKeys(email);
    }

    public void sendPassword(String password) {
        passwordRegistered.sendKeys(password);
    }

    public void clickSignIn(){
        signIn.click();
    }

    public void clickCreateAnAccount(){
        createAnAccount.click();
    }

    public String getInvalidEmail(){
        return invalidEmail.getText();
    }

    public void signIn(AccountData accountData){

        /*Date dat = new Date();
        long now = dat.getTime();*/

        super.clickSignIn();
        sendEmailFirstPage(accountData.getEmail());
        clickCreateAnAccount();
        getTitle();
    }

    public void alreadyRegistered(AccountData accountData){

        super.clickSignIn();
        sendEmail(accountData.getEmail());
        sendPassword(accountData.getPassword());
        clickSignIn();
        getTitle();
    }

    @Override
    public String getTitle(){
        return titleCreateAnAccount.getText();
    }
}
