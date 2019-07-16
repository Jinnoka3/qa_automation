package best;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement signOut;

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickSignIn(){
        signIn.click();
    }

    public void clickSignOut(){
        signOut.click();
    }
}
