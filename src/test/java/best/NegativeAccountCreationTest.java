package best;

import best.data_pool.DataPool;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static best.AccountCreationPage.MESSAGE_ERROR_EMAIL;
import static best.AccountCreationPage.MESSAGE_ERROR_FIRSTNAME;

public class NegativeAccountCreationTest extends BaseTest{

    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;

    @BeforeClass
    protected void beforeSuite( ITestContext testContext ) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        dataPool.fillNewDataPool("negativeDataFile", testContext, AccountData.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void negativePersonalInfoTest(AccountData accountData, AccountData accountData2){

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        accountCreationPage.accountCreate(accountData2);
        accountCreationPage.register();

        Assert.assertTrue(accountCreationPage.findError());
    }
}
