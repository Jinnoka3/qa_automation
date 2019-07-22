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
public class AccountCreationPage extends BasePage{

    private WebDriver driver;

    public AccountCreationPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"id_gender2\"]")
    private WebElement gender;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailSecondPage;

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

    public void clickGender(){
        gender.click();
    }

    public void sendFirstName(String nameFirst) {
        firstName.sendKeys(nameFirst);
    }

    public void sendLastName(String nameLast) {
        lastName.sendKeys(nameLast);
    }

    public void sendEmailSecondPage(String email) {
        emailSecondPage.clear();
        emailSecondPage.sendKeys(email);
    }

    public void sendPassword(String pswrd) {
        password.sendKeys(pswrd);
    }

    public void sendDate(String dt) {
        Select dropdown = new Select(date);
        dropdown.selectByValue(String.valueOf(dt));
    }

    public void sendMonth(String mnth) {
        Select dropdown = new Select(month);
        dropdown.selectByValue(String.valueOf(mnth));
    }

    public void sendYear(String y) {
        Select dropdown = new Select(year);
        dropdown.selectByValue(String.valueOf(y));
    }

    public void clickNewsletter(){
        newsletter.click();
    }

    public void clickSpecialOffers(){
        specialOffers.click();
    }

    public void firstNameInAdress(String firstName) {
        firstNameInAdressForm.clear();
        firstNameInAdressForm.sendKeys(firstName);
    }

    public void lastNameInAdress(String lastName) {
        lastNameInAdressForm.clear();
        lastNameInAdressForm.sendKeys(lastName);
    }

    public void sendCompany(String com) {
        company.sendKeys(com);
    }

    public void sendAddressLine1(String address1) {
        adressLine1.sendKeys(address1);
    }

    public void sendAddressLine2(String address2) {
        adressLine2.sendKeys(address2);
    }

    public void sendCity(String c) {
        city.sendKeys(c);
    }

    public void sendState(String st) {
        state.click();
        Select dropdown = new Select(state);
        dropdown.selectByVisibleText(String.valueOf(st));
    }

    public void sendZip(String z) {
        zip.sendKeys(z);
    }

    public void sendCountry(String cntr) {
        country.click();
        Select dropdown = new Select(country);
        dropdown.selectByVisibleText(String.valueOf(cntr));
    }

    public void sendAdditionalInfo(String inf) {
        additionalInformation.sendKeys(inf);
    }

    public void sendHomePhone(String homePh) {
        homePhone.sendKeys(homePh);
    }

    public void sendMobilePhone(String mobPh) {
        mobilePhone.sendKeys(mobPh);
    }

    public void sendAnAddressAlias(String alias) {
        anAdressAlias.clear();
        anAdressAlias.sendKeys(alias);
    }

    public void clickRegister(){
        register.click();
    }

    public String getInvalidData(){
        return invalidData.getText();
    }

    public void accountCreate(AccountData accountData){
        clickGender();
        sendFirstName(accountData.getFirstName());
        sendLastName(accountData.getLastName());
        sendEmailSecondPage(accountData.getEmail());
        sendPassword(accountData.getPassword());

        sendDate(accountData.getDate());
        sendMonth(accountData.getMonth());
        sendYear(accountData.getYear());

        clickNewsletter();
        clickSpecialOffers();

        firstNameInAdress(accountData.getFirstName());
        lastNameInAdress(accountData.getLastName());
        sendCompany(accountData.getCompany());

        sendAddressLine1(accountData.getAddress1());
        sendAddressLine2(accountData.getAddress2());
        sendCity(accountData.getCity());
        sendState(accountData.getState());
        sendZip(accountData.getZip());
        sendCountry(accountData.getCountry());

        sendAdditionalInfo(accountData.getInfo());
        sendHomePhone(accountData.getPhone());
        sendMobilePhone(accountData.getMobile());
        sendAnAddressAlias(accountData.getAlias());
        clickRegister();
    }
}
