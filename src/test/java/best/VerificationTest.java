package best;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerificationTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyPersonalInfoPage myPersonalInfoPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void signInAccount(AccountData accountData){

        //LOGGER.info("email: " + accountData.getEmail());
        signInPage = PageFactory.initElements(driver, SignInPage.class);

        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        signInPage.alreadyRegistered(accountData);

        Assert.assertEquals("My account - My Store", myAccountPage.getTitle());
       // myAccountPage.clickPersonalInfo();
        //myAccountPage.verificationInfo();

        /*myAccountPage.clickMyAddresses();
        myAccountPage.verificationAddresses();*/


        //Assert.assertEquals("Authentication", signInPage.getTitle());
        //LOGGER.info("Correct email");

        //LOGGER.error("Uncorrect email");
    }

    @Test(dataProvider = "personalInformation")
    public void verificationUserDataTest(AccountData accountData) {

        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myPersonalInfoPage = PageFactory.initElements(driver, MyPersonalInfoPage.class);

        signInPage.signIn(accountData);
        accountCreationPage.accountCreate(accountData);

        myAccountPage.clickPersonalInfo();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myPersonalInfoPage.verificationName(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationLastName(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationEmail(accountData));
        softAssert.assertAll();


        //myAccountPage.clickPersonalInfo();

        //myAccountPage.verificationInfo();

        //Assert.assertEquals("My account - My Store", myAccountPage.getTitle());
    }

    @Test(dataProvider = "personalInformation")
    public void verificationUserAddressesTest(AccountData accountData) {

        //LOGGER.info("email: " + accountData.getEmail());
        signInPage = PageFactory.initElements(driver, SignInPage.class);

        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        //signInPage.alreadyRegistered(accountData);

        myAccountPage.clickMyAddresses();
        //myAccountPage.verificationAddresses();

       // Assert.assertEquals("My account - My Store", myAccountPage.getTitle());
    }
}

