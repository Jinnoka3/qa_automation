package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class MyAddressesPage extends AccountCreationPage{

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[1]")
    private WebElement addressFirstName;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[2]")
    private WebElement addressLastName;

    @FindBy(xpath = "//span[@class='address_company']")
    private WebElement addressCompany;

    @FindBy(xpath = "//span[@class='address_address1']")
    private WebElement addressFirst;

    @FindBy(xpath = "//span[@class='address_phone_mobile']")
    private WebElement addressMobile;

    @FindBy(xpath = "//span[contains(text(),'Update')]")
    private WebElement update;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }

    public boolean verificationFirstName(AccountData accountData){
        return addressFirstName.getText().contentEquals(accountData.getFirstName());
    }

    public boolean verificationLastName(AccountData accountData){
        return addressLastName.getText().contentEquals(accountData.getLastName());
    }

    public boolean verificationMobile(AccountData accountData){
        return addressMobile.getText().contentEquals(accountData.getMobile());
    }

    public boolean verificationFirstAddress(AccountData accountData){
        return addressFirst.getText().contentEquals(accountData.getAddress1());
    }

    public void clickUpdate(){
        update.click();
    }
    public void clickSave(){
        save.click();
    }

    public void editAddresses(AccountData acc) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        AccountData account = objectMapper.readValue( new File( ConfigFileReader.readJson() ), AccountData.class );

        clickUpdate();
        this.adressLine1.clear();
        this.adressLine1.sendKeys(account.getNewAddress1());

        clickSave();
    }
}
