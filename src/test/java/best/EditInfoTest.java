package best;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class EditInfoTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyPersonalInfoPage myPersonalInfoPage;

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void editUserDataTest(AccountData accountData) throws IOException {

       /* signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myPersonalInfoPage = PageFactory.initElements(driver, MyPersonalInfoPage.class);

        signInPage.signIn(accountData);
        accountCreationPage.accountCreate(accountData);

        myAccountPage.clickPersonalInfo();

        Assert.assertTrue(myPersonalInfoPage.editInfo(accountData), "No update");*/
    }
}
