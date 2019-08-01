package best;

import data_model.AccountData;
import lombok.Getter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AccountCreationPage extends BasePage {

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    static final Logger LOGGER = Logger.getLogger(AccountCreationPage.class);

    final static String MESSAGE_ERROR_FIRSTNAME = "firstname is too long. Maximum length: 32";
    final static String MESSAGE_ERROR_LASTNAME = "lastname is too long. Maximum length: 32";
    final static String MESSAGE_ERROR_EMAIL = "email is invalid.";
    final static String MESSAGE_ERROR_PASSWORD = "passwd is invalid.";
    final static String MESSAGE_ERROR_PASSWORD2 = "passwd is required.";

    final static String MESSAGE_ERROR_ADDRESS1 = "address1 is too long. Maximum length: 128";
    final static String MESSAGE_ERROR_ZIP = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
    final static String MESSAGE_ERROR_STATE = "This country requires you to choose a State.";
    final static String MESSAGE_ERROR_COUNTRY = "Country is invalid";
    final static String MESSAGE_ERROR_CITY = "city is too long. Maximum length: 64";
    final static String MESSAGE_ERROR_MOBILE = "phone_mobile is invalid.";

    private ArrayList<String> baseErrors = new ArrayList<>();

    private ArrayList<WebElement> pageElements = new ArrayList<>();

    @FindBy(css = "div.alert li")
    List<WebElement> userErrors;

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement male;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement female;

    @FindBy(xpath = "//input[@id='customer_firstname']")
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

    @FindBy(xpath = "//input[@id='company']")
    private WebElement company;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement adressLine1;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement adressLine2;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement zip;

    @FindBy(xpath = "//select[@id='id_country']")
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

    public void fillPageElementsList(){
        pageElements.add(male);
        pageElements.add(female);
        pageElements.add(customerFirstName);
        pageElements.add(customerLastName);
        pageElements.add(email);
        pageElements.add(password);
        pageElements.add(day);
        pageElements.add(month);
        pageElements.add(year);
        pageElements.add(newsletter);
        pageElements.add(specialOffers);
        pageElements.add(firstNameInAdressForm);
        pageElements.add(lastNameInAdressForm);
        pageElements.add(company);
        pageElements.add(adressLine1);
        pageElements.add(adressLine2);
        pageElements.add(city);
        pageElements.add(state);
        pageElements.add(zip);
        pageElements.add(country);
        pageElements.add(additionalInformation);
        pageElements.add(homePhone);
        pageElements.add(mobilePhone);
        pageElements.add(anAdressAlias);
        pageElements.add(register);
    }

    public void fillErrorArrayList(){
        baseErrors.add(MESSAGE_ERROR_FIRSTNAME);
        baseErrors.add(MESSAGE_ERROR_LASTNAME);

        baseErrors.add(MESSAGE_ERROR_EMAIL);
        baseErrors.add(MESSAGE_ERROR_PASSWORD);
        baseErrors.add(MESSAGE_ERROR_PASSWORD2);

        baseErrors.add(MESSAGE_ERROR_ADDRESS1);
        baseErrors.add(MESSAGE_ERROR_CITY);
        baseErrors.add(MESSAGE_ERROR_STATE);
        baseErrors.add(MESSAGE_ERROR_ZIP);
        baseErrors.add(MESSAGE_ERROR_COUNTRY);
        baseErrors.add(MESSAGE_ERROR_MOBILE);
    }

    public boolean findError() {

        fillErrorArrayList();

        for (WebElement webElement : userErrors) {
            if (!baseErrors.contains(webElement.getText())) {
                LOGGER.error("Error message: \"" + webElement.getText() + "\" isn't exist");
                return false;
            }
        }
        LOGGER.info("All error messages are exist");
        return true;
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

        sendToForm(company, accountData.getAddressMap().get(0).getCompany());
        sendToForm(adressLine1, accountData.getAddressMap().get(0).getAddress1());
        sendToForm(adressLine2, accountData.getAddressMap().get(0).getAddress2());

        sendToForm(city, accountData.getAddressMap().get(0).getCity());
        selectByText(state, accountData.getAddressMap().get(0).getState());
        sendToForm(zip, accountData.getAddressMap().get(0).getZip());
        selectByText(country, accountData.getAddressMap().get(0).getCountry());

        sendToForm(additionalInformation, accountData.getAddressMap().get(0).getInfo());
        sendToForm(homePhone, accountData.getAddressMap().get(0).getPhone());
        sendToForm(mobilePhone, accountData.getAddressMap().get(0).getMobile());
        sendToForm(anAdressAlias, accountData.getAddressMap().get(0).getAlias());
    }

    public void register(){
        click(register);
    }

    public boolean correctPageElementsAreShown(){
        fillPageElementsList();

        for (WebElement webElement : pageElements) {
            if (!elementIsVisible(webElement) && !elementIsClicable(webElement)) {
                LOGGER.error("Page element \"" + webElement + "\" isn't shown");
                return false;
            }
        }
        LOGGER.info("All page elements is shown");
        return true;
    }
}