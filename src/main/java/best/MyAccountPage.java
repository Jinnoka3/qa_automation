package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CLASS_NAME, using = "header_user_info")
    private WebElement nameAccount;

    @FindBy(xpath = "//span[contains(text(),'My addresses')]")
    private WebElement addresses;

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    private WebElement personalInfo;

    public void clickMyAddresses(){
        addresses.click();
    }

    public void clickPersonalInfo(){
        personalInfo.click();
    }

    public void verificationInfo(){
        clickPersonalInfo();


    }

    public void verificationAddresses(){
        clickMyAddresses();

    }

    public void editInfo(){
        clickPersonalInfo();

    }

    public void editAddresses(){
        clickMyAddresses();

    }

}
