import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AccountCreationTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;

    @Override
    @BeforeClass
    public void beforeClassMethod() throws IOException {
        super.beforeClassMethod();
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
    }

    @Test(dataProvider = "personalInformation", dataProviderClass = AccountData.class)
    public void personalInfoTest(AccountData obj){
        signInPage.clickSignIn();
        LOGGER.info("first name: " + obj.getFirstName());
        LOGGER.info("last name: " + obj.getLastName());
        LOGGER.info("password: " + obj.getPassword());
        signInPage.sendEmailFirstPage(obj.getEmail());
        signInPage.clickCreateAnAccount();
        accountCreationPage.clickGender();
        accountCreationPage.sendFirstName(obj.getFirstName());
        accountCreationPage.sendLastName(obj.getLastName());
        accountCreationPage.sendEmailSecondPage(obj.getEmail());
        accountCreationPage.sendPassword(obj.getEmail());
        /*accountCreationPage.sendDate();
        accountCreationPage.sendMonth();
        accountCreationPage.sendYear();
        accountCreationPage.clickNewsletter();
        accountCreationPage.clickSpecialOffers();*/
        accountCreationPage.sendEmailSecondPage(obj.getEmail());
        accountCreationPage.firstNameInAdress(obj.getFirstName());
        accountCreationPage.lastNameInAdress(obj.getLastName());
        //accountCreationPage.sendCompany(company);
        accountCreationPage.sendAddressLine1(obj.getAddress1());
         //accountCreationPage.sendAddressLine2(address2);
        accountCreationPage.sendCity(obj.getCity());
        accountCreationPage.sendState(obj.getState());
        accountCreationPage.sendZip(obj.getZip());
        accountCreationPage.sendCountry(obj.getCountry());
        //accountCreationPage.sendAdditionalInfo();
        //accountCreationPage.sendHomePhone(phone);
        accountCreationPage.sendMobilePhone(obj.getMobile());
        accountCreationPage.sendAnAddressAlias(obj.getAlias());
        accountCreationPage.clickRegister();

        String text = accountCreationPage.getInvalidData();

        try {
            Assert.assertEquals("> My account", text);
            LOGGER.info("Correct user data");
        }
        catch (Error error){
            LOGGER.error("Uncorrect email");
        }
    }

    @Test(dataProvider = "personalWrongInformation", dataProviderClass = AccountData.class)
    public void personalInfoNegativeTest(AccountData obj){
        signInPage.clickSignIn();
        LOGGER.info("first name: " + obj.getFirstName());
        LOGGER.info("last name: " + obj.getLastName());
        LOGGER.info("password: " + obj.getPassword());
        signInPage.sendEmailFirstPage(obj.getEmail());
        signInPage.clickCreateAnAccount();
        accountCreationPage.clickGender();
        accountCreationPage.sendFirstName(obj.getFirstName());
        accountCreationPage.sendLastName(obj.getLastName());
        accountCreationPage.sendEmailSecondPage(obj.getEmail());
        accountCreationPage.sendPassword(obj.getEmail());
        /*accountCreationPage.sendDate();
        accountCreationPage.sendMonth();
        accountCreationPage.sendYear();
        accountCreationPage.clickNewsletter();
        accountCreationPage.clickSpecialOffers();*/
        accountCreationPage.sendEmailSecondPage(obj.getEmail());
        accountCreationPage.firstNameInAdress(obj.getFirstName());
        accountCreationPage.lastNameInAdress(obj.getLastName());
        //accountCreationPage.sendCompany(company);
        accountCreationPage.sendAddressLine1(obj.getAddress1());
        //accountCreationPage.sendAddressLine2(address2);
        accountCreationPage.sendCity(obj.getCity());
        accountCreationPage.sendState(obj.getState());

        accountCreationPage.sendZip(obj.getWrongZip());

        accountCreationPage.sendCountry(obj.getCountry());
        //accountCreationPage.sendAdditionalInfo();
        //accountCreationPage.sendHomePhone(phone);
        accountCreationPage.sendMobilePhone(obj.getMobile());
        accountCreationPage.sendAnAddressAlias(obj.getAlias());
        accountCreationPage.clickRegister();

        String text = accountCreationPage.getInvalidData();

        try {
            Assert.assertNotEquals("> My account", text);
            LOGGER.info("Unorrect user data");
        }
        catch (Error error){
            LOGGER.error("Correct email");
        }
    }
}
