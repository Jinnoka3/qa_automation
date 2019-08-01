package best;

import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAddresseUpdatePage extends AccountCreationPage {

    public MyAddresseUpdatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //span[contains(text(),'Save')]")
    private WebElement saveButton;

    public void clickSave() {
        click(saveButton);
    }

}
