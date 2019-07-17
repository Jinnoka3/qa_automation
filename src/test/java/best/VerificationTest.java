package best;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerificationTest extends BaseTest {
    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void verificationTest(AccountData accountData){

        //LOGGER.info("email: " + accountData.getEmail());
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        signInPage.alreadyRegistered(accountData);

        myAccountPage.clickPersonalInfo();
        myAccountPage.verificationInfo();

        myAccountPage.clickMyAddresses();
        myAccountPage.verificationAddresses();


        //Assert.assertEquals("Authentication", signInPage.getTitle());
        //LOGGER.info("Correct email");

        //LOGGER.error("Uncorrect email");
    }
}

