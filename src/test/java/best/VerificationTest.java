package best;

import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerificationTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyPersonalInfoPage myPersonalInfoPage;
    private MyAddressesPage myAddressesPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
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
    }

    @Test(dataProvider = "personalInformation")
    public void verificationUserAddressesTest(AccountData accountData) {

        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myAddressesPage = PageFactory.initElements(driver, MyAddressesPage.class);

        signInPage.signIn(accountData);
        accountCreationPage.accountCreate(accountData);

        myAccountPage.clickMyAddresses();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAddressesPage.verificationFirstName(accountData));
        softAssert.assertTrue(myAddressesPage.verificationLastName(accountData));
        softAssert.assertTrue(myAddressesPage.verificationFirstAddress(accountData));
        softAssert.assertTrue(myAddressesPage.verificationMobile(accountData));
        //softAssert.assertTrue(myPersonalInfoPage.verificationEmail(accountData));
        softAssert.assertAll();
    }
}

