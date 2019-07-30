package best;

import best.utils.ConfigFileReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MyAddressesPage extends AccountCreationPage{

    public MyAddressesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a[title = \"Update\"]")
    List<WebElement> updateButtons;

    public void find(List<WebElement> webElementsList) {
        for (WebElement webElement : webElementsList) {
            System.out.println(webElement.getText());
        }
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[1]")
    private WebElement addressFirstName;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[2]/span[2]")
    private WebElement addressLastName;

    @FindBy(xpath = "//span[@class='address_company']")
    private WebElement addressCompany;

    @FindBy(xpath = "//span[@class='address_address1']")
    private WebElement addressFirst;

    @FindBy(xpath = "//span[@class='address_address2']")
    private WebElement addressSecond;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[1]")
    private WebElement addressesCity;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[2]")
    private WebElement addressesState;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[3]")
    private WebElement zip;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[6]/span")
    private WebElement country;

    @FindBy(xpath = "//span[@class='address_phone']")
    private WebElement addressPhone;

    @FindBy(xpath = "//span[@class='address_phone_mobile']")
    private WebElement addressMobile;

    @FindBy(xpath = "//span[contains(text(),'Update')]")
    private WebElement update;

    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private  WebElement addNewAddress;

    public void clickAddNewAddress(){
        click(addNewAddress);
    }











    /*public boolean verificationFirstName(AccountData accountData){
        return addressFirstName.getText().contentEquals(accountData.getFirstName());
    }

    public boolean verificationLastName(AccountData accountData){
        return addressLastName.getText().contentEquals(accountData.getLastName());
    }

    public boolean verificationCompany(AccountData accountData){
        return addressCompany.getText().contentEquals(accountData.getCompany());
    }

    public boolean verificationFirstAddress(AccountData accountData){
        return addressFirst.getText().contentEquals(accountData.getAddress1());
    }

    public boolean verificationSecondAddress(AccountData accountData){
        return addressSecond.getText().contentEquals(accountData.getAddress2());
    }

    public boolean verificationCity(AccountData accountData){
        return addressesCity.getText().contentEquals(accountData.getCity() + ",");
    }

    public boolean verificationZip(AccountData accountData){
        return zip.getText().contentEquals(accountData.getZip());
    }

    public boolean verificationCountry(AccountData accountData){
        return country.getText().contentEquals(accountData.getCountry());
    }

    public boolean verificationPhone(AccountData accountData){
        return addressPhone.getText().contentEquals(accountData.getPhone());
    }

    public boolean verificationMobile(AccountData accountData){
        return addressMobile.getText().contentEquals(accountData.getMobile());
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
        this.getAdressLine1().clear();
        this.getAdressLine1().sendKeys(account.getNewAddress1());

        clickSave();
    }*/
}
