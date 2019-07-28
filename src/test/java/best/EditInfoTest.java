package best;

import best.data_pool.DataPool;
import com.fasterxml.jackson.databind.ObjectMapper;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class EditInfoTest extends BaseTest {

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyPersonalInfoPage myPersonalInfoPage;

    @BeforeSuite
    protected void beforeSuite( ITestContext testContext ) {
        dataPool = new DataPool("dataFile", testContext, AccountData.class);
        dataPool.fillNewDataPool("dataToReplaceFile", testContext, AccountData.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void editUserDataTest(AccountData accountData, AccountData accountData2) {

        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myPersonalInfoPage = PageFactory.initElements(driver, MyPersonalInfoPage.class);

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        accountCreationPage.accountCreate(accountData);
        accountCreationPage.register();

        myAccountPage.clickPersonalInfo();
        myPersonalInfoPage.editUserInformation(accountData, accountData2);
        myPersonalInfoPage.saveUpdate();

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
