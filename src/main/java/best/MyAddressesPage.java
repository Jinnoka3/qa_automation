package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MyAddressesPage extends AccountCreationPage {

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private  WebElement addNewAddress;

    @FindBy(css = "div.alert li")
    List<WebElement> userErrors;

    public void clickAddNewAddress(){
        click(addNewAddress);
    }
}
