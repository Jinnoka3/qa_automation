package best;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOut;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement myAccount;

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickSignIn(){
        signIn.click();
    }

    public void clickSignOut(){
        signOut.click();
    }

    public void clickMyAccount(){
        myAccount.click();
    }

    public void send(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click(WebElement webElement){
        webElement.click();
    }

    public void select(WebElement webElement, String value){
        Select dropdown = new Select(webElement);
        click(webElement);
        dropdown.selectByVisibleText(String.valueOf(value));
    }
}
