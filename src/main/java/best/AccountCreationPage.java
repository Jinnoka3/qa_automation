package best;

import data_model.AccountData;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public class AccountCreationPage extends BasePage {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"id_gender2\"]")
    private WebElement gender;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement customerFirstName;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"days\"]")
    private WebElement date;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private WebElement month;

    @FindBy(xpath = "//*[@id=\"years\"]")
    private WebElement year;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    private WebElement newsletter;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    private WebElement specialOffers;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInAdressForm;

    @FindBy(xpath = " //input[@id='lastname']")
    private WebElement lastNameInAdressForm;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement company;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement adressLine1;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement adressLine2;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement zip;

    @FindBy(xpath = "//*[@id=\"id_country\"]")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"other\"]")
    private WebElement additionalInformation;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhone;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilePhone;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement anAdressAlias;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
    private WebElement register;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]")
    private WebElement invalidData;

    public String getInvalidData() {
        return invalidData.getText();
    }

    public void accountCreate(AccountData accountData) {
        send(customerFirstName, accountData.getFirstName());
        send(customerLastName, accountData.getLastName());
        send(email, accountData.getEmail());
        send(password, accountData.getPassword());
        send(adressLine1, accountData.getAddress1());
        send(city, accountData.getCity());
        select(state, accountData.getState());
        send(zip, accountData.getZip());
        select(country, accountData.getCountry());
        send(mobilePhone, accountData.getMobile());
        send(anAdressAlias, accountData.getAlias());
    }

    public void register(){
        click(register);
    }
}