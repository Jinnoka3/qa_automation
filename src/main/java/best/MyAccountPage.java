package best;

import data_model.AccountData;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
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
        click(addresses);
    }

    public void clickPersonalInfo(){
        click(personalInfo);
    }
}
