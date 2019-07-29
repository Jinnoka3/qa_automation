package best;

import best.data_pool.DataPool;
import data_model.AccountData;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditAddressesTest extends BaseTest {
    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private MyAddressesPage myAddressesPage;
    private MyPersonalInfoPage myPersonalInfoPage;

    @BeforeClass
    protected void beforeSuite( ITestContext testContext ) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        dataPool.fillNewDataPool("dataToReplaceFile", testContext, AccountData.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
        accountCreationPage = PageFactory.initElements(driver, AccountCreationPage.class);
        myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        myPersonalInfoPage = PageFactory.initElements(driver, MyPersonalInfoPage.class);
    }

    @DataProvider(name = "personalInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "personalInformation")
    public void editAddressesTest(AccountData accountData) throws IOException {

        signInPage.clickSignIn();
        signInPage.sendEmailForCreateAnAccount(accountData.getEmail());
        signInPage.clickCreateAnAccount();

        accountCreationPage.accountCreate(accountData);
        accountCreationPage.register();
        myAccountPage.clickMyAddresses();

        //Assert.assertEquals("Addresses - My Store", myAddressesPage.getTitle());*/
    }
}
