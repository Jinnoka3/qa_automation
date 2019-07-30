package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import data_model.UserAddress;
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

    @FindBy(css = "div.col-sm-6")
    private List<WebElement> addresses;

    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private WebElement addNewAddress;

    @FindBy(css = "div.alert li")
    List<WebElement> userErrors;

    public void clickAddNewAddress() {
        click(addNewAddress);
    }

    public void print(AccountData accountData) {
        System.out.println(accountData.toString());
    }

    public String addressesFromToString() {
        String text = "";
        for (WebElement webElement : addresses) {
            text += webElement.getText() + "\n";
        }
        return text;
    }

    public String addressesFromUser(AccountData accountData) {
        String text = "";
        for(UserAddress address : accountData.getAddressMap()){
            text+=address+"\n";
        }
        return text;
    }

    public boolean verificationAddresses(AccountData accountData){
        /*System.out.println(addressesFromUser(accountData).compareTo(addressesFromToString()));
        System.out.println(addressesFromUser(accountData));
        System.out.println("-------------");*/
        System.out.println(addressesFromToString());
        return addressesFromUser(accountData).compareTo(addressesFromToString()) == 0;
    }
}
