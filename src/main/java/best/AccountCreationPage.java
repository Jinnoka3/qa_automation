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

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement male;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement female;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement customerFirstName;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement customerLastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement day;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement month;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement year;

    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletter;

    @FindBy(xpath = "//input[@id='optin']")
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

    public void selectGender(String gender){
        click(gender.equals("1") ? male : female);
    }

    public void accountCreate(AccountData accountData) {
        selectGender(accountData.getUserInfo().getGender());
        sendToForm(customerFirstName, accountData.getUserInfo().getFirstName());
        sendToForm(customerLastName, accountData.getUserInfo().getLastName());

        sendToForm(email, accountData.getEmail());
        sendToForm(password, accountData.getPassword());

        selectByValue(day, accountData.getUserInfo().getDay());
        selectByValue(month, accountData.getUserInfo().getMonth());
        selectByValue(year, accountData.getUserInfo().getYear());

        selectOption(newsletter, accountData.getUserInfo().isNewsletter());
        selectOption(specialOffers, accountData.getUserInfo().isSpecialOffers());

        sendToForm(company, accountData.getUserAddress().getCompany());
        sendToForm(adressLine1, accountData.getUserAddress().getAddress1());
        sendToForm(adressLine2, accountData.getUserAddress().getAddress2());

        sendToForm(city, accountData.getUserAddress().getCity());
        selectByText(state, accountData.getUserAddress().getState());
        sendToForm(zip, accountData.getUserAddress().getZip());
        selectByText(country, accountData.getUserAddress().getCountry());

        sendToForm(additionalInformation, accountData.getUserAddress().getInfo());
        sendToForm(homePhone, accountData.getUserAddress().getPhone());
        sendToForm(mobilePhone, accountData.getUserAddress().getMobile());
        sendToForm(anAdressAlias, accountData.getUserAddress().getAlias());
    }

    public void register(){
        click(register);
    }
}