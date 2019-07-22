package best;

import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerificationInfoTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyPersonalInfoPage myPersonalInfoPage;

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
        softAssert.assertTrue(myPersonalInfoPage.verificationGender(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationName(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationLastName(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationEmail(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationDate(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationMonth(accountData));
        softAssert.assertTrue(myPersonalInfoPage.verificationYear(accountData));
        softAssert.assertAll();
    }
}

