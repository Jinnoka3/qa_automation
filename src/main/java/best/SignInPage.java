package best;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

    private WebDriver driver;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement emailFirstPage;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement createAnAccount;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement invalidEmail;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
    private WebElement titleCreateAnAccount;

    public void sendEmailFirstPage(String emailFirst) {
        emailFirstPage.sendKeys(emailFirst);
    }

    public void clickCreateAnAccount(){
        createAnAccount.click();
    }

    public String getInvalidEmail(){
        return invalidEmail.getText();
    }

    public void signIn(AccountData accountData){

        clickSignIn();
        sendEmailFirstPage(accountData.getEmail());
        clickCreateAnAccount();
        getTitle();
    }

    @Override
    public String getTitle(){
        return titleCreateAnAccount.getText();
    }
}
